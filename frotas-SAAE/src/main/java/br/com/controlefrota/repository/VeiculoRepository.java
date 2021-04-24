package br.com.controlefrota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Optional<Veiculo> findById(Long id);

	Veiculo findByPlaca(String placa);

	Veiculo findByRenavam(String renavam);

}
