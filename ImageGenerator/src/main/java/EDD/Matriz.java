/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author lex
 */
public class Matriz {

    private NodoMatriz root = new NodoMatriz(0, "root", null, null);

    public static void main(String[] args) {
        Matriz matriz = new Matriz();

        matriz.crearEncabezado(1, 0);
        matriz.crearEncabezado(3, 0);
        matriz.crearEncabezado(5, 0);
        matriz.crearEncabezado(4, 0);
        matriz.crearEncabezado(4, 0);
        matriz.crearEncabezado(2, 0);
        matriz.crearEncabezado(8, 0);

        matriz.imprimirEncabezados();

    }

    public void imprimirEncabezados() {
        NodoMatriz aux_x = root.getSiguiente();

        while (aux_x != null)
        {
            if (aux_x.getAnterior() != null && aux_x.getSiguiente() != null)
            {
                System.out.println("Encabezado en x " + aux_x.getIndice() + " Siguiente " + aux_x.getSiguiente().getIndice() + " Anterior " + aux_x.getAnterior().getIndice());
            } else if (aux_x.getAnterior() != null)
            {
                System.out.println("Encabezado en x " + aux_x.getIndice() + " Anterior " + aux_x.getAnterior().getIndice());
            } else if (aux_x.getSiguiente() != null)
            {
                System.out.println("Encabezado en x " + aux_x.getIndice() + " Siguiente " + aux_x.getSiguiente().getIndice());
            }
            aux_x = aux_x.getSiguiente();
        }

    }

    public void crearEncabezado(int fila, int columna) {

        if (!existeEncabezado(fila, "x"))
        {
            NodoMatriz aux = root.getSiguiente();
            NodoMatriz nuevoEncabezado = new NodoMatriz(fila, "x", null, null);

            if (aux == null)
            {
                root.setSiguiente(nuevoEncabezado);
            } else
            {
                while (aux != null)
                {
                    if (aux.getIndice() > fila)
                    {
                        System.out.println("Entra ");
                        NodoMatriz aux_nuevo = aux.getAnterior();
                        aux.setAnterior(nuevoEncabezado);
                        aux_nuevo.setSiguiente(nuevoEncabezado);
                        nuevoEncabezado.setSiguiente(aux);
                        nuevoEncabezado.setAnterior(aux_nuevo);
                        break;

                    } else
                    {
                        if (aux.getSiguiente() == null)
                        {
                            aux.setSiguiente(nuevoEncabezado);
                            nuevoEncabezado.setAnterior(aux);
                            break;
                        } else
                        {
                            aux = aux.getSiguiente();
                            System.out.println("Siguiente " + aux.getIndice());
                        }
                    }

                }

            }
            System.out.println("Se creo encabezado " + nuevoEncabezado.getIndice());

        }

    }

    public boolean existeEncabezado(int indice, String eje) {

        NodoMatriz aux = null;
        if (eje.equals("x"))
        {
            aux = root.getSiguiente();
        } else if (eje.equals("y"))
        {
            aux = root.getAnterior();
        }
        while (aux != null)
        {
            if (aux.getIndice() == indice)
            {
                return true;
            } else
            {
                aux = aux.getSiguiente();
            }

        }

        return false;

    }

}
