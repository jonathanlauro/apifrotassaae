package br.com.controlefrota.repository;

import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>{

	Consumo findById(long idConsumo);
	
	List<Consumo> findByCombustivel(Combustivel combustivel);
	
	List<Consumo>findByDeleted(LocalDate date);

	List<Consumo> findByCondutor(Condutor condutor);

	List<Consumo> findByVeiculo(Veiculo veiculo);
}
