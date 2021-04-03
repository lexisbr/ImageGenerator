/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo;

import EDD.ArbolAVL;
import EDD.NodoArbol;
import Objetos.Usuario;

/**
 *
 * @author lex
 */
public class Estructuras {

    private static ArbolAVL arbolUsuarios = new ArbolAVL();

    public static void insertarUsuario(String id) {
        arbolUsuarios.insertarNodo(new NodoArbol(id, new Usuario(id)));
        arbolUsuarios.mostrarArbol();
    }

    public static void eliminarUsuario(String id) {
        arbolUsuarios.eliminarNodo(id);
        arbolUsuarios.mostrarArbol();
    }

    public static String buscarUsuario(String id) {
        NodoArbol nodo = arbolUsuarios.buscarNodo(id);
        if (nodo != null)
        {
            return nodo.getId();

        } else
        {
            return null;

        }
    }

    public static void modificarUsuario(String user, String id) {
        arbolUsuarios.modificarUsuario(user, id);
        arbolUsuarios.mostrarArbol();
    }

}
