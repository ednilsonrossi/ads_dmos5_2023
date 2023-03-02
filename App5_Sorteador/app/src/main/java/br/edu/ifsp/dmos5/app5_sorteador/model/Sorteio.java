package br.edu.ifsp.dmos5.app5_sorteador.model;

public class Sorteio {

    private SorteioStrategy mSorteioStrategy;

    public Sorteio() {
        mSorteioStrategy = DefaultLimit.getInstance();
    }

    public Sorteio(int border){
        mSorteioStrategy = new DefinedLimit(border);
    }

    public int getNumber(){
        return mSorteioStrategy.nextNumber();
    }
}

