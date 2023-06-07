package org.example.Classes;

public class Livro {

    private String titulo;
    private String anoPublicacao;
    private double preco;
    private int id;
    private int fk_Editora_CNPJ;

    public Livro(String titulo, String anoPublicacao, double preco, int id, int editoraCnpj) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.id = id;
        this.fk_Editora_CNPJ = editoraCnpj;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_Editora_CNPJ() {
        return fk_Editora_CNPJ;
    }

    public void setFk_Editora_CNPJ(int fk_Editora_CNPJ) {
        this.fk_Editora_CNPJ = fk_Editora_CNPJ;
    }

}


