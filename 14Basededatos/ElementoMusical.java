

public class ElementoMusical {

    private int id;
    private String nombre;

    public ElementoMusical() {
        this.id = 0;
        this.nombre = "";
    }

    public ElementoMusical(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0)
            this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarDetalle() {
        return "ID: " + id + " | Nombre: " + nombre;
    }

    @Override
    public String toString() {
        return mostrarDetalle();
    }
}