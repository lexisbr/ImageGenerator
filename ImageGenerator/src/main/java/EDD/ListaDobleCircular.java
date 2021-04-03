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
public class ListaDobleCircular {

    private NodoListaDoble root;
    private NodoListaDoble end;

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
        }else if (nodoNoExiste(nuevoNodo.getId())) {
            end.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(root);
            nuevoNodo.setAnterior(end);
            end = nuevoNodo;
            root.setAnterior(end);
        } else{
            System.out.println("NODO YA EXISTE: "+nuevoNodo.getId());
        }
    }
    
    public boolean nodoNoExiste(String id){
        NodoListaDoble aux = root;
        do
        {            
            if(aux.getId().equals(id)){
                return false;
            }
            aux = aux.getSiguiente();
            
        } while (aux!=root);
        
        return true;
    }
    
    public void mostrarDatos(){
        NodoListaDoble aux = root;
        
        do{
            System.out.print("Nodo: "+aux.getId());
            if(aux.getSiguiente()!=null){
                System.out.print(" Siguiente: "+aux.getSiguiente().getId());
            }
            if(aux.getAnterior()!=null){
                System.out.print(" Anterior: "+aux.getAnterior().getId());
            }
            System.out.println("\n\n**********************************************");
            aux = aux.getSiguiente();
        }while(aux!=root);
        
        
    }

}
