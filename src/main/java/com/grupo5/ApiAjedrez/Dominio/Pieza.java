package com.grupo5.ApiAjedrez.Dominio;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pieza {
    private int id;
    public List<int[]> movPosibles(int[][] tablero, int[] posicion) {
        return null;
    }

    public void borrarPosibles(int[][] tablero, List<int[]> movimientosPosibles){
        for(int[] movimientoPosible : movimientosPosibles){
            tablero[movimientoPosible[0]][movimientoPosible[1]] -= 100;
        }

    }
}
