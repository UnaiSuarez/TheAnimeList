package com.company.Gestores;

import com.company.Clases.Usuario;

import java.util.Scanner;

public class Ajustes {
    GestorUsuario gestorUsuario = new GestorUsuario();
    Usuario usuario;
    Scanner scanner = new Scanner(System.in);
    public Ajustes(Usuario usuario) {
        this.usuario = usuario;
    }

    public void ajustes(){
        System.out.println("----------------------");
        System.out.println("¿Que desea hacer?");
        System.out.println("1) Cambiar nombre\n2) Cambiar correo\n3) Cambiar contraseña");
        if (!usuario.getAdmin()){
            System.out.println("4)Activar administrador");
        }
        System.out.println("5) Volver");
        System.out.print("Opción---> ");
        Integer opcion = Integer.valueOf(scanner.nextLine());
        if (opcion==1){
            System.out.println("----------------------");
            System.out.print("Nuevo nombre---> ");
            String nombre = scanner.nextLine();
            if (gestorUsuario.comprobarNombre(nombre)){
                usuario.setNombre(nombre);
            }
            else {
                System.out.println("El nombre ya esta en uso.");
            }
            ajustes();
        }
        else if (opcion==2){
            System.out.println("----------------------");
            System.out.print("Nuevo correo---> ");
            String correo = scanner.nextLine();
            if (gestorUsuario.comprobarNombre(correo)){
                usuario.setCorreo(correo);
            }
            else {
                System.out.println("El correo ya esta en uso.");
            }
            ajustes();
        }
        else if (opcion==3){
            contraseña();
        }
        else if (opcion==4){
            System.out.print("Para activar el administrador ponga el codigo--->");
            int codigo = Integer.parseInt(scanner.nextLine());
            usuario.setAdmin(codigo);
        }
        else if (opcion==5){
            return;
        }
        else {
            System.out.println("No es una opcion.");
            ajustes();
        }

    }

    private void contraseña(){
        System.out.println("---------");
        System.out.print("Ponga su contraseña---> ");
        String contra = scanner.nextLine();
        if (contra.equals(usuario.getContraseña())){
            while (true){
                System.out.print("Ponga su nueva contraseña---> ");
                String contraseña = scanner.nextLine();
                System.out.print("Repita su nueva contraseña---> ");
                String contraseña2 = scanner.nextLine();
                if (contraseña.equals(contraseña2)){
                    usuario.setContraseña(contraseña);
                    break;
                }
                else {
                    System.out.println("Las contaseñas no coinciden");
                }
            }
        }
        else {
            System.out.println("La contraseña no coincide.");
        }
        ajustes();
    }
}
