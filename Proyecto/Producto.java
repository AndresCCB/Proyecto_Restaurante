package Java.Objetos.CORTE_4.Proyecto;

public class Producto {
    protected String Referencia;
    protected String Descripcion;
    protected double Valor;

    public Producto(String referencia, String descripcion, double valor) {
        Referencia = referencia;
        Descripcion = descripcion;
        Valor = valor;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }
    
}
