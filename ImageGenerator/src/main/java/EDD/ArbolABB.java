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

    public static void main(String[] args) {
        ArbolABB arbol = new ArbolABB();
        arbol.insertarNodo(new NodoArbolABB(new Matriz("uno"), "uno"));
        arbol.insertarNodo(new NodoArbolABB(new Matriz("dos"), "dos"));
        arbol.insertarNodo(new NodoArbolABB(new Matriz("tres"), "tres"));
        arbol.insertarNodo(new NodoArbolABB(new Matriz("cuat"), "cuat"));
        arbol.mostrarArbol();
    }

    public ArbolABB() {
        this.root = null;
    }

    public void insertarNodo(NodoArbolABB nuevoNodo) {
        root = insertarABB(root, nuevoNodo);
    }

    private NodoArbolABB insertarABB(NodoArbolABB actualNodo, NodoArbolABB nuevoNodo) {
        if (actualNodo == null)
        {
            System.out.println("Nodo nuevo " + nuevoNodo.getId());
            return nuevoNodo;
        }
        System.out.println("Nodo actual " + actualNodo.getId());

        if (nuevoNodo.getId().compareTo(actualNodo.getId()) < 0)
        {
            actualNodo.setHijoIzquierdo(insertarABB(actualNodo.getHijoIzquierdo(), nuevoNodo));
        } else if (nuevoNodo.getId().compareTo(actualNodo.getId()) > 0)
        {
            actualNodo.setHijoDerecho(insertarABB(actualNodo.getHijoDerecho(), nuevoNodo));
        } else
        {
            JOptionPane.showMessageDialog(null, "La capa ya existe");
            return actualNodo;
        }

        return actualNodo;
    }

    public void mostrarArbol() {
        System.out.println("ARBOL ABB");
        obtenerNodo(root);
    }

    private void obtenerNodo(NodoArbolABB actualNodo) {

        if (actualNodo != null)
        {
            
            if (actualNodo.getHijoIzquierdo() != null)
            {
                System.out.print("\nNodo padre: " + actualNodo.getId()+" >>>> Hijo Izquierdo: " + actualNodo.getHijoIzquierdo().getId());
                obtenerNodo(actualNodo.getHijoIzquierdo());
            }
            
            if (actualNodo.getHijoDerecho() != null)
            {
                System.out.print("\nNodo padre: " + actualNodo.getId()+" >>>> Hijo Derecho: " + actualNodo.getHijoDerecho().getId());
                obtenerNodo(actualNodo.getHijoDerecho());
            } 
            
            if(actualNodo.getHijoIzquierdo() == null && actualNodo.getHijoDerecho() == null){
                System.out.print("\nNodo hoja: "+actualNodo.getId());
            }
        } else
        {
            System.out.println("ARBOL VACIO");
        }

    }

}
