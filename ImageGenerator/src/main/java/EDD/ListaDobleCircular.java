package EDD;

import Nodos.NodoListaDoble;
import javax.swing.JOptionPane;

/**
 *
 * @author lex
 */
public class ListaDobleCircular {

    private NodoListaDoble root;
    private NodoListaDoble end;

    public static void main(String[] args) {
        ListaDobleCircular lista = new ListaDobleCircular();
        lista.insertarNodo(new NodoListaDoble("3"));
        lista.insertarNodo(new NodoListaDoble("2"));
        lista.insertarNodo(new NodoListaDoble("1"));
        lista.insertarNodo(new NodoListaDoble("4"));
        lista.mostrarDatos();
        lista.ordenarLista();
        lista.mostrarDatos();
    }

    public ListaDobleCircular() {
        root = null;
        end = null;
    }

    public void insertarNodo(NodoListaDoble nuevoNodo) {
        if (root == null)
        {
            root = nuevoNodo;
            end = nuevoNodo;
            root.setSiguiente(root);
            root.setAnterior(end);
        } else if (nodoNoExiste(nuevoNodo.getId()))
        {
            end.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(root);
            nuevoNodo.setAnterior(end);
            end = nuevoNodo;
            root.setAnterior(end);
        } else
        {
            System.out.println("NODO YA EXISTE: " + nuevoNodo.getId());
        }
    }

    public boolean nodoNoExiste(String id) {
        NodoListaDoble aux = root;
        do
        {
            if (aux.getId().equals(id))
            {
                return false;
            }
            aux = aux.getSiguiente();

        } while (aux != root);

        return true;
    }

    public void mostrarDatos() {
        NodoListaDoble aux = root;
        System.out.println("Lista Circular Doblemente Enlazada ");
        System.out.println("Tamanio " + getSize());
        do
        {
            System.out.print("Nodo: " + aux.getId());
            if (aux.getSiguiente() != null)
            {
                System.out.print(" Siguiente: " + aux.getSiguiente().getId());
            }
            if (aux.getAnterior() != null)
            {
                System.out.print(" Anterior: " + aux.getAnterior().getId());
            }
            System.out.println("\n\n**********************************************");
            aux = aux.getSiguiente();
        } while (aux != root);

    }

    public NodoListaDoble buscarNodo(String id) {
        if (root != null)
        {
            NodoListaDoble aux = root;
            do
            {
                if (aux.getId().equals(id))
                {
                    return aux;
                } else
                {
                    aux = aux.getSiguiente();
                }
            } while (aux != root);
        }

        return null;
    }

    public void eliminarNodo(String id) {
        if (root != null)
        {
            NodoListaDoble nodo = buscarNodo(id);
            NodoListaDoble nodoAnterior = nodo.getAnterior();
            NodoListaDoble nodoSiguiente = nodo.getSiguiente();
            nodoAnterior.setSiguiente(nodoSiguiente);
            nodoSiguiente.setAnterior(nodoAnterior);
            JOptionPane.showMessageDialog(null, "Se ha eliminado imagen correctamente.");
        }
    }

    public void ordenarLista() {
        int size = getSize();
        if (size > 1)
        {
            for(int i = 0; i < getSize();i++){
                NodoListaDoble actual = root;
                NodoListaDoble siguiente = actual.getSiguiente();
                for(int j=1; j<getSize(); j++){
                    if(actual.getId().compareTo(siguiente.getId()) > 0){
                        String id_1 = actual.getId();
                        Object imagen_1 = actual.getContenido();
                        
                        actual.setId(siguiente.getId());
                        actual.setContenido(siguiente.getContenido());
                        siguiente.setId(id_1);
                        siguiente.setContenido(imagen_1);
                        actual = actual.getSiguiente();
                        siguiente = siguiente.getSiguiente();
                    }else{
                        actual = actual.getSiguiente();
                        siguiente = siguiente.getSiguiente();
                    }
                }
            }
        }
    }

    public int getSize() {
        NodoListaDoble aux = root;
        int size = 0;
        do
        {
            size++;
            aux = aux.getSiguiente();
        } while (aux != root);
        return size;
    }

}
