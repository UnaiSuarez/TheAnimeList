package com.company.Gestores;

public class GestorCifradoContraseña {
    public String codificaCesar(String texto){
        String textoCodificado = "";
        for (int a = 0; a < texto.length(); a++) {
            char letra = texto.charAt(a);
            int letraN = (int)letra + 3;
            char letraF = (char)letraN;
            textoCodificado += letraF;
        }
        return textoCodificado;
    }
}
