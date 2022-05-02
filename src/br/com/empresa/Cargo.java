package br.com.empresa;

public class Cargo {
    private Long idcargo;
    private String nomecargo;
    private String descricaocargo;

    public  Cargo(){

    }

    public Cargo(String nomecargo, String descricaocargo){
        this.nomecargo = nomecargo;
        this.descricaocargo = descricaocargo;
    }

    public Long getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Long idcargo) {
        this.idcargo = idcargo;
    }

    public String getNomecargo() {
        return nomecargo;
    }

    public void setNomecargo(String nomecargo) {
        this.nomecargo = nomecargo;
    }

    public String getDescricaocargo() {
        return descricaocargo;
    }

    public void setDescricaocargo(String descricaocargo) {
        this.descricaocargo = descricaocargo;
    }
}