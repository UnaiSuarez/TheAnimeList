package com.company.Clases;

import java.io.Serializable;
import java.util.Date;

public class Anime implements Serializable {
    private String nombre;
    private int calificacion, duracion;
    private int fechaSalida;

    public Anime(String nombre, int calificacion, int duracion, int fechaSalida) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.duracion = duracion;
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "nombre='" + nombre + '\'' +
                ", calificacion=" + calificacion +
                ", duracion=" + duracion +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
