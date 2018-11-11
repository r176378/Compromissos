package br.unicamp.ft.r176378_f171258.compromissos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ScreenCompromissos extends Fragment {
    FragmentManager fragmentManager;
    FloatingActionButton btnNewCard;
    public ScreenCompromissos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getActivity().getSupportFragmentManager();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_screen_compromissos, container, false);
    }

    private void screenNewCompromisso() {
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ScreenNewCompromisso screenNewCompromisso = new ScreenNewCompromisso();
        ftrans.replace(R.id.mainContainer, screenNewCompromisso, "screenNewCompromissos");
        ftrans.addToBackStack("screenNewCompromissos");
        ftrans.commit();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mRecyclerView = getView().findViewById(R.id.compromissosRecycler);
        btnNewCard = getView().findViewById(R.id.floatingAddCard);
        btnNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenNewCompromisso();
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ScreenCompromissosAdapter screenCompromissosAdapter = new ScreenCompromissosAdapter();
        mRecyclerView.setAdapter(screenCompromissosAdapter);
    }
}
