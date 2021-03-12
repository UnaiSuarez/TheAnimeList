package com.company.Gestores;

import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import java.util.*;

public class GestorUsuario {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    List<Usuario> usuarios = new ArrayList<>();

    public void creaUsuarios(){
        System.out.println("-----------------------");
        System.out.print("Correo---> ");
        String correo = scanner.toString();

        System.out.print("Nombre de usuario---> ");
        String nombre = scanner.toString();

        System.out.println("Contraseña---> ");

            //DAOFactory.getInstance().getDaoUsuario().add();

    }

    private String creaContraseña(){

        String contraseña ="";

        Character[] listaMinusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character[] listaMayus = {'A','B','C','D'};
        Character[] listaNumeros = {'0','1','2','3'};

        ArrayList<Character> abecedario = new ArrayList<>();

        abecedario.addAll(Arrays.asList(listaMinusculas));
        abecedario.addAll(Arrays.asList(listaMayus));
        abecedario.addAll(Arrays.asList(listaNumeros));

        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(abecedario.size());
            contraseña += abecedario.get(numero);
        }

        return contraseña;
    }
}
