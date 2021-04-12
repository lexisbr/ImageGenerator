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
public class ArbolABB {

    private NodoArbolABB root;
    private ListaSimple listaCapas;
    private StringBuffer grafica;

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
            JOptionPane.showMessageDialog(null, "La capa ya: \"" + nuevoNodo.getId() + "\" existe");
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

    public ListaSimple inOrden(int numeroCapas) {
        listaCapas = new ListaSimple();
        inOrden(root, numeroCapas);
        return listaCapas;
    }

    private void inOrden(NodoArbolABB nodo, int numeroCapas) {
        if (nodo == null)
        {
            return;
        }

        inOrden(nodo.getHijoIzquierdo(), numeroCapas);
        if (listaCapas.getSize() == numeroCapas)
        {
            return;
        } else
        {
            listaCapas.insertarNodo(new NodoListaSimple(nodo.getId(), nodo));
        }
        inOrden(nodo.getHijoDerecho(), numeroCapas);

    }

    public ListaSimple preOrden(int numeroCapas) {
        listaCapas = new ListaSimple();
        preOrden(root, numeroCapas);
        return listaCapas;
    }

    private void preOrden(NodoArbolABB nodo, int numeroCapas) {
        if (null == nodo)
        {
            return;
        }
        if (listaCapas.getSize() == numeroCapas)
        {
            return;
        } else
        {
            listaCapas.insertarNodo(new NodoListaSimple(nodo.getId(), nodo));
        }
        preOrden(nodo.getHijoIzquierdo(),numeroCapas);
        preOrden(nodo.getHijoDerecho(),numeroCapas);
    }

    public ListaSimple postOrden(int numeroCapas) {
        listaCapas = new ListaSimple();
        postOrden(root, numeroCapas);
        return listaCapas;
    }

    private void postOrden(NodoArbolABB nodo, int numeroCapas) {
        if (null == nodo)
        {
            return;
        }
        postOrden(nodo.getHijoIzquierdo(), numeroCapas);
        postOrden(nodo.getHijoDerecho(), numeroCapas);
        if (listaCapas.getSize() == numeroCapas)
        {
            return;
        } else
        {
            listaCapas.insertarNodo(new NodoListaSimple(nodo.getId(), nodo));
        }
    }
    
    public void crearGrafo(){
        grafica = new StringBuffer();
        obtenerGrafo(root);
        Estructuras.generarGrafo(grafica, "\"Arbol ABB de Capas\"", "arbolABB");
    }
    
    public void obtenerGrafica(){
        grafica = new StringBuffer();
        obtenerGrafo(root);
    }
    
    public void obtenerGrafo(NodoArbolABB nodo){
        if(nodo==null){
            return;
        }
        
        obtenerGrafo(nodo.getHijoIzquierdo());
        if(nodo.getHijoIzquierdo()!=null){
            grafica.append(nodo.getId()+"->"+nodo.getHijoIzquierdo().getId()+";\n");
        }
        if(nodo.getHijoDerecho()!=null){
            grafica.append(nodo.getId()+"->"+nodo.getHijoDerecho().getId()+";\n");
        }
        obtenerGrafo(nodo.getHijoDerecho());
    }

    public StringBuffer getGrafica() {
        return grafica;
    }
    
    
    
}
