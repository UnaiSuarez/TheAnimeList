package com.company.Clases;

import com.company.Clases.Categorias.Categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author unai suarez
 */
public class Usuario implements Serializable {

private String nombre,correo,contraseña;
private boolean admin;
private HashMap<Categoria, List<Anime>> animes;
private HashMap<Categoria,List<Manga>> mangas;

    /**
     *
     * @param nombre nombre que tendra el usuario
     * @param correo correo que tendra el usuario
     * @param contraseña contraseña que tendra el usuario
     */
    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.animes = new HashMap<>();
        this.mangas = new HashMap<>();
        this.admin = false;
    }

    /**
     * @return devuelve el nombre de usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return devuelve el correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }


    /**
     *
     * @param anime
     * @param categoria
     */
    public void añadirAnime(Anime anime, Categoria categoria){
        List<Anime> animeHas = animes.get(categoria);
        if (animeHas == null){
            animeHas = new ArrayList<>();
        }
        animeHas.add(anime);
        animes.put(categoria,animeHas);
    }

    /**
     *
     * @param manga
     * @param categoria
     */
    public void añadirManga(Manga manga, Categoria categoria){
        List<Manga> mangaHas = mangas.get(categoria);
        if (mangaHas == null){
            mangaHas = new ArrayList<>();
        }
        mangaHas.add(manga);
        mangas.put(categoria,mangaHas);
    }

    /**
     *
     * @return
     */
    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin() {
        this.admin = true;

    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public void setCorreo(String correo) {
            this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public HashMap<Categoria, List<Anime>> getAnimes() {
        return animes;
    }

    public HashMap<Categoria, List<Manga>> getMangas() {
        return mangas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", animes=" + animes +
                ", mangas=" + mangas +
                '}';
    }
}
