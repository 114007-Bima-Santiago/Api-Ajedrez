package com.grupo5.ApiAjedrez.Controllers;

import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartidaController {
    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService){ this.partidaService = partidaService; }

    @PostMapping("/crear-Actualizar/partida")
    boolean createPartida(@RequestBody Partida partida){
        return partidaService.actualizarCrearPartida(partida);
    }

    @GetMapping("/obtener/partida/{id}")
    Partida getPartidaById(@PathVariable Integer id){
        return partidaService.getPartidaById(id);
    }

    @GetMapping("/obtener/partidas")
    List<Partida> getPartidas(){ return partidaService.getPartidas(); }

    @DeleteMapping("/eliminar/partida/{id}")
    boolean deletePartida(@PathVariable Integer id){ return  partidaService.elminarPartidaById(id); }
}
