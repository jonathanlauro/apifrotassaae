package br.com.controlefrota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefrota.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Optional<Empresa> findById(Long id);

}
