/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Nodos.NodoArbolABB;
import Nodos.NodoListaSimple;
import Nucleo.Estructuras;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class ListaSimple {

    private NodoListaSimple root;
    private NodoListaSimple end;

    public ListaSimple() {
        this.root = null;
        this.end = null;
    }

    public void insertarNodo(NodoListaSimple nuevoNodo) {

        NodoArbolABB capaArbol = Estructuras.buscarCapa(nuevoNodo.getId());
        if (capaArbol != null)
        {
            nuevoNodo.setContenido(capaArbol.getContenido());
            nuevoNodo.setCapa(capaArbol);
            if (root == null)
            {
                root = nuevoNodo;
                end = nuevoNodo;
            } else if (buscarNodo(nuevoNodo.getId()) == null)
            {
                end.setSiguiente(nuevoNodo);
                end = nuevoNodo;
            } else
            {
                JOptionPane.showMessageDialog(null, "La capa ya existe");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "La capa no ha sido creada");
        }

    }

    public NodoListaSimple buscarNodo(int id) {
        NodoListaSimple aux = root;

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

    public void mostrarDatos() {
        if (root != null)
        {
            NodoListaSimple aux = root;
            while (aux != null)
            {
                System.out.print("Nodo: " + aux.getId());
                System.out.print(" Capa en arbol: " + aux.getCapa().getId());
                if (aux.getSiguiente() != null)
                {
                    System.out.print(" Siguiente: " + aux.getSiguiente().getId());
                }
                System.out.println("\n");

                aux = aux.getSiguiente();
            }
        }else{
            System.out.println("lista vacia");
        }
    }

    public Matriz extraerNodo() {
        if (root != null)
        {
            Matriz capa = (Matriz) root.getContenido();
            if (root == end)
            {
                root = end = null;
            } else
            {
                root = root.getSiguiente();
            }
            return capa;
        } else
        {
            //JOptionPane.showMessageDialog(null, "La lista de capas esta vacia");
            return null;
        }
    }

    public Matriz obtenerCapa(int id) {
        if (root != null)
        {
            NodoListaSimple aux = buscarNodo(id);
            if (aux != null)
            {
                Matriz capa = (Matriz) aux.getContenido();
                return capa;
            } else
            {
                JOptionPane.showMessageDialog(null, "No existe capa");
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "Imagen no tiene capas");
        return null;
    }
    
    public boolean estaVacia(){
        if(root == null && end == null){
            return true;
        }else{
            return false;
        }
    }

}
