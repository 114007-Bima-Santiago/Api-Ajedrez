package com.grupo5.ApiAjedrez.Dominio;


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
    private int contenidoPosVieja;
    @Column
    private int contenidoPosActual;
    @Column
    private List<String> listaMovimientos;

    //TODO: ver si hay que incluir foreign keys
    @Column
    private Jugador jugadorBlancas;
    @Column
    private Jugador jugadorNegras;
}
