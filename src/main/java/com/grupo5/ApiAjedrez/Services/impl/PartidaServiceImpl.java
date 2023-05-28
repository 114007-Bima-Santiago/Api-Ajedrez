package com.grupo5.ApiAjedrez.Services.impl;

import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Dominio.Tablero;
import com.grupo5.ApiAjedrez.Services.PartidaService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PartidaServiceImpl implements PartidaService {
    private static final Map<Integer, Partida> partidasLibrary = new ConcurrentHashMap<>();
    @Override
    public Partida createPartida(Partida partida) {
        partidasLibrary.put(partida.getId(), partida);
        return partida;
    }

    @Override
    public Partida getPartidaById(Integer id) {
        return partidasLibrary.get(id);
    }

    @Override
    public Partida updatePartida(Integer id, Partida partida) {
        partidasLibrary.put(id, partida);
        return partida;
    }

    @Override
    public Partida deletePartida(Integer id) {
        return partidasLibrary.remove(id);
    }
}
