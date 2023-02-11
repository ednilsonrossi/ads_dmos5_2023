package model;

import java.time.LocalDateTime;

public class Credito implements OperacaoFinanceira{
    
    private LocalDateTime dateTime;
    private double value;

    @Override
    public void exercutarOperacao(Saldo saldo, double valor, Limite limite) {
        this.value = valor;
        this.dateTime = LocalDateTime.now();
        saldo.setValorSaldo(saldo.getValorSaldo() + value);
    }

    @Override
    public LocalDateTime getDataOperacao() {
        return this.dateTime;
    }
    @Override
    public double getValorOperacao() {
        return this.value;
    }
}
