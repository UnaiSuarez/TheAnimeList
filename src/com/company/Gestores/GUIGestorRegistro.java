package com.company.Gestores;

import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GUIGestorRegistro extends JFrame{
    GestorCifradoContraseña gestorCifradoContraseña = new GestorCifradoContraseña();
    List<Usuario> usuarios = new ArrayList<>();
    private JTextField inputContraseña;
    private JTextField inputCorreo;
    private JTextField inputNombre;
    private JButton generarContraseña;
    private JLabel errorCorreo;
    private JLabel errorNombre;
    private JPanel gestorRegistro;
    private JTextField inputAdministrador;
    private JButton Registrar;

    public GUIGestorRegistro(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(gestorRegistro);
        Registrar.addActionListener(e -> {
            doRegister();
        });
        generarContraseña.addActionListener(e -> {
            inputContraseña.setText(creaContraseña());
        });
    }

    private void doRegister(){
        String nombre = inputNombre.getText();
        String correo = inputCorreo.getText();
        String contraseña = gestorCifradoContraseña.codificaCesar(inputContraseña.getText());
        if (comprobarCorreo(correo)&&comprobarNombre(nombre)){
            Usuario usuario = new Usuario(nombre,correo,contraseña);
            if (inputAdministrador.getText().equals("1234")){
                usuario.setAdmin();
            }
            else {
                JOptionPane.showMessageDialog(this,"El codigo de administrador no es correcto, podrá activarlo mas adelnate.","ADMINISTRADOR",JOptionPane.PLAIN_MESSAGE);
            }
            DAOFactory.getInstance().getDaoUsuario().add(usuario);
            dispose();
            GUIGestorMenu guiGestorMenu = new GUIGestorMenu();
            guiGestorMenu.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this,"El nombre de usuario o Correo y existe","REGISTRO",JOptionPane.PLAIN_MESSAGE);
        }

    }

    private String creaContraseña(){
        Random random = new Random();
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

    public boolean comprobarCorreo(String correo){
        usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCorreo().equals(correo)){
                return false;
            }
        }
        return true;
    }

    public boolean comprobarNombre(String nombre){
        usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(nombre)){
                return false;
            }
        }
        return true;
    }
}
