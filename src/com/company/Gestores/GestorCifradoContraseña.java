package com.company.Gestores;

/**
 * Funcion para poder cifrar las contraseñas
 * Se utiliza un cifrado con ascii
 */
public class GestorCifradoContraseña {
    /**
     *
     * @param texto se refiere a la contraseña que qeuremos cifrar
     * @return devuelve el parametro texto(la contraseña) cifrado
     */
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
