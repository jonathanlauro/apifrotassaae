package br.com.controlefrota.domain.model;

import br.com.controlefrota.model.Veiculo;

public class VeiculoModel {

	private Long id;
	private String modelo;
	private String status;
	private String placa;
	private String renavam;
	private String empresa;
	
	public VeiculoModel() {
		
	}
	public VeiculoModel(Veiculo veiculo) {
		this.id = veiculo.getIdVeiculo();
		this.modelo = veiculo.getModelo();
		this.status = veiculo.getStatus();
		this.placa = veiculo.getPlaca();
		this.renavam = veiculo.getRenavam();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getRenavam() {
		return renavam;
	}


	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
	
}
