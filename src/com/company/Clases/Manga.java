package com.company.Clases;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class Manga implements Serializable {
    private String nombre;
    private int calificacion, paginas;
    private int fechaSalida;

    public Manga(String nombre, int calificacion, int paginas, int fechaSalida) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.paginas = paginas;
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "nombre='" + nombre + '\'' +
                ", calificacion=" + calificacion +
                ", paginas=" + paginas +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
