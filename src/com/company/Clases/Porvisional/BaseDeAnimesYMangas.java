package com.company.Clases.Porvisional;

import com.company.Clases.Anime;
import com.company.Clases.Manga;
import com.company.DAO.DAOFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseDeAnimesYMangas implements Serializable {
    private List<Anime> animes;
    private List<Manga> mangas;

    public List<Anime> getAnimes() {
        return animes;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void añadirAnime(Anime anime){
        DAOFactory.getInstance().getDaoAnime().add(anime);
        animes = DAOFactory.getInstance().getDaoAnime().getAnime();
    }

    public void añadirManga(Manga manga){
        DAOFactory.getInstance().getDaoMangas().add(manga);
        mangas = DAOFactory.getInstance().getDaoMangas().getManga();
    }

    @Override
    public String toString() {
        return "BaseDeAnimesYMangas{" +
                "animes=" + animes +
                ", mangas=" + mangas +
                '}';
    }
}
