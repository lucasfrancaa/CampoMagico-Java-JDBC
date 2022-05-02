package br.com.empresa;

import java.util.Date;

public class Funcionario {
    private Long idfuncionario;
    private String nomefuncionario;
    private String telefone;
    private Date datanascimento;
    private Date datacontratacao;
    private String situacao;
    private String cpf;
    private Float altura;
    private Integer idade;
    private Long cargo;

    public Funcionario(String nomefuncionario, String telefone, Date datanascimento, Date datacontratacao, String situacao, String cpf, Float altura, Integer idade, Long cargo){
        this.nomefuncionario = nomefuncionario;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
        this.datacontratacao = datacontratacao;
        this.situacao = situacao;
        this.cpf = cpf;
        this.altura = altura;
        this.idade = idade;
        this.cargo = cargo;
    }


    public Funcionario() {

    }

    public Long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Date getDatacontratacao() {
        return datacontratacao;
    }

    public void setDatacontratacao(Date datacontratacao) {
        this.datacontratacao = datacontratacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getCargo() {
        return cargo;
    }

    public void setCargo(Long cargo) {
        this.cargo = cargo;
    }

}
