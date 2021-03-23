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
public class NodoMatriz {
    private int indice;
    private String eje;
    private NodoMatriz anterior;
    private NodoMatriz siguiente;

    public NodoMatriz(int indice, String eje, NodoMatriz anterior, NodoMatriz siguiente) {
        this.indice = indice;
        this.eje = eje;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public int getIndice() {
        return indice;
    }

    public String getEje() {
        return eje;
    }

    public NodoMatriz getAnterior() {
        return anterior;
    }

    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

    public void setAnterior(NodoMatriz anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
    
}
