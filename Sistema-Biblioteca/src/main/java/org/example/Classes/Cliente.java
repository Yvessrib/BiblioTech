package org.example.Classes;

public class Cliente {

    //Atributos do cliente
    private String nome;
    private String CPF;
    private String telefone;

    //Construtor do cliente
    public Cliente(String nome, String CPF, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    //Getters do cliente
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return telefone;
    }
}
