package com.grupo5.ApiAjedrez.Services.impl;

import com.grupo5.ApiAjedrez.Dominio.Tablero;
import com.grupo5.ApiAjedrez.Services.TableroService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TableroServiceImpl implements TableroService {
    private static final Map<Integer, Tablero> tablerosLibrary = new ConcurrentHashMap<>();
    @Override
    public Tablero createTablero(Tablero tablero) {
        tablerosLibrary.put(tablero.getId(), tablero);
        return tablero;
    }

    @Override
    public Tablero getTableroById(Integer id) {
        return tablerosLibrary.get(id);
    }

    @Override
    public Tablero updateTablero(Integer id, Tablero tablero) {
        tablerosLibrary.put(id, tablero);
        return tablero;
    }
}
