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
public class NodoArbolABB {
    private NodoArbolABB hijoIzquierdo;
    private NodoArbolABB hijoDerecho;
    private Object contenido;
    private int id;

    public NodoArbolABB(NodoArbolABB hijoIzquierdo, NodoArbolABB hijoDerecho, Object contenido, int id) {
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
        this.contenido = contenido;
        this.id = id;
    }

    public NodoArbolABB(Object contenido, int id) {
        this.contenido =  contenido;
        this.id = id;
    }

    public NodoArbolABB getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoArbolABB getHijoDerecho() {
        return hijoDerecho;
    }

    public Object getContenido() {
        return contenido;
    }

    public int getId() {
        return id;
    }

    public void setHijoIzquierdo(NodoArbolABB hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoArbolABB hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
