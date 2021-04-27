package br.com.controlefrota.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String CNPJ;
	@NotNull
	private String nome;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "empresa",orphanRemoval = true)
	private List<Veiculo> Veiculos = new ArrayList<Veiculo>();




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
	
	public List<Veiculo> getVeiculos() {
		return Veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		Veiculos = veiculos;
	}


}
