/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Objetos.Pixel;

/**
 *
 * @author lex
 */
public class Matriz {

    private NodoMatriz root = new NodoMatriz(0, 0, "root");

    public static void main(String[] args) {
        Matriz matriz = new Matriz();

        matriz.verificarEncabezado(3, 3);
        matriz.verificarEncabezado(5, 5);
        matriz.verificarEncabezado(4, 4);
        matriz.verificarEncabezado(4, 8);
        matriz.verificarEncabezado(2, 9);
        matriz.verificarEncabezado(8, 6);
        matriz.verificarEncabezado(2, 2);
        matriz.verificarEncabezado(7, 2);
        matriz.verificarEncabezado(1, 1);

        matriz.imprimirEncabezados();

    }

    /*public void insertarPixel(int fila, int columna, String color) {
        Pixel nuevoPixel = new Pixel(fila, columna, color);

        NodoMatriz nuevoNodo = new NodoMatriz(nuevoPixel);
        crearEncabezado(fila, columna);

        NodoMatriz aux_x = getRoot().getSiguiente();
        NodoMatriz aux_y = getRoot().getAnterior();

        while (aux_x != null)
        {
            if (aux_x.getIndice() == columna)
            {
                while (aux_y != null)
                {
                    if (aux_y.getIndice() == fila)
                    {
                        NodoMatriz aux_abajo = aux_x.getAbajo();
                        NodoMatriz aux_arriba = aux_y.getArriba();
                        
                        while(aux_abajo!=null){
                           if(aux_abajo.get)
                        }
                        
                        

                    } else
                    {
                        aux_y = aux_y.getSiguiente();
                    }
                }

            } else
            {
                aux_x = aux_x.getSiguiente();
            }
        }

    }*/
    public void imprimirEncabezados() {
        NodoMatriz aux_x = root.getDerecha();
        //NodoMatriz aux_y = root.getAnterior();

        //System.out.print(root.getEje() + " >> ");
        while (aux_x != null)
        {
            if (aux_x.getIzquierda() != null && aux_x.getDerecha() != null)
            {
                System.out.println("Encabezado en x " + aux_x.getContenido().toString() + " Siguiente " + aux_x.getDerecha().getContenido().toString() + " Anterior " + aux_x.getIzquierda().getContenido().toString());
            } else if (aux_x.getIzquierda() != null)
            {
                System.out.println("Encabezado en x " + aux_x.getContenido().toString() + " Anterior " + aux_x.getIzquierda().getContenido().toString());
            } else if (aux_x.getDerecha() != null)
            {
                System.out.println("Encabezado en x " + aux_x.getContenido().toString() + " Siguiente " + aux_x.getDerecha().getContenido().toString());
            }
            //System.out.print(aux_x.getContenido().toString() + " >> ");
            aux_x = aux_x.getDerecha();
        }

        /* System.out.println("");
        while (aux_y != null)
        {
            System.out.println("V");
            System.out.println(aux_y.getIndice());
            aux_y = aux_y.getSiguiente();
        }*/
    }

    public void verificarEncabezado(int columna, int fila) {

        if (!existeEncabezadoColumna(columna))
        {
            NodoMatriz nuevoEncabezado = new NodoMatriz(columna, 0, new Integer(columna));
            crearEncabezadoColumna(nuevoEncabezado);
        }

        /*if (!existeEncabezado(fila, "y"))
        {
            NodoMatriz aux = root.getAnterior();
            NodoMatriz nuevoEncabezado = new NodoMatriz(fila, "y", null, null);

            if (aux == null)
            {
                root.setAnterior(nuevoEncabezado);
            } else
            {
                while (aux != null)
                {
                    if (aux.getIndice() > fila)
                    {

                        NodoMatriz aux_nuevo = aux.getAnterior();
                        if (aux_nuevo != null)
                        {
                            aux_nuevo.setSiguiente(nuevoEncabezado);
                            nuevoEncabezado.setAnterior(aux_nuevo);
                        } else
                        {
                            root.setAnterior(nuevoEncabezado);
                        }
                        aux.setAnterior(nuevoEncabezado);
                        nuevoEncabezado.setSiguiente(aux);
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
                        }
                    }

                }

            }
        }*/
    }

    public boolean existeEncabezadoColumna(int columna) {

        NodoMatriz aux = root.getDerecha();

        while (aux != null)
        {
            if (Integer.valueOf(aux.getContenido().toString()) == columna)
            {
                return true;
            } else
            {
                aux = aux.getDerecha();
            }
        }

        return false;

    }

    public void crearEncabezadoColumna(NodoMatriz nuevoEncabezado) {
        NodoMatriz aux = root.getDerecha();

        if (aux == null)
        {
            root.setDerecha(nuevoEncabezado);
        } else
        {
            while (aux != null)
            {
                if (aux.getX() > nuevoEncabezado.getX())
                {
                    NodoMatriz aux_nuevo = aux.getIzquierda();
                    if (aux_nuevo != null)
                    {
                        aux_nuevo.setDerecha(nuevoEncabezado);
                        nuevoEncabezado.setIzquierda(aux_nuevo);
                    } else
                    {
                        root.setDerecha(nuevoEncabezado);
                    }
                    aux.setIzquierda(nuevoEncabezado);
                    nuevoEncabezado.setDerecha(aux);
                    break;

                } else
                {
                    if (aux.getDerecha() == null)
                    {
                        aux.setDerecha(nuevoEncabezado);
                        nuevoEncabezado.setIzquierda(aux);
                        break;
                    } else
                    {
                        aux = aux.getDerecha();
                    }
                }

            }

        }

    }

    public NodoMatriz getRoot() {
        return root;
    }

    public void setRoot(NodoMatriz root) {
        this.root = root;
    }

}
