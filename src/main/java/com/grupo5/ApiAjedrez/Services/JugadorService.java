package com.grupo5.ApiAjedrez.Services;

import com.grupo5.ApiAjedrez.Dominio.Jugador;

import java.util.List;

public interface JugadorService {

    Jugador getJugadorById(int id);
    List<Jugador> getJugadores();
    boolean actualizarJugador(Jugador jugador);
    boolean crearJugador(Jugador jugador);
    boolean elminarJugadorById(int id);

}
