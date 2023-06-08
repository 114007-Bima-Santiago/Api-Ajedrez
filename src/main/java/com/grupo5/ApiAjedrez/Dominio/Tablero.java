package com.grupo5.ApiAjedrez.Dominio;


import lombok.*;

@Getter
@Setter
@ToString
public class Tablero{
    private int id;
    private int[][] tablero;

    public Tablero(){
        iniciarEscaques();
        rellenerEscaques();
    }
    public int getPosicion(int columna, int fila){
        return tablero[columna][fila];
    }

    private void iniciarEscaques() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || j == 0 || i == 4 || j == 4) {
                    tablero[i][j] = 1;
                }
            }
        }
    }

    private void rellenerEscaques() {
        tablero[1][1] = 25;
        tablero[2][1] = 26;
        tablero[3][1] = 27;
        tablero[4][1] = 28;
        tablero[5][1] = 29;
        tablero[6][1] = 27;
        tablero[7][1] = 26;
        tablero[8][1] = 25;

        tablero[1][8] = 35;
        tablero[2][8] = 36;
        tablero[3][8] = 37;
        tablero[4][8] = 38;
        tablero[5][8] = 39;
        tablero[6][8] = 37;
        tablero[7][8] = 36;
        tablero[8][8] = 35;

        for (int x = 0; x < 2; x++) {
            int j;
            int c;
            if(x == 0){
                j = 2;
                c = 24;
            } else{
                c = 34;
                j = 7;
            }

            for (int i = 1; i <= 8; i++) {
                tablero[i][j] = c;
            }
        }
    }
}
