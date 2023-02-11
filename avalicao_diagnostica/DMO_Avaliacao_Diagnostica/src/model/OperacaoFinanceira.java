package model;

import java.time.LocalDateTime;

public interface OperacaoFinanceira {
    
    public abstract void exercutarOperacao(Saldo saldo, double valor, Limite limite);

    public abstract LocalDateTime getDataOperacao();

    public abstract double getValorOperacao();

}
