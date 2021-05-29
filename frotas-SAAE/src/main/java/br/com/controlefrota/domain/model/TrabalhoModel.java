package br.com.controlefrota.domain.model;

import java.time.LocalDate;

public class TrabalhoModel {

	private Long idTrabalho;
	private String statusTrabalho;
	private String condutor;
	private String veiculo;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public Long getIdTrabalho() {
		return idTrabalho;
	}
	public void setIdTrabalho(Long idTrabalho) {
		this.idTrabalho = idTrabalho;
	}
	public String getStatusTrabalho() {
		return statusTrabalho;
	}
	public void setStatusTrabalho(String statusTrabalho) {
		this.statusTrabalho = statusTrabalho;
	}
	public String getCondutor() {
		return condutor;
	}
	public void setCondutor(String condutor) {
		this.condutor = condutor;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
}
