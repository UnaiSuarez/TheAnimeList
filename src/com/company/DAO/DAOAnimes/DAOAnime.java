package com.company.DAO.DAOAnimes;

import com.company.Clases.Anime;

import java.util.List;

/**
 * Interfaz que define el comportamiento de los animes y su persistencia
 */
public interface DAOAnime {
  /**
   * Con este método, las clases que implementen la interfaz obtendrán una lista de animes
   * @return List<Anime>
   */
  public List<Anime> getAnime();
    public void add(Anime anime);
    public void delete(int posicion);
}
