package org.example;

import org.example.Classes.Cliente;
import org.example.Tables.ClienteBD;
import org.example.Tables.LivroBD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Boolean flag = true;

        ClienteBD clienteBD = new ClienteBD();
        LivroBD  livroBD = new LivroBD();

        //Informações do cliente
        String nome;
        String cpf;
        String telefone;

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

                    Cliente cliente = new Cliente(nome,cpf,telefone);
                    clienteBD.insertCliente(cliente);
                    break;

                case 2:
                    System.out.print("\nEntre com seu CPF: ");
                    cpf = sc.nextLine();

                    if(clienteBD.selectClienteCPF(cpf)){
                        System.out.println("SEJA BEM VINDO " + clienteBD.selectClienteNome(cpf));
                        System.out.println("-------------------- MENU --------------------");
                        System.out.println("1 - Novo pedido");
                        System.out.println("2 - Detalhes do pedido");
                        System.out.println("3 - Atualizar pedido");
                        System.out.println("3 - Sair");
                        System.out.print("Opção: ");
                        op = sc.nextInt();
                        sc.nextLine();

                        switch (op){

                            case 1:
                                System.out.println("--- Livros disponíveis ---");
                                livroBD.selectLivro();




                                break;
                            case 2:
                                break;
                            case 3:
                                flag = false;
                                break;
                            default:
                                System.out.println("\tInsira um valor válido!");

                        }
                    }else{
                        System.out.println("CPF inválido");
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