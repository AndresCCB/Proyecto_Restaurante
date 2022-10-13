package Java.Objetos.CORTE_4.Proyecto;

import java.time.LocalDateTime;

public class Pedido {
    private int codigo;
    private LocalDateTime fecha_pago;
    private  String forma_pago;
    private String tipo_pedido;
    Producto producto1;
    Cliente cliente1;

    public Pedido(int codigo, LocalDateTime fecha_pago, String forma_pago, String tipo_pedido) {
        this.codigo = codigo;
        this.fecha_pago = fecha_pago;
        this.forma_pago = forma_pago;
        this.tipo_pedido = tipo_pedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getTipo_pedido() {
        return tipo_pedido;
    }

    public void setTipo_pedido(String tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
    }

}
