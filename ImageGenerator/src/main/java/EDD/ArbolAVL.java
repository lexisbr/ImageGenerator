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
public class ArbolAVL {

    private NodoArbol root;

    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();

        arbol.insertarNodo(new NodoArbol("a"));
        arbol.insertarNodo(new NodoArbol("aaa"));
        arbol.insertarNodo(new NodoArbol("aa"));
        arbol.insertarNodo(new NodoArbol("aa"));
        arbol.insertarNodo(new NodoArbol("aaBB"));
        arbol.insertarNodo(new NodoArbol("aaCC"));

        arbol.mostrarArbol();

        
        arbol.eliminarNodo("aa");
        arbol.mostrarArbol();
        
    }

    public ArbolAVL() {
        this.root = null;
    }

    public void clearAll() {
        root = null;
    }

    public void insertarNodo(NodoArbol nuevoNodo) {
        root = insertarAVL(root, nuevoNodo);
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
            System.out.println("El nodo ya existe");
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
        mostrarNodos(root, 0);

    }

    private void mostrarNodos(NodoArbol nodo, int espacio) {
        if (nodo.getHijoDerecho() != null)
        {
            System.out.println("Nodo: " + nodo.getId() + " Hijo derecho: " + nodo.getHijoDerecho().getId());
            // System.out.println("Altura " + nodo.getAltura());
            mostrarNodos(nodo.getHijoDerecho(), espacio + 1);
        }

        if (nodo.getHijoIzquierdo() != null)
        {
            System.out.println("Nodo: " + nodo.getId() + " Hijo Izquierdo: " + nodo.getHijoIzquierdo().getId());
            //  System.out.println("Altura " + nodo.getAltura());
            mostrarNodos(nodo.getHijoIzquierdo(), espacio + 1);
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
            if ((actualNodo.getHijoDerecho() == null) || (actualNodo.getHijoDerecho() == null))
            {
                NodoArbol aux = null;
                if (actualNodo.getHijoDerecho() == aux)
                {
                    aux = actualNodo.getHijoDerecho();
                } else
                {
                    aux = actualNodo.getHijoIzquierdo();
                }

                if (aux == null)
                {
                    actualNodo = null;
                } else
                {
                    actualNodo = aux;
                }
            } else
            {
                NodoArbol aux = getNodoMasGrande(actualNodo.getHijoIzquierdo());

                actualNodo = aux;

                actualNodo.setHijoIzquierdo(eliminarEnArbol(actualNodo.getHijoIzquierdo(), aux.getId()));

            }
        }

        if (actualNodo == null)
        {
            return actualNodo;
        }

        actualNodo.setAltura(alturaMaxima(getAltura(actualNodo.getHijoIzquierdo()), getAltura(actualNodo.getHijoDerecho())) + 1);

        int fe = getFactorEquilibrio(actualNodo);

        if (fe > 1 && getFactorEquilibrio(actualNodo.getHijoDerecho()) <= 0)
        {
            return rotacionIzquierda(actualNodo);
        }

        if (fe < -1 && getFactorEquilibrio(actualNodo.getHijoIzquierdo()) >= 0)
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
}
