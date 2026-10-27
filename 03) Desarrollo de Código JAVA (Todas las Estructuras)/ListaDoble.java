
public class ListaDoble<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamano;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }
// Método creado por mí para agregar un nuevo nodo al inicio actualizando referencias dobles
    public void insertarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamano++;
    }
// Este método permite insertar al final o recorrer la lista doblemente enlazada
    public void insertarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cola == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamano++;
    }

    public void mostrarAdelante() {
        System.out.print("Lista Doble (Hacia adelante): ");
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + (actual.getSiguiente() != null ? " <-> " : ""));
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void mostrarAtras() {
        System.out.print("Lista Doble (Hacia atras): ");
        NodoDoble<T> actual = cola;
        while (actual != null) {
            System.out.print(actual.getDato() + (actual.getAnterior() != null ? " <-> " : ""));
            actual = actual.getAnterior();
        }
        System.out.println();
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
