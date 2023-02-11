package model;

import java.time.LocalDateTime;

import exceptions.NotCashException;

public class Debito implements OperacaoFinanceira{
    
    private LocalDateTime dateTime;
    private double value;

   
    @Override
    public void exercutarOperacao(Saldo saldo, double valor, Limite limite) {
        this.value = valor;
        this.dateTime = LocalDateTime.now();
        
        if(saldo.getValorSaldo() + limite.getValorLimite() >= value){
            saldo.setValorSaldo(saldo.getValorSaldo() - value);
        }else{
            throw new NotCashException("Saldo insuficiente para a transação.");
        }
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
