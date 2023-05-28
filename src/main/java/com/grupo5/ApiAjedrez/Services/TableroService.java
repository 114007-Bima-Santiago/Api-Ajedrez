package com.grupo5.ApiAjedrez.Services;

import com.grupo5.ApiAjedrez.Dominio.Tablero;

public interface TableroService {
    Tablero createTablero(Tablero tablero);
    Tablero getTableroById(Integer id);
    Tablero updateTablero(Integer id, Tablero tablero);
}
