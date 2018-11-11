package br.unicamp.ft.r176378_f171258.compromissos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class ScreenCompromissosAdapter extends RecyclerView.Adapter implements Observer {
    private CompromissoCollection compromissoCollection = CompromissoCollection.getInstance();
    View v;

    //Observa ComprimissosCollection, que maneja os dados e conexao com o banco
    ScreenCompromissosAdapter() {
        compromissoCollection.addObserver(this);
    }

    private void deleteCompromisso(int position) {
        CompromissoCollection.getInstance().removeCompromisso(position);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_card_compromisso, parent, false);


        return new CardCompromissoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Compromisso compromisso = compromissoCollection.getCompromisso(i);
        ((CardCompromissoHolder) viewHolder).bind(compromisso);
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteCompromisso(viewHolder.getLayoutPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return compromissoCollection.getSize();
    }

    //Observa Compromisso colection
    @Override
    public void update(Observable o, Object arg) {
        notifyDataSetChanged();
    }

    class CardCompromissoHolder extends RecyclerView.ViewHolder {

        private LinearLayout cardContainer;
        private TextView titulo;
        private TextView data;
        private TextView horario;
        private TextView type;
        private ImageView importancy;

        CardCompromissoHolder(@NonNull View itemView) {
            super(itemView);
            cardContainer = itemView.findViewById(R.id.container_card_compromisso);
            titulo = itemView.findViewById(R.id.compromisso_titulo);
            data = itemView.findViewById(R.id.compromisso_data);
            horario = itemView.findViewById(R.id.compromisso_hora);
            type = itemView.findViewById(R.id.compromisso_type);
            importancy = itemView.findViewById(R.id.isImportant);
        }

        void bind(final Compromisso compromisso) {
            titulo.setText(compromisso.getTitle());
            data.setText(compromisso.getDate());
            horario.setText(compromisso.getTime());
            type.setText(compromisso.getType());
            if (compromisso.getImportance()) {
                importancy.setVisibility(View.VISIBLE);
            }


        }

    }
}
