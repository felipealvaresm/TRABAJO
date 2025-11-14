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

    // ------------------------------------------ LISTA EN REVERSA------------------------------------------

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

    // ------------------------------------------ AGREGA PERSONA AL FINAL ------------------------------------------

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

    ////////-------------------------------- INSERTA EN POSICION ESPECIFICA --------------------------------///////

public boolean insertarEnPosicion(Persona persona, int posicion) {
    if (posicion < 0 || posicion > tamaño) {
        System.out.println("Posición inválida.");
        return false;
    }

    NodoDoble nuevo = new NodoDoble(persona);

    if (posicion == 0) {
        // Este inserta al inicio
        nuevo.setSiguiente(cabeza);
        if (cabeza != null) {
            cabeza.setAnterior(nuevo);
        }
        cabeza = nuevo;
        if (cola == null) {
            cola = nuevo;
        }
    } else if (posicion == tamaño) {
        // Este nserta  al final
        nuevo.setAnterior(cola);
        if (cola != null) {
            cola.setSiguiente(nuevo);
        }
        cola = nuevo;
        if (cabeza == null) {
            cabeza = nuevo;
        }
    } else {
        // Este Inserta en el medio
        NodoDoble actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        NodoDoble anterior = actual.getAnterior();
        nuevo.setAnterior(anterior);
        nuevo.setSiguiente(actual);
        anterior.setSiguiente(nuevo);
        actual.setAnterior(nuevo);
    }

    tamaño++;
    return true;
}
}