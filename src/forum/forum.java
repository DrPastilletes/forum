package forum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import forum.classes.Lector;
import forum.classes.Persona;
import forum.funcions.Funcions;

public class forum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Persona> usuaris = new ArrayList<>();
        ArrayList<Post> posts = new ArrayList<>();
        System.out.println("Introdueix el nom del usuari que fara de administrador:");
        String usuAdmin = sc.nextLine();
        String passAdmin = Funcions.entrarPassword();
        System.out.println("Usuari administrador creat! Ja pots començar a utilitzar l'aplicació");
        boolean sortir = false;
        Lector admin = new Lector(usuAdmin, passAdmin, 0);
        while(!sortir){
            Funcions.menu();
            int accio = Integer.parseInt(sc.nextLine());
            switch (accio) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}