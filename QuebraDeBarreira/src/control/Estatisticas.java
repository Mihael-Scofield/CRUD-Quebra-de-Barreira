package control;

import java.util.List;

import dao.HistoricoDAO;
import model.RegistroHistorico;

public class Estatisticas {
    public Estatisticas(){}

    public double porcentagemAprovacao(int nDisciplinasAprovadas, int nDisciplinas){
        return (nDisciplinas > 0) ? ((nDisciplinasAprovadas * 100) / nDisciplinas) : 0;
    }

    public double calcularIra(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        List<RegistroHistorico> historico = historicoDAO.recuperarHistorico();
        double somaNotas = 0, materiasFinalizadas = 0;

        for(RegistroHistorico registro: historico){
            if(!registro.getSituacao().equals("Matrícula")){
                materiasFinalizadas++;
                somaNotas += registro.getMediaFinal();
            }
        }
        //Calcula ira com 3 casas decimais
        double ira = (materiasFinalizadas > 0) ? (somaNotas / (materiasFinalizadas * 100)) : 0;
        ira = (double) (Math.round(ira * 1000.0) / 1000.0);

        return ira;
    }

    public int reprovacaoPorFrequencia(List<RegistroHistorico> disciplinasPeriodo){
        int nReprovacaoFrequencia = 0;
        
        for(RegistroHistorico registro : disciplinasPeriodo){
            if(registro.getSituacao().equals("Reprovado por Frequência")){
                nReprovacaoFrequencia++;
            }
        }

        return nReprovacaoFrequencia;
    }
}
