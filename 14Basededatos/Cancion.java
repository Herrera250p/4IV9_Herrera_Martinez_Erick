public class Cancion {

    private int id;
    private String nombre;
    private String artista;
    private String genero;
    private String dificultad;
    private int duracion;

    public Cancion() {
    }

    public Cancion(int id,
            String nombre,
            String artista,
            String genero,
            String dificultad,
            int duracion) {

        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.dificultad = dificultad;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}