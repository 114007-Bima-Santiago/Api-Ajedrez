package com.grupo5.ApiAjedrez.Controllers;

import com.grupo5.ApiAjedrez.Dominio.Movimiento;
import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MovimientoController {
    private final MovimientoService movimientoService;
    @Autowired
    public MovimientoController(MovimientoService movimientoService){ this.movimientoService = movimientoService; }

    @PostMapping("/crear/movimiento")
    Movimiento createMovimiento(@RequestBody Movimiento movimiento){
        return movimientoService.createMovimiento(movimiento);
    }

    @GetMapping("/buscar/movimientos")
    Map<Integer, Movimiento> getMovimientos(){
        return movimientoService.getMovimientos();
    }
}
