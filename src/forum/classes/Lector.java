package forum.classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lector extends Persona {

    public Lector(String nomUsuari, String password, int tipus) {
        super(nomUsuari, password);
        this.tipus = tipus;
    }

    public Lector(String nomUsuari, String password, int tipus, ArrayList<Persona> editorFollow) {
        super(nomUsuari, password, tipus, editorFollow);
    }

    public Lector(String nomUsuari, String password, int tipus, LocalDate dataNaix, ArrayList<Persona> editorFollow) {
        super(nomUsuari, password, tipus, dataNaix, editorFollow);
        super.calcularEdat();
        System.out.println(edat);
    }

    

}