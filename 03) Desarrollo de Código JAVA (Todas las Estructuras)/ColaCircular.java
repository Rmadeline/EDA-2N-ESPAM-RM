public class ColaCircular<T> {
    private T[] arreglo;
    private int frente;
    private int finalCola;
    private int capacidad;
    private int tamanio;

    @SuppressWarnings("unchecked")
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = (T[]) new Object[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public boolean estaLlena() {
        return tamanio == capacidad;
    }

    public void enqueue(T elemento) {
        if (estaLlena()) {
            System.out.println("Desbordamiento (Overflow) La cola esta llena.");
            return;
        }
        finalCola = (finalCola + 1) % capacidad; 
        arreglo[finalCola] = elemento;
        tamanio++;
    }
    public T dequeue() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No hay turnos por atender.");
            return null;
        }
        T elemento = arreglo[frente];
        arreglo[frente] = null; 
        frente = (frente + 1) % capacidad; 
        tamanio--;
        return elemento;
    }

    public T peek() {
        if (estaVacia()) return null;
        return arreglo[frente];
    }

    public int getTamanio() {
        return tamanio;
    }
}