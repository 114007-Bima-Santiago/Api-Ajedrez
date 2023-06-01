package com.grupo5.ApiAjedrez.Controllers;

import com.grupo5.ApiAjedrez.Dominio.Jugador;
import com.grupo5.ApiAjedrez.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    private final JugadorService jugadorServiceimpl;

    @Autowired
    public UsuarioController(JugadorService jugadorService){ this.jugadorServiceimpl = jugadorService; }

    @PostMapping("/crear/jugador")
    boolean createUsuario(@RequestBody Jugador jugador){
        return jugadorServiceimpl.crearJugador(jugador);
    }

    @GetMapping("/obtener/jugador/{id}")
    Jugador getTableroById(@PathVariable Integer id){
        return jugadorServiceimpl.getJugadorById(id);
    }

    @PutMapping("/actualizar/jugador")
    boolean updateTablero(@RequestBody Jugador jugador){
        return jugadorServiceimpl.actualizarJugador(jugador);
    }
}
