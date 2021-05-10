package br.com.controlefrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.VeiculoModel;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {

	VeiculoModel findById(long idVeiculo);

	VeiculoModel findByPlaca(String placa);

	VeiculoModel findByRenavam(String renavam);
	
	List<VeiculoModel>findByDeleted(boolean deleted);

}
