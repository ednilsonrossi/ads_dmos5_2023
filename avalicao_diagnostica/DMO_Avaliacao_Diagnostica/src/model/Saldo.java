package model;

import java.time.LocalDateTime;

public class Saldo {
    private LocalDateTime ultimaAtualizacao;
    private double valorSaldo;

    public Saldo(LocalDateTime ultimaAtualizacao, double valorSaldo) {
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.valorSaldo = valorSaldo;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(double valorSaldo) {
        this.ultimaAtualizacao = LocalDateTime.now();
        this.valorSaldo = valorSaldo;
    }
}
