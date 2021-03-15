package com.company.Gestores;

import com.company.Clases.Anime;
import com.company.Clases.Categorias.Categoria;
import com.company.Clases.Manga;
import com.company.Clases.Usuario;
import com.company.DAO.DAOFactory;

import java.util.List;
import java.util.Scanner;

public class GestroAplicacion {
    Scanner scanner = new Scanner(System.in);
    GestorMenu gestorMenu = new GestorMenu();
    Usuario usuario;
    private List<Anime> animes = DAOFactory.getInstance().getDaoAnime().getAnime();
    private List<Manga> mangas = DAOFactory.getInstance().getDaoMangas().getManga();
    private List<Usuario> usuarios;


    public GestroAplicacion(Usuario usuario) {
        this.usuario = usuario;
    }

    public void aplicacion() {
        Ajustes ajustes = new Ajustes(usuario);
        System.out.println("----------------------");
        System.out.println("¿Que desea hacer?");
        String texto = "1) Guardar un nuevo anime o manga\n2) Ver mis animes o mangas\n3) Cerrar sesión\n";

        if (usuario.getAdmin()) {
            usuarios = DAOFactory.getInstance().getDaoUsuario().getUsuario();
            System.out.println("--------");
            System.out.println("Opciones de Usuario:");
            System.out.println(texto);
            System.out.println("--------");
            System.out.println("Opciones de administrador:");
            System.out.println("4) Añadir un nuevo anime o manga\n5) Eliminar un anime o manga\n6) Bannear un usuario");
            System.out.println("--------");
            System.out.print("Ponga 10 para acceder a los ajustes\nOpcioón---> ");
        } else {
            System.out.println(texto);
            System.out.println("--------");
            System.out.print("Ponga 10 para acceder a los ajustes\nOpcioón---> ");
        }

        Integer opcion = Integer.valueOf(scanner.nextLine());
        if (opcion == 1) {
            guardarMenu();
        } else if (opcion == 2) {
            verAnimesYMangas();
        } else if (opcion == 3) {
            System.out.println("Hasta la proxima " + usuario.getNombre() + " ;)");
            gestorMenu.MenuPrincipal();
        } else if (opcion == 4 && usuario.getAdmin()) {
            añadirAnmimeOManga();
        } else if (opcion == 5 && usuario.getAdmin()) {
            eliminarAnimeOManga();
        } else if (opcion == 6 && usuario.getAdmin()) {
            bannearUsuario();
        } else if (opcion == 10){
            ajustes.ajustes();
            aplicacion();
        } else {
            System.out.println(opcion + " no es una opción :(");
            aplicacion();
        }
    }

    private void guardarMenu() {
        System.out.println("------------------");
        System.out.print("¿Que desea guardar, Anime o Manga?\nPonga 3 para volver atras\nOpción---> ");
        String opcion = scanner.nextLine();
        if (opcion.equals("anime")) {
            guardarAnime();
        } else if (opcion.equals("manga")) {
            guardarManga();
        } else if (opcion.equals("3")) {
            aplicacion();
        } else {
            System.out.println(opcion + " no es una opcion");
            guardarMenu();
        }
    }

    private void guardarAnime() {
        System.out.println("----------------------");
        while (true) {
            for (int i = 0; i < animes.size(); i++) {
                System.out.println(i + ") " + animes.get(i).getNombre());
            }
            System.out.print("Anime---> ");
            Integer animeEsoger = Integer.valueOf(scanner.nextLine());
            showAnimes(animes.get(animeEsoger), animeEsoger);
            System.out.print("¿Desea gaurdar este anime?---> ");
            String opcion = scanner.nextLine();
            if (opcion.equals("si")) {
                Categoria categoria = null;
                System.out.println("¿En que categoria desea guardarlo?");
                System.out.print("1) Favoritos\n2) Seguidos\n3) Espera\nOpción---> ");
                String cat = scanner.nextLine();
                if (cat.equals("1")) {
                    categoria = Categoria.FAVORITO;
                } else if (cat.equals("2")) {
                    categoria = Categoria.SEGUIDO;
                } else {
                    categoria = Categoria.ESPERA;
                }
                usuario.añadirAnime(animes.get(animeEsoger), categoria);
                System.out.println("Anime guardado correctamente");
                aplicacion();
            }
        }

    }

