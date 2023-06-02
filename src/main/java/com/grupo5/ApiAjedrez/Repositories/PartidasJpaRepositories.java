package com.grupo5.ApiAjedrez.REpositories;

import com.grupo5.ApiAjedrez.Dominio.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidasJpaRepositories extends JpaRepository<Partida, Long> {
}
