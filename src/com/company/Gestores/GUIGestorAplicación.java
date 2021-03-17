package com.company.Gestores;

import com.company.Clases.Anime;
import com.company.Clases.Categorias.Categoria;
import com.company.Clases.Manga;
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
    private JPanel eliminarAnimePanel;
    private JList listaAnimeEliminar;
    private JButton eliminarAnimeSeleccionado;
    private JPanel panelUsuario;
    private JButton favoritosButtonAnime;
    private JButton esperaButtonAnime;
    private JButton seguidosButtonAnime;
    private JList verAnimesLista;
    private JPanel verAnimesPanel;
    private JButton favoritosButtonGuardarAnime;
    private JButton esperaButtonGuardarAnime;
    private JButton seguidosButtonGuardarAnime;
    private JPanel guardarVerMangaPanel;
    private JButton guardarMangaNuevo;
    private JButton verMangaNuevo;
    private JPanel guardarMangaPanel;
    private JList mangaList;
    private JButton favoritosBotonGuardarManga;
    private JButton esperaBotonGuardarManga;
    private JButton seguidosBotonGuardarManga;
    private JPanel verMangasPanel;
    private JList verMangasLista;
    private JButton verfavoritosMangasBoton;
    private JButton verEsperaMangasBoton;
    private JButton verSeguidosMangaBoton;
    private JButton eliminarMangaSeleccionado;
    private JList listaMangasEliminar;
    private Usuario usuario;

    private List<Anime> animes;
    private List<Manga> mangas;


    public GUIGestorAplicación(Usuario usuario){
        agregarAnimePanel.setVisible(false);
        agregarMangaPanel.setVisible(false);
        guardarVerAnimePanel.setVisible(false);
        guardarAnimePanel.setVisible(false);
        verAnimesPanel.setVisible(false);
        verMangasPanel.setVisible(false);
        guardarMangaPanel.setVisible(false);
        guardarVerMangaPanel.setVisible(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(aplicacionUsuario);
        this.usuario = usuario;
        nombreUsuario.setText(usuario.getNombre());
        if (!usuario.getAdmin()){
            this.administradorPanel.setVisible(false);
        }
        editarAnimes.addActionListener(e -> {
            if (guardarVerAnimePanel.isVisible()){
                guardarVerAnimePanel.setVisible(false);
            }
            else {
                guardarVerAnimePanel.setVisible(true);
            }
        });
        editarMangas.addActionListener(e -> {
            if (guardarVerMangaPanel.isVisible()){
                guardarVerMangaPanel.setVisible(false);
            }
            else {
                guardarVerMangaPanel.setVisible(true);
            }
        });
        guardarAnimeNuevo.addActionListener(e -> {
            setAnimeList();
            if (guardarAnimePanel.isVisible()){
                guardarAnimePanel.setVisible(false);
            }
            else {
                guardarAnimePanel.setVisible(true);
            }
        });
        guardarMangaNuevo.addActionListener(e -> {
            setMangaList();
            if (guardarMangaPanel.isVisible()){
                guardarMangaPanel.setVisible(false);
            }
            else {
                guardarMangaPanel.setVisible(true);
            }
        });
        verMangaNuevo.addActionListener(e -> {
            if (verMangasPanel.isVisible()){
                verMangasPanel.setVisible(false);
            }
            else {
                verMangasPanel.setVisible(true);
            }
        });
        verAnimes.addActionListener(e -> {
            if (verAnimesPanel.isVisible()){
                verAnimesPanel.setVisible(false);
            }
            else {
                verAnimesPanel.setVisible(true);
            }
        });
        favoritosButtonAnime.addActionListener(e -> {
            setVerAnimesLista(Categoria.FAVORITO);
        });
        esperaButtonAnime.addActionListener(e -> {
            setVerAnimesLista(Categoria.ESPERA);
        });
        seguidosButtonAnime.addActionListener(e -> {
            setVerAnimesLista(Categoria.SEGUIDO);
        });
        verfavoritosMangasBoton.addActionListener(e -> {
            setVerMangasLista(Categoria.FAVORITO);
        });
        verEsperaMangasBoton.addActionListener(e -> {
            setVerMangasLista(Categoria.ESPERA);
        });
        verSeguidosMangaBoton.addActionListener(e -> {
            setVerMangasLista(Categoria.SEGUIDO);
        });
        agregarMangaDesplegable.addActionListener(e -> {
            setListaMangasEliminar();
            if (agregarMangaPanel.isVisible()){
                agregarMangaPanel.setVisible(false);
            }else {
                agregarMangaPanel.setVisible(true);
            }
        });
        agregarAnimeDesplegable.addActionListener(e -> {
            setListaAnimeEliminar();
            if (agregarAnimePanel.isVisible()){
                agregarAnimePanel.setVisible(false);
            }
            else {
                agregarAnimePanel.setVisible(true);
            }
        });
        favoritosButtonGuardarAnime.addActionListener(e ->{
         guardarAnimeFuncion(Categoria.FAVORITO);
        });
        esperaButtonGuardarAnime.addActionListener(e -> {
            guardarAnimeFuncion(Categoria.ESPERA);
        });
        seguidosButtonGuardarAnime.addActionListener(e -> {
            guardarAnimeFuncion(Categoria.SEGUIDO);
        });
        favoritosBotonGuardarManga.addActionListener(e -> {
            guardarMangaFuncion(Categoria.FAVORITO);
        });
        seguidosBotonGuardarManga.addActionListener(e -> {
            guardarMangaFuncion(Categoria.SEGUIDO);
        });
        esperaBotonGuardarManga.addActionListener(e -> {
            guardarMangaFuncion(Categoria.ESPERA);
        });
        eliminarAnimeSeleccionado.addActionListener(e -> {
            eliminarAnimeFuncion(listaAnimeEliminar.getSelectedIndex());
            setListaAnimeEliminar();
        });
        eliminarMangaSeleccionado.addActionListener(e -> {
            eliminarMangaFuncion(listaMangasEliminar.getSelectedIndex());
            setListaMangasEliminar();
        });
        salir.addActionListener(e -> {
                JOptionPane.showMessageDialog(this,"Sesion cerrada ","Cierre Sesion",JOptionPane.PLAIN_MESSAGE);
            dispose();
        });
        agrgarAnime();
        agregarMangaFuncion();

    }

    private void agrgarAnime(){

try {
    agregarAnime.addActionListener(e -> {
        String nombre = inputNombreAnime.getText();
        int calificacion= Integer.parseInt(inputCalificacionAnime.getText());
        int duracion = Integer.parseInt(inputDuracionAnime.getText());
        int fecha = Integer.parseInt(inputFechaAnime.getText());
        Anime anime = new Anime(nombre,calificacion,duracion,fecha);
        DAOFactory.getInstance().getDaoAnime().add(anime);
        setListaAnimeEliminar();
    });
}
catch (Exception e){
    inputCalificacionAnime.setText("0");
    inputDuracionAnime.setText("0");
    inputFechaAnime.setText("0");
}

    }
    private void agregarMangaFuncion(){
        try {
            agregarManga.addActionListener(e -> {
                String nombre = inputNombreManga.getText();
                int calificacion= Integer.parseInt(inputCalificacionManga.getText());
                int duracion = Integer.parseInt(inputDuracionManga.getText());
                int fecha = Integer.parseInt(inputFechaManga.getText());
                Manga manga = new Manga(nombre,calificacion,duracion,fecha);
                DAOFactory.getInstance().getDaoMangas().add(manga);
                setListaMangasEliminar();
            });
        }
        catch (Exception e){
            inputCalificacionManga.setText("0");
            inputDuracionManga.setText("0");
            inputFechaManga.setText("0");
        }

    }
    private void guardarAnimeFuncion(Categoria categoria){
            animes = DAOFactory.getInstance().getDaoAnime().getAnime();
            usuario.añadirAnime(animes.get(animeList.getSelectedIndex()),categoria);
            DAOFactory.getInstance().getDaoUsuario().add(usuario);
    }

    private  void  guardarMangaFuncion(Categoria categoria){
        mangas = DAOFactory.getInstance().getDaoMangas().getManga();
        usuario.añadirManga(mangas.get(mangaList.getSelectedIndex()),categoria);
        DAOFactory.getInstance().getDaoUsuario().add(usuario);
    }
private void eliminarAnimeFuncion(int id){
        DAOFactory.getInstance().getDaoAnime().delete(id);
}
private void eliminarMangaFuncion(int id){
        DAOFactory.getInstance().getDaoMangas().delete(id);
}
    private void setVerAnimesLista(Categoria categoria){
        if (usuario.getAnimes().get(categoria)==null){
            verAnimesLista.setVisible(false);
        }
        else {
            verAnimesLista.setVisible(true);
            verAnimesLista.setListData(usuario.getAnimes().get(categoria).toArray()); 
        }
        
    }

    private void setVerMangasLista(Categoria categoria){
        if (usuario.getMangas().get(categoria)==null){
            verMangasLista.setVisible(false);
        }
        else {
            verMangasLista.setVisible(true);
            verMangasLista.setListData(usuario.getMangas().get(categoria).toArray());
        }
    }

    private void setMangaList(){mangaList.setListData(DAOFactory.getInstance().getDaoMangas().getManga().toArray());}

    private void setListaMangasEliminar(){listaMangasEliminar.setListData(DAOFactory.getInstance().getDaoMangas().getManga().toArray());}

    private void setListaAnimeEliminar(){listaAnimeEliminar.setListData(DAOFactory.getInstance().getDaoAnime().getAnime().toArray());}

    private void setAnimeList(){animeList.setListData(DAOFactory.getInstance().getDaoAnime().getAnime().toArray());}
}
