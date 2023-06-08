package com.grupo5.ApiAjedrez.Dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Jaque {
    private int turnoONo;
    private Coordenada posicion;
    private int[][] tablero;

    public List<Coordenada> verJaque(int turnoONo, Tablero tablero){
        List<Coordenada> amenazas = new ArrayList<>();
        this.turnoONo = turnoONo;
        this.tablero = tablero.getTablero();
        posicion = buscarReyTurno(turnoONo);

        amenazas.addAll(damaTorreAlfil());
        amenazas.addAll(caballos());
        amenazas.addAll(peones());
        amenazas.addAll(rey());

        return amenazas;
    }

    private Coordenada buscarReyTurno(int turno){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(tablero[i][j] / 10 == turno && tablero[i][j] % 10 == 9){
                    Coordenada coord = new Coordenada();
                    coord.setColumna(i);
                    coord.setFila(j);
                    return coord;
                }
            }
        }
        return null;
    }

    private List<Coordenada> damaTorreAlfil(){
        List<Coordenada> amenazas = new ArrayList<>();
        Coordenada amenaza = new Coordenada();
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

                // todo: redundante?
                if ((tablero[c][r] / 10 == 2 && turnoONo == 3) || (tablero[c][r] / 10 == 3 && turnoONo == 2)) {
                    if((x[i] == 0 || y[i] == 0) && (tablero[c][r] % 10 == 5 || tablero[c][r] % 10 == 8)){
                        amenazas.add(crearAmenaza(amenaza, c, r));
                    } else if ((x[i] != 0 && y[i] != 0) && (tablero[c][r] % 10 == 7 || tablero[c][r] % 10 == 8)) {
                        amenazas.add(crearAmenaza(amenaza, c, r));
                    } else {
                        break;
                    }
                } else if(tablero[c][r] > 0){
                    break;
                }
            } while (tablero[c][r] != 1);
        }

        return amenazas;
    }
    private List<Coordenada> caballos(){
        List<Coordenada> amenazas = new ArrayList<>();
        Coordenada amenaza = new Coordenada();
        int c;
        int r;

        int[] x = { 1,1,-1,0,0, 1,-3,-1,1, 0, 0,-1};
        int[] y = {-1,0,-1,3,1,-1, 0, 0,1,-3,-1, 1};

        c = posicion.getColumna();
        r = posicion.getFila();

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
                if (tablero[c][r] / 10 == 2 && turnoONo == 3 && tablero[c][r] % 10 == 6
                        && i != 0 && i != 3 && i != 6 && i != 9) {
                    amenazas.add(crearAmenaza(amenaza, c, r));
                } else if (tablero[c][r] / 10 == 3 && turnoONo == 2 && tablero[c][r] % 10 == 6
                        && i != 0 && i != 3 && i != 6 && i != 9) {
                    amenazas.add(crearAmenaza(amenaza, c, r));
                }
            }
        }

        return amenazas;
    }
    private List<Coordenada> peones(){
        List<Coordenada> amenazas = new ArrayList<>();
        Coordenada amenaza = new Coordenada();
        int c;
        int r;

        if(turnoONo == 2){
            c = posicion.getColumna() + 1;
            r = posicion.getFila() + 1;
            for(int i = 0; i < 2; i++){
                if(tablero[c][r] / 10 == 3 && tablero[c][r] % 10 == 4){
                    amenazas.add(crearAmenaza(amenaza, c, r));
                }
                c -= 2;
            }
        }
        if(turnoONo == 3){
            c = posicion.getColumna() - 1;
            r = posicion.getFila() - 1;
            for(int i = 0; i < 2; i++){
                if(tablero[c][r] / 10 == 2 && tablero[c][r] % 10 == 4){
                    amenazas.add(crearAmenaza(amenaza, c, r));
                }
                c += 2;
            }
        }

        return amenazas;
    }
    private List<Coordenada> rey(){
        List<Coordenada> amenazas = new ArrayList<>();
        Coordenada amenaza = new Coordenada();
        int c;
        int r;

        int[] x = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] y = {-1, 1, 0, 0, -1, 1, -1, 1};

        for (int i = 0; i < x.length; i++) {
            c = posicion.getColumna();
            r = posicion.getFila();

            c += x[i];
            r += y[i];

            if (tablero[c][r] / 10 == 2 && turnoONo == 3 && tablero[c][r] % 10 == 9) {
                amenazas.add(crearAmenaza(amenaza, c, r));
            } else if (tablero[c][r] / 10 == 3 && turnoONo == 2 && tablero[c][r] % 10 == 9) {
                amenazas.add(crearAmenaza(amenaza, c, r));
            }
        }

        return amenazas;
    }

    private Coordenada crearAmenaza(Coordenada amenaza, int c, int r){
        amenaza.setFila(r);
        amenaza.setColumna(c);
        return amenaza;
    }
}
