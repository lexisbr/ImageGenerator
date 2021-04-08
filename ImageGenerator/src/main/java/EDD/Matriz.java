/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Nodos.NodoMatriz;
import Nucleo.Estructuras;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class Matriz {

    private final String WHITE = "#FFFFFF";
    private NodoMatriz root;
    private int id;

    public Matriz() {
        this.root = new NodoMatriz(0, 0, "root");
    }

    public Matriz(int id) {
        this.id = id;
        this.root = new NodoMatriz(0, 0, "root");
    }

    public void insertarPixel(NodoMatriz nuevoNodo) {
        if (buscarNodo(nuevoNodo.getX(), nuevoNodo.getY()) == null)
        {
            verificarEncabezado(nuevoNodo.getX(), nuevoNodo.getY());
            insertarPixelColumna(nuevoNodo);
            insertarPixelFila(nuevoNodo);
        }/* else
        {
            JOptionPane.showMessageDialog(null, "El pixel en la posicion (" + nuevoNodo.getX() + "," + nuevoNodo.getY() + ") ya existe. Matriz: "+getId());
            imprimirNodos();
        }*/

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

    public NodoMatriz buscarNodo(int x, int y) {
        NodoMatriz aux = root.getDerecha();

        while (aux != null)
        {
            if (aux.getX() == x)
            {
                while (aux != null)
                {
                    if (aux.getY() == y)
                    {
                        return aux;
                    } else
                    {
                        aux = aux.getAbajo();
                    }
                }
            } else
            {
                aux = aux.getDerecha();
            }
        }

        return null;

    }

    public void imprimirNodos() {
        NodoMatriz aux_x = root;
        NodoMatriz aux_y = root;
        System.out.println("\n\nMatriz: "+getId());
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
    }

    public void verificarEncabezado(int columna, int fila) {

        if (!existeEncabezadoColumna(columna))
        {
            NodoMatriz nuevoEncabezado = new NodoMatriz(columna, 0, "x_" + columna);
            crearEncabezadoColumna(nuevoEncabezado);
        }

        if (!existeEncabezadoFila(fila))
        {
            NodoMatriz nuevoEncabezado = new NodoMatriz(0, fila, "y_" + fila);
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

    public boolean estaVacia() {
        if (root.getDerecha() == null && root.getAbajo() == null)
        {
             return true;
        } else
        {
            return false;
        }
    }

    public int obtenerFilas() {
        NodoMatriz nodoFilas = root.getAbajo();
        while (nodoFilas.getAbajo() != null)
        {
            nodoFilas = nodoFilas.getAbajo();
        }
        return nodoFilas.getY();
    }

    public int obtenerColumnas() {
        NodoMatriz nodoColumnas = root.getDerecha();
        while (nodoColumnas.getDerecha() != null)
        {
            nodoColumnas = nodoColumnas.getDerecha();
        }
        return nodoColumnas.getX();
    }

    private StringBuffer graficarMatriz() {
        StringBuffer codigo = new StringBuffer("digraph matriz{\n"
                + "node [shape=plaintext]\n"
                + "a [label=<<TABLE BORDER=\"1\" CELLBORDER=\"1\" CELLSPACING=\"0\">\n");

        for (int y = 1; y <= obtenerFilas(); y++)
        {
            codigo.append("<TR> ");
            for (int x = 1; x <= obtenerColumnas(); x++)
            {
                NodoMatriz nodoActual = buscarNodo(x, y);
                if (nodoActual != null)
                {
                    codigo.append("<TD BGCOLOR=\"" + nodoActual.getContenido().toString() + "\"></TD>");
                } else
                {
                    codigo.append("<TD BGCOLOR=\"" + WHITE + "\"></TD>");
                }
            }
            codigo.append("</TR>\n");
        }

        codigo.append("</TABLE>>];\n}");

        return codigo;
    }

    public void generarImagen() {
        try
        {
            StringBuffer codigo = graficarMatriz();
            File imagen = new File("./capa.dot");
            if (imagen.exists())
            {
                imagen.delete();
                imagen.createNewFile();
            } else
            {
                imagen.createNewFile();
            }
            Estructuras.guardarArchivo(codigo, imagen.getAbsolutePath());
            String comando = "dot -Tpng capa.dot -o imagenCapa.png";
            Runtime.getRuntime().exec(comando);
            JOptionPane.showMessageDialog(null, "Se ha generado la imagen de la capa exitosamente: " + imagen.getPath());
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error al generar imagen de capa");
        }

    }

    public NodoMatriz getRoot() {
        return root;
    }

    public void setRoot(NodoMatriz root) {
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
