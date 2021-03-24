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

    private NodoMatriz root;

    public Matriz() {
        this.root = new NodoMatriz(0, 0, "root");
    }
    
    

    public static void main(String[] args) {
        Matriz matriz = new Matriz();

        matriz.insertarPixel(1, 1, "color0");
        matriz.insertarPixel(1, 2, "color1");
        matriz.insertarPixel(1, 4, "color4");
        matriz.insertarPixel(2, 3, "color2");
        matriz.insertarPixel(3, 3, "color3");
        matriz.imprimirNodos();

    }

    public void insertarPixel(int columna, int fila, String color) {
        NodoMatriz nuevoNodo = new NodoMatriz(columna, fila, color);
        verificarEncabezado(columna, fila);

        insertarPixelColumna(nuevoNodo);
        insertarPixelFila(nuevoNodo);

    }

    public void insertarPixelFila(NodoMatriz nuevoNodo) {
        NodoMatriz aux_y = root.getAbajo();

        while (aux_y != null)
        {
            if (aux_y.getY() == nuevoNodo.getY())
            {
                if (aux_y.getDerecha() == null)
                {
                    aux_y.setDerecha(nuevoNodo);
                    nuevoNodo.setIzquierda(aux_y);
                    break;
                } else
                {
                    NodoMatriz auxDerecha = aux_y.getDerecha();
                    while (auxDerecha != null)
                    {
                        if (auxDerecha.getX() > nuevoNodo.getX())
                        {
                            if (auxDerecha.getIzquierda() != null)
                            {
                                auxDerecha.getIzquierda().setDerecha(nuevoNodo);
                                nuevoNodo.setDerecha(auxDerecha.getIzquierda());

                            }
                            nuevoNodo.setDerecha(auxDerecha);
                            auxDerecha.setIzquierda(nuevoNodo);
                            break;
                        } else
                        {
                            if (auxDerecha.getDerecha() == null)
                            {
                                auxDerecha.setDerecha(nuevoNodo);
                                nuevoNodo.setIzquierda(auxDerecha);
                                break;
                            } else
                            {
                                auxDerecha = auxDerecha.getAbajo();
                            }
                        }

                    }
                    break;
                }

            } else
            {
                aux_y = aux_y.getAbajo();
            }
        }

    }

    public void insertarPixelColumna(NodoMatriz nuevoNodo) {
        NodoMatriz aux_x = root.getDerecha();

        while (aux_x != null)
        {
            if (aux_x.getX() == nuevoNodo.getX())
            {
                if (aux_x.getAbajo() == null)
                {
                    aux_x.setAbajo(nuevoNodo);
                    nuevoNodo.setArriba(aux_x);
                    break;
                } else
                {
                    NodoMatriz auxAbajo = aux_x.getAbajo();
                    while (auxAbajo != null)
                    {
                        if (auxAbajo.getY() > nuevoNodo.getY())
                        {

                            if (auxAbajo.getArriba() != null)
                            {
                                auxAbajo.getArriba().setAbajo(nuevoNodo);
                                nuevoNodo.setArriba(auxAbajo.getArriba());

                            }
                            nuevoNodo.setAbajo(auxAbajo);
                            auxAbajo.setArriba(nuevoNodo);
                            break;
                        } else
                        {
                            if (auxAbajo.getAbajo() == null)
                            {
                                auxAbajo.setAbajo(nuevoNodo);
                                nuevoNodo.setArriba(auxAbajo);
                                break;
                            } else
                            {
                                auxAbajo = auxAbajo.getAbajo();
                            }
                        }

                    }
                    break;
                }

            } else
            {
                aux_x = aux_x.getDerecha();
            }
        }

    }

    public void imprimirNodos() {
        NodoMatriz aux_x = root;
        NodoMatriz aux_y = root;

        while (aux_y != null)
        {
            aux_x = aux_y;
            while (aux_x != null)
            {

                System.out.print("\n" + aux_x.getContenido().toString() + " >> ");
                if (aux_x.getArriba() != null)
                {
                    System.out.print("Arriba: " + aux_x.getArriba().getContenido().toString() + " >> ");
                }
                if (aux_x.getAbajo() != null)
                {
                    System.out.print("Abajo: " + aux_x.getAbajo().getContenido().toString() + " >> ");
                }
                if (aux_x.getDerecha() != null)
                {
                    System.out.print("Derecha: " + aux_x.getDerecha().getContenido().toString() + " >> ");
                }
                if (aux_x.getIzquierda() != null)
                {
                    System.out.print("Izquierda: " + aux_x.getIzquierda().getContenido().toString() + " >> ");
                }
                aux_x = aux_x.getDerecha();
            }
            aux_y = aux_y.getAbajo();
        }

        /*while (aux_y != null)
        {
            aux_x = aux_y;
            while (aux_x != null)
            {
                System.out.print(aux_x.getContenido().toString() + " >> ");
                aux_x = aux_x.getDerecha();
            }
            System.out.println("\nv");
            aux_y = aux_y.getAbajo();
        }*/
    }

    public void verificarEncabezado(int columna, int fila) {

        if (!existeEncabezadoColumna(columna))
        {
            NodoMatriz nuevoEncabezado = new NodoMatriz(columna, 0, "x_"+columna);
            crearEncabezadoColumna(nuevoEncabezado);
        }

        if (!existeEncabezadoFila(fila))
        {
            NodoMatriz nuevoEncabezado = new NodoMatriz(0, fila, "y_"+fila);
            crearEncabezadoFila(nuevoEncabezado);
        }
    }

    public boolean existeEncabezadoColumna(int columna) {

        NodoMatriz aux = root.getDerecha();

        while (aux != null)
        {
            if (aux.getX() == columna)
            {
                return true;
            } else
            {
                aux = aux.getDerecha();
            }
        }

        return false;

    }

    public boolean existeEncabezadoFila(int fila) {

        NodoMatriz aux = root.getAbajo();

        while (aux != null)
        {
            if (aux.getY() == fila)
            {
                return true;
            } else
            {
                aux = aux.getAbajo();
            }
        }

        return false;

    }

    public void crearEncabezadoFila(NodoMatriz nuevoEncabezado) {
        NodoMatriz aux = root.getAbajo();

        if (aux == null)
        {
            root.setAbajo(nuevoEncabezado);
        } else
        {
            while (aux != null)
            {
                if (aux.getY() > nuevoEncabezado.getY())
                {

                    NodoMatriz aux_nuevo = aux.getArriba();
                    if (aux_nuevo != null)
                    {
                        aux_nuevo.setAbajo(nuevoEncabezado);
                        nuevoEncabezado.setArriba(aux_nuevo);
                    } else
                    {
                        root.setAbajo(nuevoEncabezado);
                    }
                    aux.setArriba(nuevoEncabezado);
                    nuevoEncabezado.setAbajo(aux);
                    break;

                } else
                {
                    if (aux.getAbajo() == null)
                    {
                        aux.setAbajo(nuevoEncabezado);
                        nuevoEncabezado.setArriba(aux);
                        break;
                    } else
                    {
                        aux = aux.getAbajo();
                    }
                }

            }

        }

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
