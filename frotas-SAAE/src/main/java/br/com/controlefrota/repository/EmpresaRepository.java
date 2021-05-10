package br.com.controlefrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

	EmpresaModel findById(long id);
	EmpresaModel findByCNPJ(String cnpj);


}
