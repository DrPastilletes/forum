package forum.funcions;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import forum.classes.Persona;
import forum.classes.Post;

public class Funcions{
    static Scanner sc = new Scanner(System.in);
    public static String entrarPassword(){
        boolean passIgual = false;
        String passAdmin = null;
        while(!passIgual){
            System.out.println("Introdueix el password");
            passAdmin = sc.nextLine();
            System.out.println("Trona a introduir el password");
            String passAdminVal = sc.nextLine();
            passIgual = Funcions.comprovarPassword(passAdmin,passAdminVal);
            if(!passIgual){
                System.out.println("Les passwords no coincideixen, torna-ho a provar!");
            }
        }
        return passAdmin;
    }

    public static boolean comprovarPassword(String pass1,String pass2){
        if(pass1.equals(pass2)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void menu(){
        System.out.println("################################");
        System.out.println("#   1 - Login                  #");
        System.out.println("#   2 - Registre com a Lector  #");
        System.out.println("#   3 - Sortir                 #");
        System.out.println("################################");
    }

    public static boolean login(String nomUsu, String passUsu, ArrayList<Persona> usuaris){
        boolean coincideixen = false;
        for (Persona persona : usuaris) {
            if(nomUsu.equals(persona.getNomUsuari())){
                if(passUsu.equals(persona.getPassword())){
                    coincideixen = true;
                }
            }
        }
        return coincideixen;
    }

    public static int retornarTipusPersona(String nomUsu, String passUsu, ArrayList<Persona> usuaris){
        int tipus = 3;
        for (Persona persona : usuaris) {
            if(nomUsu.equals(persona.getNomUsuari())){
                if(passUsu.equals(persona.getPassword())){
                    tipus = persona.getTipus();
                }
            }
        }
        return tipus;
    }

    public static String retornarNomUsuari(String usu, String pass, ArrayList<Persona> usuaris) {
        String nom = null;
        for (Persona persona : usuaris) {
            if(usu.equals(persona.getNomUsuari())){
                if(pass.equals(persona.getPassword())){
                    nom = persona.getNomUsuari();
                }
            }
        }
        return nom;
    }

    public static boolean retornarMajorEdat(String usu, String pass, ArrayList<Persona> usuaris){
        boolean major = false;
        for (Persona persona : usuaris) {
            if(usu.equals(persona.getNomUsuari())){
                if(pass.equals(persona.getPassword())){
                    major = persona.isMajorEdat();
                }
            }
        }
        return major;
    }

    public static void menusUsuaris(int tipus){
        switch(tipus){
            case 0:
                System.out.println("#######################################");
                System.out.println("#   1 - Crear un post                 #");
                System.out.println("#   2 - Llistar tots els posts        #");
                System.out.println("#   3 - Eliminar un post              #");
                System.out.println("#   4 - Modificar un Lector a Editor  #");
                System.out.println("#   5 - Llistar Editors               #");
                System.out.println("#   6 - Llistar Lectors               #");
                System.out.println("#   0 - Log Out                       #");
                System.out.println("#######################################");

            break;
            case 1:
                System.out.println("#######################################");
                System.out.println("#   1 - Seguir a un Editor nou        #");
                System.out.println("#   2 - Veure els editors que segueixo#");
                System.out.println("#   3 - Mirar el teu mur              #");
                System.out.println("#   0 - Log Out                       #");
                System.out.println("#######################################");
            break;
            case 2:
                System.out.println("#######################################");
                System.out.println("#   1 - Crear un post                 #");
                System.out.println("#   2 - Seguir a un Editor nou        #");
                System.out.println("#   3 - Veure els editors que segueixo#");
                System.out.println("#   4 - Mirar el teu mur              #");
                System.out.println("#   0 - Log Out                       #");
                System.out.println("#######################################");
            break;
        }
    }

    public static void mostrarPosts(ArrayList<Post> posts){
        System.out.println("---------------------------------");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println(""+i+1+" - Data: "+
            posts.get(i).getDataCreació()+
            " - Autor: "+posts.get(i).getAutor()+
            " - Titol: "+posts.get(i).getTitol());
        }
        System.out.println("---------------------------------");
    }

    public static ArrayList<Post> eliminarPost(ArrayList<Post> posts){
        mostrarPosts(posts);
        System.out.println("Quin post vols borrar?");
        int accio = Integer.parseInt(sc.nextLine());
        posts.remove(accio);
        System.out.println("Eliminat correctament!");
        mostrarPosts(posts);
        return posts;
    }

    public static void mostrarLectors(ArrayList<Persona> usuaris){
        System.out.println("Llista de usuaris Lectors!");
        System.out.println("---------------------------------------");
        for (Persona persona : usuaris) {
            if(persona.getTipus()==1){
                System.out.println(persona.getNomUsuari());
            }
        }
    }

    public static void mostrarEditors(ArrayList<Persona> usuaris){
        System.out.println("Llista de usuaris Editors!");
        System.out.println("---------------------------------------");
        for (Persona persona : usuaris) {
            if(persona.getTipus()==2){
                System.out.println(persona.getNomUsuari());
            }
        }
    }
}