package model;

public class Mensageiro implements ContaObserver{
    
    public void enviarEmail(Cliente cliente){
        System.out.println("Endereço: " + cliente.getEmail());
        System.out.println("Prezado " + cliente.getNome() + ", ");
        System.out.println("Por favor, verifique o estado de sua conta.");
    }

    @Override
    public void update(Conta context) {
        if(context.getSaldo().getValorSaldo() <= 500){
            enviarEmail(context.getCliente());
        }
        
    }

}
