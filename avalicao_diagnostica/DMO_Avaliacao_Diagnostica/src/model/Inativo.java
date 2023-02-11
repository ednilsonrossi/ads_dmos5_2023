package model;

public class Inativo implements ContaState {
    private static Inativo instance;

    private Inativo(){
    
        }

    public static Inativo getInstance() {
        if (instance == null) {
            instance = new Inativo();
        }
        return instance;
    }
}
