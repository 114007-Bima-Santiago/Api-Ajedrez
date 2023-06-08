package com.grupo5.ApiAjedrez.Dominio;


import com.grupo5.ApiAjedrez.Dominio.Piezas.*;
import com.grupo5.ApiAjedrez.Dto.Touch;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partidas")
public class Partida implements Serializable {
    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private Tablero tablero;
    @Column
    private Estado estado;
    @Column
    private int turno;
    @Column
    private int turnoOponente;
    @Column
    private List<String> listaMovimientos;
    @Column
    private boolean segundoTouch;

    //TODO: ver si hay que incluir foreign keys
    @Column
    private Jugador jugadorBlancas;
    @Column
    private Jugador jugadorNegras;


    private static List<String> movimientosPosibles;
    private static Coordenada posVieja;

    public Touch getTouch(Coordenada coord){
        int contenidoEscaque = getContenidoEscaque(coord);

        if (!segundoTouch && contenidoEscaque / 10 == turno) {
            Pieza pieza;
            switch (contenidoEscaque % 10){
                case 4:
                    pieza = new Peon();
                    break;
                case 5:
                    pieza = new Torre();
                    break;
                case 6:
                    pieza = new Caballo();
                    break;
                case 7:
                    pieza = new Alfil();
                    break;
                case 8:
                    pieza = new Dama();
                    break;
                case 9:
                    pieza = new Rey();
                    break;
                default:
                    pieza = null;
                    break;
            }

            movimientosPosibles = pieza.movPosibles(tablero.getTablero(), coord);
            posVieja = coord;
            segundoTouch = true;
            return new Touch(1);
        } else if (segundoTouch && contenidoEscaque >= 100) {
            borrarPosibles(movimientosPosibles);
            movimiento(posVieja, coord);
            segundoTouch = false;
            cambiarTurno();
            //TODO: agregar un metodo para guardar el movimiento en la lista de movimientos para subirla a la base de datos en caso de necesitarse
            return new Touch(2);
        } else {
            return new Touch(3);
        }
    }

    private void cambiarTurno() {
        if (turno == 2) {
            turno = 3;
        } else {
            turno = 2;
        }
    }

    public int getContenidoEscaque(Coordenada coord) { return tablero.getPosicion(coord.getColumna(), coord.getFila()); }

    public void borrarPosibles(List<String> movimientosPosibles) {
        for (String movimientoPosible : movimientosPosibles) {
            Coordenada coord = new Coordenada();
            coord.transformarACoordenada(movimientoPosible);

            tablero.getTablero()[coord.getColumna()][coord.getFila()] -= 100;
        }
    }

    public void movimiento(Coordenada posicion1, Coordenada posicion2) {
        int contenido = getContenidoEscaque(posicion1);
        setContenidoEscaque(posicion2, contenido);
        setContenidoEscaque(posicion1, 0);
    }

    public void setContenidoEscaque(Coordenada posicion, int contenido) {
        tablero.getTablero()[posicion.getColumna()][posicion.getFila()] = contenido;
    }
}
