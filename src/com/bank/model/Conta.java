package com.bank.model;

public class Conta {
    private final int number;
    private double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente, int number) {
        this.cliente = cliente;
        this.number = number;
        this.saldo = 0.0;
    }

    public int getNumber() {
        return number;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void deposit(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }

        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
        if (valor > saldo) {
            throw new RuntimeException("Saldo Insuficiente");
        }

        saldo -= valor;
    }
}
