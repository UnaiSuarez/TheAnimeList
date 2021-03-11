package com.company.Clases.Porvisional;

import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AñadirUsuarios implements Serializable {
    Random random = new Random();
    List<Usuario> usuarios = new ArrayList<>();
    String[] nombres = new String[]{
            "pablo","unai","jorge","isa","raul","iñigo","gabriel","antonio","pepe","sofia"
    };
    String[] apellidos = new String[]{
            "suarez","Romero","Álvarez","Ramírez","Benítez","González","Ortiz","Moreno","Peralta","Ledesma"
    };

    public void creaUsuarios(){
        for (int i = 0; i < 100; i++) {
            Boolean minus = random.nextBoolean();
            Boolean mayus = random.nextBoolean();
            Boolean numeros = random.nextBoolean();
            Integer digitos = random.nextInt(10);
            Integer nombre = random.nextInt(nombres.length);
            Integer apellido = random.nextInt(apellidos.length);
            String contraseña = creaContraseña(minus,mayus,numeros,digitos);
            Usuario usuario = new Usuario(nombres[nombre],apellidos[apellido],contraseña);
            DAOFactory.getInstance().getDaoUsuario().add(usuario);
        }
    }

   private String creaContraseña( Boolean minus, Boolean mayus, Boolean numeros, Integer digitos){

        String contraseña ="";

        Character[] listaMinusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        Character[] listaMayus = {'A','B','C','D'};
        Character[] listaNumeros = {'0','1','2','3'};

        ArrayList<Character> abecedario = new ArrayList<>();

        if (minus) abecedario.addAll(Arrays.asList(listaMinusculas));
        if (mayus) abecedario.addAll(Arrays.asList(listaMayus));
        if (numeros) abecedario.addAll(Arrays.asList(listaNumeros));

        for (int i = 0; i < digitos; i++) {
            int numero = random.nextInt(abecedario.size());
            contraseña += abecedario.get(numero);
        }

        return contraseña;
    }
}
