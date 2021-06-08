package br.com.controlefrota.service;

import java.util.List;

import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.Consumo;

import javax.mail.MessagingException;

public interface CadastroDeConsumo {

	public void criar(Consumo consumo);
	
	public void deletar(long id);
	
	public List<Consumo> findAll();

	public List<ConsumoModel> listaDeConsumos();
	
	public List<ConsumoModel> findbyCombustivel(String nome);

	public List<Consumo> findbyCombustivelCompleta(String nome);

	public List<Consumo> findByNomeCondutor(String nome);

	public List<Consumo> findByVeiculo(String placa);

	public void realizarReembolso(long id) throws MessagingException;
}
