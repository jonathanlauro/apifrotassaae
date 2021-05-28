package br.com.controlefrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.model.Veiculo;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

	Trabalho findById(long id);
	Trabalho findByCondutor(Condutor condutor);
	Trabalho findByVeiculo(Veiculo veiculo);
	List<Trabalho> findByStatusTrabalho(String Status);
	List<Trabalho>findByDeleted(boolean deleted);
}
