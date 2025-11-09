
public class Persona {
    private String nombre;
    private String apellido;
    private int estatura;
    private float peso;

    public Persona(String nombre, String apellido, int estatura, float peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.peso = peso;

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Estatura: " + estatura + " Metros" +
                ", Peso: " + peso + " kg";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return (float) peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
