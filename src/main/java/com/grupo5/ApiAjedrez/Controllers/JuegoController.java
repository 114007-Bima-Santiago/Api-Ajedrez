package com.grupo5.ApiAjedrez.Controllers;
import com.grupo5.ApiAjedrez.Dominio.Partida;
import com.grupo5.ApiAjedrez.Dto.Touch;
import com.grupo5.ApiAjedrez.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JuegoController {
    private Juego juego;

    @Autowired
    public JuegoController(){  }

    @GetMapping("obtener/touch")
    public Touch getTouch(){
        juego = Juego.obtenerInstancia();
        return juego.mov();
    }

    @GetMapping("nueva-partida/{idJB}/{idJN}")
    public Partida getPartida(@PathVariable int idJB, @PathVariable int idJN){
        this.juego = Juego.crearInstancia();
        return juego.getPartida(idJB, idJN);
    }
}
