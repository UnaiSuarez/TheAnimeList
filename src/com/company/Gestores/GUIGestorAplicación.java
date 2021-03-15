package com.company.Gestores;

import com.company.Clases.Anime;
import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import javax.swing.*;

public class GUIGestorAplicación extends JFrame{
    private JPanel aplicacionUsuario;
    private JButton editarAnimes;
    private JButton editarMangas;
    private JLabel nombreUsuario;
    private JButton salir;
    private JPanel administradorPanel;
    private JButton agregarAnimeDesplegable;
    private JPanel agregarMangaLista;
    private JButton agregarMangaDesplegable;
    private JTextField inputNombreManga;
    private JTextField inputFechaManga;
    private JTextField inputCalificacionManga;
    private JTextField inputDuracionManga;
    private JButton agregarManga;
    private JPanel agragarAnimeLista;
    private JButton cerrarAnimeLista;
    private JButton cerrarMangaLista;
    private JTextField inputNombreAnime;
    private JSpinner inputFechaAnime;
    private JTextField inputCalificacionAnime;
    private JTextField inputDuracionAnime;
    private JButton agregarAnime;
    private Usuario usuario;

    public GUIGestorAplicación(Usuario usuario){
        agragarAnimeLista.setVisible(false);
        agregarMangaLista.setVisible(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(aplicacionUsuario);
        this.usuario = usuario;
        nombreUsuario.setText(usuario.getNombre());
        if (!usuario.getAdmin()){
            this.administradorPanel.setVisible(false);
        }
        agregarAnimeDesplegable.addActionListener(e -> {
            agragarAnimeLista.setVisible(true);
        });
        cerrarAnimeLista.addActionListener(e -> {
            agragarAnimeLista.setVisible(false);
        });
        agregarMangaDesplegable.addActionListener(e -> {
            agregarMangaLista.setVisible(true);
        });
        cerrarMangaLista.addActionListener(e -> {
            agregarMangaLista.setVisible(false);
        });
        salir.addActionListener(e -> {
                JOptionPane.showMessageDialog(this,"Sesion cerrada ","Cierre Sesion",JOptionPane.PLAIN_MESSAGE);
            dispose();
        });
        agrgarAnime();
    }

    private void agrgarAnime(){
        System.out.println(DAOFactory.getInstance().getDaoAnime().getAnime());;

        String nombre = inputNombreAnime.getText();
        String calificacion = inputCalificacionAnime.getText();
        String duracion = inputDuracionAnime.getText();
        //Anime anime = new Anime(nombre,calificacion,duracion,fecha);
        agregarAnime.addActionListener(e -> {
        //  DAOFactory.getInstance().getDaoAnime().add(anime);
            System.out.println(DAOFactory.getInstance().getDaoAnime().getAnime());
        });
    }
}
