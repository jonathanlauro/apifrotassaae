package br.com.controlefrota.domain.model;

public class ErroModelo {
	

    private String codigo;

    private String mensagem;


    public ErroModelo() {
        this(null,null);
    }

    public ErroModelo(String codigo, String mensagem) {
       this.codigo = codigo;
       this.mensagem = mensagem;
    }


    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
}
