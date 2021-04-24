package br.com.controlefrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefrota.model.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {

	Condutor findById(long id);

	Condutor findByCNH(String CNH);
}
