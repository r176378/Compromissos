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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenNewCompromisso extends Fragment {

    EditText editTitulo;
    EditText editTime;
    Button btnSave;
    RadioButton radio;
    RadioButton radioPm;
    RadioGroup radioGroup;
    CheckBox chkImportante;
    DatePicker datePicker;

    public ScreenNewCompromisso() {
        // Required empty public constructor
    }

    View.OnClickListener btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            CompromissoCollection.getInstance()
                    .getComprimissoList()
                    .add(new Compromisso(
                            editTitulo.getText().toString(),
                            datePicker.getDayOfMonth()+ "/"+ datePicker.getMonth() + "/" + datePicker.getYear(),

                            editTime.getText().toString() + " "+radio.getText().toString()));
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen_new_compromisso, container, false);

        btnSave = (Button) view.findViewById(R.id.btnSave);
        chkImportante = view.findViewById(R.id.checkboxImportante);
        editTitulo = view.findViewById(R.id.editText_titulo);
        radioGroup = view.findViewById(R.id.radio_group);
        radio = view.findViewById(radioGroup.getCheckedRadioButtonId());
        radioPm= view.findViewById(R.id.PM);
        btnSave.setOnClickListener(btnListener);
        datePicker = view.findViewById(R.id.datePicker);
        editTime = view.findViewById(R.id.editText_horario);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
