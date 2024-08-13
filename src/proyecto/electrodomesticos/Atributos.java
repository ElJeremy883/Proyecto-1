package proyecto.electrodomesticos;

public class Atributos {

    private int codigo;
    private String nombre, marca;

    public Atributos(int codigo, String nombre, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
