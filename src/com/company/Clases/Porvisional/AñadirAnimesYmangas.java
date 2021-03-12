package com.company.Clases.Porvisional;

import com.company.Clases.Anime;
import com.company.Clases.Manga;

import java.io.Serializable;
import java.util.Random;

public class AñadirAnimesYmangas implements Serializable {
    String[] nombre = new String[]{"CAMPEONES (OLIVER Y BENJI)","CAPETA","CHIHAYAFURU","CITRUS","CLASSROOM OF THE ELITE","ENEN NO SHOUBOUTAI","FRUITS BASKET (2019)","LITTLE WITCH ACADEMIA"};
    String[] nombreM = new String[]{"¡A los dieciséis!" ,
            "Historias de Kioto - A Propósito de Chihiro" ,
            "Historias de Kioto - A Propósito de Yukichi" ,
            "A Silent Voice" ,
            "Abrazado a las estrellas" ,
            "Accel World" ,
            "Accel World (novela)" ,
            "Achis!" ,
            "ACT-AGE" ,
            "Ad Mortem" ,
            "Adam y Eve" ,
            "Adolescente pero no inocente",
            "Adolf",
            "¡Ah, mi diosa!",
            "Air Gear"};
    Random random = new Random();
    BaseDeAnimesYMangas baseDeAnimesYMangas = new BaseDeAnimesYMangas();
    public void añadir(){
        for (int i = 0; i < nombre.length; i++) {
            int calificacion = random.nextInt(5);
            int duracion = random.nextInt(50);
            int fecha = random.nextInt(2021);
            Anime anime = new Anime(nombre[i],calificacion,duracion,fecha);
            baseDeAnimesYMangas.añadirAnime(anime);
        }
        for (int i = 0; i < nombreM.length; i++) {
            int calificacion = random.nextInt(5);
            int duracion = random.nextInt(50);
            int fecha = random.nextInt();
            Manga manga = new Manga(nombreM[i],calificacion,duracion,fecha);
            baseDeAnimesYMangas.añadirManga(manga);
        }

    }
}
