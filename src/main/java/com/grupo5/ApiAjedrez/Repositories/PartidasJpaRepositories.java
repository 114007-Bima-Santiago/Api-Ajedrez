package com.grupo5.ApiAjedrez.Repositories;

import com.grupo5.ApiAjedrez.Dominio.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidasJpaRepositories extends JpaRepository<Partida, Long> {
    //TODO: escribir la cadena de coneccion de la BD en app.properties
}
