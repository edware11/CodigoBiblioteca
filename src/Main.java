import java.util.*;

// Clase Libro que representa un libro en la biblioteca
class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    // Constructor
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Disponible: " + (disponible ? "Sí" : "No");
        // Clase Biblioteca que maneja la colección de libros
        class Biblioteca {
            private List<Libro> libros;

            public Biblioteca() {
                libros = new ArrayList<>();
                // Agregando libros predeterminados
                agregarLibro(new Libro("semestre 6", "Edwar Fontecha", "ISBN001"));
                agregarLibro(new Libro("semestre 5", "Brayan Guerrero", "ISBN002"));
                agregarLibro(new Libro("semestre 4", "Sebastián Bonza", "ISBN003"));
                agregarLibro(new Libro("profesor", "Fabio Alejandro", "ISBN004"));
            }

            // Método para agregar un libro
            public void agregarLibro(Libro libro) {
                libros.add(libro);
                System.out.println("Libro agregado correctamente.");
            }

            // Método para buscar libros por título
            public void buscarPorTitulo(String titulo) {
                for (Libro libro : libros) {
                    if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                        System.out.println(libro);
                        return;
                    }
                }
                System.out.println("Libro no encontrado.");
            }

            // Método para buscar libros por autor
            public void buscarPorAutor(String autor) {
                boolean encontrado = false;
                for (Libro libro : libros) {
                    if (libro.getAutor().equalsIgnoreCase(autor)) {
                        System.out.println(libro);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontraron libros de este autor.");
                }
            }

            // Método para listar todos los libros
            public void listarLibros() {
                if (libros.isEmpty()) {
                    System.out.println("No hay libros en la biblioteca.");
                    return;
                }
                for (Libro libro : libros) {
                    System.out.println(libro);
                }
            }
        }
    }
}

// Clase principal con el menú de usuario
 class GestionBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\nGestión de Biblioteca");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Listar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ingrese ISBN: ");
                        String isbn = scanner.nextLine();
                        biblioteca.agregarLibro(new Libro(titulo, autor, isbn));
                        break;
                    case 2:
                        System.out.print("Ingrese título del libro: ");
                        biblioteca.buscarPorTitulo(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Ingrese autor del libro: ");
                        biblioteca.buscarPorAutor(scanner.nextLine());
                        break;
                    case 4:
                        biblioteca.listarLibros();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }
}
