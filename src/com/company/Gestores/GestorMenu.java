package com.company.Gestores;

import java.util.Scanner;

public class GestorMenu {

    public void MenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu principal");
        System.out.println("Iniciar sesión");
        System.out.print("Usuario -->");
        String user = scanner.nextLine();
    }
}
