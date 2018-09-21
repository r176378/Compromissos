package br.unicamp.ft.r176378_f171258.compromissos;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenNewCompromisso extends Fragment {

    EditText editTitulo;
    Button btnSave;
    RadioButton radioAm;
    RadioButton radioPm;
    CheckBox chkImportante;



    public ScreenNewCompromisso() {
        // Required empty public constructor
    }

    View.OnClickListener btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "fiwf", Toast.LENGTH_SHORT);
            CompromissoCollection.getInstance()
                    .getComprimissoList()
                    .add(new Compromisso(
                            editTitulo.getText().toString(),
                            "1111",
                            "1111"));
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_screen_new_compromisso, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSave = getActivity().findViewById(R.id.btnSave);
        chkImportante = getActivity().findViewById(R.id.checkboxImportante);
        editTitulo = getActivity().findViewById(R.id.editText_titulo);
        radioAm = getActivity().findViewById(R.id.radioAM);
        radioPm= getActivity().findViewById(R.id.radioPM);
        btnSave.setOnClickListener(btnListener);
    }
}
