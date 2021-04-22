package br.com.controlefrota.condutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefrota.condutor.models.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
 
	Condutor findById(long id);
	Condutor findByCNH(String CNH);
}
