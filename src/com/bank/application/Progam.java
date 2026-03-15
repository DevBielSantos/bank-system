package com.bank.application;

import com.bank.model.Cliente;
import com.bank.service.BancoService;

import java.util.Scanner;

public class Progam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BancoService bancoService = new BancoService();
        while (true) {
            System.out.println("1 Criar Conta");
            System.out.println("2 Depositar ");
            System.out.println("3 Sacar ");
            System.out.println("4 Transferir ");
            System.out.println("5 Listar Contas ");
            System.out.println("0 Sair ");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando Sistema...");
                    sc.close();
                    return;
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.next();

                    System.out.println("Número da conta: ");
                    int numero = sc.nextInt();

                    Cliente cliente = new Cliente(nome, cpf);

                    bancoService.criarConta(cliente,numero);
                    System.out.println("Conta criada com sucesso!");

                    break;

                case 2:
                    // depositar
                    break;
            }


        }
        sc.close();


    }

}
