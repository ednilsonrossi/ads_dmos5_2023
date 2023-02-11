package model;

public class Ativo implements ContaState{
    private static Ativo instance;

    private Ativo(){

    }

    public static Ativo getInstance(){
        if(instance == null){
            instance = new Ativo();
        }
        return instance;
    }
}
