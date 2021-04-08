/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo;

import EDD.ArbolABB;
import EDD.ArbolAVL;
import EDD.ListaDobleCircular;
import EDD.ListaSimple;
import EDD.Matriz;
import Nodos.NodoArbol;
import Nodos.NodoArbolABB;
import Nodos.NodoListaDoble;
import Nodos.NodoListaSimple;
import Nodos.NodoMatriz;
import Objetos.Imagen;
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
    private static ArbolABB arbolCapas = new ArbolABB();
    private static ListaDobleCircular listaImagenes = new ListaDobleCircular();


    public static void insertarUsuario(String id) {
        arbolUsuarios.insertarNodo(new NodoArbol(id, new Usuario(id)), false);
        arbolUsuarios.mostrarArbol();
    }

    public static void eliminarUsuario(String id) {
        arbolUsuarios.eliminarNodo(id, false);
        arbolUsuarios.mostrarArbol();
    }

    public static NodoArbol buscarUsuario(String id) {
        NodoArbol nodo = arbolUsuarios.buscarNodo(id);
        if (nodo != null)
        {
            return nodo;

        } else
        {
            return null;

        }
    }

    public static void modificarUsuario(String user, String id) {
        arbolUsuarios.modificarUsuario(user, id);
        arbolUsuarios.mostrarArbol();
    }

    public static void insertarCapa(Matriz capaNueva) {
        arbolCapas.insertarNodo(new NodoArbolABB(capaNueva, capaNueva.getId()));
    }

    public static NodoArbolABB buscarCapa(int id) {
        return arbolCapas.buscarNodo(id);
    }

    public static void graficarCapa(int id) {
        NodoArbolABB nodoMatriz = arbolCapas.buscarNodo(id);
        Matriz matriz = (Matriz) nodoMatriz.getContenido();
        matriz.generarImagen();
    }
    
    public static void mostrarCapas(){
        arbolCapas.mostrarArbol();
    }

    public static void insertarImagen(Imagen imagenNueva) {
        listaImagenes.insertarNodo(new NodoListaDoble(imagenNueva.getId(), imagenNueva));
        NodoListaDoble aux = listaImagenes.buscarNodo(imagenNueva.getId());
        Imagen aux_img = (Imagen) aux.getContenido();
        aux_img.getCapas().mostrarDatos();
        listaImagenes.mostrarDatos();
    }

    public static NodoListaDoble buscarImagen(int id) {
        return listaImagenes.buscarNodo(id);
    }
    
    public static void mostrarImagenes(){
        listaImagenes.mostrarDatos();
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
