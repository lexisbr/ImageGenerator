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

    public static void main(String[] args) {
        Matriz matriz = new Matriz("1");
        matriz.insertarPixel(new NodoMatriz(1,1,"#4568cb"));
        matriz.insertarPixel(new NodoMatriz(1,2,"#4568cb"));
        matriz.insertarPixel(new NodoMatriz(1,3,"#4568cb"));
        matriz.insertarPixel(new NodoMatriz(1,4,"#4568cb"));
        Matriz matriz2 = new Matriz("2");
        
        
        Estructuras.insertarCapa(matriz);
        Estructuras.insertarCapa(matriz2);

        Imagen imagen = new Imagen("imagen1");
        imagen.getCapas().insertarNodo(new NodoListaSimple("1"));
        imagen.getCapas().insertarNodo(new NodoListaSimple("2"));
        
//        Matriz matriz3 = imagen.getCapas().extraerNodo();
//        System.out.println("Matriz "+matriz3.getId());
//        matriz3.imprimirNodos();
//        Matriz matriz4 = imagen.getCapas().extraerNodo();
//        System.out.println("Matriz "+matriz4.getId());
//        matriz4.imprimirNodos();
        imagen.generarImagen();
    }

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

    public static void insertarCapa(Matriz capaNueva) {
        arbolCapas.insertarNodo(new NodoArbolABB(capaNueva, capaNueva.getId()));
    }

    public static NodoArbolABB buscarCapa(String id) {
        return arbolCapas.buscarNodo(id);
    }
    
    public static void graficarCapa(String id){
        NodoArbolABB nodoMatriz = arbolCapas.buscarNodo(id);
        Matriz matriz = (Matriz) nodoMatriz.getContenido();
        matriz.generarImagen();
    }
    
    public static void insertarImagen(Imagen imagenNueva) {
        listaImagenes.insertarNodo(new NodoListaDoble(imagenNueva.getId(), imagenNueva));
        System.out.println("\n");
        NodoListaDoble aux = listaImagenes.buscarNodo(imagenNueva.getId());
        Imagen aux_img = (Imagen) aux.getContenido();
        System.out.println("Imagen "+aux_img.getId());
        System.out.println("Capas: ");
        aux_img.getCapas().mostrarDatos();
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
