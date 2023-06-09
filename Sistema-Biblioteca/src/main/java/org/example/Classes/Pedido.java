package org.example.Classes;

public class Pedido {

    private int Pk_idPedido;
    private String Fk_Cliente_CPF;
    private String dataPedido;
    private String statusPedido;

    public Pedido(int pk_idPedido, String fk_Cliente_CPF, String dataPedido, String statusPedido) {
        Pk_idPedido = pk_idPedido;
        Fk_Cliente_CPF = fk_Cliente_CPF;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }

    public int getPk_idPedido() {
        return Pk_idPedido;
    }

    public void setPk_idPedido(int pk_idPedido) {
        Pk_idPedido = pk_idPedido;
    }

    public String getFk_Cliente_CPF() {
        return Fk_Cliente_CPF;
    }

    public void setFk_Cliente_CPF(String fk_Cliente_CPF) {
        Fk_Cliente_CPF = fk_Cliente_CPF;
    }

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
