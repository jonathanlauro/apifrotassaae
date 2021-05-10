package br.com.controlefrota.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_EMPRESA")
public class EmpresaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String CNPJ;
	@NotNull
	private String nome;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "empresa")
	private List<VeiculoModel> Veiculos;

	private LocalDate dataDeCriacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	


}
