package org.example.Classes;

public class Pedido {

    //Atributos do pedido
    private int Pk_idPedido;
    private String Fk_Cliente_CPF;
    private String dataPedido;
    private String statusPedido;

    //Construtor do pedido
    public Pedido(int pk_idPedido, String fk_Cliente_CPF, String dataPedido, String statusPedido) {
        Pk_idPedido = pk_idPedido;
        Fk_Cliente_CPF = fk_Cliente_CPF;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }

    //Getters do pedido
    public int getPk_idPedido() {
        return Pk_idPedido;
    }

    public String getFk_Cliente_CPF() {
        return Fk_Cliente_CPF;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }
}
