package com.grupo5.ApiAjedrez.Dominio;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {
    private int id;
    private String casillaAnterior;
    private String casillaNueva;
    private Pieza pieza;
}
