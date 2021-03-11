package com.company.Clases;

import com.company.Clases.Categorias.Categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuario implements Serializable {
private String nombre,correo,contraseña;
private HashMap<Categoria, List<Anime>> animes;
private HashMap<Categoria,List<Manga>> mangas;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.animes = new HashMap<>();
        this.mangas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }



    public void añadirAnime(Anime anime, Categoria categoria){
        List<Anime> animeHas = animes.get(categoria);
        if (animeHas == null){
            animeHas = new ArrayList<>();
        }
        animeHas.add(anime);
        animes.put(categoria,animeHas);
    }

    public void añadirManga(Manga manga, Categoria categoria){
        List<Manga> mangaHas = mangas.get(categoria);
        if (mangaHas == null){
            mangaHas = new ArrayList<>();
        }
        mangaHas.add(manga);
        mangas.put(categoria,mangaHas);
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
