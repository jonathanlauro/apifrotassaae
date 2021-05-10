package br.com.controlefrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.CondutorModel;

@Repository
public interface CondutorRepository extends JpaRepository<CondutorModel, Long> {

	CondutorModel findById(long id);

	CondutorModel findByCNH(String CNH);
	
	List<CondutorModel> findByDeleted(boolean deleted);
}
