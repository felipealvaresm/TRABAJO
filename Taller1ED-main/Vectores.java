
class Persona {
    private String nombre;

    public Persona(String nombre, String apellido, int estatura, float peso) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre='" + nombre + '\'' + '}';
    }

	public double getEstatura() {

		throw new UnsupportedOperationException("Unimplemented method 'getEstatura'");
	}

    public float getPeso() {

        throw new UnsupportedOperationException("Unimplemented method 'getPeso'");
    }
}

public class Vectores {

    private Persona[] VectorPersona;
    private int max;
    private int indice;
    private int indiceActual;

    public Vectores(int Max) {

        this.max = Max;
        this.VectorPersona = new Persona[Max];
        this.indice = 0;

    }

    public Persona getPersona(int indice) {
        if (indice >= 0 && indice < this.indice && this.VectorPersona[indice] != null) {
            return this.VectorPersona[indice];
        }
        return null;
    }

    public void setVectorPersona(Persona[] VectorPersona) {
        this.VectorPersona = VectorPersona;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean VectorLleno() {
        return indiceActual >= VectorPersona.length;
    }

    public boolean VectorVacio() {
        return indiceActual == 0;
    }

    public void agregarPersona(Persona p) {
        if (!VectorLleno()) {
            VectorPersona[indiceActual] = p;
            indiceActual++;
            System.out.println("Persona agregada Exitosamente." + p);
        } else {
            System.out.println("El vector está lleno. No se puede agregar.");
        }
    }

    public void eliminarPersona(int pos) {
        if (pos >= 0 && pos < indice) {

            Persona personaEliminada = this.VectorPersona[pos];
            System.out.println(" Persona eliminada: " + personaEliminada);

            for (int i = pos; i < indice - 1; i++) {
                this.VectorPersona[i] = this.VectorPersona[i + 1];
            }
            this.VectorPersona[indice - 1] = null;
            indice--;

        } else {
            System.out.println("No se puede eliminar, el vector esta vacio o la posicion es invalida");
        }
    }

    public int buscarPersona(String nombre) {
        for (int i = 0; i < this.indiceActual; i++) {
            if (this.VectorPersona[i] != null &&
                    this.VectorPersona[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(this.VectorPersona[i]);
                System.out.println("Persona encontrada en la posición: " + i);
                return i;
            }
        }
        return -1;
    }

    public void mostrar() {
        if (!VectorVacio()) {
            for (int i = 0; i <= this.indice; i++) {
                System.out.println(this.VectorPersona[i]);
            }
        } else {
            System.out.println("El vector esta vacio");
        }
    }
}
