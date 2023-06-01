package com.grupo5.ApiAjedrez.Dominio;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Partida {
    private int id;
    private Jugador jugadorBlancas;
    private Jugador jugadorNegras;
    private Tablero tablero;
    private int turno;
    private List<Movimiento> listaDeMovimientos;

    public Partida(){
        iniciarTablero();
        turno = 2;
        listaDeMovimientos = new ArrayList<>();
    }

    private void iniciarTablero(){
        // porner los unos
        // poner las piezas en su posicion inicial
    }
}
