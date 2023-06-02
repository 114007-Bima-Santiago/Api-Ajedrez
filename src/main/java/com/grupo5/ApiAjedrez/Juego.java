package com.grupo5.ApiAjedrez;

import com.grupo5.ApiAjedrez.Dominio.Estado;
import com.grupo5.ApiAjedrez.Dominio.Jugador;
import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Dto.Touch;
import com.grupo5.ApiAjedrez.Services.JugadorService;
import com.grupo5.ApiAjedrez.Services.Impl.JugadorServiceImpl;

public class Juego {

    static Juego instancia;

    public static Juego crearInstancia(){
        instancia = new Juego();
        return instancia;
    }

    public static Juego obtenerInstancia(){
        return instancia;
    }

    private Partida partida;
    private Estado estado;
    private int turnoOponente;
    private int contenidoPosVieja;
    private int contenidoPosActual;

    public Partida getPartida() {
        return partida;
    }

    public Touch mov(){
        return null;
    }

    public Partida getPartida(int idJB, int idJN){
        Partida partida = new Partida();
        partida.setJugadorBlancas(getJugador(idJB));
        partida.setJugadorNegras(getJugador(idJN));
        return partida;
    }

    private Jugador getJugador(int id){
        JugadorService js = new JugadorServiceImpl();
        return js.getJugadorById(id);
    }
}
