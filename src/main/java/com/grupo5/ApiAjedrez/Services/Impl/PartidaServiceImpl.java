package com.grupo5.ApiAjedrez.Services.Impl;

import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Juego;
import com.grupo5.ApiAjedrez.Services.PartidaService;

import java.util.List;

public class PartidaServiceImpl implements PartidaService {

    Juego juego;

    public PartidaServiceImpl(){
        juego = Juego.obtenerInstancia();
    }

    @Override
    public Partida getPartidaById(int id) {
        return null; // desde la bbdd
    }

    @Override
    public List<Partida> getPartidas() {
        return null; // desde la bbdd
    }

    @Override
    public boolean actualizarCrearPartida() {
        return false; // desde instancia juego a bbdd
    }

    @Override
    public boolean elminarPartidaById(int id) {
        return false;
    }
}
