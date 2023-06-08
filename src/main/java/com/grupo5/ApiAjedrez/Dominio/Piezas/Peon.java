package com.grupo5.ApiAjedrez.Dominio.Piezas;

import com.grupo5.ApiAjedrez.Dominio.Coordenada;
import com.grupo5.ApiAjedrez.Dominio.Pieza;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Peon extends Pieza {
    @Override
    public List<String> movPosibles(int[][] tablero, Coordenada posicion){
        List<String> movimientosPosibles = new ArrayList<>();
        String movimientoPosible;
        posicion.transformarANotacion();
        int c = posicion.getColumna();
        int r = posicion.getFila();
        int pasos;

        if(tablero[c][r] / 10 == 2 && posicion.getFila() == 2 || tablero[c][r] / 10 == 3 && posicion.getColumna() == 7){
            pasos = 2;
        } else {
            pasos = 1;
        }

        if(tablero[c][r] / 10 == 2){
            do{
                r++;
                if(tablero[c][r] == 0){
                    tablero[c][r] += 100;
                    movimientoPosible = posicion.getNombre();
                    movimientosPosibles.add(movimientoPosible);
                    pasos--;
                }
            }while(tablero[c][r] == 100 && pasos > 0);

            c = posicion.getColumna() + 1;
            r = posicion.getFila() + 1;
            for(int i = 0; i < 2; i++){
                if(tablero[c][r] / 10 == 3 && tablero[c][r] != 1){
                    tablero[c][r] += 100;
                    movimientoPosible = posicion.getNombre();
                    movimientosPosibles.add(movimientoPosible);
                }
                c -= 2;
            }
            c = posicion.getColumna();
            r = posicion.getFila();
        }

        if(tablero[c][r] / 10 == 3){
            do{
                r--;
                if(tablero[c][r] == 0){
                    tablero[c][r] += 100;
                    movimientoPosible = posicion.getNombre();
                    movimientosPosibles.add(movimientoPosible);
                    pasos--;
                }
            }while(tablero[c][r] == 100 && pasos > 0);

            c = posicion.getColumna() - 1;
            r = posicion.getFila() - 1;
            for(int i = 0; i < 2; i++){
                if(tablero[c][r] / 10 == 2 && tablero[c][r] != 1){
                    tablero[c][r] += 100;
                    movimientoPosible = posicion.getNombre();
                    movimientosPosibles.add(movimientoPosible);
                }
                c += 2;
            }
        }
        return movimientosPosibles;
    }
}
