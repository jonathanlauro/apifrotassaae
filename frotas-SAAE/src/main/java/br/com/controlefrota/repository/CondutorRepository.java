package br.com.controlefrota.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Condutor;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {

	Condutor findById(long id);

	Condutor findBycnh(String cnh);
	
	List<Condutor> findByDeleted(LocalDate date);

	List<Condutor> findByNome(String nome);
}
