package br.com.controlefrota.combustivel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefrota.combustivel.model.Combustivel;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
	
	Combustivel findById(long id);

}
