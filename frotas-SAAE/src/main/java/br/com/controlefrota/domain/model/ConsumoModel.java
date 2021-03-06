package br.com.controlefrota.domain.model;

import io.swagger.annotations.ApiModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(
		value = "consumos",
		description = "Consumos de veiculos"
)
public class ConsumoModel implements Comparable<ConsumoModel>{

	private Long idConsumo;
	private String condutor;
	private String veiculo;
	private String combustivel;
	private String placa;
	private Boolean temReembolso;
	private LocalDate dataRegistroDaNota;
	private Float litros;
	private Float valor;
	private String numeroDaNotaFiscal;
	private LocalDateTime reembolso;
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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Boolean getTemReembolso() {
		return temReembolso;
	}

	public void setTemReembolso(Boolean temReembolso) {
		this.temReembolso = temReembolso;
	}

	public LocalDateTime getReembolso() {
		return reembolso;
	}

	public void setReembolso(LocalDateTime reembolso) {
		this.reembolso = reembolso;
	}

	@Override
	public int compareTo(ConsumoModel consumo) {
		if(this.getDataDeRegistro().isAfter(consumo.getDataDeRegistro())){
			return -1;
		}else{

			return 1;
		}
	}
}
