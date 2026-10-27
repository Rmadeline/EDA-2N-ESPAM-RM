
public class PilaArreglo<T> implements IPila<T> {
    private Object[] elementos;
    private int tope;

    public PilaArreglo(int capacidad) {
        this.elementos = new Object[capacidad];
        this.tope = -1;
    }

    // Método creado por mí para apilar un elemento bajo la estructura LIFO
    @Override
    public void push(T elemento) {
        if (tope == elementos.length - 1) {
            throw new IllegalStateException("Pila llena: Stack Overflow");
        }
        tope++;
        elementos[tope] = elemento;
    }

    // Este método extrae el elemento superior de la pila respetando el principio LIFO
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new PilaVaciaException("No se puede hacer pop en una pila vacia");
        }
        T dato = (T) elementos[tope];
        elementos[tope] = null; // Previene fuga de memoria (loitering)
        tope--;
        return dato;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new PilaVaciaException("No se puede hacer peek en una pila vacia");
        }
        return (T) elementos[tope];
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    @Override
    public int size() {
        return tope + 1;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= tope; i++) {
            elementos[i] = null;
        }
        tope = -1;
    }
}
