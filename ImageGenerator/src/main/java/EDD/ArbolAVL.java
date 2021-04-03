/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Objetos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class ArbolAVL {

    private NodoArbol root;
    private boolean exist = false;
    private boolean deleted = false;

    public ArbolAVL() {
        this.root = null;
    }

    public void clearAll() {
        root = null;
    }

    public void insertarNodo(NodoArbol nuevoNodo) {
        root = insertarAVL(root, nuevoNodo);
        if (exist)
        {
            JOptionPane.showMessageDialog(null, "El usuario ya existe");
            exist = false;
        } else
        {
            JOptionPane.showMessageDialog(null, "El usuario se ha creado exitosamente");
        }
    }

    private NodoArbol insertarAVL(NodoArbol actualNodo, NodoArbol nuevoNodo) {
        if (actualNodo == null)
        {
            return nuevoNodo;
        }

        if (nuevoNodo.getId().compareTo(actualNodo.getId()) < 0)
        {
            actualNodo.setHijoIzquierdo(insertarAVL(actualNodo.getHijoIzquierdo(), nuevoNodo));
        } else if (nuevoNodo.getId().compareTo(actualNodo.getId()) > 0)
        {
            actualNodo.setHijoDerecho(insertarAVL(actualNodo.getHijoDerecho(), nuevoNodo));
        } else
        {
            exist = true;
            return actualNodo;
        }

        actualNodo.setAltura(1 + alturaMaxima(getAltura(actualNodo.getHijoIzquierdo()), getAltura(actualNodo.getHijoDerecho())));

        int fe = getFactorEquilibrio(actualNodo);

        if (fe > 1 && nuevoNodo.getId().compareTo(actualNodo.getHijoDerecho().getId()) > 0)
        {
            return rotacionIzquierda(actualNodo);
        }

        if (fe < -1 && nuevoNodo.getId().compareTo(actualNodo.getHijoIzquierdo().getId()) < 0)
        {
            return rotacionDerecha(actualNodo);
        }

        if (fe >= 2 && getFactorEquilibrio(actualNodo.getHijoDerecho()) < 0)
        {
            actualNodo.setHijoDerecho(rotacionDerecha(actualNodo.getHijoDerecho()));
            return rotacionIzquierda(actualNodo);
        }

        if (fe <= -2 && getFactorEquilibrio(actualNodo.getHijoIzquierdo()) > 0)
        {
            actualNodo.setHijoIzquierdo(rotacionIzquierda(actualNodo.getHijoIzquierdo()));
            return rotacionDerecha(actualNodo);
        }

        return actualNodo;
    }

    private NodoArbol rotacionDerecha(NodoArbol actualNodo) {
        NodoArbol nuevoRoot = actualNodo.getHijoIzquierdo();
        NodoArbol aux = nuevoRoot.getHijoDerecho();

        nuevoRoot.setHijoDerecho(actualNodo);
        actualNodo.setHijoIzquierdo(aux);

        actualNodo.setAltura(alturaMaxima(getAltura(actualNodo.getHijoIzquierdo()), getAltura(actualNodo.getHijoDerecho())) + 1);
        nuevoRoot.setAltura(alturaMaxima(getAltura(nuevoRoot.getHijoIzquierdo()), getAltura(nuevoRoot.getHijoDerecho())) + 1);

        return nuevoRoot;
    }

    private NodoArbol rotacionIzquierda(NodoArbol actualNodo) {
        NodoArbol nuevoRoot = actualNodo.getHijoDerecho();
        NodoArbol aux = nuevoRoot.getHijoIzquierdo();

        nuevoRoot.setHijoIzquierdo(actualNodo);
        actualNodo.setHijoDerecho(aux);

        actualNodo.setAltura(alturaMaxima(getAltura(actualNodo.getHijoIzquierdo()), getAltura(actualNodo.getHijoDerecho())) + 1);
        nuevoRoot.setAltura(alturaMaxima(getAltura(nuevoRoot.getHijoIzquierdo()), getAltura(nuevoRoot.getHijoDerecho())) + 1);

        return nuevoRoot;
    }

    public void mostrarArbol() {
        System.out.println("Arbol AVL");
        mostrarNodos(root);

    }

    private void mostrarNodos(NodoArbol nodo) {

        if (root != null)
        {

            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null)
            {
                System.out.println("Nodo: " + nodo.getId());
            }
            if (nodo.getHijoDerecho() != null)
            {
                System.out.println("Nodo: " + nodo.getId() + " Hijo derecho: " + nodo.getHijoDerecho().getId());
                mostrarNodos(nodo.getHijoDerecho());
            }
            if (nodo.getHijoIzquierdo() != null)
            {
                System.out.println("Nodo: " + nodo.getId() + " Hijo Izquierdo: " + nodo.getHijoIzquierdo().getId());
                mostrarNodos(nodo.getHijoIzquierdo());
            }
        } else
        {
            System.out.println("ARBOL VACIO");
        }

    }

    private int alturaMaxima(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getAltura(NodoArbol actualNodo) {
        if (actualNodo == null)
        {
            return 0;
        }

        return actualNodo.getAltura();
    }

    private int getFactorEquilibrio(NodoArbol actualNodo) {
        if (actualNodo == null)
        {
            return 0;
        }

        return getAltura(actualNodo.getHijoDerecho()) - getAltura(actualNodo.getHijoIzquierdo());
    }

    public NodoArbol buscarNodo(String id) {
        return buscarEnArbol(root, id);
    }

    private NodoArbol buscarEnArbol(NodoArbol actualNodo, String id) {
        if (actualNodo == null)
        {
            return null;
        } else if (id.equals(actualNodo.getId()))
        {
            return actualNodo;
        } else if (id.compareTo(actualNodo.getId()) < 0)
        {
            return buscarEnArbol(actualNodo.getHijoIzquierdo(), id);
        } else
        {
            return buscarEnArbol(actualNodo.getHijoDerecho(), id);
        }
    }

    public void eliminarNodo(String id) {
        root = eliminarEnArbol(root, id);
        if (deleted)
        {
            JOptionPane.showMessageDialog(null, "Se ha eliminado usuario exitosamente");
            deleted = false;
        } else
        {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        }
    }

    public NodoArbol eliminarEnArbol(NodoArbol actualNodo, String id) {
        if (actualNodo == null)
        {
            return actualNodo;
        }

        if (id.compareTo(actualNodo.getId()) < 0)
        {
            actualNodo.setHijoIzquierdo(eliminarEnArbol(actualNodo.getHijoIzquierdo(), id));
        } else if (id.compareTo(actualNodo.getId()) > 0)
        {
            actualNodo.setHijoDerecho(eliminarEnArbol(actualNodo.getHijoDerecho(), id));
        } else
        {
            if ((actualNodo.getHijoIzquierdo() == null) || (actualNodo.getHijoDerecho() == null))
            {
                NodoArbol aux = null;
                if (actualNodo.getHijoDerecho() == aux)
                {
                    aux = actualNodo.getHijoIzquierdo();
                } else
                {
                    aux = actualNodo.getHijoDerecho();
                }

                if (aux == null)
                {
                    actualNodo = null;
                } else
                {
                    actualNodo = aux;
                }
                deleted = true;
            } else
            {
                NodoArbol aux = getNodoMasGrande(actualNodo.getHijoIzquierdo());

                actualNodo.setId(aux.getId());
                actualNodo.setContenido(aux.getContenido());

                actualNodo.setHijoIzquierdo(eliminarEnArbol(actualNodo.getHijoIzquierdo(), aux.getId()));

            }
        }

        if (actualNodo == null)
        {
            return actualNodo;
        }

        actualNodo.setAltura(alturaMaxima(getAltura(actualNodo.getHijoIzquierdo()), getAltura(actualNodo.getHijoDerecho())) + 1);

        int fe = getFactorEquilibrio(actualNodo);

        if (fe > 1 && getFactorEquilibrio(actualNodo.getHijoDerecho()) >= 0)
        {
            return rotacionIzquierda(actualNodo);
        }

        if (fe < -1 && getFactorEquilibrio(actualNodo.getHijoIzquierdo()) <= 0)
        {
            return rotacionDerecha(actualNodo);
        }

        if (fe > 1 && getFactorEquilibrio(actualNodo.getHijoDerecho()) < 0)
        {
            actualNodo.setHijoDerecho(rotacionDerecha(actualNodo.getHijoDerecho()));
            return rotacionIzquierda(actualNodo);
        }

        if (fe < -1 && getFactorEquilibrio(actualNodo.getHijoIzquierdo()) > 0)
        {
            actualNodo.setHijoIzquierdo(rotacionIzquierda(actualNodo.getHijoIzquierdo()));
            return rotacionDerecha(actualNodo);
        }

        return actualNodo;
    }

    private NodoArbol getNodoMasGrande(NodoArbol nodo) {
        NodoArbol actualNodo = nodo;

        while (actualNodo.getHijoDerecho() != null)
        {
            actualNodo = actualNodo.getHijoDerecho();
        }

        return actualNodo;
    }

    public void modificarUsuario(String nodoSeleccionado, String id) {
        NodoArbol nodoSelec = buscarNodo(nodoSeleccionado);
        NodoArbol nodoNuevo = buscarNodo(id);

        if (nodoNuevo == null)
        {
            nodoSelec.setId(id);
            Usuario user = (Usuario) nodoSelec.getContenido();
            user.setId(id);
            nodoSelec.setContenido(user);
            JOptionPane.showMessageDialog(null, "El usuario fue modificado");
        } else
        {
            JOptionPane.showMessageDialog(null, "El id ya existe");
        }
    }

}
