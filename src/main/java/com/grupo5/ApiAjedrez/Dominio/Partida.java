package com.grupo5.ApiAjedrez.Dominio;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    private int[][] tablero;
    // private IEstado estado;
    int turno;
    int noTurno;
    int contenidoPosVieja;
    int contenidoPosActual;
}
