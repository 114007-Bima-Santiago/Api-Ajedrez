package com.grupo5.ApiAjedrez.Controllers;
import com.grupo5.ApiAjedrez.Dominio.Coordenada;
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

    @GetMapping("obtener/touch/{fA}{cA}-{fN}{cN}")
    public Touch getTouch(@PathVariable int fA, @PathVariable int cA, @PathVariable int fN, @PathVariable int cN){
        juego = Juego.obtenerInstancia();
        Coordenada casillaAntigua = new Coordenada(fA, cA);
        Coordenada casillaNueva = new Coordenada(fN, cN);
        return juego.mov(casillaAntigua, casillaNueva);
    }

    @GetMapping("nueva-partida/{idJB}/{idJN}")
    public Partida getPartida(@PathVariable int idJB, @PathVariable int idJN){
        this.juego = Juego.crearInstancia();
        return juego.getPartida(idJB, idJN);
    }
}
