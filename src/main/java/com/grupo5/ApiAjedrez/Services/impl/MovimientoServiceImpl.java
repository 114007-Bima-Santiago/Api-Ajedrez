package com.grupo5.ApiAjedrez.Services.impl;

import com.grupo5.ApiAjedrez.Dominio.Movimiento;
import com.grupo5.ApiAjedrez.Dominio.Tablero;
import com.grupo5.ApiAjedrez.Services.MovimientoService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MovimientoServiceImpl implements MovimientoService {
    private static final Map<Integer, Movimiento> movimientosLibrary = new ConcurrentHashMap<>();
    @Override
    public Movimiento createMovimiento(Movimiento movimiento) {
        movimientosLibrary.put(movimiento.getId(), movimiento);
        return movimiento;
    }

    @Override
    public Map<Integer, Movimiento> getMovimientos() {
        return movimientosLibrary;
    }
}
