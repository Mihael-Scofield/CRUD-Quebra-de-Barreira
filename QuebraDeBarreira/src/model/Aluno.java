package model;

public class Aluno {
    String nome, grr;

    public Aluno(String nome, String grr) {
        this.nome = nome;
        this.grr = grr;
    }

    public Aluno(){}    

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getGrr() {
        return grr;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }
}
