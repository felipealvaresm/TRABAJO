public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamaño;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void agregarPersonaInicio(Persona persona) {
        NodoDoble nuevo = new NodoDoble(persona);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamaño++;
    }

    public void mostrarLista() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getPersona());
            actual = actual.getSiguiente();
        }
    }

    public int contarNodos() {
        return tamaño;
    }

    public boolean eliminarPersona(String nombre) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getPersona().getNombre().equalsIgnoreCase(nombre)) {
                NodoDoble anterior = actual.getAnterior();
                NodoDoble siguiente = actual.getSiguiente();

                if (anterior != null) {
                    anterior.setSiguiente(siguiente);
                } else {
                    cabeza = siguiente;
                }

                if (siguiente != null) {
                    siguiente.setAnterior(anterior);
                } else {
                    cola = anterior;
                }

                tamaño--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public Persona buscarPersona(String nombre) {
        NodoDoble actual = cabeza;
        while (actual != null) {
            if (actual.getPersona().getNombre().equalsIgnoreCase(nombre)) {
                return actual.getPersona();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void promedioEstaturaPeso() {
        if (tamaño == 0) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDoble actual = cabeza;
        int sumaEstatura = 0;
        float sumaPeso = 0;

        while (actual != null) {
            sumaEstatura += actual.getPersona().getEstatura();
            sumaPeso += actual.getPersona().getPeso();
            actual = actual.getSiguiente();
        }

        System.out.println("Promedio de estatura: " + (sumaEstatura / (float) tamaño) + " cm");
        System.out.println("Promedio de peso: " + (sumaPeso / tamaño) + " kg");
    }

    // ------------------------------------------ LISTA EN REVERSA
    // ------------------------------------------

    public void mostrarListaReversa() {
        if (cola == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDoble actual = cola;
        while (actual != null) {
            System.out.println(actual.getPersona());
            actual = actual.getAnterior();
        }
    }

    // ------------------------------------------ AGREGAR PERSONA AL FINAL ------------------------------------------

    public void agregarPersonaFinal(Persona persona) {
        NodoDoble nuevo = new NodoDoble(persona);
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamaño++;
    }

}
