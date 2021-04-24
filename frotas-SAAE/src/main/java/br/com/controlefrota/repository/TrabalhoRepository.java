package br.com.controlefrota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

	Optional<Trabalho> findById(Long id);
}
