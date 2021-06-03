package br.com.controlefrota.domain.model;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class TrabalhoModel {

    @ApiModelProperty(value = "Id do trabalho")
    private Long idTrabalho;

    @ApiModelProperty(value = "Status do trabalho")
    private String statusTrabalho;

    @ApiModelProperty(value = "Nome do condutor")
    private String condutor;

    @ApiModelProperty(value = "Id do condutor")
    private Long idConduto;

    @ApiModelProperty(value = "Modelo do veiculo")
    private String veiculo;

    @ApiModelProperty(value = "Apelido do veiculo")
    private String apelidoVeiculo;

    @ApiModelProperty(value = "Placa do veiculo")
    private String placa;

    @ApiModelProperty(value = "Data inicio da vigencia do trabalho")
    private LocalDate dataInicio;

    @ApiModelProperty(value = "Data fim da vigencia do trabalho")
    private LocalDate dataFim;

    public Long getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(Long idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public String getStatusTrabalho() {
        return statusTrabalho;
    }

    public void setStatusTrabalho(String statusTrabalho) {
        this.statusTrabalho = statusTrabalho;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Long getIdConduto() {
        return idConduto;
    }

    public void setIdConduto(Long idConduto) {
        this.idConduto = idConduto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getApelidoVeiculo() {
        return apelidoVeiculo;
    }

    public void setApelidoVeiculo(String apelidoVeiculo) {
        this.apelidoVeiculo = apelidoVeiculo;
    }
}
