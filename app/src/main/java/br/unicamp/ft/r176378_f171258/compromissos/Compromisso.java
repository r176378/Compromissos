package br.unicamp.ft.r176378_f171258.compromissos;

public class Compromisso {
    String title;
    String date;
    String time;

    public Compromisso( String time,  String date, String title) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public Compromisso(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
