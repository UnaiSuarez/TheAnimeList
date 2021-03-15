package com.company.Gestores;

import com.company.Clases.Porvisional.AñadirAnimesYmangas;
import com.company.DAO.DAOFactory;
import com.company.DAO.DAOUsuario.DAOUsuario;

import java.util.Scanner;

public class GestorMenu {
    GestorUsuario gestorUsuario = new GestorUsuario();

    public void MenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu principal");
        System.out.println("--------------");
        System.out.print("1) Iniciar sesión\n2) Registrarse\n3) Salir\nOpción --> ");
        Integer opcion = Integer.valueOf(scanner.nextLine());
        if (opcion==1){
            gestorUsuario.iniciarSesion();
        }
        else if (opcion==2){
            gestorUsuario.creaUsuarios();
        }
        else if (opcion==3){
            System.out.println("Adios");
        }
        else {
            System.out.println("no es una opcion");
        }



    }
}
