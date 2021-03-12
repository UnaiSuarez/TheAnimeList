package com.company.Gestores;

import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import java.util.*;

public class GestorUsuario {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    List<Usuario> usuarios = new ArrayList<>();

    public void creaUsuarios(){
        boolean truee = true;
        String correo = "";
        String nombre = "";
        while (truee){
            System.out.println("-----------------------");
            System.out.print("Correo---> ");
             correo = scanner.nextLine();
           if (comprobarCorreo(correo)){
               break;
           }
        }
        while (truee){
            System.out.print("Nombre de usuario---> ");
             nombre = scanner.nextLine();
             if (comprobarNombre(nombre)){
                 break;
             }
        }
        System.out.println("Contraseña---> ");
        String contraseña1 = contraseña();
        GestorCifradoContraseña gestorCifradoContraseña = new GestorCifradoContraseña();
        String contraseña = gestorCifradoContraseña.codificaCesar(contraseña1);
        Usuario usuario = new Usuario(nombre,correo,contraseña);
        DAOFactory.getInstance().getDaoUsuario().add(usuario);
        GestorMenu gestorMenu = new GestorMenu();
        gestorMenu.MenuPrincipal();

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

    private String contraseña(){
        String contraseña = "";
        System.out.println("¿Quiers generar una contraseña automatica?");
        String opcionContraseña = scanner.nextLine();
        Boolean opcionContraseñaBoo = true;
        if (opcionContraseña.equals("si")){
            while (opcionContraseñaBoo){
                contraseña = creaContraseña();
                System.out.println("Su contraseña será: "+contraseña);
                System.out.println("¿Está de acuerdo?");
                String opcion = scanner.nextLine();
                if (opcion.equals("si")){
                    break;
                }
            }
        }
        else {
            while (opcionContraseñaBoo){
                System.out.println("Escriba su contraseña---> ");
                String contraseña1 = scanner.nextLine();
                System.out.println("Repita su contraseña---> ");
                String contraseña2 = scanner.nextLine();
                if (contraseña1.equals(contraseña2)){
                    contraseña = contraseña1;
                    break;
                }
                else {
                    System.out.println("Las contraseñas no coinciden");
                }
            }

        }
        return contraseña;
    }

    private boolean comprobarCorreo(String correo){
         usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCorreo().equals(correo)){
                System.out.println("Este correo ya existe");
                return false;
            }
        }
        return true;
    }

    private boolean comprobarNombre(String nombre){
        usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(nombre)){
                System.out.println("Este nombre ya existe");
                return false;
            }
        }
        return true;
    }


    public void iniciarSesion(){
        GestorCifradoContraseña gestorCifradoContraseña = new GestorCifradoContraseña();
        usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        System.out.println("--------------------------");
        System.out.print("Escriba su correo o nombre de usuario---> ");
        String correo = scanner.nextLine();
        System.out.print("Escriba su contraseña---> ");
        String contraseña1 = scanner.nextLine();
        String contraseña = gestorCifradoContraseña.codificaCesar(contraseña1);
        for (int i = 0; i < usuarios.size(); i++) {
            String user = usuarios.get(i).getNombre();
            String c = usuarios.get(i).getCorreo();
            String con = usuarios.get(i).getContraseña();
            if (user.equals(correo)&&con.equals(contraseña)||correo.equals(c)&&con.equals(contraseña)){
                System.out.println("inicio de sesion correcta");
                System.out.println("Bienvenido "+usuarios.get(i).getNombre());
                GestroAplicacion gestroAplicacion = new GestroAplicacion(usuarios.get(i));
                gestroAplicacion.aplicacion();
            }
        }
        System.out.println("Error al iniciar sesion");
        iniciarSesion();
    }
}
