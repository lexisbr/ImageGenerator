package Nodos;

/**
 *
 * @author lex
 */
public class NodoListaDoble {
    private int id;
    private Object contenido;
    private NodoListaDoble siguiente;
    private NodoListaDoble anterior;

    public NodoListaDoble(int id, Object contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public NodoListaDoble(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Object getContenido() {
        return contenido;
    }

    public NodoListaDoble getSiguiente() {
        return siguiente;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public void setSiguiente(NodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }
    
    
    
    
    
}
