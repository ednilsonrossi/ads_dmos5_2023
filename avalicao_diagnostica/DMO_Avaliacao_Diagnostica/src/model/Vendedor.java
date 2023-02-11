package model;

public class Vendedor implements ContaObserver{
    
    public void ofertarCredito(Conta conta){
        System.out.println("Vendedor, ligar para : " + conta.getCliente().getTelefone());
    }

    @Override
    public void update(Conta context) {
        if(context.getSaldo().getValorSaldo() < 200.0){
            ofertarCredito(context);
        }
        
    }



}
