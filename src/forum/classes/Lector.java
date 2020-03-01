package forum.classes;

import java.util.ArrayList;

public class Lector extends Persona{
    /*TIPUS USUARI: 0-Admin 1-Lector 2-Editor*/
    private int tipus;

    public Lector(String nomUsuari, String password, int tipus) {
        super(nomUsuari, password);
        this.tipus = tipus;
    }

    

}