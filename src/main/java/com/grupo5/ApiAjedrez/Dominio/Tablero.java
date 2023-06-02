package com.grupo5.ApiAjedrez.Dominio;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tablero{
    private int id;
    private int[][] tablero;

}
