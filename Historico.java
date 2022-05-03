package Control;

import java.util.*;

import DAO.HistoricoDAO;
import Model.RegistroHistorico;

public class Historico {
    private List<RegistroHistorico> historico = new ArrayList<RegistroHistorico>();

    public Historico(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        this.historico = historicoDAO.recuperarHistorico();
    }

    public void imprimirHistorico(){

        System.out.println("Histórico");

        for(RegistroHistorico registro: this.historico){

            String frequencia = (registro.getFrequancia() < 0) ? "Indefinida" : Integer.toString(registro.getFrequancia());
            String mediaFinal = (registro.getSigla().equals("Matricula")) ? "Indefinida" : Integer.toString(registro.getMediaFinal());

            System.out.println("\n**************************************");

            System.out.println("GRR: " + registro.getAluno().getGrr());
            System.out.println("Nome: " + registro.getAluno().getnome() + '\n');

            System.out.println("Código do curso: " + registro.getCurso().getcodigo());
            System.out.println("Nome do curso: " + registro.getCurso().getnome());
            System.out.println("Versão do Curso: " + registro.getCurso().getVersao());
            System.out.println("Ano: " + registro.getAno());
            System.out.println("Período: " + registro.getPeriodo() + '\n');

            System.out.println("Código da matéria: " + registro.getCodigoDisciplina());
            System.out.println("Nome da matéria: " + registro.getNomeDisciplina());
            System.out.println("Descrição: " + registro.getDescricaoDisciplina() + '\n');

            System.out.println("Média Final: " + mediaFinal);
            System.out.println("Frequência: " + frequencia);
            System.out.println("Carga Horária: " + registro.getCargaHorariaDisciplina() + '\n');

            System.out.println("Situação: " + registro.getSituacao());
            // System.out.println("Situação Item: " + registro.getSituacaoItem());
            // System.out.println("Sigla: " + registro.getSigla());
        }

        System.out.println("**************************************\n");
    }

    public void imprimirDisciplinasCursadas(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        List<RegistroHistorico> disciplinasCursadas = historicoDAO.recuperarHistorico();
        List<String> listAnos = new ArrayList<String>();

        for(RegistroHistorico registro: disciplinasCursadas){
            listAnos.add(Integer.toString(registro.getAno()));
        }

        //Remove anos duplicados
        Set<String> setPeriodos = new HashSet<String>(listAnos);
        listAnos.clear();
        listAnos.addAll(setPeriodos);
        Collections.sort(listAnos);

        System.out.println("Disciplinas Cursadas\n");

        for(String ano: listAnos){
            for(int i = 0; i < 3; i++){
                List<RegistroHistorico> listDisciplinas = new ArrayList<RegistroHistorico>();
                String semestre = i + "o. Semestre";

                for(RegistroHistorico disciplina: disciplinasCursadas){
                    if(disciplina.getPeriodo().equals(semestre) && Integer.toString(disciplina.getAno()).equals(ano)){
                        listDisciplinas.add(disciplina);
                    }
                }

                imprimirDisciplinas(listDisciplinas);
            }
        }
    }

    private void imprimirDisciplinas(List<RegistroHistorico> listDisciplinas){
        if(listDisciplinas.size() == 0){
            return;
        }

        System.out.println("************************************************");
        System.out.println(listDisciplinas.get(0).getPeriodo() + " de " + listDisciplinas.get(0).getAno() + '\n');
        
        for(RegistroHistorico disciplina : listDisciplinas){
            System.out.println(disciplina.getNomeDisciplina() + " - " + disciplina.getCodigoDisciplina() + " - " + disciplina.getSituacao());
        }

        System.out.println("************************************************\n\n");
    }

    public void calcularIra(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        List<RegistroHistorico> historico = historicoDAO.recuperarHistorico();
        List<RegistroHistorico> disciplinasFinalizadas = new ArrayList<RegistroHistorico>();

        for(RegistroHistorico registro: historico){
            if(!registro.getSituacao().equals("")){
                
            }
        }
    } 
}
