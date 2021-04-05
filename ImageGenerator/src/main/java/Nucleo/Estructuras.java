/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo;

import EDD.ArbolAVL;
import Nodos.NodoArbol;
import Objetos.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class Estructuras {

    private static ArbolAVL arbolUsuarios = new ArbolAVL();

    public static void insertarUsuario(String id) {
        arbolUsuarios.insertarNodo(new NodoArbol(id, new Usuario(id)), false);
        arbolUsuarios.mostrarArbol();
    }

    public static void eliminarUsuario(String id) {
        arbolUsuarios.eliminarNodo(id, false);
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

    public static void guardarArchivo(StringBuffer codigo, String path) {
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(writer);
            out.write("");
            out.write(codigo.toString());
            out.close();
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
        } finally
        {
            try
            {
                writer.close();
            } catch (IOException ex)
            {
                JOptionPane.showMessageDialog(null, "No se pudo cerrar el archivo");
            }
        }
    }

}
