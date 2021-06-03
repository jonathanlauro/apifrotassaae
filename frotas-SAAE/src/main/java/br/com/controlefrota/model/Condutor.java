package br.com.controlefrota.model;

import java.io.Serializable;
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
@Table(name="TB_CONDUTOR")
public class Condutor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String cnh;
	@NotNull
	private String cpf;
	@NotNull
	private String status = "Disponivel";
	@NotNull
	private LocalDate deleted;
	
	@OneToMany(mappedBy = "condutor",cascade = CascadeType.ALL)
	private List<Consumo> consumo;
	
	private LocalDate dataDeCriacao;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cNH) {
		cnh = cNH;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cPF) {
		cpf = cPF;
	}
	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}
	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public LocalDate getDeleted() {
		return deleted;
	}

	public void setDeleted(LocalDate deleted) {
		this.deleted = deleted;
	}
}
