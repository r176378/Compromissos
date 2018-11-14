package br.unicamp.ft.r176378_f171258.compromissos;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenCalendar extends Fragment {

    TextView proximo_mes;
    TextView ultimo_mes;
    LocalDate today;
    TextView days[];

    public ScreenCalendar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_calendar, container, false);
        days = new TextView[42];
        int numFirstDay = 0;
        today = LocalDate.now();
        DayOfWeek firstDay = today.withDayOfMonth(1).getDayOfWeek();
        int lastDay = today.lengthOfMonth();
        String mounthName = today.getMonth().toString();
        TextView mounth = view.findViewById(R.id.nome_mes);
        mounth.setText(mounthName);
        numFirstDay = getNumFirstDay(numFirstDay, firstDay);
        getDayIDs(view);
        hideDaysNotInMonth(numFirstDay, lastDay);
        highlightCurrentDay(days[today.getDayOfMonth() + numFirstDay - 1]);
        highlightEvents(numFirstDay, today);
        setDayNumbersText(numFirstDay, lastDay);
        return view;
    }

    public void nextMonth(){
        int numFirstDay = 0;
        today = today.plusMonths(1);
        DayOfWeek firstDay = today.withDayOfMonth(1).getDayOfWeek();
        int lastDay = today.lengthOfMonth();
        String mounthName = today.getMonth().toString();
        TextView mounth = getView().findViewById(R.id.nome_mes);
        mounth.setText(mounthName);
        numFirstDay = getNumFirstDay(numFirstDay, firstDay);
        getDayIDs(getView());
        hideDaysNotInMonth(numFirstDay, lastDay);
        highlightCurrentDay(days[today.getDayOfMonth() + numFirstDay - 1]);
        highlightEvents(numFirstDay, today);
        setDayNumbersText(numFirstDay, lastDay);
    }

    public void lastMount(){
        int numFirstDay = 0;
        today = today.plusMonths(1);
        DayOfWeek firstDay = today.withDayOfMonth(1).getDayOfWeek();
        int lastDay = today.lengthOfMonth();
        String mounthName = today.getMonth().toString();
        TextView mounth = getView().findViewById(R.id.nome_mes);
        mounth.setText(mounthName);
        numFirstDay = getNumFirstDay(numFirstDay, firstDay);
        getDayIDs(getView());
        hideDaysNotInMonth(numFirstDay, lastDay);
        highlightCurrentDay(days[today.getDayOfMonth() + numFirstDay - 1]);
        highlightEvents(numFirstDay, today);
        setDayNumbersText(numFirstDay, lastDay);
    }


    private void setDayNumbersText(int numFirstDay, int lastDay) {
        for (Integer day = 1; day <= lastDay; day++) {
            days[numFirstDay].setText(day.toString());
            numFirstDay++;
        }
    }

    private void highlightEvents(int numFirstDay, LocalDate today) {
        String dateCompromisso;
        int size = CompromissoCollection.getInstance().getSize();
        for (int i = 0; i < size; i++) {
            String[] date = getSplitDate(i);
            if (Integer.parseInt(date[1]) == today.getMonthValue()) {
                if (Integer.parseInt(date[0]) != today.getDayOfMonth()) {
                    if (CompromissoCollection.getInstance().getCompromisso(i).getImportance()) {
                        days[Integer.parseInt(date[0]) + numFirstDay - 1].setTextColor(Color.RED);
                        days[Integer.parseInt(date[0]) + numFirstDay - 1].setBackground(getActivity().getResources().getDrawable(R.drawable.retangle_important));
                    } else {
                        days[Integer.parseInt(date[0]) + numFirstDay - 1].setTextColor(Color.BLUE);
                        days[Integer.parseInt(date[0]) + numFirstDay - 1].setBackground(getActivity().getResources().getDrawable(R.drawable.retangle_compromisso));
                    }
                }
            }
        }
    }

    @NonNull
    private String[] getSplitDate(int i) {
        String dateCompromisso;
        dateCompromisso = CompromissoCollection.getInstance().getCompromisso(i).getDate();
        return dateCompromisso.split("/");
    }

    private void highlightCurrentDay(TextView day) {
        day.setBackground(getActivity().getResources().getDrawable(R.drawable.circle));
        day.setTextColor(Color.WHITE);
    }

    private void hideDaysNotInMonth(int numFirstDay, int lastDay) {
        for (int hide = (numFirstDay - 1); hide >= 0; hide--) {
            days[hide].setAlpha(0);
        }
        for (int hide = (lastDay + numFirstDay); hide < 42; hide++) {
            days[hide].setAlpha(0);
        }
    }

    private void getDayIDs(View view) {
        for (Integer i = 0; i < 42; i++) {
            String dayID = "day" + (i + 1);
            int resID = view.getResources().getIdentifier(dayID, "id", getActivity().getPackageName());
            days[i] = (view.findViewById(resID));
        }
    }

    private int getNumFirstDay(int numFirstDay, DayOfWeek firstDay) {
        switch (firstDay) {
            case SUNDAY:
                numFirstDay = 0; break;
            case MONDAY:
                numFirstDay = 1; break;
            case TUESDAY:
                numFirstDay = 2; break;
            case WEDNESDAY:
                numFirstDay = 3; break;
            case THURSDAY:
                numFirstDay = 4; break;
            case FRIDAY:
                numFirstDay = 5; break;
            case SATURDAY:
                numFirstDay = 6; break;
        }
        return numFirstDay;
    }

}
