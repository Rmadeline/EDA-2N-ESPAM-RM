
public class PilaEnlazada<T> implements IPila<T> {
    private static class NodoPila<E> {
        E dato;
        NodoPila<E> siguiente;

        NodoPila(E dato, NodoPila<E> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    private NodoPila<T> cima;
    private int tamano;

    public PilaEnlazada() {
        this.cima = null;
        this.tamano = 0;
    }

    @Override
    public void push(T elemento) {
        cima = new NodoPila<>(elemento, cima);
        tamano++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new PilaVaciaException("No se puede hacer pop en una pila vacia");
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        return dato;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new PilaVaciaException("No se puede hacer peek en una pila vacia");
        }
        return cima.dato;
    }

    @Override
    public boolean isEmpty() {
        return cima == null;
    }

    @Override
    public int size() {
        return tamano;
    }

    @Override
    public void clear() {
        cima = null;
        tamano = 0;
    }
}
