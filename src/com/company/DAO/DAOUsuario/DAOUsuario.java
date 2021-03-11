package com.company.DAO.DAOUsuario;

import com.company.Clases.Manga;
import com.company.Clases.Usuario;

import java.util.List;

public interface DAOUsuario {
    public List<Usuario> getUsuario();
    public void add(Usuario usuario);
}
