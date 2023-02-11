package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ContaSubject {
    
    private List<ContaObserver> observers;

    public ContaSubject(){
        observers = new ArrayList<>();
    }

    public void registerObserver(ContaObserver observer){
        if(observer != null)
            this.observers.add(observer);
    }

    public void unRegisterObserver(ContaObserver observer){
        if(observer != null){
            this.observers.remove(observer);
        }
    }

    public void notifyObservers(Conta context){
        for(ContaObserver o : this.observers){
            o.update(context);
        }
    }
}
