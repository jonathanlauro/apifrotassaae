package br.com.controlefrota.domain.model;

import java.time.LocalDate;

public class ConsumoModel {

	private Long idConsumo;
	private String condutor;
	private String veiculo;
	private String combustivel;
	private LocalDate dataRegistroDaNota;
	private Float litros;
	private Float valor;
	private String numeroDaNotaFiscal;
	private LocalDate dataDeRegistro;
	
	public Long getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(Long idConsumo) {
		this.idConsumo = idConsumo;
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
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public LocalDate getDataRegistroDaNota() {
		return dataRegistroDaNota;
	}
	public void setDataRegistroDaNota(LocalDate dataRegistroDaNota) {
		this.dataRegistroDaNota = dataRegistroDaNota;
	}
	public Float getLitros() {
		return litros;
	}
	public void setLitros(Float litros) {
		this.litros = litros;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public String getNumeroDaNotaFiscal() {
		return numeroDaNotaFiscal;
	}
	public void setNumeroDaNotaFiscal(String numeroDaNotaFiscal) {
		this.numeroDaNotaFiscal = numeroDaNotaFiscal;
	}
	public LocalDate getDataDeRegistro() {
		return dataDeRegistro;
	}
	public void setDataDeRegistro(LocalDate dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
	}
	
	
	
}
