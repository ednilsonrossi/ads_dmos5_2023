package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;

import exceptions.NotCashException;

public class Conta extends ContaSubject{
    public static final int SAQUE = 1;
    public static final int DEPOSITO = 2;   


    private long numero;
    private String agencia;

    private Cliente cliente;
    private Saldo saldo;
    private Limite limite;
    private ContaState contaState;
    private List<OperacaoFinanceira> operacoesFinanceiras;
    
    
    public Conta(long numero, String agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.limite = new Limite(0, 0);
        operacoesFinanceiras = new ArrayList<>();
        saldo = new Saldo(LocalDateTime.now(), 0f);
        contaState = Ativo.getInstance();
    }

    public Conta(long numero, String agencia, Cliente cliente, Saldo saldo, Limite limite, ContaState contaState) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
        this.contaState = contaState;
        operacoesFinanceiras = new ArrayList<>();
    }

    public void operar(double valor, int operacao) throws NotCashException{
        OperacaoFinanceira operation;
        switch (operacao) {
            case SAQUE:
                operation = new Debito();
                break;
            case DEPOSITO:
                operation = new Credito();
                break;
            default:
                operation = null;
        }
        try{
            operation.exercutarOperacao(saldo, valor, limite);
        }catch(NotCashException nCash){
            throw nCash;
        }
        operacoesFinanceiras.add(operation);
        notifyObservers(this);
    }
    
    public String getAccountStatement(){
        StringBuilder sb = new StringBuilder();
        sb.append("EXTRATO BANCÁRIO \n");
        sb.append("Agencia: " + agencia);
        sb.append("\n");
        sb.append("Conta: " + numero);
        sb.append("\n");
        for(OperacaoFinanceira o : operacoesFinanceiras){
            if(o instanceof Debito){
                sb.append(o.getDataOperacao() + " Saque    R$ " + o.getValorOperacao());
                sb.append("\n");
            }else{
                sb.append(o.getDataOperacao() + " Depósito R$ " + o.getValorOperacao());
                sb.append("\n");
            }
        }
        sb.append("\n");
        sb.append("Saldo: R$ " + saldo.getValorSaldo());
        sb.append("\n");
        notifyObservers(this);

        return sb.toString();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public long getNumero() {
        return numero;
    }

    

}
