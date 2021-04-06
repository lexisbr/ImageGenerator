/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import EDD.Matriz;

/**
 *
 * @author lex
 */
public class Capa {

    private String id;
    private Matriz capa;

    public Capa(String id, Matriz capa) {
        this.id = id;
        this.capa = capa;
    }

    public String getId() {
        return id;
    }

    public Matriz getCapa() {
        return capa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCapa(Matriz capa) {
        this.capa = capa;
    }

}
