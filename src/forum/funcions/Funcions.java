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
        accio -= 1;
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

    public static boolean comprovarNomUsuari(String nomUsu, ArrayList<Persona> usuaris){
        boolean iguals = false;
        for (Persona persona : usuaris) {
            if(persona.getNomUsuari().equals(nomUsu)){
                iguals = true;
                System.out.println("Usuari ja existent prova amb un altre nom!");
            }
        }
        return iguals;
    }

    public static ArrayList<Persona> deLectorAEditor(ArrayList<Persona> usuaris, String nom){
        int contador = 0;
        for (Persona persona : usuaris) {
            if(persona.getNomUsuari().equals(nom)){
                persona.setTipus(2);
                contador++;
            }
        }
        if(contador==0){
            System.out.println("Lector no trobat, Torna-ho a intentar!");
        }
        return usuaris;
    }

    public static ArrayList<Persona> seguirEditor(String usuActual,ArrayList<Persona> usuaris, String nom){
        for (int i = 0; i < usuaris.size(); i++) {
            if(usuaris.get(i).getNomUsuari().equals(usuActual)){
                for (int j = 0; j < usuaris.size(); j++) {
                    if(usuaris.get(j).getNomUsuari().equals(nom)){
                        usuaris.get(i).getEditorFollow().add(usuaris.get(j));
                    }
                }
            }
        }
        return usuaris;
    }

    public static void veureEditorsSeguits(String usuActual, ArrayList<Persona> usuaris){
        System.out.println("Editors seguits per "+usuActual);
        for (Persona persona : usuaris) {
            persona.mostrarEditorsSeguits();
        }
    }

    public static void veureMur(String usuActual, ArrayList<Persona> usuaris, ArrayList<Post> posts, String usuAdmin) {
        ArrayList<Persona> editorFollow = new ArrayList<>();
        for (Persona persona : usuaris) {
            if(persona.getNomUsuari().equals(usuActual)){
                editorFollow = persona.getEditorFollow();
            }
        }
        for (Persona persona : usuaris){
            for (Post post : posts) {
                if(persona.getNomUsuari().equals(usuActual)){
                    if(persona.isMajorEdat()==post.isMajorEdat() || !post.isMajorEdat()){
                        if(post.getAutor().equals(usuAdmin)){
                            escriurePosts(post);
                        }
                    } 
                }
            }
        }
        for (Persona persona : editorFollow) {
            for (Post post : posts) {
              if(post.getAutor().equals(persona.getNomUsuari())){
                  escriurePosts(post);
              }  
            }
        }
    }

    public static void escriurePosts(Post post){
        System.out.println(post.toString());
    }
}