package org.example.Classes;

public class Livro {

    //Atributos do livro
    private String titulo;
    private String anoPublicacao;
    private double preco;
    private int id;
    private int fk_Editora_CNPJ;

    //Construtor do livro
    public Livro(String titulo, String anoPublicacao, double preco, int id, int editoraCnpj) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.id = id;
        this.fk_Editora_CNPJ = editoraCnpj;
    }

    public Livro(int id) {
        this.id = id;
    }

    //Getters do livro
    public String getTitulo() {
        return titulo;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public int getFk_Editora_CNPJ() {
        return fk_Editora_CNPJ;
    }

}


