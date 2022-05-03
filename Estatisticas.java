package Control;

import java.util.*;

import DAO.HistoricoDAO;
import Model.RegistroHistorico;

public class Estatisticas {
    public Estatisticas(){}

    public void imprimirEstatisticas(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        List<RegistroHistorico> historico = historicoDAO.recuperarHistorico();
        List<String> periodos = new ArrayList<String>();

        for(RegistroHistorico registro: historico){
            periodos.add(Integer.toString(registro.getAno()) + '/' + registro.getPeriodo());
        }

        //Remove as repetições e ordenação decrescente
        periodos = removerRepetidos(periodos);
        periodos = ordenar(periodos);

        boolean ultimoPeriodo = true;
        for(String periodo : periodos){
            String[] str = periodo.split("/");
            List<RegistroHistorico> disciplinasPeriodo = historicoDAO.recuperarDisciplinasPeriodo(str[0], str[1]);
            ultimoPeriodo = true;
            for(RegistroHistorico disciplina: disciplinasPeriodo){ // Se todas estiverem diferente de matrícula este é o último periódo
                if(disciplina.getSituacao().equals("Matrícula")){
                    ultimoPeriodo = false;
                    break;
                }
            }

            if(ultimoPeriodo){
                gerarEstatísticasPeriodo(disciplinasPeriodo, str);
                break;
            }
        }
    }

    private void gerarEstatísticasPeriodo(List<RegistroHistorico> disciplinasPeriodo, String[] periodo) {
        int nDisciplinas = disciplinasPeriodo.size(), nDisciplinasAprovadas = 0, nDisciplinasReprovadasFalta = 0;
        double aprovacao = 0, reprovacao = 0;

        for(RegistroHistorico registro: disciplinasPeriodo){
            if(registro.getSituacao().equals("Aprovado")){
                nDisciplinasAprovadas++;
            }
            else if(registro.getSituacao().equals("Reprovado por Frequência")){
                nDisciplinasReprovadasFalta++;
            }
        }

        aprovacao = (nDisciplinasAprovadas * 100) / nDisciplinas;
        reprovacao = 100 - aprovacao;

        System.out.println(periodo[0] + "/" + periodo[1] + '\n');
        System.out.println("Disciplinas cursadas: " + nDisciplinas);
        System.out.println("Disciplinas aprovadas: " + nDisciplinasAprovadas);
        System.out.println("Porcentagem de aprovação: " + aprovacao + '%');
        System.out.println("Porcentagem de reprovação: " + reprovacao + '%');
        System.out.println("Disciplinas reprovadas por falta: " + nDisciplinasReprovadasFalta);
        System.out.println("");
    }

    private List<String> removerRepetidos(List<String> periodos){
        List<String> list = new ArrayList<String>();
        Set<String> setPeriodos = new HashSet<String>(periodos);
        list.addAll(setPeriodos);
        return list;
    }

    private List<String> ordenar(List<String> periodos){
        List<String> list = new ArrayList<String>();
        
        list.addAll(periodos);
        Collections.sort(list, (p1, p2) -> p2.compareTo(p1));

        return list;
    }
}
