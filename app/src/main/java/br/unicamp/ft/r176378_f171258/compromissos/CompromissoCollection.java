package br.unicamp.ft.r176378_f171258.compromissos;

import java.util.ArrayList;

public class CompromissoCollection {
    private ArrayList<Compromisso> comprimissoList= new ArrayList<>();

    public ArrayList<Compromisso> getComprimissoList() {
        return comprimissoList;
    }


    public void addCompromisso(Compromisso compromisso){
        comprimissoList.add(compromisso);
    }
}