    private void guardarManga() {
        System.out.println("----------------------");
        mangas = DAOFactory.getInstance().getDaoMangas().getManga();
        while (true) {
            for (int i = 0; i < mangas.size(); i++) {
                System.out.println(i + ") " + mangas.get(i).getNombre());
            }
            System.out.print("Manga---> ");
            Integer mangaEsoger = Integer.valueOf(scanner.nextLine());
            showMangas(mangas.get(mangaEsoger), mangaEsoger);
            System.out.print("¿Desea gaurdar este Manga?---> ");
            String opcion = scanner.nextLine();
            if (opcion.equals("si")) {
                Categoria categoria = null;
                System.out.println("¿En que categoria desea guardarlo?");
                System.out.print("1) Favoritos\n2) Seguidos\n3) Espera\nOpción---> ");
                String cat = scanner.nextLine();
                if (cat.equals("1")) {
                    categoria = Categoria.FAVORITO;
                } else if (cat.equals("2")) {
                    categoria = Categoria.SEGUIDO;
                } else {
                    categoria = Categoria.ESPERA;
                }
                usuario.añadirManga(mangas.get(mangaEsoger), categoria);
                System.out.println("Manga guardado correctamente");
                aplicacion();
            }
        }
    }

    private void verAnimesYMangas() {
        System.out.println("----------------------");
        System.out.print("¿Qué quieres ver, Animes o Mangas?\nPonga 3 para volver atras\nOpción---> ");
        String opcion = scanner.nextLine();
        if (opcion.equals("anime")) {
            verAnimes();
        } else if (opcion.equals("manga")) {
            verMangas();
        } else {
            aplicacion();
        }
    }

    private void verAnimes() {
        System.out.println("----------------------");
        System.out.println("¿Que categoria quieres ver?");
        System.out.print("1) Favoritos\n2) Seguidos\n3) Espera\nPonga 4 para volver atras\nOpción--->  ");
        String cat = scanner.nextLine();
        if (cat.equals("1")) {
            for (int i = 0; i < usuario.getAnimes().get(Categoria.FAVORITO).size(); i++) {
                showAnimes(usuario.getAnimes().get(Categoria.FAVORITO).get(i), i);
            }
        } else if (cat.equals("2")) {
            for (int i = 0; i < usuario.getAnimes().get(Categoria.SEGUIDO).size(); i++) {
                showAnimes(usuario.getAnimes().get(Categoria.SEGUIDO).get(i), i);
            }
        } else if (cat.equals("3")) {
            for (int i = 0; i < usuario.getAnimes().get(Categoria.ESPERA).size(); i++) {
                showAnimes(usuario.getAnimes().get(Categoria.ESPERA).get(i), i);
            }
        } else if (cat.equals("4")) {
            verAnimesYMangas();
        } else {
            System.out.println("No es una opcion");
            verAnimes();
        }
        aplicacion();
    }

    private void showAnimes(Anime anime, Integer n) {
        System.out.println("------------" + n);
        System.out.println("Nombre: " + anime.getNombre());
        System.out.println("Duracion: " + anime.getDuracion());
        System.out.println("Fecha de salida: " + anime.getFechaSalida());
        System.out.println("Calificacion: " + anime.getCalificacion());

    }

    private void verMangas() {
        System.out.println("----------------------");
        System.out.println("¿Que categoria quieres ver?");
        System.out.print("1) Favoritos\n2) Seguidos\n3) Espera\nPonga 4 para volver atras\nOpción--->  ");
        String cat = scanner.nextLine();
        if (cat.equals("1")) {
            for (int i = 0; i < usuario.getMangas().get(Categoria.FAVORITO).size(); i++) {
                showMangas(usuario.getMangas().get(Categoria.FAVORITO).get(i), i);
            }
        } else if (cat.equals("2")) {
            for (int i = 0; i < usuario.getMangas().get(Categoria.SEGUIDO).size(); i++) {
                showMangas(usuario.getMangas().get(Categoria.SEGUIDO).get(i), i);
            }
        } else if (cat.equals("3")) {
            for (int i = 0; i < usuario.getMangas().get(Categoria.ESPERA).size(); i++) {
                showMangas(usuario.getMangas().get(Categoria.ESPERA).get(i), i);
            }
        } else if (cat.equals("4")) {
            verAnimesYMangas();
        } else {
            System.out.println("No es una opcion");
            verMangas();
        }
        aplicacion();
    }

