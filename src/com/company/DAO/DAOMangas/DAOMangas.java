package com.company.DAO.DAOMangas;

import com.company.Clases.Anime;
import com.company.Clases.Manga;

import java.util.List;

public interface DAOMangas {
    public List<Manga> getManga();
    public void add(Manga manga);
}
