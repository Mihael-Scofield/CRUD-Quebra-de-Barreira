package model;

public class RegistroHistorico {
    private Aluno aluno;
    private Curso curso;

    private int ano, mediaFinal, situacaoItem;
    private String periodo, situacao;
    private int frequancia;
    private String sigla;

    private String codigoDisciplina, nomeDisciplina, descricaoDisciplina;
    private int cargaHorariaDisciplina;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(int mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public int getSituacaoItem() {
        return situacaoItem;
    }

    public void setSituacaoItem(int situacaoItem) {
        this.situacaoItem = situacaoItem;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getFrequancia() {
        return frequancia;
    }

    public void setFrequancia(int frequancia) {
        this.frequancia = frequancia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getDescricaoDisciplina() {
        return descricaoDisciplina;
    }

    public void setDescricaoDisciplina(String descricaoDisciplina) {
        this.descricaoDisciplina = descricaoDisciplina;
    }

    public int getCargaHorariaDisciplina() {
        return cargaHorariaDisciplina;
    }

    public void setCargaHorariaDisciplina(int cargaHorariaDisciplina) {
        this.cargaHorariaDisciplina = cargaHorariaDisciplina;
    }
}
