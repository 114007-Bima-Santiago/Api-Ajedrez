package com.grupo5.ApiAjedrez;

import com.grupo5.ApiAjedrez.Dominio.Coordenada;
import com.grupo5.ApiAjedrez.Dominio.Estado;
import com.grupo5.ApiAjedrez.Dominio.Jugador;
import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Dto.Touch;
import com.grupo5.ApiAjedrez.Services.JugadorService;
import com.grupo5.ApiAjedrez.Services.Impl.JugadorServiceImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Juego {

    static Juego instancia;
    private Partida partida;

    public static Juego crearInstancia(){
        instancia = new Juego();
        return instancia;
    }

    public static Juego obtenerInstancia(){
        return instancia;
    }


    public Touch mov(Coordenada coord){
        return partida.getTouch(coord);
    }



    public Partida getPartida(int idJB, int idJN){
        Partida partida = new Partida();
        partida.setJugadorBlancas(getJugador(idJB));
        partida.setJugadorNegras(getJugador(idJN));
        partida.setEstado(Estado.EN_CURSO);
        //TODO: ver si se cambia el id por un codigo ej: 1 o 2
        partida.setTurno(idJB);
        return partida;
    }

    private Jugador getJugador(int id){
        JugadorService js = new JugadorServiceImpl();
        return js.getJugadorById(id);
    }
}
