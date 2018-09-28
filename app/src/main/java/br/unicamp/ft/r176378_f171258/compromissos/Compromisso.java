package br.unicamp.ft.r176378_f171258.compromissos;

public class Compromisso {
    private String title;
    private String date;
    private String time;
    private Boolean isImportant;
    private String type;

    public Boolean getImportancy() {
        if (isImportant == null){
            return false;
        }
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



    public Compromisso( String title, String date, String time,  String type, Boolean importancy) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.isImportant = importancy;
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
