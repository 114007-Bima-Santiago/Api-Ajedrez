package com.grupo5.ApiAjedrez.Services;

import com.grupo5.ApiAjedrez.Dominio.Partida;

import java.util.List;

public interface PartidaService {
    Partida getPartidaById(int id);
    List<Partida> getPartidas();
    boolean actualizarCrearPartida(Partida partida);
    boolean elminarPartidaById(int id);
}
