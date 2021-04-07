/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import EDD.ListaDoble;

/**
 *
 * @author lex
 */
public class Usuario {
    private String id;
    private ListaDoble listaImagenes;

    public Usuario(String id) {
        this.id = id;
        this.listaImagenes = new ListaDoble();
    }

    public String getId() {
        return id;
    }
    
    public ListaDoble getListaImagenes(){
        return listaImagenes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListaImagenes(ListaDoble listaImagenes) {
        this.listaImagenes = listaImagenes;
    }
    
}
