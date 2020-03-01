package forum.classes;

import java.time.LocalDateTime;

public class Post {
    protected LocalDateTime dataCreació;
    protected String autor;
    protected boolean majorEdat;
    protected String titol,contingut;

    public Post() {
    }

    public LocalDateTime getDataCreació() {
        return dataCreació;
    }

    public void setDataCreació(LocalDateTime dataCreació) {
        this.dataCreació = dataCreació;
    }


    public boolean isMajorEdat() {
        return majorEdat;
    }

    public void setMajorEdat(boolean majorEdat) {
        this.majorEdat = majorEdat;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }

    public Post(LocalDateTime dataCreació, String string, boolean majorEdat, String titol, String contingut) {
        this.dataCreació = dataCreació;
        this.autor = string;
        this.majorEdat = majorEdat;
        this.titol = titol;
        this.contingut = contingut;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return"Data de creació=" + dataCreació+"\n"+ "Autor=" + autor +"\n"+ "Titol=" + titol +"\n"+"Contingut=" + contingut +"\n"+ "+18?="
                + majorEdat + "";
    }
}