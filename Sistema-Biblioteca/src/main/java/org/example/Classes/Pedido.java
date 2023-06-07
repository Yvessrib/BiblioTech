package org.example.Classes;

public class Pedido {

    private String dataPedido;
    private String statusPedido;
    private int idPedido;

    public Pedido(String dataPedido, String statusPedido) {
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }

    /*
    public void totalCompra() {
        double totalcompra = 0;
        for (int i = 0; i < .size(); i++) {
            totalcompra += .get(i).getPreco();
        }
    }
     */

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
