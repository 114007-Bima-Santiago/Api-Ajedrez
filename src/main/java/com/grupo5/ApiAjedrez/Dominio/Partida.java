package com.grupo5.ApiAjedrez.Dominio;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    int id;
    private Tablero tablero;
    // private IEstado estado;
    int turno;
    int turnoOponente;
    int contenidoPosVieja;
    int contenidoPosActual;
}
