package com.company.Gestores;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIGestorMenu extends JFrame{
    GestorUsuario gestorUsuario = new GestorUsuario();
    private JPanel inicio;
    private JButton iniciarSesion;
    private JButton registrasrse;
    private JButton salir;

    public GUIGestorMenu(){
        setSize(400,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(inicio);
        iniciarSesion.addActionListener(e -> {
            dispose();
            gestorUsuario.iniciarSesion();
        });
        registrasrse.addActionListener(e -> {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gestorUsuario.creaUsuarios();
        });
        salir.addActionListener(e -> {
        });
    }

}
