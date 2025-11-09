import java.util.Scanner;

public class MenuM_V_L {

    private int opcion;
    private Vectores vector;
    private Scanner scanner = new Scanner(System.in);
    private Matrices matriz;
    private ListaSimple lista;

    private Persona solicitarDatosPersona(Scanner scanner) {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la estatura (Metros): ");
        int estatura = scanner.nextInt();
        System.out.print("Ingrese el peso (kg): ");
        float peso = scanner.nextFloat();
        scanner.nextLine(); // limpiar buffer

        return new Persona(nombre, apellido, estatura, peso);
    }

    public void MenuM_M_V() {
        this.scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de gestion de personas");
        System.out.println("Seleccione la estructura de datos que desea utilizar:");

        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Vectores");
            System.out.println("2. Matrices");
            System.out.println("3. Listas");
            System.err.println("4.Lista Doble");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuVectores();
                    break;
                case 2:
                    menuMatrices();
                    break;
                case 3:
                    menuListas();
                    break;
                case 4:
                    menuListaDoble();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 4);

    }

    public void menuVectores() {
        System.out.println("Bienvenido al metodo vectores");

        do {
            System.out.println("1. Agregar personas");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Buscar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (vector == null) {
                        System.out.println("Ingrese el número de personas a registrar: ");
                        int max = scanner.nextInt();
                        scanner.nextLine();
                        vector = new Vectores(max);
                    }

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la estatura (Metros): ");
                    int estatura = scanner.nextInt();
                    System.out.print("Ingrese el peso (en kg): ");
                    float peso = scanner.nextFloat();
                    scanner.nextLine();

                    Persona persona = new Persona(nombre, apellido, estatura, peso);
                    vector.agregarPersona(persona);

                    break;
                case 2:
                    if (vector == null || vector.VectorVacio()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        vector.mostrar();
                    }
                    break;

                case 3:

                    if (vector == null || vector.VectorVacio()) {
                        System.out.println("No hay personas registradas para buscar.");
                    } else {

                        System.out.print("Ingrese el nombre de la persona a buscar: ");
                        String nombreBuscar = scanner.nextLine();

                        vector.buscarPersona(nombreBuscar);

                    }
                    break;

                case 4:
                    if (vector == null || vector.VectorVacio()) {
                        System.out.println("No hay personas registradas para eliminar.");
                    } else {
                        int indiceActual = vector.getIndice();
                        System.out.print("Ingrese la posición a eliminar (0 a " + (indiceActual - 1) + "): ");

                        if (scanner.hasNextInt()) {
                            int posicionPersona = scanner.nextInt();
                            scanner.nextLine();

                            if (posicionPersona >= 0 && posicionPersona < indiceActual) {
                                vector.eliminarPersona(posicionPersona);
                                System.out.println("Persona eliminada de la posición " + posicionPersona + ".");
                            } else {
                                System.out.println("Error: La posición " + posicionPersona + " no es válida.");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

        } while (opcion != 5);

    }

    public void menuMatrices() {
        System.out.println("Bienvenido al Menu de Matrices");

        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Mostrar Personas");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Buscar Persona");
            System.out.println("5. Promedio de estatura y peso");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // agregar persona
                    if (matriz == null) {
                        System.out.println("Ingrese el número de filas de la matriz: ");
                        int filas = scanner.nextInt();
                        System.out.println("Ingrese el número de columnas de la matriz: ");
                        int columnas = scanner.nextInt();
                        scanner.nextLine();
                        matriz = new Matrices(filas, columnas);

                        System.out.println("Matriz de " + filas + "x" + columnas + " creada.");

                    }
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la estatura (Metros): ");
                    int estatura = scanner.nextInt();
                    System.out.print("Ingrese el peso (en kg): ");
                    float peso = scanner.nextFloat();
                    scanner.nextLine();
                    Persona p = new Persona(nombre, apellido, estatura, peso);
                    matriz.ingresarPersonaSecuencial1(p);

                    break;

                // mostrar personas
                case 2:

                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        matriz.mostrarPersona();
                    }

                    // eliminar persona
                    break;
                case 3:
                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas para eliminar.");
                    } else {
                        System.out.print("Ingrese la fila de la persona a eliminar: ");
                        int fila = scanner.nextInt();
                        System.out.print("Ingrese la columna de la persona a eliminar: ");
                        int columna = scanner.nextInt();
                        scanner.nextLine();

                        matriz.eliminarPersona(fila, columna);

                    }

                    // buscar persona
                    break;
                case 4:
                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas para buscar.");
                    } else {
                        System.out.print("Ingrese el nombre de la persona a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        matriz.buscarPersona(nombreBuscar);
                    }
                    break;

                case 5:
                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        matriz.promedioEstaturaYPeso();
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema de matrices...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    public void menuListas() {
        Scanner scanner = new Scanner(System.in);
        ListaSimple lista = new ListaSimple(); // Lista se Inicializa aquí
        int opcion;

        System.out.println("Bienvenido al Menu de Listas");

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Mostrar Personas");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Buscar Persona");
            System.out.println("5. Promedio de estatura y peso");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                // Agregar Persona
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la estatura (Metros): ");
                    int estatura = scanner.nextInt();
                    System.out.print("Ingrese el peso (kg): ");
                    float peso = scanner.nextFloat();
                    scanner.nextLine();

                    lista.agregarPersonaInicio(new Persona(nombre, apellido, estatura, peso));
                    System.out.println("Persona agregada exitosamente.");
                    break;

                case 2:
                    // Mostrar Personas
                    lista.mostrarLista();
                    System.out.println("Cantidad de nodos: " + lista.ContarNodos());
                    break;

                case 3:
                    // Eliminar Persona
                    System.out.print("Ingrese el nombre de la persona a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (lista.eliminarPersona(nombreEliminar))
                        System.out.println("Persona eliminada.");
                    else
                        System.out.println("No se encontró la persona.");
                    break;

                case 4:
                    // Buscar Persona
                    System.out.print("Ingrese el nombre de la persona a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Persona encontrada = lista.buscarPersona(nombreBuscar);
                    if (encontrada != null)
                        System.out.println("Persona encontrada: " + encontrada);
                    else
                        System.out.println("No se encontró la persona.");
                    break;

                case 5:
                    // Promedio de estatura y peso
                    lista.promedioEstaturaPeso();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema de listas...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    public void menuListaDoble() {
        Scanner scanner = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();
        int opcion;

        System.out.println("Bienvenido al Menú de Listas Doblemente Enlazadas");

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Persona al inicio");
            System.out.println("2. Mostrar Personas");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Buscar Persona");
            System.out.println("5. Promedio de estatura y peso");
            System.out.println("6. Mostrar lista en reversa");
            System.out.println("7. Agregar persona al final");
            System.out.println("8. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Persona personaInicio = solicitarDatosPersona(scanner);
                    lista.agregarPersonaInicio(personaInicio);
                    System.out.println("Persona agregada exitosamente.");

                    break;

                case 2:
                    lista.mostrarLista(); // recorre de inicio a fin
                    System.out.println("Cantidad de nodos: " + lista.contarNodos());
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la persona a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (lista.eliminarPersona(nombreEliminar))
                        System.out.println("Persona eliminada.");
                    else
                        System.out.println("No se encontró la persona.");
                    break;

                case 4:
                    System.out.print("Ingrese el nombre de la persona a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Persona encontrada = lista.buscarPersona(nombreBuscar);
                    if (encontrada != null)
                        System.out.println("Persona encontrada: " + encontrada);
                    else
                        System.out.println("No se encontró la persona.");
                    break;

                case 5:
                    lista.promedioEstaturaPeso();
                    break;
                case 6:
                    lista.mostrarListaReversa();
                    break;
                case 7:
                    Persona personaFinal = solicitarDatosPersona(scanner);
                    lista.agregarPersonaFinal(personaFinal);
                    System.out.println("Persona agregada al final exitosamente.");

                    break;

                case 8:
                    System.out.println("Saliendo del sistema de listas dobles...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }

}
