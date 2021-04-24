package br.com.controlefrota.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRABALHO")
public class Trabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTrabalho;
	@OneToOne
	private Condutor condutor;
	@OneToOne
	private Veiculo veiculo;
	private LocalDate DataInicioVigencia;
	private LocalDate DataFimVigencia;

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

}
