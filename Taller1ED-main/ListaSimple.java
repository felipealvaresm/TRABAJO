public class ListaSimple {
    private Nodo P, U, Q;

    public ListaSimple() {
        this.P = null;//primero
        this.U = null;//ultimo
        this.Q = null; // Auxiliar

    }

    public ListaSimple(Persona Persona) {
        Nodo nuevo = new Nodo(Persona);
        this.P = nuevo;
        this.U = nuevo;
        this.Q = null;
    }

    public Nodo getP() {
        return P;
    }

    public void setP(Nodo p) {
        P = p;
    }

    public Nodo getU() {
        return U;
    }

    public void setU(Nodo u) {
        U = u;
    }

    public Nodo getQ() {
        return Q;
    }

    public void setQ(Nodo q) {
        Q = q;
    }


    public boolean ListaVacia() {
        if (this.P == null) {
            return true;
        } else {
            return false;
        }
    }

        public void agregarPersonaInicio(Persona persona) {
        Nodo nuevo = new Nodo(persona);
        if (ListaVacia()) {
            P = nuevo;
            U = nuevo;
        } else {
            U.setSiguiente(nuevo);
            U = nuevo;
        }
    }

    public void mostrarLista() {
        if (ListaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo aux = P;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public Persona buscarPersona(String nombre) {
        Nodo aux = P;
        while (aux != null) {
            if (aux.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null; // no encontrada
    }

    public boolean eliminarPersona(String nombre) {
        if (ListaVacia()) return false;

        // Caso: para primera persona
        if (P.getDato().getNombre().equalsIgnoreCase(nombre)) {
            P = P.getSiguiente();
            if (P == null) U = null;
            return true;
        }

        // Caso:para el medio o al final
        Nodo anterior = P;
        Nodo actual = P.getSiguiente();

        while (actual != null) {
            if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
                anterior.setSiguiente(actual.getSiguiente());
                if (actual == U) U = anterior;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false; // no encontrada
    }
public void promedioEstaturaPeso() {
        if (ListaVacia()) {
            System.out.println("No hay personas en la lista.");
            return;
        }

        int sumaEstatura = 0;
        float sumaPeso = 0;
        int contador = 0;

        Nodo aux = P;
        while (aux != null) {
            sumaEstatura += aux.getDato().getEstatura();
            sumaPeso += aux.getDato().getPeso();
            contador++;
            aux = aux.getSiguiente();
        }

        System.out.println("Promedio de estatura: " + (sumaEstatura / (float) contador) + " cm");
        System.out.println("Promedio de peso: " + (sumaPeso / contador) + " kg");
    }

    public int ContarNodos(){
        int contador = 0;
        Nodo aux = P;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
    

    

}
