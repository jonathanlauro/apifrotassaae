package br.com.controlefrota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Empresa;
import br.com.controlefrota.model.Veiculo;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Empresa findById(long id);


}
