package forum.classes;

import java.time.LocalDateTime;

public class Post {
    protected LocalDateTime dataCreació;
    protected Persona autor;
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

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
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
}