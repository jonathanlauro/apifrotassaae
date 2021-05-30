package br.com.controlefrota.domain.model;

import br.com.controlefrota.model.Veiculo;
import io.swagger.annotations.ApiModelProperty;

public class VeiculoModel {

	@ApiModelProperty(value = "Id do veiculo")
	private Long id;
	@ApiModelProperty(value = "Modelo do veiculo")
	private String modelo;
	@ApiModelProperty(value = "Status do veículo de está em trabalho ou não")
	private String status;
	@ApiModelProperty(value = "Placa do veículo")
	private String placa;
	@ApiModelProperty(value = "Renavam (Documento do veículo)")
	private String renavam;
	@ApiModelProperty(value = "Nome da Empresa")
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
