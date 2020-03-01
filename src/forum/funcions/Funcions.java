package forum.funcions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import forum.classes.Persona;

public class Funcions{
    public static String entrarPassword(){
        Scanner sc = new Scanner(System.in);
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
        System.out.println("#   3 - Login                  #");
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
}