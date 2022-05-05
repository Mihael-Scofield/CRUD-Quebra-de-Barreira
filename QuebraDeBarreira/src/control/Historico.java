package control;

import java.util.*;

import dao.HistoricoDAO;
import model.RegistroHistorico;

public class Historico {

    public Historico(){}
    
    //Retorna o último período cursado str[0] = ano, str[1] = semestre
    public String[] recuperarUltimoPeriodo(){ 
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
                return str;
            }
        }
        return null;
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
