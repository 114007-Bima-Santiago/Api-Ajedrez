package com.grupo5.ApiAjedrez.Dominio;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Coordenada {
    private int fila;
    private int columna;
    private String nombre;
    private static String columnas = "ABCDEFGH";

    public void transformarACoordenada(String posicion){
        char col = posicion.charAt(0);
        for(int i = 0; i<8; i++){
            if(col == columnas.charAt(i)){
                fila = Integer.getInteger(String.valueOf(posicion.charAt(1)));
                columna = i + 1;
            }
        }
    }
    public void transformarANotacion(){
        nombre = columnas.charAt(columna-1) + String.valueOf(fila);
    }
}
