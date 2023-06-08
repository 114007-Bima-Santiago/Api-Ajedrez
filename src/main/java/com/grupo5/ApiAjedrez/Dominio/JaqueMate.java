package com.grupo5.ApiAjedrez.Dominio;

import com.grupo5.ApiAjedrez.Dominio.Piezas.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JaqueMate{
    private int[][] tablero;
    private int turno;
    private int noTurno;
    private Coordenada posicionRey;

    public boolean verJaqueMate(int turno, int noTurno, Tablero tablero){

        this.turno = turno;
        this.noTurno = noTurno;
        this.tablero = tablero.getTablero();

        Jaque jaque = new Jaque();
        jaque.setTablero(this.tablero);
        posicionRey = buscarReyTurno(this.tablero, noTurno);

        if(verSiEscapa()){
            return false;
        }

        if(jaque.verJaque(noTurno, tablero).size() == 1){
            Coordenada amenaza = jaque.verJaque(noTurno, tablero).get(0);

            if(verSiSeCome(amenaza)){
                return false;
            }
            if(verSiSeTapa(amenaza)){
                return false;
            }
        }

        return true;
    }

    private Coordenada buscarReyTurno(int[][] tablero, int noTurno){
        for(int i = 1; i < 9; i++){
            for(int j = 0; j < 10; j++){
                if(tablero[i][j] / 10 == noTurno && tablero[i][j] % 10 == 9){
                    Coordenada coord = new Coordenada();
                    coord.setColumna(i);
                    coord.setFila(j);
                    return coord;
                }
            }
        }
        return null;
    }

    private boolean verSiEscapa(){

        int c;
        int r;

        int[] x = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] y = {-1, 1, 0, 0, -1, 1, -1, 1};

        for (int i = 0; i < x.length; i++) {
            c = posicionRey.getColumna();
            r = posicionRey.getFila();

            c += x[i];
            r += y[i];

            Coordenada posicion = new Coordenada();
            posicion.setColumna(c);
            posicion.setFila(r);

            if(tablero[c][r] == 0){
                if(!damaTorreAlfil(posicion, false) && !caballos(posicion) && !peones(posicion)){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean verSiSeCome(Coordenada amenaza){
        List<Coordenada> posiblesAmenazas;

        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 9; j++){
                posiblesAmenazas = new ArrayList<>();

                if(tablero[i][j] / 10 == noTurno && (tablero[i][j] % 10 == 4 ||tablero[i][j] % 10 == 5 || tablero[i][j] % 10 == 6 || tablero[i][j] % 10 == 7 || tablero[i][j] % 10 == 8)){
                    posiblesAmenazas = posiblesAmenazas(i, j);
                }

                for(Coordenada posibleAmenaza : posiblesAmenazas){
                    if(posibleAmenaza.getColumna() == amenaza.getColumna() && posibleAmenaza.getFila() == amenaza.getFila()){
                        quePieza(4).borrarPosibles(tablero, posiblesAmenazas);
                        return true;
                    }
                }
                quePieza(4).borrarPosibles(tablero, posiblesAmenazas);
            }
        }
        return false;
    }

    private List<Coordenada> posiblesAmenazas(int i, int j){
        Coordenada posicion = new Coordenada();
        posicion.setColumna(i);
        posicion.setFila(j);

        return transformarStringACoord(quePieza(tablero[i][j] % 10).movPosibles(tablero, posicion));
    }

    private Pieza quePieza(int opcion){

        Pieza pieza = null;
        switch (opcion){
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
        }
        return pieza;
    }

    private boolean verSiSeTapa(Coordenada amenaza){

        List<Coordenada> coinsidencias = new ArrayList<>();
        List<Coordenada> movimientosAmenaza = transformarStringACoord(quePieza(tablero[amenaza.getColumna()][amenaza.getFila()] % 10).movPosibles(tablero, amenaza));
        quePieza(4).borrarPosibles(tablero, movimientosAmenaza);
        List<Coordenada> visionesRey = transformarStringACoord(quePieza(8).movPosibles(tablero,posicionRey));
        quePieza(4).borrarPosibles(tablero, visionesRey);

        for(Coordenada movimiento : movimientosAmenaza){
            for(Coordenada vision : visionesRey){
                if(movimiento.getColumna() == vision.getColumna() && movimiento.getFila() == vision.getFila()){
                    coinsidencias.add(movimiento);
                }
            }
        }

        for(Coordenada coinsidencia : coinsidencias){
            if(damaTorreAlfil(coinsidencia, true)){
                return true;
            }
        }

        return false;
    }

    private boolean damaTorreAlfil(Coordenada posicion, boolean amigo){

        int turnoUno;
        int turnoDos;
        if(amigo){
            turnoUno = 3;
            turnoDos = 2;
        } else {
            turnoUno = 2;
            turnoDos = 3;
        }

        int c;
        int r;

        int[] x = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] y = {-1, 1, 0, 0, -1, 1, -1, 1};

        for (int i = 0; i < x.length; i++) {
            c = posicion.getColumna();
            r = posicion.getFila();

            do {
                c += x[i];
                r += y[i];
                if (tablero[c][r] / 10 == turnoUno && noTurno == 3) {
                    if((x[i] == 0 || y[i] == 0) && (tablero[c][r] % 10 == 5 || tablero[c][r] % 10 == 8)){
                        return true;
                    } else if ((x[i] != 0 && y[i] != 0) && (tablero[c][r] % 10 == 7 || tablero[c][r] % 10 == 8)) {
                        return true;
                    } else {
                        break;
                    }
                } else if (tablero[c][r] / 10 == turnoDos && noTurno == 2) {
                    if((x[i] == 0 || y[i] == 0) && (tablero[c][r] % 10 == 5 || tablero[c][r] % 10 == 8)){
                        return true;
                    } else if ((x[i] != 0 && y[i] != 0) && (tablero[c][r] % 10 == 7 || tablero[c][r] % 10 == 8)) {
                        return true;
                    } else {
                        break;
                    }
                } else if(tablero[c][r] > 0){
                    break;
                }
            } while (tablero[c][r] != 1);
        }
        return false;
    }

    private boolean caballos(Coordenada posicion){
        int[] x = { 1,1,-1,0,0, 1,-3,-1,1, 0, 0,-1};
        int[] y = {-1,0,-1,3,1,-1, 0, 0,1,-3,-1, 1};

        int c = posicion.getColumna();
        int r = posicion.getFila();

        for (int i = 0; i < x.length; i++) {
            c += x[i];
            r += y[i];

            if (tablero[c][r] == 1 && (i == 0 || i == 3 || i == 6 || i == 9)) {
                for(int j = 0; j < 2; j++){
                    i++;
                    c += x[i];
                    r += y[i];
                }
            } else {
                if (tablero[c][r] / 10 == 2 && noTurno == 3 && tablero[c][r] % 10 == 6
                        && i != 0 && i != 3 && i != 6 && i != 9) {
                    return true;
                } else if (tablero[c][r] / 10 == 3 && noTurno == 2 && tablero[c][r] % 10 == 6
                        && i != 0 && i != 3 && i != 6 && i != 9) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean peones(Coordenada posicion){
        int c;
        int r;

        if(noTurno == 2){
            c = posicion.getColumna() + 1;
            r = posicion.getFila() + 1;
            for(int i = 0; i < 2; i++){
                if(tablero[c][r] / 10 == 3 && tablero[c][r] % 10 == 4){
                    return true;
                }
                c -= 2;
            }
        }
        if(noTurno == 3){
            c = posicion.getColumna() - 1;
            r = posicion.getFila() - 1;
            for(int i = 0; i < 2; i++){
                if(tablero[c][r] / 10 == 2 && tablero[c][r] % 10 == 4){
                    return true;
                }
                c += 2;
            }
        }
        return false;
    }
    private List<Coordenada> transformarStringACoord(List<String> listaString){
        List<Coordenada> listaCoord = new ArrayList<>();
        for(String movimiento : listaString){
            Coordenada coord = new Coordenada();
            coord.transformarACoordenada(movimiento);
            listaCoord.add(coord);
        }

        return listaCoord;
    }
}