    private void showMangas(Manga manga, Integer n) {
        System.out.println("------------" + n);
        System.out.println("Nombre: " + manga.getNombre());
        System.out.println("Paginas: " + manga.getPaginas());
        System.out.println("Fecha de salida: " + manga.getFechaSalida());
        System.out.println("Calificacion: " + manga.getCalificacion());

    }

    private void añadirAnmimeOManga() {
        System.out.println("----------------------");
        System.out.print("¿Qué quieres guardar, Anime o Manga?\nPonga 3 para volver atras\nOpción---> ");
        String opcion = scanner.nextLine();
        if (opcion.equals("anime")) {
            añadirAnimes();
        } else if (opcion.equals("manga")) {
            añadirMangas();
        } else {
            aplicacion();
        }
    }

    private void añadirAnimes() {
        System.out.println("----------------------");
        System.out.print("Nombre---> ");
        String nombre = scanner.nextLine();
        System.out.print("Calificación---> ");
        Integer califiacaion = Integer.valueOf(scanner.nextLine());
        System.out.print("Duracion---> ");
        Integer duracion = Integer.valueOf(scanner.nextLine());
        System.out.print("Año de salida---> ");
        Integer fecha = Integer.valueOf(scanner.nextLine());
        Anime anime = new Anime(nombre, califiacaion, duracion, fecha);
        DAOFactory.getInstance().getDaoAnime().add(anime);
        System.out.println("Anime guardado correctamente");
        aplicacion();
    }

    private void añadirMangas() {
        System.out.println("----------------------");
        System.out.print("Nombre---> ");
        String nombre = scanner.nextLine();
        System.out.print("Calificación---> ");
        Integer califiacaion = Integer.valueOf(scanner.nextLine());
        System.out.print("Paginas---> ");
        Integer duracion = Integer.valueOf(scanner.nextLine());
        System.out.print("Año de salida---> ");
        Integer fecha = Integer.valueOf(scanner.nextLine());
        Manga manga = new Manga(nombre, califiacaion, duracion, fecha);
        DAOFactory.getInstance().getDaoMangas().add(manga);
        System.out.println("Manga guardado correctamente");
        aplicacion();
    }

    private void eliminarAnimeOManga() {
        System.out.println("----------------------");
        System.out.print("¿Qué quieres eliminar, Anime o Manga?\nPonga 3 para volver atras\nOpción---> ");
        String opcion = scanner.nextLine();
        if (opcion.equals("anime")) {
            eliminarAnimes();
        } else if (opcion.equals("manga")) {
            eliminarMangas();
        } else {
            aplicacion();
        }
    }

    private void eliminarAnimes() {
        System.out.println("----------------------");
        for (int i = 0; i < animes.size(); i++) {
            System.out.println(i + ") " + animes.get(i).getNombre());
        }
        System.out.print("¿Cual desea eliminar?---> ");
        int opcion = Integer.parseInt(scanner.nextLine());
        DAOFactory.getInstance().getDaoAnime().delete(opcion);
        System.out.println("Anime eliminado correctamente.");
        aplicacion();
    }

    private void eliminarMangas() {
        System.out.println("----------------------");
        for (int i = 0; i < mangas.size(); i++) {
            System.out.println(i + ") " + mangas.get(i).getNombre());
        }
        System.out.print("¿Cual desea eliminar?---> ");
        int opcion = Integer.parseInt(scanner.nextLine());
        DAOFactory.getInstance().getDaoMangas().delete(opcion);
        System.out.println("Manga eliminado correctamente.");
        aplicacion();
    }

    private void bannearUsuario(){
        System.out.println("----------------------");
        for (int i = 0; i < usuarios.size(); i++) {
            if (!usuarios.get(i).getAdmin()){
                System.out.println(i + ") " + usuarios.get(i).getNombre());
            }
        }
        System.out.print("¿Cual desea eliminar?---> ");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (!usuarios.get(opcion).getAdmin()){
            DAOFactory.getInstance().getDaoUsuario().delete(opcion);
            System.out.println("Usuario eliminado correctamente.");
        }
        else {
            System.out.println("El usuario es administrador, no es posible eliminarlo.");;
        }
        aplicacion();

    }

}
