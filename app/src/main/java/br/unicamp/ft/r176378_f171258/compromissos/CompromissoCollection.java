package br.unicamp.ft.r176378_f171258.compromissos;

import java.util.ArrayList;

public class CompromissoCollection {

    private static CompromissoCollection compromissos;

    private static ArrayList<Compromisso> comprimissoList= new ArrayList<>();

    public ArrayList<Compromisso> getComprimissoList() {
        return comprimissoList;
    }


    public void addCompromisso(Compromisso compromisso){
        comprimissoList.add(compromisso);
    }

    private CompromissoCollection() {
        this.comprimissoList = comprimissoList;
    }


    public static synchronized CompromissoCollection getInstance() {
        if (compromissos == null){
            compromissos = new CompromissoCollection();
        }
        return compromissos;
    }

}

