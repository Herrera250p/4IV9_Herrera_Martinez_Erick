

public class Accesorio extends ElementoMusical {

    private String marca;
    private String tipo;
    private double precio;
    private int stock;

    public Accesorio() {
        super();
    }

    public Accesorio(int id,
            String nombre,
            String marca,
            String tipo,
            double precio,
            int stock) {

        super(id,nombre);

        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio >= 0)
            this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock >= 0)
            this.stock = stock;
    }

    @Override
    public String mostrarDetalle() {

        return String.format(
                "ID:%d | Nombre:%s | Marca:%s | Tipo:%s | Precio:$%.2f | Stock:%d",
                id,nombre,marca,tipo,precio,stock);
    }
}