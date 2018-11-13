package br.unicamp.ft.r176378_f171258.compromissos;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Observable;


public class CompromissoCollection extends Observable {
    private static CompromissoCollection compromissos;
    private static ArrayList<Compromisso> comprimissoList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;


    private CompromissoCollection() {
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> dbCompromissos = dataSnapshot.getChildren();
                comprimissoList.clear();
                for (DataSnapshot compromisso : dbCompromissos) {
                    comprimissoList.add(compromisso.getValue(Compromisso.class));
                }
                setChanged();
                notifyObservers();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    public static void updateCompromisso(Integer position,Compromisso compromisso ){
        comprimissoList.set(position, compromisso);
    }

    public static synchronized CompromissoCollection getInstance() {
        if (compromissos == null) {
            compromissos = new CompromissoCollection();
        }
        return compromissos;
    }

    public void removeCompromisso(int position) {
        comprimissoList.remove(position);
        databaseReference.setValue(comprimissoList);
        setChanged();
        notifyObservers();
    }


    public void addCompromisso(Compromisso compromisso) {
        comprimissoList.add(compromisso);
        databaseReference.setValue(comprimissoList);
    }

    public Compromisso getCompromisso(int position) {
        return comprimissoList.get(position);
    }

    public int getSize() {
        return comprimissoList.size();
    }

}

