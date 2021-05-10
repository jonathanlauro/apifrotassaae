package br.com.controlefrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.CombustivelModel;

@Repository
public interface CombustivelRepository extends JpaRepository<CombustivelModel, Long> {
	
	CombustivelModel findById(long id);

}
