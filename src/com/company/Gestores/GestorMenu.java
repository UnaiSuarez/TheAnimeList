package com.company.Gestores;

import com.company.Clases.Porvisional.AñadirAnimesYmangas;
import com.company.Clases.Porvisional.AñadirUsuarios;
import com.company.DAO.DAOFactory;
import com.company.DAO.DAOUsuario.DAOUsuario;

public class GestorMenu {

    public void MenuPrincipal(){
      /*  Scanner scanner = new Scanner(System.in);
        System.out.println("Menu principal");
        System.out.println("Iniciar sesión");
        System.out.print("Usuario -->");
        String user = scanner.nextLine();
       */

        System.out.println(DAOFactory.getInstance().getDaoUsuario().getUsuario());
    }
}
