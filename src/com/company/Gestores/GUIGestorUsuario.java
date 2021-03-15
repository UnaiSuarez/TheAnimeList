package com.company.Gestores;

import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import javax.swing.*;
import java.util.List;

public class GUIGestorUsuario extends JFrame{
    GestorCifradoContraseña gestorCifradoContraseña = new GestorCifradoContraseña();
    List<Usuario> usuarios;
    private JTextField usuario;
    private JLabel errorNombre;
    private JLabel errorContraseña;
    private JPasswordField contraseña;
    private JPanel GestorUsuario;
    private JButton acceder;

    public GUIGestorUsuario(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(GestorUsuario);
        acceder.addActionListener(e -> {
            doLogin();
        });
    }

    private void doLogin(){
        usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        String email, password;
        email = usuario.getText();
        password = gestorCifradoContraseña.codificaCesar(contraseña.getText());
        for (int i = 0; i < usuarios.size(); i++) {
            String user = usuarios.get(i).getNombre();
            String c = usuarios.get(i).getCorreo();
            String con = usuarios.get(i).getContraseña();
            if (user.equals(email)&&con.equals(password)||c.equals(email)&&con.equals(password)){
                dispose();
                GUIGestorAplicación guiGestorAplicación = new GUIGestorAplicación(usuarios.get(i));
                guiGestorAplicación.setVisible(true);
            }
            else if (i == usuarios.size()){
                errorContraseña.setText("Error usuario o contraseña");
            }
            usuario.setText("");
            contraseña.setText("");
        }

    }
}
