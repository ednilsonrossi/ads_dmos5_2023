package model;

public class Limite {
    private double valorLimite;
    private double taxaJuros;

    public Limite(double valorLimite, double taxaJuros) {
        this.valorLimite = valorLimite;
        this.taxaJuros = taxaJuros;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

}
