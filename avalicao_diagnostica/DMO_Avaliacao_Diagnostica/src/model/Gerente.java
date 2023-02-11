package model;

public class Gerente implements ContaObserver{

    public void analisarConta(Conta conta){
        System.out.println("Atenção, sinal de calote em: " + conta.getNumero());
    }

    @Override
    public void update(Conta context) {
        if(context.getSaldo().getValorSaldo() <= 0){
            analisarConta(context);
        }
        
    }
    

}
