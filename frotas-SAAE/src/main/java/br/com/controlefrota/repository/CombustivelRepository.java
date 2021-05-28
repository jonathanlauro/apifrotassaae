package br.com.controlefrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Combustivel;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
	
	Combustivel findById(long id);

}
