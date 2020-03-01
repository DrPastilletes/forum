package forum.classes;

import java.util.ArrayList;

public class Lector extends Persona{
    

    public Lector(String nomUsuari, String password, int tipus) {
        super(nomUsuari, password);
        this.tipus = tipus;
    }

    public Lector(String nomUsuari, String password, int tipus, ArrayList<Persona> editorFollow) {
        super(nomUsuari, password, tipus, editorFollow);
    }

    

}