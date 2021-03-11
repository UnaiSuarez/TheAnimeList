package com.company.DAO.DAOAnimes;

import com.company.Clases.Anime;
import com.company.DAO.DAOSerializable;

import java.util.ArrayList;
import java.util.List;

public class DAOAnimeSerializable extends DAOSerializable implements DAOAnime {

    List<Anime> animes;


    public DAOAnimeSerializable() {
        super("animes.txt");
        Object obj = this.load();
        if(obj == null){
            animes = new ArrayList<>();
        }
        else {
            animes = (List<Anime>) obj;
        }
    }

    @Override
    public List<Anime> getAnime() {
        return animes;
    }

    @Override
    public void add(Anime anime) {
        animes.add(anime);
        this.save(animes);
    }
}
