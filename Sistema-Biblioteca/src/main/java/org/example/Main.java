package org.example;

import org.example.Classes.Cliente;
import org.example.Classes.Data;
import org.example.Classes.Pedido;
import org.example.Tables.ClienteBD;
import org.example.Tables.LivroBD;
import org.example.Tables.PedidoBD;
import org.example.Tables.PedidoHasLivroBD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        Boolean flag2 = true;
        Boolean flag3 = true;
        Boolean flag4 = true;

        ClienteBD clienteBD = new ClienteBD();
        LivroBD livroBD = new LivroBD();
        PedidoBD pedidoBD = new PedidoBD();
        PedidoHasLivroBD pedidoHasLivroBD = new PedidoHasLivroBD();

        //Informações do cliente
        String nome;
        String cpf;
        String telefone;

        //Informações do pedido
        int idPedido;
        String dataPedido;

        //Informações do livro
        int idLivro;

        //Instanciando a classe de adquirir a data
        Data data = new Data();

        // MENU PARA SELEÇÃO
        while (flag) {
            System.out.println("\n-------------------- MENU --------------------");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Ja possuo conta");
            System.out.println("3 - Sair");

            System.out.print("Opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:

                    System.out.print("\nEntre com seu nome: ");
                    nome = sc.nextLine();

                    System.out.print("Entre com o seu CPF: ");
                    cpf = sc.nextLine();

                    System.out.print("Entre com o seu telefone: ");
                    telefone = sc.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, telefone);
                    clienteBD.insertCliente(cliente);
                    break;

                case 2:
                    System.out.print("\nEntre com seu CPF: ");
                    cpf = sc.nextLine();

                    if (clienteBD.selectClienteCPF(cpf)) {

                        System.out.println("SEJA BEM VINDO " + clienteBD.selectClienteNome(cpf));
                        flag2 = true;
                        while (flag2) {
                            System.out.println("\n-------------------- MENU --------------------");
                            System.out.println("1 - Gerenciar pedidos");
                            System.out.println("2 - Detalhes dos pedidos");
                            System.out.println("3 - Pagar pedido existente");
                            System.out.println("4 - Voltar");
                            System.out.print("\nOpção: ");
                            op = sc.nextInt();
                            sc.nextLine();

                            switch (op) {

                                case 1:
                                    flag3 = true;
                                    while (flag3) {
                                        System.out.println("\n-------------------- MENU --------------------");
                                        System.out.println("1 - Criar pedido");
                                        System.out.println("2 - Mostrar livros disponíveis");
                                        System.out.println("3 - Adicionar livro a um pedido existente");
                                        System.out.println("4 - Remover livro de um pedido existente");
                                        System.out.println("5 - Apagar pedido existente");
                                        System.out.println("6 - Voltar");

                                        System.out.print("\nOpção: ");
                                        op = sc.nextInt();
                                        sc.nextLine();
                                        switch (op) {

                                            case 1:
                                                System.out.println("Criando novo pedido: ");
                                                System.out.print("Insira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                Pedido pedido = new Pedido(idPedido, cpf, data.getDateTime(),"Processando");
                                                pedidoBD.insertPedido(pedido);
                                                System.out.println("Pedido criado com sucesso");
                                                break;
                                            case 2:
                                                System.out.println("--- Livros disponíveis ---");
                                                livroBD.selectLivro();
                                                break;
                                            case 3:
                                                System.out.print("Insira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                if (pedidoBD.selectPedidoId(idPedido)) {
                                                    System.out.print("Insira o ID do livro: ");
                                                    idLivro = sc.nextInt();
                                                    if (livroBD.selectLivroId(idLivro)) {
                                                        pedidoHasLivroBD.insertLivroOnPedido(idLivro, idPedido);
                                                        System.out.println("Livro adicionado com sucesso ao pedido!");
                                                    }
                                                }
                                                break;
                                            case 4:
                                                System.out.print("Insira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                if (pedidoBD.selectPedidoId(idPedido)) {
                                                    System.out.print("Insira o ID do livro: ");
                                                    idLivro = sc.nextInt();
                                                    if (pedidoHasLivroBD.deleteLivroFromPedido(idLivro, idPedido))
                                                        System.out.println("Livro retirado com sucesso!");
                                                    else {
                                                        System.out.println("Não há um livro de ID:" + idLivro + " vinculado ao pedido de ID: " + idPedido);
                                                    }
                                                } else {
                                                    System.out.println("ID de pedido inválido");
                                                }
                                                break;
                                            case 5:
                                                System.out.print("Insira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                if (pedidoBD.selectPedidoId(idPedido)) {
                                                    pedidoBD.deletePedido(idPedido);
                                                    System.out.println("Pedido deletado com sucesso!");
                                                } else
                                                    System.out.println("Pedido não encontrado!");
                                                break;
                                            case 6:
                                                flag3 = false;
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    flag4 = true;
                                    while(flag4) {
                                        System.out.println("\n-------------------- MENU --------------------");
                                        System.out.println("1 - Pedidos desta conta");
                                        System.out.println("2 - Mostrar infos de um pedido específico");
                                        System.out.println("3 - Voltar");

                                        System.out.print("\nOpção: ");
                                        op = sc.nextInt();
                                        sc.nextLine();
                                        switch (op) {

                                            case 1:
                                                pedidoBD.selectPedidosIDs(cpf);
                                                break;
                                            case 2:
                                                System.out.print("Insira o ID do pedido: ");
                                                idPedido = sc.nextInt();
                                                if (pedidoBD.selectPedidoId(idPedido)) {
                                                    pedidoBD.selectInfosPedidos(idPedido);

                                                    int idLivros[] = pedidoHasLivroBD.selectLivrosPedido(idPedido);
                                                    double TotalPreco = 0;

                                                    System.out.println("Livros do pedido: ");
                                                    for (int i = 0; i < idLivros.length; i++) {
                                                        if (idLivros[i] != 0) {
                                                            livroBD.selectLivroId(idLivros[i]);
                                                            TotalPreco += livroBD.selectLivroPreco(idLivros[i]);
                                                        }
                                                    }
                                                    System.out.println("Total valor do pedido: R$" + TotalPreco);
                                                }else{
                                                    System.out.println("ID Inválido");
                                                }
                                                break;
                                            case 3:
                                                flag4 = false;
                                                break;
                                            default:
                                                System.out.println("\tInsira um valor válido!");
                                                break;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.print("Insira o ID do pedido: ");
                                    idPedido = sc.nextInt();
                                    if (pedidoBD.selectPedidoId(idPedido)) {
                                        pedidoBD.updateStatusPedido(idPedido);
                                        System.out.println("Pedido pago com sucesso!");
                                    }else
                                        System.out.println("ID inválido");
                                    break;
                                case 4:
                                    flag2 = false;
                                    break;
                                default:
                                    System.out.println("\tInsira um valor válido!");
                                    break;
                            }
                        }
                    }else{
                        System.out.println("CPF INVALIDO");
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInsira um valor válido!");
            }
        }
        System.out.println("Codigo terminou");
    }
}

