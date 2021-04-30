package br.com.controlefrota.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVeiculo;
	@NotNull
	private  String modelo;
	@NotNull
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")	
	private Empresa empresa;
	
	@NotNull
	private String renavam;
	@NotNull
	private String placa;
	@NotNull
	private LocalDate dataInicioVigencia;
	@NotNull
	private LocalDate dataFimVigencia;
	@NotNull
	private String motorizacao;
	@NotNull
	private Float mediaConsumoCidade;
	@NotNull
	private Float mediaConsumoEstrada;
//	@OneToOne(mappedBy = "veiculo")
//	private Consumo consumo;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public String getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(String motorizacao) {
		this.motorizacao = motorizacao;
	}

	public Float getMediaConsumoCidade() {
		return mediaConsumoCidade;
	}

	public void setMediaConsumoCidade(Float mediaConsumoCidade) {
		this.mediaConsumoCidade = mediaConsumoCidade;
	}

	public Float getMediaConsumoEstrada() {
		return mediaConsumoEstrada;
	}

	public void setMediaConsumoEstrada(Float mediaConsumoEstrada) {
		this.mediaConsumoEstrada = mediaConsumoEstrada;
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


}
