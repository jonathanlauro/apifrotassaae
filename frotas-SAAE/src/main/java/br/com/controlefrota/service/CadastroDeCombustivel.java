package br.com.controlefrota.service;

import br.com.controlefrota.model.Combustivel;

public interface CadastroDeCombustivel {

	public Combustivel cadastrar(Combustivel combustivel);
	
	public Combustivel findById(long id);
}
