package com.company.DAO;

import com.company.DAO.DAOAnimes.DAOAnime;
import com.company.DAO.DAOAnimes.DAOAnimeSerializable;
import com.company.DAO.DAOMangas.DAOMangas;
import com.company.DAO.DAOMangas.DAOMangasSerializable;
import com.company.DAO.DAOUsuario.DAOUsuario;
import com.company.DAO.DAOUsuario.DAOUsuarioSerializable;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOAnime daoAnime;
    private DAOMangas daoMangas;
    private DAOUsuario daoUsuario;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOAnime getDaoAnime(){
        if (daoAnime == null){
            daoAnime = new DAOAnimeSerializable();
        }
        return daoAnime;
    }

    public DAOMangas getDaoMangas(){
        if (daoMangas == null){
            daoMangas = new DAOMangasSerializable();
        }
        return daoMangas;
    }

    public DAOUsuario getDaoUsuario(){
        if (daoUsuario == null){
            daoUsuario = new DAOUsuarioSerializable();
        }
        return daoUsuario;
    }
}
