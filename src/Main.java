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
