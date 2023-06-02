package com.grupo5.ApiAjedrez.Controllers;
import com.grupo5.ApiAjedrez.Dominio.Jugador;
import com.grupo5.ApiAjedrez.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JugadorController {
    private final JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService){ this.jugadorService = jugadorService; }

    @PostMapping("/crear/jugador")
    boolean createJugador(@RequestBody Jugador jugador){
        return jugadorService.crearJugador(jugador);
    }

    @GetMapping("/obtener/jugador/{id}")
    Jugador getJugadorById(@PathVariable Integer id){
        return jugadorService.getJugadorById(id);
    }

    @PutMapping("/actualizar/jugador")
    boolean updateJugador(@RequestBody Jugador jugador){
        return jugadorService.actualizarJugador(jugador);
    }
}
