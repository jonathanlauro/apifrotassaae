package br.com.controlefrota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefrota.model.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
 
	Optional<Condutor> findById(Long id);
}
