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
    private String id;
    private int altura;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    public NodoArbol(String id) {
        this.id = id;
        altura = 1;
    }

    public NodoArbol(Object contenido) {
        this.contenido = contenido;
        altura = 1;
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

    public String getId() {
        return id;
    }

    public int getAltura() {
        return altura;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    
}
