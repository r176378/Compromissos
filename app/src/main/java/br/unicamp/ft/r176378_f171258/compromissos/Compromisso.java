package br.unicamp.ft.r176378_f171258.compromissos;

public class Compromisso {
    String title;
    String date;
    String time;
    Boolean isImportant;
    String type;

    public Boolean getImportant() {
        return isImportant;
    }

    public void setImportancy(Boolean importancy) {
        this.isImportant = importancy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Compromisso( String title, String date, String time,  String type, Boolean importancia) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.isImportant = importancia;
        this.type = type;
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
