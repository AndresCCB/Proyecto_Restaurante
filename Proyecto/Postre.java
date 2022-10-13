package Java.Objetos.CORTE_4.Proyecto;

public class Postre extends Producto{
    private int calorias;

    public Postre(String referencia, String descripcion, double valor, int calorias) {
        super(referencia, descripcion, valor);
        this.calorias = calorias;
    }
}
