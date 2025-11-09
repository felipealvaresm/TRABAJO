public class NodoDoble {
    private Persona persona;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(Persona persona) {
        this.persona = persona;
        this.anterior = null;
        this.siguiente = null;
    }

    public Persona getPersona() {
        return persona;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
public void setPersona(Persona persona) {
    this.persona = persona;
}

}


