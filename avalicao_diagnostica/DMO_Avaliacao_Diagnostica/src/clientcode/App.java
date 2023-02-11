package clientcode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotCashException;
import model.Ativo;
import model.Cliente;
import model.Conta;
import model.Gerente;
import model.Limite;
import model.Mensageiro;
import model.Saldo;
import model.Vendedor;

public class App {
    public static void main(String[] args) throws Exception {
        List<Conta> contas = new ArrayList();


        contas.add(new Conta(123, "Centro", new Cliente(1, "Jose", "3333", "jose@gmail.com")));
        contas.add(new Conta(987, "Centro", new Cliente(999, "Joao", "4444", "joao@gmail.com")));
        contas.add(new Conta(777, "Centro", new Cliente(123456, "Jucelino", "7777", "jucelino@gmail.com"), new Saldo(LocalDateTime.now(), 0), new Limite(500f, 0.01), Ativo.getInstance()));

        for(Conta c : contas){
            c.registerObserver(new Gerente());
            c.registerObserver(new Vendedor());
            c.registerObserver(new Mensageiro());
        }


        contas.get(2).operar(1000, Conta.DEPOSITO);
        contas.get(1).operar(1000, Conta.DEPOSITO);
        contas.get(0).operar(1000, Conta.DEPOSITO); 

        boolean continua = true;
        do{
            try{
                contas.get(1).operar(200, Conta.SAQUE);
            }catch (NotCashException nCash){
                System.out.println("Acabou o dinheiro!");
                continua = false;
            }
        }while(continua);
        

        continua = true;
        do{
            try{
                contas.get(2).operar(100, Conta.SAQUE);
            }catch (NotCashException nCash){
                System.out.println("Acabou o dinheiro!");
                continua = false;
            }
        }while(continua);

        contas.get(0).operar(200, Conta.DEPOSITO);

        for(Conta c : contas){
            System.out.println(c.getAccountStatement());
        }
    }
}
