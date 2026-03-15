package com.bank.service;

import com.bank.model.Cliente;
import com.bank.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class BancoService {
    private List<Conta> contas = new ArrayList<>();

    public Conta criarConta(Cliente cliente, int numero) {
        Conta conta = new Conta(cliente, numero);
        contas.add(conta);
        return conta;
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumber() == numero) {
                return conta;
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    public  void depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        conta.deposit(valor);
    }

    public void sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        conta.sacar(valor);
    }

    public void transferir(int origem, int destino, double valor) {
        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);

        contaOrigem.sacar(valor);
        contaDestino.deposit(valor);
    }
    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println(
                    "Conta: "
                    + conta.getNumber()
                    +" | Cliente: "
                    + conta.getCliente().getNome()
                    +" | Saldo: "
                    + conta.getSaldo()
            );
        }
    }
}
