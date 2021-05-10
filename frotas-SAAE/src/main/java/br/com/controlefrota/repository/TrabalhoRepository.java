package br.com.controlefrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.CondutorModel;
import br.com.controlefrota.model.TrabalhoModel;
import br.com.controlefrota.model.VeiculoModel;

@Repository
public interface TrabalhoRepository extends JpaRepository<TrabalhoModel, Long>{

	TrabalhoModel findById(long id);
	TrabalhoModel findByCondutor(CondutorModel condutor);
	TrabalhoModel findByVeiculo(VeiculoModel veiculo);
	List<TrabalhoModel> findByStatusTrabalho(String Status);

}
