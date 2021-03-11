package com.company.DAO.DAOAnimes;

import com.company.Clases.Anime;

import java.util.List;

public interface DAOAnime {
  public List<Anime> getAnime();
    public void add(Anime anime);
}
