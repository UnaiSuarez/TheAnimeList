package com.company.Clases;

import com.company.Clases.Categorias.Categoria;
import com.company.Gestores.GestorUsuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @
 */
public class Usuario implements Serializable {
    GestorUsuario gestorUsuario = new GestorUsuario();
private String nombre,correo,contraseña;
private boolean admin;
private HashMap<Categoria, List<Anime>> animes;
private HashMap<Categoria,List<Manga>> mangas;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.animes = new HashMap<>();
        this.mangas = new HashMap<>();
        this.admin = false;
    }

    /**
     * @return
     */
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

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(int codigo) {
        if (codigo == 1234){
            this.admin = true;
            System.out.println("Cuenta de administrador activa.");
        }
        else {
            this.admin = false;
            System.out.println("El codigo no es correcto.");
            System.out.println("Se creará una cuenta nromal, puede cambiarlo mas adelante.");
        }

    }

    public void setNombre(String nombre) {
        if (gestorUsuario.comprobarNombre(nombre)){
            this.nombre = nombre;
        }
    }

    public void setCorreo(String correo) {
        if (gestorUsuario.comprobarCorreo(correo)){
            this.correo = correo;
        }
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
