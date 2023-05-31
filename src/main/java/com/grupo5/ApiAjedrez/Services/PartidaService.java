package com.grupo5.ApiAjedrez.Services;

import com.grupo5.ApiAjedrez.Dominio.Partida;

public interface PartidaService {
    Partida createPartida(Partida partida);
    Partida getPartidaById(Integer id);
    Partida updatePartida(Integer id, Partida partida);
    Partida deletePartida(Integer id);
}
