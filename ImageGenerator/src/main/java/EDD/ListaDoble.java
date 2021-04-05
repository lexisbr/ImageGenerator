/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Nodos.NodoListaDoble;

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

    public void insertarNodo(NodoListaDoble nuevoNodo) {
        if (root == null)
        {
            root = nuevoNodo;
            end = nuevoNodo;
        } else if (nodoNoExiste(nuevoNodo.getId()))
        {
            end.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(end);
            end = nuevoNodo;
        }
    }

    public boolean nodoNoExiste(String id) {
        NodoListaDoble aux = root;
        while (aux != null)
        {
            if (aux.getId().equals(id))
            {
                return false;
            }
            System.out.println("No existe: "+aux.getId());
            aux = aux.getSiguiente();
        }
        return true;
    }

    public void mostrarDatos() {
        if (root != null)
        {
            NodoListaDoble aux = root;
            while(aux != null){
                System.out.print("Nodo: "+aux.getId());
                if(aux.getSiguiente() != null)
                    System.out.print(" Siguiente: "+aux.getSiguiente().getId());
                if(aux.getAnterior() != null)
                    System.out.print(" Anterior: "+aux.getAnterior().getId());
                System.out.println("\n");
                
                aux = aux.getSiguiente();
            }
        }
    }

}
