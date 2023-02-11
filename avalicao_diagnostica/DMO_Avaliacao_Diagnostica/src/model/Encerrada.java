package model;

public class Encerrada implements ContaState{
    private static Encerrada instance;

    private Encerrada(){

    }

    public static Encerrada getInstance(){
        if(instance == null){
            instance = new Encerrada();
        }
        return instance;
    }
}