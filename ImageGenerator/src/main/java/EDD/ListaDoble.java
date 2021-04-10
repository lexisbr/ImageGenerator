/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Nodos.NodoListaDoble;
import Nucleo.Estructuras;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class ListaDoble {

    private NodoListaDoble root;
    private NodoListaDoble end;

    public ListaDoble() {
        this.root = null;
        this.end = null;
    }

    public boolean insertarNodo(NodoListaDoble nuevoNodo) {
        NodoListaDoble imagenArbol = Estructuras.buscarImagen(nuevoNodo.getId());
        if (imagenArbol != null)
        {
            nuevoNodo.setContenido(imagenArbol.getContenido());
            if (root == null)
            {
                root = nuevoNodo;
                end = nuevoNodo;
            } else if (nodoNoExiste(nuevoNodo.getId()))
            {
                end.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(end);
                end = nuevoNodo;
            } else
            {
                JOptionPane.showMessageDialog(null, "La imagen: \"" + nuevoNodo.getId() + "\" ya existe para el usuario");
                return false;
            }
        } else
        {
            System.out.println("Entra");
            JOptionPane.showMessageDialog(null, "La imagen: \"" + nuevoNodo.getId() + "\" no ha sido creada");
            return false;
        }
        return true;
    }

    public NodoListaDoble eliminarNodo(int id) {
        NodoListaDoble aux = root;
        while (aux != null)
        {
            if (aux.getId() == id)
            {
                NodoListaDoble nodoAnterior = aux.getAnterior();
                NodoListaDoble nodoSiguiente = aux.getSiguiente();
                nodoAnterior.setSiguiente(nodoSiguiente);
                nodoSiguiente.setSiguiente(nodoAnterior);
                return aux;
            } else
            {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminarImagen(int id) {
        if (root == null)
        {
            return false;
        }
        NodoListaDoble aux = root;
        if (root == end)
        {
            root = end = null;
            return true;
        } else if (id == root.getId())
        {
            root = root.getSiguiente();
            root.setAnterior(null);
            return true;
        } else if (id == end.getId())
        {
            end = end.getAnterior();
            end.setSiguiente(null);
            return true;
        } else
        {
            while (aux != null)
            {
                if (aux.getId() == id)
                {
                    NodoListaDoble nodoAnterior = aux.getAnterior();
                    NodoListaDoble nodoSiguiente = aux.getSiguiente();
                    nodoAnterior.setSiguiente(nodoSiguiente);
                    nodoSiguiente.setAnterior(nodoAnterior);
                    return true;
                } else
                {
                    aux = aux.getSiguiente();
                }
            }
            return false;
        }
    }

    public NodoListaDoble buscarNodo(int id) {
        NodoListaDoble aux = root;
        while (aux != null)
        {
            if (aux.getId() == id)
            {
                return aux;
            } else
            {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean nodoNoExiste(int id) {
        NodoListaDoble aux = root;
        while (aux != null)
        {
            if (aux.getId() == id)
            {
                return false;
            }
            aux = aux.getSiguiente();
        }
        return true;
    }

    public void mostrarDatos() {
        System.out.println("Lista Doblemente Enlazada");
        if (root != null)
        {
            NodoListaDoble aux = root;
            while (aux != null)
            {
                System.out.print("Nodo: " + aux.getId());
                if (aux.getSiguiente() != null)
                {
                    System.out.print(" Siguiente: " + aux.getSiguiente().getId());
                }
                if (aux.getAnterior() != null)
                {
                    System.out.print(" Anterior: " + aux.getAnterior().getId());
                }
                System.out.println("\n");

                aux = aux.getSiguiente();
            }
        }
    }

}
