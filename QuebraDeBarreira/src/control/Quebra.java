package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.HistoricoDAO;
import model.Disciplina;
import model.PedidoQuebra;
import model.RegistroHistorico;

public class Quebra {

    public Quebra() {}

    //Calcula o número de disciplinas concedidas no pedido de quebra
    public int calcularNumeroDisciplinas(int nSolicitado){
        Estatisticas estatisticas = new Estatisticas();
        Historico historico = new Historico();
        
        String[] ultimoPeriodo = historico.recuperarUltimoPeriodo();
        HistoricoDAO historicoDAO = new HistoricoDAO();
        List<RegistroHistorico> historicoUltimoSemestre = historicoDAO.recuperarDisciplinasPeriodo(ultimoPeriodo[0], ultimoPeriodo[1]);
        int nAprovadas = 0;
        
        for(RegistroHistorico registro: historicoUltimoSemestre){
            if(registro.getSituacao().equals("Aprovado")){
                nAprovadas++;
            }
        }

        double aprovacao = estatisticas.porcentagemAprovacao(nAprovadas, historicoUltimoSemestre.size());
        double ira = estatisticas.calcularIra();

        if(ira >= 0.8){
            return nSolicitado;
        }

        if(aprovacao >= (200 / 3)){
            return 5;
        }
        else if(aprovacao >= 50 && aprovacao < (200/3)){
            return 4;
        }
        else if(aprovacao < 50){
            return 3;
        }

        return 0;
    }

    //Analisa pedido de quebra  
    public List<List<Disciplina>> analisarPedido(PedidoQuebra pedido){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        
        List<RegistroHistorico> disciplinasConcluidas = historicoDAO.recuperarDisciplinasAprovadas(); 
        List<Disciplina> disciplinasAprovadas = new ArrayList<Disciplina>();
        List<Disciplina> disciplinasReprovadas = new ArrayList<Disciplina>();
        List<Disciplina> disciplinasSolicitadas = pedido.getDisciplinas();
        List<List<Disciplina>> resultado = new ArrayList<List<Disciplina>>();

        // Ordena por período (Tem que priorizar as mais para o começo do curso)
        Collections.sort(disciplinasAprovadas, 
                        (d1, d2) -> Integer.toString(d1.getPeriodoIdeal()).compareTo(Integer.toString(d2.getPeriodoIdeal())));

        int nDisciplinas = calcularNumeroDisciplinas(pedido.getDisciplinas().size());

        System.out.println("Numero disciplinas: " + nDisciplinas);


        for(Disciplina disciplina: disciplinasSolicitadas){
            //Não é optatativa
            if(disciplina.getPeriodoIdeal() < 9 && !disciplina.getCodigoDisciplina().equals("CI1215")){ 
              disciplinasAprovadas.add(disciplina);
            }
            else if(disciplina.getCodigoDisciplina().equals("CI1215") && temDisciplina(disciplinasConcluidas, "CI1212")){
                disciplinasAprovadas.add(disciplina); //Só aprova ci1215 se concluiu ci1212
            }
            else{
                disciplinasReprovadas.add(disciplina);
            }

            if(disciplinasAprovadas.size() == nDisciplinas){
                break;
            }
        }
        resultado.add(disciplinasAprovadas);
        resultado.add(disciplinasReprovadas);
        return resultado;
    }

    public boolean temDisciplina(List<RegistroHistorico> disciplinas, String codigo){
        for(RegistroHistorico disciplina: disciplinas){
            if(disciplina.getCodigoDisciplina().equals(codigo)){
                return true;
            }
        }  
        return false;      
    }
}
