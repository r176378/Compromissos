package br.unicamp.ft.r176378_f171258.compromissos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ScreenCompromissosAdapter extends RecyclerView.Adapter{
    private ArrayList<Compromisso> compromissoCollection;



    ScreenCompromissosAdapter(ArrayList<Compromisso> compromissos){
        this.compromissoCollection =compromissos;
    }

    private void deleteCompromisso(int position){
        CompromissoCollection.getInstance().getComprimissoList().remove(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_card_compromisso, parent, false);
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteCompromisso(position);
                return true;
            }
        });

        return new CardCompromissoHolder(v);
        }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Compromisso compromisso = compromissoCollection.get(i);
        ((CardCompromissoHolder) viewHolder).bind(compromisso);
    }

    @Override
    public int getItemCount() {
        return compromissoCollection.size();
    }

    class CardCompromissoHolder extends RecyclerView.ViewHolder{

        private LinearLayout cardContainer;
        private TextView titulo;
        private TextView data;
        private TextView horario;
        CardCompromissoHolder(@NonNull View itemView) {
            super(itemView);
            cardContainer=itemView.findViewById(R.id.container_card_compromisso);
            titulo = itemView.findViewById(R.id.compromisso_titulo);
            data = itemView.findViewById(R.id.compromisso_data);
            horario = itemView.findViewById(R.id.compromisso_hora);
        }

        void bind(final Compromisso compromisso){
            titulo.setText(compromisso.getTitle());
            data.setText(compromisso.getDate());
            horario.setText(compromisso.getTime());
        }

    }
}
