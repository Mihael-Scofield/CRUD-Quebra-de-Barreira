package control;

import java.util.List;

import dao.HistoricoDAO;
import model.PedidoQuebra;
import model.RegistroHistorico;

public class Quebra {
    public Quebra(){}

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

    public void analisarPedido(/*PedidoQuebra pedido|*/){
        //int nDisciplinas = calcularNumeroDisciplinas(pedido.getDisciplinas().size());
    }
}
