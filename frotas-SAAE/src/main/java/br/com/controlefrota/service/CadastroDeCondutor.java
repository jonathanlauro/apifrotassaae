package br.com.controlefrota.service;

import java.util.List;

import br.com.controlefrota.model.Condutor;

public interface CadastroDeCondutor {

	public Condutor criar(Condutor condutor);

	public Condutor findById(long id);

	public Condutor findByCnh(String cnh);

	public List<Condutor> findAll();

	public void deletar(long id);
}
