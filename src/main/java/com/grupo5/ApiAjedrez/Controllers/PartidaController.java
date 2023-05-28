package com.grupo5.ApiAjedrez.Controllers;

import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Dominio.Tablero;
import com.grupo5.ApiAjedrez.Services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartidaController {
    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService){ this.partidaService = partidaService; }

    @PostMapping("/crear/partida")
    Partida createPartida(@RequestBody Partida partida){
        return partidaService.createPartida(partida);
    }

    @GetMapping("/buscar/partida/{id}")
    Partida getPartidaById(@PathVariable Integer id){
        return partidaService.getPartidaById(id);
    }

    @PutMapping("/actualizar/tablero/{id}")
    Partida updatePartida(@PathVariable Integer id, @RequestBody Partida partida){
        return partidaService.updatePartida(id, partida);
    }

    @DeleteMapping("/eliminar/partida/{id}")
    Partida eliminarPartida(@PathVariable Integer id){
        return  partidaService.deletePartida(id);
    }
}
