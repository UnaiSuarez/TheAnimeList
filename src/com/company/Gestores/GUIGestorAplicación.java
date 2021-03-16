package com.company.Gestores;

import com.company.Clases.Anime;
import com.company.Clases.Categorias.Categoria;
import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.util.Date;
import java.util.List;

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
    private JTextField inputCalificacionAnime;
    private JTextField inputDuracionAnime;
    private JButton agregarAnime;
    private JPanel guardarVerAnime;
    private JButton guardarAnimeNuevo;
    private JButton verAnimes;
    private JButton cerrarEditarAnimes;
    private JPanel guardarAnime;
    private JList animeList;
    private JButton guardarAnimeSeleccionado;
    private JTextField inputFechaAnime;
    private Usuario usuario;

    private List<Anime> animes;


    public GUIGestorAplicación(Usuario usuario){
        agragarAnimeLista.setVisible(false);
        agregarMangaLista.setVisible(false);
        guardarVerAnime.setVisible(false);
        guardarAnime.setVisible(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(aplicacionUsuario);
        this.usuario = usuario;
        nombreUsuario.setText(usuario.getNombre());
        if (!usuario.getAdmin()){
            this.administradorPanel.setVisible(false);
        }
        editarAnimes.addActionListener(e -> {
            guardarVerAnime.setVisible(true);
        });
        guardarAnimeNuevo.addActionListener(e -> {
            setAnimeList();
            guardarAnime.setVisible(true);
            guardarAnimeFuncion();
        });
        cerrarEditarAnimes.addActionListener(e -> {
            guardarVerAnime.setVisible(false);
            guardarAnime.setVisible(false);
        });

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
        int calificacion= Integer.parseInt(inputCalificacionAnime.getText());
        int duracion = Integer.parseInt(inputDuracionAnime.getText());
        int fecha = Integer.parseInt(inputFechaAnime.getText());
        Anime anime = new Anime(nombre,calificacion,duracion,fecha);
        agregarAnime.addActionListener(e -> {
        //  DAOFactory.getInstance().getDaoAnime().add(anime);
            System.out.println(DAOFactory.getInstance().getDaoAnime().getAnime());
        });
    }

    private void guardarAnimeFuncion(){
        System.out.println(usuario.getAnimes());
        guardarAnimeSeleccionado.addActionListener(e -> {
            animes = DAOFactory.getInstance().getDaoAnime().getAnime();
            usuario.añadirAnime(animes.get(animeList.getSelectedIndex()),Categoria.ESPERA);
            System.out.println(usuario.getAnimes());
        });
    }

    private void setAnimeList(){animeList.setListData(DAOFactory.getInstance().getDaoAnime().getAnime().toArray());}
}
