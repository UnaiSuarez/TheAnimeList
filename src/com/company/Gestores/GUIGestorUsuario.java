package com.company.Gestores;

import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import javax.swing.*;
import java.util.List;

/**
 * @author unai
 */
public class GUIGestorUsuario extends JFrame{
    GestorCifradoContraseña gestorCifradoContraseña = new GestorCifradoContraseña();
    List<Usuario> usuarios;
    private JTextField usuario;
    private JLabel errorNombre;
    private JLabel errorContraseña;
    private JPasswordField contraseña;
    private JPanel GestorUsuario;
    private JButton acceder;
//inicio la ventana

    /**
     *  inicia la ventana con unos parametros asignados
     */
    public GUIGestorUsuario(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(GestorUsuario);
        acceder.addActionListener(e -> {
            doLogin();
        });
    }

//con esta funcion puedo iniciar sesion

    /**
     * con esta funcion iniciamos sesion
     * Si el usuario y contraseña introducidos no coinciden saltará un error
     */
    private void doLogin(){
        //aqui cargo todos los usuarios
        usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        String email, password;
        //cojo lo introducido en los campos de texto y lo guardo en variables
        email = usuario.getText();
        password = gestorCifradoContraseña.codificaCesar(contraseña.getText());
        //hago un for para comprobar el usuario y la contraseña
        for (int i = 0; i < usuarios.size(); i++) {
            String user = usuarios.get(i).getNombre();
            String c = usuarios.get(i).getCorreo();
            String con = usuarios.get(i).getContraseña();
            //si coinciden las dos a la vez se ejecuta la aplicacion
            if (user.equals(email)&&con.equals(password)||c.equals(email)&&con.equals(password)){
                dispose();
                GUIGestorAplicación guiGestorAplicación = new GUIGestorAplicación(usuarios.get(i));
                guiGestorAplicación.setVisible(true);
            }
            //si no existen salta un error
            else if (i == usuarios.size()){
                errorContraseña.setText("Error usuario o contraseña");
            }

        }

    }
}
