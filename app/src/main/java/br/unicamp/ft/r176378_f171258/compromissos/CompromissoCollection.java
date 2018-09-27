package br.unicamp.ft.r176378_f171258.compromissos;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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



    }


    public static synchronized CompromissoCollection getInstance() {
        if (compromissos == null){
            compromissos = new CompromissoCollection();
        }
        return compromissos;
    }

}

