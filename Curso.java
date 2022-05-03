package Model;

public class Curso {
    private String codigo, nome;
    private int versao;

    public Curso(String codigo, String nome, int versao) {
        this.codigo = codigo;
        this.nome = nome;
        this.versao = versao;
    }

    public Curso(){}

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }
    
}
