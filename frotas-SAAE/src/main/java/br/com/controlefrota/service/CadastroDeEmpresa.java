package br.com.controlefrota.service;

import java.util.List;

import br.com.controlefrota.model.Empresa;

public interface CadastroDeEmpresa {

	public Empresa cadastrarEmpresa(Empresa empresa);
	
	public List<Empresa> findAll();
	
	public Empresa findById(long id);
	
	public void delete(long id);
	
	public Empresa findByCNPJ(String cnpj);
	
}
