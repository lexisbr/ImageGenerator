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
public class NodoArbol {

    private Object contenido;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    public NodoArbol(Object contenido) {
        this.contenido = contenido;
    }

    public NodoArbol(Object contenido, NodoArbol hijoIzquierdo, NodoArbol hijoDerecho) {
        this.contenido = contenido;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

}
