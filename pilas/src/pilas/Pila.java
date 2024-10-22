
package pilas;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Pila<T> {
    private Object[] elementos;
    private int tope;
    private static final int CAPACIDAD_INICIAL = 10;
    
    // Constructor
    public Pila() {
        elementos = new Object[CAPACIDAD_INICIAL];
        tope = -1; // La pila está vacía
    }

    // Método para agregar un elemento a la pila
    public void push(T elemento) {
        if (tope == elementos.length - 1) {
            aumentarCapacidad();
        }
        elementos[++tope] = elemento;
    }

    // Método para quitar el elemento superior de la pila
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T elemento = (T) elementos[tope];
        elementos[tope--] = null; // Limpiar la referencia
        return elemento;
    }

    // Método para obtener el elemento superior sin quitarlo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return (T) elementos[tope];
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return tope == -1;
    }

    // Método para aumentar la capacidad 
    private void aumentarCapacidad() {
        int nuevaCapacidad = elementos.length * 2;
        elementos = Arrays.copyOf(elementos, nuevaCapacidad);
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return tope + 1;
    }
    
    public void imprimir() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
            return;
        }

        JOptionPane.showMessageDialog(null, "Elementos en la lista:");
        for (int i = tope; i >= 0; i--) {
            JOptionPane.showMessageDialog(null, elementos[i]);
        }
    }
    
}
