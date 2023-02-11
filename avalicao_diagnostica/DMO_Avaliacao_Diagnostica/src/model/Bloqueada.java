package model;

public class Bloqueada implements ContaState {
    private static Bloqueada instance;

    private Bloqueada(){
    
        }

    public static Bloqueada getInstance() {
        if (instance == null) {
            instance = new Bloqueada();
        }
        return instance;
    }
}