package Java.Objetos.CORTE_4.Proyecto;

public class Bebida extends Producto {
    private String tipo_bebida;

    public Bebida(String referencia, String descripcion, double valor, String tipo_bebida) {
        super(referencia, descripcion, valor);
        this.tipo_bebida = tipo_bebida;
    }
}
