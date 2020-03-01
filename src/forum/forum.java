package forum;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import forum.classes.Lector;
import forum.classes.Persona;
import forum.classes.Post;
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
        usuaris.add(admin);
        while(!sortir){
            Funcions.menu();
            int accio = Integer.parseInt(sc.nextLine());
            switch (accio) {
                case 1:
                    System.out.println("Quin és el nom d'usuari?");
                    String usu = sc.nextLine();
                    System.out.println("Quina és la contrasenya?");
                    String pass = sc.nextLine();
                    if(Funcions.login(usu, pass, usuaris)){
                        System.out.println("Usuari autenticat amb exit!");
                        boolean logout = false;
                        while(!logout){
                            Funcions.menusUsuaris(Funcions.retornarTipusPersona(usu, pass, usuaris));
                            int accio2 = Integer.parseInt(sc.nextLine());
                            switch(Funcions.retornarTipusPersona(usu, pass, usuaris)) {
                                case 0:
                                    switch(accio2){
                                        case 1:
                                        System.out.println("Quin és el titol del Post?");
                                        String titol = sc.nextLine();
                                        System.out.println("Introdueix el contingut");
                                        String contingut = sc.nextLine();
                                        System.out.println("És per majors de 18 anys?(S/N)");
                                        String major = sc.nextLine();
                                        boolean majorBool = true;
                                        if(major.equalsIgnoreCase("N")){
                                            majorBool = false;
                                        }
                                        Post post = new Post(LocalDateTime.now(), Funcions.retornarNomUsuari(usu, pass, usuaris), majorBool, titol, contingut);
                                        posts.add(post);
                                        break;
                                        case 2:
                                            Funcions.mostrarPosts(posts);
                                        break;
                                        case 3:
                                            posts = Funcions.eliminarPost(posts);
                                        break;
                                        case 4:
                                            Funcions.mostrarLectors(usuaris);
                                            System.out.println("Quin Lector vols que passi a ser Editor?");
                                            String nom = sc.nextLine();
                                            usuaris = Funcions.deLectorAEditor(usuaris, nom);
                                        break;
                                        case 5:
                                            Funcions.mostrarEditors(usuaris);
                                        break;
                                        case 6:
                                            Funcions.mostrarLectors(usuaris);
                                        break;
                                        case 0:
                                            System.out.println("Desconnectant... Fins la Proxima!");
                                            logout = true;
                                        break;
                                    }
                                break;
                                case 1:
                                    switch(accio2){
                                        case 1:
                                            Funcions.mostrarEditors(usuaris);
                                            System.out.println("A quin editor vols començar a seguir?");
                                            String nom = sc.nextLine();
                                            usuaris = Funcions.seguirEditor(usu, usuaris, nom);
                                        break;
                                        case 2:
                                        Funcions.veureEditorsSeguits(usu, usuaris);
                                        break;
                                        case 3:
                                        Funcions.veureMur(usu, usuaris, posts, usuAdmin);
                                        break;
                                        case 0:
                                            logout = true;
                                        break;
                                    }
                                break;
                                case 2:
                                    switch(accio2){
                                        case 1:
                                            System.out.println("Quin és el titol del Post?");
                                            String titol = sc.nextLine();
                                            System.out.println("Introdueix el contingut");
                                            String contingut = sc.nextLine();
                                            System.out.println("És per majors de 18 anys?(S/N)");
                                            String major = sc.nextLine();
                                            boolean majorBool = true;
                                            if(major.equalsIgnoreCase("N")){
                                                majorBool = false;
                                            }
                                            Post post = new Post(LocalDateTime.now(), Funcions.retornarNomUsuari(usu, pass, usuaris), majorBool, titol, contingut);
                                            posts.add(post);
                                        break;
                                        case 2:
                                            Funcions.mostrarEditors(usuaris);
                                            System.out.println("A quin editor vols començar a seguir?");
                                            String nom = sc.nextLine();
                                            usuaris = Funcions.seguirEditor(usu, usuaris, nom);
                                        break;
                                        case 3:
                                            Funcions.veureEditorsSeguits(usu, usuaris);
                                        break;
                                        case 4:
                                            Funcions.veureMur(usu, usuaris, posts, usuAdmin);
                                        break;
                                        case 0:
                                            logout = true;
                                        break;
                                    }
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("Usuari o contrasenya mal introduits! Torna-ho a provar...");
                    }
                    break;
                case 2:
                    System.out.println("Quin és el nom d'usuari?");
                    boolean iguals = true;
                    String nomUsuari = null;
                    while(iguals){
                        nomUsuari = sc.nextLine();
                        iguals = Funcions.comprovarNomUsuari(nomUsuari, usuaris);
                    }
                    String password = Funcions.entrarPassword();
                    Lector lec = new Lector(nomUsuari, password, 1, new ArrayList<Persona>());
                    usuaris.add(lec);
                    System.out.println("Usuari Lector creat correctament!");
                    break;
                case 3:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}