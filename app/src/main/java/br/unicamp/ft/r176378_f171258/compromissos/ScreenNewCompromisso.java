package br.unicamp.ft.r176378_f171258.compromissos;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observer;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenNewCompromisso extends Fragment{

    EditText editTitulo;
    TextView editTime;
    Button btnSave;
    RadioGroup radioGroup;
    CheckBox chkImportante;
    DatePicker datePicker;
    TimePicker timePicker;
    Spinner mSpinner;
    FragmentManager fragmentManager;
    View.OnClickListener btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String mTime;
            if (editTime.getText().toString().equals("")){
                mTime = "";
            }else{
                mTime = editTime.getText().toString();
            }
            if ((Integer)getArguments().get("position") != -1 ){
                CompromissoCollection.updateCompromisso((Integer)getArguments().get("position"), new Compromisso(
                        editTitulo.getText().toString(),
                        datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear(),

                        mTime, mSpinner.getSelectedItem().toString(), chkImportante.isChecked()));
            }else{

                CompromissoCollection.getInstance().addCompromisso(new Compromisso(
                        editTitulo.getText().toString(),
                        datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear(),

                        mTime, mSpinner.getSelectedItem().toString(), chkImportante.isChecked()));
            }
                    screenCompromissos();
        }
    };



    private void screenCompromissos() {
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ScreenCompromissos screenCompromissos = new ScreenCompromissos();
        ftrans.replace(R.id.mainContainer, screenCompromissos, "screenCompromissos");
        ftrans.addToBackStack("screenCompromissos");
        ftrans.commit();
    }

    TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(android.widget.TimePicker view,
                                      int hourOfDay, int minute) {
                    editTime.setText(""+hourOfDay+":"+minute);
                }
            };

    View.OnClickListener timeListener = v -> {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(getContext(), mTimeSetListener, hour, minute, true);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    };

    public ScreenNewCompromisso() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentManager = getActivity().getSupportFragmentManager();
        View view = inflater.inflate(R.layout.fragment_screen_new_compromisso, container, false);
        btnSave = view.findViewById(R.id.btnSave);
        chkImportante = view.findViewById(R.id.checkboxImportante);
        editTitulo = view.findViewById(R.id.editText_titulo);
        btnSave.setOnClickListener(btnListener);
        datePicker = view.findViewById(R.id.datePicker);
        editTime = view.findViewById(R.id.editTime);
        editTime.setOnClickListener(this.timeListener);
        mSpinner = view.findViewById(R.id.spinnerType);
        try{
        if ((Integer)getArguments().get("position") != -1){
            CompromissoCollection compromissoCollection = CompromissoCollection.getInstance();
            Compromisso compromisso = compromissoCollection.getCompromisso((Integer)getArguments().get("position"));
            if (compromisso.getImportance()){
                chkImportante.setChecked(true);
            }
            String[] arrayString = compromisso.getDate().split("/");
            datePicker.updateDate(Integer.parseInt((arrayString[2])  ), Integer.parseInt(arrayString[1])-1, Integer.parseInt(arrayString[0]));
            editTitulo.setText(compromisso.getTitle());
            editTime.setText(compromisso.getTime());
            String compromissoType = compromisso.getType();
            if (!mSpinner.getSelectedItem().toString().equals(compromissoType)){
                mSpinner.setSelection(1);
            }
        }

    } catch (NullPointerException e){

        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
