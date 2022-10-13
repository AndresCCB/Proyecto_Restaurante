package Java.Objetos.CORTE_4.Proyecto;

public class Plato extends Producto{
    private String tipo_plato;

    public Plato(String referencia, String descripcion, double valor, String tipo_plato) {
        super(referencia, descripcion, valor);
        this.tipo_plato = tipo_plato;
    }

    public void seleccion_plato(int control ){

    }
}
