package com.company.DAO.DAOUsuario;

import com.company.Clases.Manga;
import com.company.Clases.Usuario;
import com.company.DAO.DAOAnimes.DAOAnimeSerializable;
import com.company.DAO.DAOSerializable;

import java.util.ArrayList;
import java.util.List;

public class DAOUsuarioSerializable extends DAOSerializable implements DAOUsuario {
    List<Usuario> usuarios;

    public DAOUsuarioSerializable(){
        super("usuarios.txt");
        Object obj = this.load();
        if (obj == null){
            usuarios = new ArrayList<>();
        }
        else {
            usuarios = (List<Usuario>) obj;
        }
    }


    @Override
    public List<Usuario> getUsuario() {
        return usuarios;
    }

    public void add(Usuario usuario){
        usuarios.add(usuario);
        this.save(usuarios);
    }


    public void delete(int posicion){
        usuarios.remove(posicion);
        this.save(usuarios);
    }
}
