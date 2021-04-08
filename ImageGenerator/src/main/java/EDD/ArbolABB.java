/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Nodos.NodoArbolABB;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class ArbolABB {

    private NodoArbolABB root;

    public ArbolABB() {
        this.root = null;
    }

    public void insertarNodo(NodoArbolABB nuevoNodo) {
        root = insertarABB(root, nuevoNodo);
    }

    private NodoArbolABB insertarABB(NodoArbolABB actualNodo, NodoArbolABB nuevoNodo) {
        if (actualNodo == null)
        {
            return nuevoNodo;
        }

        if (nuevoNodo.getId() < actualNodo.getId())
        {
            actualNodo.setHijoIzquierdo(insertarABB(actualNodo.getHijoIzquierdo(), nuevoNodo));
        } else if (nuevoNodo.getId() > actualNodo.getId())
        {
            actualNodo.setHijoDerecho(insertarABB(actualNodo.getHijoDerecho(), nuevoNodo));
        } else
        {
            JOptionPane.showMessageDialog(null, "La capa ya existe");
            return actualNodo;
        }

        return actualNodo;
    }

    public NodoArbolABB buscarNodo(int id) {
        return obtenerNodo(root, id);
    }

    private NodoArbolABB obtenerNodo(NodoArbolABB actualNodo, int id) {
        if (actualNodo == null)
        {
            return null;
        } else if (id == actualNodo.getId())
        {
            return actualNodo;
        } else if (id < actualNodo.getId())
        {
            return obtenerNodo(actualNodo.getHijoIzquierdo(), id);
        } else
        {
            return obtenerNodo(actualNodo.getHijoDerecho(), id);
        }

    }

    public void mostrarArbol() {
        System.out.println("ARBOL ABB");
        obtenerNodos(root);
    }

    private void obtenerNodos(NodoArbolABB actualNodo) {

        if (actualNodo != null)
        {

            if (actualNodo.getHijoIzquierdo() != null)
            {
                System.out.print("\nNodo padre: " + actualNodo.getId() + " >>>> Hijo Izquierdo: " + actualNodo.getHijoIzquierdo().getId());
                obtenerNodos(actualNodo.getHijoIzquierdo());
            }

            if (actualNodo.getHijoDerecho() != null)
            {
                System.out.print("\nNodo padre: " + actualNodo.getId() + " >>>> Hijo Derecho: " + actualNodo.getHijoDerecho().getId());
                obtenerNodos(actualNodo.getHijoDerecho());
            }

            if (actualNodo.getHijoIzquierdo() == null && actualNodo.getHijoDerecho() == null)
            {
                System.out.print("\nNodo hoja: " + actualNodo.getId());
            }
        } else
        {
            System.out.println("ARBOL VACIO");
        }

    }

}
