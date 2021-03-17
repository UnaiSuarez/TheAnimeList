package com.company.DAO.DAOMangas;

import com.company.Clases.Anime;
import com.company.Clases.Manga;

import java.util.List;
/**
 * Interfaz que define el comportamiento de los animes y su persistencia
 */
public interface DAOMangas {
    /**
     * Con este método, las clases que implementen la interfaz obtendrán una lista de mangas
     * @return List<Manga> lista de mangas
     */
    public List<Manga> getManga();
    public void add(Manga manga);
    public void delete(int posicion);
}
