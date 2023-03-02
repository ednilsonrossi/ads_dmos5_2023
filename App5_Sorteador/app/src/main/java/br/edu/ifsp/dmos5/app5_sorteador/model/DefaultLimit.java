package br.edu.ifsp.dmos5.app5_sorteador.model;

public class DefaultLimit extends SorteioStrategy{

    private static final int BORDER_DEFAULT = 100;
    private static DefaultLimit instance;


    private DefaultLimit() {
    }

    public static DefaultLimit getInstance(){
        if(instance == null){
            instance = new DefaultLimit();
        }
        return instance;
    }

    @Override
    public int nextNumber() {
        return mRandom.nextInt(BORDER_DEFAULT) + 1;
    }
}
