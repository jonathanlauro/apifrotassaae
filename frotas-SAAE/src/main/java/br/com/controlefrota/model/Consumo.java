package br.com.controlefrota.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

@Entity
@Table(name = "TB_CONSUMO")
public class Consumo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConsumo;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name="condutor_id")
	private Condutor condutor;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idVeiculo",referencedColumnName = "idVeiculo")
	private Veiculo veiculo;
	
	@OneToOne
	@JoinColumn(name="Combustivel_id",referencedColumnName = "id")
	private Combustivel combustivel;
	private LocalDate dataRegistro;
	private Float km;
	private Float litros;
	private Float valor;
	private String numNotaFiscal;
	
	public Long getIdConsumo() {
		return idConsumo;
	}
	public void setIdConsumo(Long idConsumo) {
		this.idConsumo = idConsumo;
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
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Float getKm() {
		return km;
	}
	public void setKm(Float km) {
		this.km = km;
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
	public String getNumNotaFiscal() {
		return numNotaFiscal;
	}
	public void setNumNotaFiscal(String numNotaFiscal) {
		this.numNotaFiscal = numNotaFiscal;
	}


}
