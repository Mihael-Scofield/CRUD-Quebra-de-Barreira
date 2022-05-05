package model;

public class Disciplina {
    private String codigoCurso, versaoCurso, estrutura, codigoDisciplina, nomeUnidade, nomeDisciplina,
                   tipo, situacao;

    private int periodoIdeal, cargaHoraria, horas;

    public Disciplina() {}

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getVersaoCurso() {
        return versaoCurso;
    }

    public void setVersaoCurso(String versaoCurso) {
        this.versaoCurso = versaoCurso;
    }

    public String getEstrutura() {
        return estrutura;
    }

    public void setEstrutura(String estrutura) {
        this.estrutura = estrutura;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getPeriodoIdeal() {
        return periodoIdeal;
    }

    public void setPeriodoIdeal(int periodoIdeal) {
        this.periodoIdeal = periodoIdeal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }    
}
