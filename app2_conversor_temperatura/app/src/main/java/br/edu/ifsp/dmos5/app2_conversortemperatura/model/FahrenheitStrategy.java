package br.edu.ifsp.dmos5.app2_conversortemperatura.model;

public class FahrenheitStrategy implements ConversorTemperatura{

    private static FahrenheitStrategy instance = null;

    private FahrenheitStrategy(){}

    public static FahrenheitStrategy getInstance(){
        if(instance == null){
            instance = new FahrenheitStrategy();
        }
        return instance;
    }

    @Override
    public double getConvertion(double temperature) {
        return (temperature - 32) / 1.8;
    }

    @Override
    public String getDegres() {
        return "ºC";
    }
}
