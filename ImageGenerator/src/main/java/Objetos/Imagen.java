/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import EDD.ListaSimple;
import EDD.Matriz;
import Nodos.NodoListaSimple;
import Nodos.NodoMatriz;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class Imagen {

    private int id;
    private ListaSimple capas;
    private Matriz imagen;

    public Imagen() {
        this.capas = new ListaSimple();
    }

    public Imagen(int id) {
        this.id = id;
        this.capas = new ListaSimple();
    }

    public int getId() {
        return id;
    }

    public ListaSimple getCapas() {
        return capas;
    }

    public Matriz getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapas(ListaSimple capas) {
        this.capas = capas;
    }

    public void setImagen(Matriz imagen) {
        this.imagen = imagen;
    }

    public void generarImagen() {
        if (this.imagen == null)
        {
            imagen = crearImagen();
        }
        imagen.generarImagen();
    }

    private Matriz crearImagen() {
        Matriz imagenMatriz = new Matriz();
        if (capas.estaVacia())
        {
            return null;
        } else
        {
            Matriz capa = capas.extraerNodo();
            while (capa != null)
            {
                if (!capa.estaVacia())
                {
                    int filas = capa.obtenerFilas();
                    int columnas = capa.obtenerColumnas();
                    for (int y = 1; y <= filas; y++)
                    {
                        for (int x = 1; x <= columnas; x++)
                        {
                            NodoMatriz nodo = capa.buscarNodo(x, y);
                            if (nodo != null)
                            {
                                imagenMatriz.insertarPixel(new NodoMatriz(nodo.getX(), nodo.getY(), nodo.getContenido().toString()));
                            }
                        }
                    }
                }
                capa = capas.extraerNodo();
            }
            return imagenMatriz;

        }

    }

}
