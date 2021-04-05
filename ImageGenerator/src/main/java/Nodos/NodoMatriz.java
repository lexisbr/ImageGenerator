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
public class NodoMatriz {
    private int x;
    private int y;
    private Object contenido;
    private NodoMatriz izquierda;
    private NodoMatriz derecha;
    private NodoMatriz abajo;
    private NodoMatriz arriba;

    public NodoMatriz(int x, int y, Object contenido, NodoMatriz izquierda, NodoMatriz derecha, NodoMatriz abajo, NodoMatriz arriba) {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.abajo = abajo;
        this.arriba = arriba;
    }

    public NodoMatriz(int x, int y, Object contenido) {
        this.x = x;
        this.y = y;
        this.contenido = contenido;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoMatriz getIzquierda() {
        return izquierda;
    }

    public NodoMatriz getDerecha() {
        return derecha;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setIzquierda(NodoMatriz izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(NodoMatriz derecha) {
        this.derecha = derecha;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    
    
    
    
    
    
}
