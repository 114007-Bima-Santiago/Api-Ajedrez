package com.grupo5.ApiAjedrez.Dominio;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pieza {
    public List<Coordenada> movPosibles(int[][] tablero, Coordenada posicion) {
        return null;
    }

    public void borrarPosibles(int[][] tablero, List<Coordenada> movimientosPosibles){
        for(Coordenada movimientoPosible : movimientosPosibles){
            tablero[movimientoPosible.getColumna()][movimientoPosible.getFila()] -= 100;
        }

    }
}
