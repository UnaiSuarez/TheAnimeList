package com.company.DAO.DAOMangas;

import com.company.Clases.Anime;
import com.company.Clases.Manga;
import com.company.DAO.DAOSerializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMangasSerializable extends DAOSerializable implements DAOMangas{
    List<Manga> mangas;

    public DAOMangasSerializable(){
        super("mangas.txt");
        Object obj = this.load();
        if (obj == null){
            mangas = new ArrayList<>();
        }
        else {
            mangas = (List<Manga>) obj;
        }
    }


    @Override
    public List<Manga> getManga() {
        return mangas;
    }

    public void add(Manga manga){
        mangas.add(manga);
        this.save(mangas);
    }

    public void delete(int posicion){
        mangas.remove(posicion);
        this.save(mangas);
    }
}
