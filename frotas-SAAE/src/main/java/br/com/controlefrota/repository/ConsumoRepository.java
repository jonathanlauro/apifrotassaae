package br.com.controlefrota.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>{

	Consumo findById(long idConsumo);
	
	List<Consumo> findByCombustivel(Combustivel combustivel);
	
	List<Consumo>findByDeleted(LocalDate date);
}
