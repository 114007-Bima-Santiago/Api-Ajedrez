package com.grupo5.ApiAjedrez.Controllers;

import com.grupo5.ApiAjedrez.Dominio.Tablero;
import com.grupo5.ApiAjedrez.Services.TableroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TableroController {
    private final TableroService tableroService;

    @Autowired
    public TableroController(TableroService tableroService){ this.tableroService = tableroService; }

    @PostMapping("/crear/tablero")
    Tablero createTablero(@RequestBody Tablero Tablero){
        return tableroService.createTablero(Tablero);
    }

    @GetMapping("/buscar/tablero/{id}")
    Tablero getTableroById(@PathVariable Integer id){
        return tableroService.getTableroById(id);
    }

    @PutMapping("/actualizar/tablero/{id}")
    Tablero updateTablero(@PathVariable Integer id, @RequestBody Tablero tablero){
        return tableroService.updateTablero(id, tablero);
    }
}
