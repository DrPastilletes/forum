package forum.classes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Persona{
    protected String nomUsuari, password;
    protected int edat;
    /*TIPUS USUARI: 0-Admin 1-Lector 2-Editor*/
    protected int tipus;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    protected LocalDate dataNaix;
    protected ArrayList<Persona> editorFollow = new ArrayList<>();
    protected boolean majorEdat;
    private ArrayList<Post> posts = new ArrayList<>();

    public Persona() {
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public LocalDate getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(LocalDate dataNaix) {
        this.dataNaix = dataNaix;
    }

    public ArrayList<Persona> getEditorFollow() {
        return editorFollow;
    }

    public void setEditorFollow(ArrayList<Persona> editorFollow) {
        this.editorFollow = editorFollow;
    }

    public boolean isMajorEdat() {
        return majorEdat;
    }

    public void setMajorEdat(boolean majorEdat) {
        this.majorEdat = majorEdat;
    }

    public void calcularEdat(){
        LocalDate ara = LocalDate.now();
        this.edat = Period.between(dataNaix, ara).getYears();
        if(edat>=18){
            majorEdat = true;
        }
        else{
            majorEdat = false;
        }
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Persona(String nomUsuari, String password) {
        this.nomUsuari = nomUsuari;
        this.password = password;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public void mostrarEditorsSeguits(){
        for (Persona persona : editorFollow) {
            System.out.println(persona.getNomUsuari()); 
        }
    }

    public Persona(String nomUsuari, String password, int tipus, ArrayList<Persona> editorFollow) {
        this.nomUsuari = nomUsuari;
        this.password = password;
        this.tipus = tipus;
        this.editorFollow = editorFollow;
    }
    
}