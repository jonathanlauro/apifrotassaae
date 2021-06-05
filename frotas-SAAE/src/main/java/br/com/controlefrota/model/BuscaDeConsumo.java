package br.com.controlefrota.model;

import java.time.LocalDate;
import java.util.List;

public class BuscaDeConsumo {

    private List<String> nome;

    private LocalDate dataDeInicio;
    private LocalDate dataFim;
    private String combustivelNome;

//    private String cnpjEmpresa;
//    private String placaVeiculo;

    public List<String> getNome() {
        return nome;
    }

    public void setNome(List<String> nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getCombustivelNome() {
        return combustivelNome;
    }

    public void setCombustivelNome(String combustivelNome) {
        this.combustivelNome = combustivelNome;
    }
}
