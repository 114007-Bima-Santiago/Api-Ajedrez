package com.grupo5.ApiAjedrez.Repositories;

import com.grupo5.ApiAjedrez.Dominio.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadoresJpaRepositories extends JpaRepository<Jugador, Long> {
}
