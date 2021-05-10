package br.com.controlefrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.ConsumoModel;

@Repository
public interface ConsumoRepository extends JpaRepository<ConsumoModel, Long>{

	ConsumoModel findById(long idConsumo);
}
