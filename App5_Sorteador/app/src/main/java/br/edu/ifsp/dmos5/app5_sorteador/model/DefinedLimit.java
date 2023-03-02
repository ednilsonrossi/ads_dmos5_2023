package br.edu.ifsp.dmos5.app5_sorteador.model;

public class DefinedLimit extends SorteioStrategy{

    private int mBorder;

    public DefinedLimit(int border) {
        this.mBorder = border;
    }

    @Override
    public int nextNumber() {
        return mRandom.nextInt(this.mBorder) + 1;
    }

    public int getBorder() {
        return mBorder;
    }

    public void setBorder(int mBorder) {
        this.mBorder = mBorder;
    }


}
