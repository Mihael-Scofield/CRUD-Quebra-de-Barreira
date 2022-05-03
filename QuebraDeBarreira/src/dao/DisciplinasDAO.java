package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinasDAO {

    public DisciplinasDAO(){}

    public List<Disciplina> recuperarDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("disciplinas.csv"));
            disciplinas.addAll(extrairDados(br));
        }
        catch(Exception e){
            System.out.println("Erro ao recuperarDisciplinas: " + e.getMessage());
        }

        return disciplinas;
    } 

    private List<Disciplina> extrairDados(BufferedReader br){
        List<Disciplina> list = new ArrayList<Disciplina>();
        String str;
        int cont = 0;

        try{
            while ((str = br.readLine()) != null) {
                if(cont > 1){
                    String[] linha = str.split(",");
                    Disciplina disciplina = new Disciplina();     
                    int periodoIdeal = (!linha[6].equals("")) ? Integer.parseInt(linha[6]) : 9;
                    int horas = (!linha[7].equals("")) ? Integer.parseInt(linha[7]) : -1;
                    int cargaHoraria = (!linha[9].equals("")) ? Integer.parseInt(linha[9]) : -1;  
    
                    disciplina.setCodigoCurso(linha[0]);
                    disciplina.setVersaoCurso(linha[1]);
                    disciplina.setEstrutura(linha[2]);
                    disciplina.setCodigoDisciplina(linha[3]);
                    disciplina.setNomeUnidade(linha[4]);
                    disciplina.setNomeDisciplina(linha[5]);
                    disciplina.setTipo(linha[8]);
                    disciplina.setSituacao(linha[10]);
                    disciplina.setPeriodoIdeal(periodoIdeal);
                    disciplina.setCargaHoraria(cargaHoraria);
                    disciplina.setHoras(horas);

                    list.add(disciplina);
                }
                cont++;
            }

        }
        catch(Exception e){
            System.out.println("Erro ao extrair dados: ");
            e.printStackTrace();
        }

        return list;
    }

    public void imprimirDisciplinas(){
        List<Disciplina> disciplinas = recuperarDisciplinas();
        for(Disciplina disciplina : disciplinas){
            System.out.println("Código Curso: " + disciplina.getCodigoCurso());
            System.out.println("Versão Curso: " + disciplina.getVersaoCurso());
            System.out.println("Estrutura: " + disciplina.getEstrutura());
            System.out.println("Código Disciplina: " + disciplina.getCodigoDisciplina());
            System.out.println("Nome Unidade: " + disciplina.getNomeUnidade());
            System.out.println("Nome Disciplina: " + disciplina.getNomeDisciplina());
            System.out.println("Período Ideal: " + disciplina.getPeriodoIdeal());
            System.out.println("Horas: " + disciplina.getHoras());
            System.out.println("Tipo: " + disciplina.getTipo());
            System.out.println("Carga Horária: "+ disciplina.getCargaHoraria());
            System.out.println("Situação: " + disciplina.getSituacao());
            System.out.println("");
        }
    }

    public List<Disciplina> recuperarDisciplinasBarreira(){
        List<Disciplina> disciplinas = recuperarDisciplinas();
        List<Disciplina> disciplinasBarreira = new ArrayList<Disciplina>();

        for(Disciplina disciplina: disciplinas){
            if(disciplina.getPeriodoIdeal() <= 3 && disciplina.getPeriodoIdeal() > 0){
                disciplinasBarreira.add(disciplina);
            }
        }
        return disciplinasBarreira;
    }
}
