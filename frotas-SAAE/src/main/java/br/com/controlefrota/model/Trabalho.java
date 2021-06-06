package br.com.controlefrota.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_TRABALHO")
public class Trabalho implements Serializable,Comparable<Trabalho> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTrabalho;
	private String statusTrabalho = "Em_vigencia";
	@NotNull
	@OneToOne
	@JoinColumn(name = "condutor_id", referencedColumnName="id")
	private Condutor condutor;
	@NotNull
	@OneToOne 
	private Veiculo veiculo;
	@NotNull
	private String KmInicial;
	private String kmFinal;
	@NotNull
	private LocalDate DataInicioVigencia;
	private LocalDate DataFimVigencia;
	
	private LocalDate dataDeCriacao;
	private LocalDate deleted;
	
	

	public LocalDate getDeleted() {
		return deleted;
	}

	public void setDeleted(LocalDate deleted) {
		this.deleted = deleted;
	}

	public Long getIdTrabalho() {
		return idTrabalho; 
	}

	public void setIdTrabalho(Long idTrabalho) {
		this.idTrabalho = idTrabalho;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDate getDataInicioVigencia() {
		return DataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		DataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return DataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		DataFimVigencia = dataFimVigencia;
	}

	public String getStatusTrabalho() {
		return statusTrabalho;
	}

	public void setStatusTrabalho(String statusTrabalho) {
		this.statusTrabalho = statusTrabalho;
	}

	public String getKmInicial() {
		return KmInicial;
	}

	public void setKmInicial(String kmInicial) {
		KmInicial = kmInicial;
	}

	public String getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(String kmFinal) {
		this.kmFinal = kmFinal;
	}

	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}


	@Override
	public int compareTo(Trabalho trabalho) {
		if(this.dataDeCriacao.isAfter(trabalho.getDataDeCriacao())){
			return -1;
		}else{
			return 1;
		}

	}
}
