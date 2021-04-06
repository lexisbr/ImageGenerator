/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author lex
 */
public class NodoListaSimple {

    private String id;
    private Object contenido;
    private NodoListaSimple siguiente;
    private NodoArbolABB capa;

    public NodoListaSimple(String id) {
        this.id = id;
    }

    public NodoListaSimple(String id, Object contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public NodoListaSimple(Object contenido, NodoListaSimple siguiente) {
        this.contenido = contenido;
        this.siguiente = siguiente;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    public String getId() {
        return id;
    }

    public NodoArbolABB getCapa() {
        return capa;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setSiguiente(NodoListaSimple siguiente) {
        this.siguiente = siguiente;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCapa(NodoArbolABB capa) {
        this.capa = capa;
    }

}
