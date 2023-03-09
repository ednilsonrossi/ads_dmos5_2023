package br.edu.ifsp.dmos5.app5_sorteador.model;

import java.util.Random;

public abstract class SorteioStrategy {

    protected Random mRandom;

    public SorteioStrategy() {
        mRandom = new Random();
    }

    public abstract int nextNumber();

    public abstract int getLowBorder();

    public abstract int getHighBorder();
}
