package com.grupo5.ApiAjedrez.Dominio;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    private int id;
    private Tablero tablero;
    private Estado estado;
    private int turno;
    private int turnoOponente;
    private int contenidoPosVieja;
    private int contenidoPosActual;
    private List<String> listaMovimientos;
}
