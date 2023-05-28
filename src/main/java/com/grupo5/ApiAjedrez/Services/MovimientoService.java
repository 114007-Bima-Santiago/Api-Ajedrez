package com.grupo5.ApiAjedrez.Services;

import com.grupo5.ApiAjedrez.Dominio.Movimiento;

import java.util.List;
import java.util.Map;

public interface MovimientoService {
    Movimiento createMovimiento(Movimiento movimiento);
    Map<Integer, Movimiento> getMovimientos();
}
