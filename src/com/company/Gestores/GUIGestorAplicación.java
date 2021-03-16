package com.company.Gestores;

import com.company.Clases.Anime;
import com.company.Clases.Categorias.Categoria;
import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import javax.swing.*;
import java.util.List;

public class GUIGestorAplicación extends JFrame{
    private JPanel aplicacionUsuario;
    private JButton editarAnimes;
    private JButton editarMangas;
    private JLabel nombreUsuario;
    private JButton salir;
    private JPanel administradorPanel;
    private JButton agregarAnimeDesplegable;
    private JPanel agregarMangaPanel;
    private JButton agregarMangaDesplegable;
    private JTextField inputNombreManga;
    private JTextField inputFechaManga;
    private JTextField inputCalificacionManga;
    private JTextField inputDuracionManga;
    private JButton agregarManga;
    private JPanel agregarAnimePanel;
    private JButton cerrarMangaLista;
    private JTextField inputNombreAnime;
    private JTextField inputCalificacionAnime;
    private JTextField inputDuracionAnime;
    private JButton agregarAnime;
    private JPanel guardarVerAnimePanel;
    private JButton guardarAnimeNuevo;
    private JButton verAnimes;
    private JButton cerrarEditarAnimes;
    private JPanel guardarAnimePanel;
    private JList animeList;
    private JButton guardarAnimeSeleccionado;
    private JTextField inputFechaAnime;
    private JButton botonEliminarAnime;
    private JPanel eliminarAnimePanel;
    private JList listaAnime;
    private JButton eliminarAnimeSeleccionado;
    private JPanel panelUsuario;
    private Usuario usuario;

    private List<Anime> animes;


    public GUIGestorAplicación(Usuario usuario){
        agregarAnimePanel.setVisible(false);
        agregarMangaPanel.setVisible(false);
        guardarVerAnimePanel.setVisible(false);
        guardarAnimePanel.setVisible(false);
        eliminarAnimePanel.setVisible(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(aplicacionUsuario);
        this.usuario = usuario;
        nombreUsuario.setText(usuario.getNombre());
        if (!usuario.getAdmin()){
            this.administradorPanel.setVisible(false);
        }
        editarAnimes.addActionListener(e -> {
            guardarVerAnimePanel.setVisible(true);
        });
        guardarAnimeNuevo.addActionListener(e -> {
            setAnimeList();
            guardarAnimePanel.setVisible(true);
            guardarAnimeFuncion();
        });
        cerrarEditarAnimes.addActionListener(e -> {
            guardarVerAnimePanel.setVisible(false);
            guardarAnimePanel.setVisible(false);
        });

        agregarMangaDesplegable.addActionListener(e -> {
            agregarMangaPanel.setVisible(true);
        });
        cerrarMangaLista.addActionListener(e -> {
            agregarMangaPanel.setVisible(false);
        });
        agregarAnimeDesplegable.addActionListener(e -> {
            if (agregarAnimePanel.isVisible()){
                agregarAnimePanel.setVisible(false);
            }
            else {
                agregarAnimePanel.setVisible(true);
            }
        });
        salir.addActionListener(e -> {
                JOptionPane.showMessageDialog(this,"Sesion cerrada ","Cierre Sesion",JOptionPane.PLAIN_MESSAGE);
            dispose();
        });
        agrgarAnime();
    }

    private void agrgarAnime(){

try {
    System.out.println(DAOFactory.getInstance().getDaoAnime().getAnime());

    agregarAnime.addActionListener(e -> {
        String nombre = inputNombreAnime.getText();
        int calificacion= Integer.parseInt(inputCalificacionAnime.getText());
        int duracion = Integer.parseInt(inputDuracionAnime.getText());
        int fecha = Integer.parseInt(inputFechaAnime.getText());
        Anime anime = new Anime(nombre,calificacion,duracion,fecha);
        DAOFactory.getInstance().getDaoAnime().add(anime);
        System.out.println(DAOFactory.getInstance().getDaoAnime().getAnime());
    });
}
catch (Exception e){
    inputCalificacionAnime.setText("0");
    inputDuracionAnime.setText("0");
    inputFechaAnime.setText("0");
}

    }

    private void guardarAnimeFuncion(){
        System.out.println(usuario.getAnimes());
        guardarAnimeSeleccionado.addActionListener(e -> {
            animes = DAOFactory.getInstance().getDaoAnime().getAnime();
            usuario.añadirAnime(animes.get(animeList.getSelectedIndex()),Categoria.ESPERA);
            System.out.println(usuario.getAnimes());
        });
    }
private void eliminarAnimeFuncion(){
        
}
    private void setAnimeList(){animeList.setListData(DAOFactory.getInstance().getDaoAnime().getAnime().toArray());}
}
