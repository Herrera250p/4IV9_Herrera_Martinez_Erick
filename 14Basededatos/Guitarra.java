

public class Guitarra extends ElementoMusical {

    private String marca;
    private String modelo;
    private String tipo;
    private String color;
    private double precio;

    public Guitarra() {
        super();
    }

    public Guitarra(int id, String nombre,
            String marca,
            String modelo,
            String tipo,
            String color,
            double precio) {

        super(id, nombre);

        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.color = color;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio >= 0)
            this.precio = precio;
    }

    @Override
    public String mostrarDetalle() {
        return String.format(
                "ID:%d | Nombre:%s | Marca:%s | Modelo:%s | Tipo:%s | Color:%s | Precio:$%.2f",
                id,nombre,marca,modelo,tipo,color,precio);
    }
}