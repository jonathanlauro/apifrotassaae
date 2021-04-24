package br.com.controlefrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefrota.model.Combustivel;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
	
	Combustivel findById(long id);

}
