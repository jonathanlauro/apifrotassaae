package br.com.controlefrota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>{

	Consumo findById(long id);
}
