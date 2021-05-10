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
public class VeiculoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVeiculo;
	@NotNull
	private String modelo;
	@NotNull
	private String status;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private EmpresaModel empresa;

	@NotNull
	private String renavam;
	@NotNull
	private String placa;

	@NotNull
	private String chassi;
	@NotNull
	private String cor;
	@NotNull
	private String anoFab;
	@NotNull
	private String tipo;
	@NotNull
	private String combustivel;
	@NotNull
	private String potencia;
	@NotNull
	private String categoria;
	@NotNull
	private String capPassageiros;
	@NotNull
	private String municipio;
	@NotNull
	private String roubo;
	@NotNull
	private String sitVeiculo;
	@NotNull
	private String nacionalidade;
	@NotNull
	private String anoUltimoLicenciamento;
	@NotNull
	private boolean deleted;

	@NotNull
	private LocalDate dataInicioVigencia;
	@NotNull
	private LocalDate dataFimVigencia;

	@NotNull
	private String Km;

	private LocalDate dataCriacao;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public EmpresaModel getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaModel empresa) {
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

	public String getKm() {
		return Km;
	}

	public void setKm(String km) {
		Km = km;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAnoFab() {
		return anoFab;
	}

	public void setAnoFab(String anoFab) {
		this.anoFab = anoFab;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCapPassageiros() {
		return capPassageiros;
	}

	public void setCapPassageiros(String capPassageiros) {
		this.capPassageiros = capPassageiros;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getRoubo() {
		return roubo;
	}

	public void setRoubo(String roubo) {
		this.roubo = roubo;
	}

	public String getSitVeiculo() {
		return sitVeiculo;
	}

	public void setSitVeiculo(String sitVeiculo) {
		this.sitVeiculo = sitVeiculo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getAnoUltimoLicenciamento() {
		return anoUltimoLicenciamento;
	}

	public void setAnoUltimoLicenciamento(String anoUltimoLicenciamento) {
		this.anoUltimoLicenciamento = anoUltimoLicenciamento;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	

}
