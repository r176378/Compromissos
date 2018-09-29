package br.unicamp.ft.r176378_f171258.compromissos;


import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Switch;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import static java.util.Calendar.SATURDAY;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenCalendar extends Fragment {


    public ScreenCalendar() {
        // Required empty public constructor
    }
        TextView days[];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_calendar, container, false);
        days = new TextView[42];
        int numFirstDay = 0;
        LocalDate today = LocalDate.now();
        DayOfWeek firstDay = today.withDayOfMonth(1).getDayOfWeek();
        int lastDay = today.lengthOfMonth();
        String mounthName = today.getMonth().toString();
        TextView mounth = view.findViewById(R.id.nome_mes);
        mounth.setText(mounthName);
        switch (firstDay){
            case SUNDAY: numFirstDay = 0;
            case MONDAY: numFirstDay = 1;
            case TUESDAY: numFirstDay = 2;
            case WEDNESDAY: numFirstDay = 3;
            case THURSDAY: numFirstDay = 4;
            case FRIDAY: numFirstDay = 5;
            case SATURDAY: numFirstDay = 6;
        }


        for(Integer i=0; i<42; i++) {
                String dayID = "day" + (i+1);
                int resID = view.getResources().getIdentifier(dayID, "id", getActivity().getPackageName());
                days[i] = (view.findViewById(resID));
            }
        for (int hide = (numFirstDay-1); hide >= 0; hide--){
            days[hide].setAlpha(0);
        }
        for (int hide = (lastDay + numFirstDay); hide <42; hide++){
            days[hide].setAlpha(0);
        }
        days[today.getDayOfMonth()+ numFirstDay-1].setBackground(getActivity().getResources().getDrawable(R.drawable.circle));
        days[today.getDayOfMonth()+ numFirstDay-1].setTextColor(Color.WHITE);
        String dateCompromisso;
        int size =  CompromissoCollection.getInstance().getSize();
        for (int i = 0; i<size; i++){
            dateCompromisso = CompromissoCollection.getInstance().getCompromisso(i).getDate();
            String date[] = dateCompromisso.split("/");
            dateCompromisso= dateCompromisso.substring(0, 2);



            if (dateCompromisso.substring(1,2).equals("/")){
                dateCompromisso=dateCompromisso.substring(0,1);
            }



            if (Integer.parseInt(date[1]) == today.getMonthValue()){
                if(Integer.parseInt(dateCompromisso) != today.getDayOfMonth()) {
                    days[Integer.parseInt(date[0]) + numFirstDay - 1].setBackground(getActivity().getResources().getDrawable(R.drawable.retangle));
                }
            }

        }
        for (Integer day=1; day<= lastDay; day ++) {
                    days[numFirstDay].setText(day.toString());
                    numFirstDay++;
                }


        return view;
    }

}
