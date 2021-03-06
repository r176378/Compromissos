package br.unicamp.ft.r176378_f171258.compromissos;

public class Compromisso {
    private String title;
    private String date;
    private String time;
    private Boolean isImportant;
    private String type;

    public Compromisso(String title, String date, String time, String type, Boolean importancy) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.isImportant = importancy;
        this.type = type;
    }

    public Compromisso() {
    }

    public Boolean getImportance() {
        return isImportant;
    }

    public void setImportance(Boolean importance) {
        this.isImportant = importance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
