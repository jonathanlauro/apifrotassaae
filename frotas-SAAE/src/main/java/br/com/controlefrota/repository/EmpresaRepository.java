package br.com.controlefrota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlefrota.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Empresa findById(long id);
	Empresa findByCNPJ(String cnpj);
	List<Empresa> findByDeleted(boolean deleted);

}
