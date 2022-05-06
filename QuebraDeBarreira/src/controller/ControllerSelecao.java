package controller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Aluno;

public class ControllerSelecao {
    ControllerMaster controllerMaster;
    
    public ControllerSelecao (ControllerMaster controllerMaster) {
        this.controllerMaster = controllerMaster;
    }

    public void Exporta () {
        System.out.println(controllerMaster.disciplinas.get(0));
    }
    
    public ArrayList<String> carregaHistorico() {
    	ArrayList<String> materiasCursadas = new ArrayList<String>();
    	for(int i = 0; i < controllerMaster.historico.size(); i++) {
    		materiasCursadas.add(controllerMaster.historico.get(i).getNomeDisciplina() + " / " +
    							  controllerMaster.historico.get(i).getCodigoDisciplina() + " / " +
    							  controllerMaster.historico.get(i).getPeriodo() + " / " +
    							  controllerMaster.historico.get(i).getSituacao() + " / " +
    							  controllerMaster.historico.get(i).getMediaFinal());    							  	
    	}
    	return materiasCursadas;
    }
    
    public ArrayList<String> carregarPreBarreira() {
    	ArrayList<String> materiasPreBarreira = new ArrayList<String>();
    	for(int i = 0; i < controllerMaster.disciplinas.size(); i++) {
    		if (controllerMaster.disciplinas.get(i).getPeriodoIdeal() <= 3) {
    			materiasPreBarreira.add(controllerMaster.disciplinas.get(i).getNomeDisciplina() + " / " +
    							  controllerMaster.disciplinas.get(i).getCodigoDisciplina() + " / " +
    							  controllerMaster.disciplinas.get(i).getPeriodoIdeal() + " / " +
    							  controllerMaster.disciplinas.get(i).getSituacao() + " / " +
    							  controllerMaster.disciplinas.get(i).getPeriodoIdeal());
    		}
    	}
    	return materiasPreBarreira;
    }
    
    public ArrayList<String> carregarPosBarreira() {
    	ArrayList<String> materiasPosBarreira = new ArrayList<String>();
    	for(int i = 0; i < controllerMaster.disciplinas.size(); i++) {
    		if (controllerMaster.disciplinas.get(i).getPeriodoIdeal() >= 4) {
    			materiasPosBarreira.add(controllerMaster.disciplinas.get(i).getNomeDisciplina() + " / " +
    							  controllerMaster.disciplinas.get(i).getCodigoDisciplina() + " / " +
    							  controllerMaster.disciplinas.get(i).getPeriodoIdeal() + " / " +
    							  controllerMaster.disciplinas.get(i).getSituacao() + " / " +
    							  controllerMaster.disciplinas.get(i).getPeriodoIdeal());
    		}
    	}
    	return materiasPosBarreira;
    }
	
    
    public String pegarInformacoesAluno() {
    	Aluno aluno = controllerMaster.historico.get(0).getAluno();
    	return aluno.getnome() + " - " + aluno.getGrr();
    }
    
    public void geraCSV(int[] preBarreiraSelected, int[] posBarreiraSelected, ArrayList<String> materiasPreBarreira, ArrayList<String> materiasPosBarreira ) {
		
		try {
			FileWriter fileWriter = new FileWriter ("src/dao/solicitacao.csv");
			PrintWriter printWriter = new PrintWriter (fileWriter);
			
			printWriter.println ("COD_CURSO,NUM_VERSAO,DESCR_ESTRUTURA,COD_DISCIPLINA,NOME_UNIDADE,NOME_DISCIPLINA,PERIODO_IDEAL,NUM_HORAS,TIPO_DISCIPLINA,CH_TOTAL,SITUACAO_VERSAO");
			printWriter.println (",,,,,,,,,,");
			
			int flag_pre = 0;
		
			int flag_pre_s = 0;
			int flag_pos = 0;
			int flag_pos_s = 0;
			for(int i = 0; i < controllerMaster.disciplinas.size(); i++) {
				if (controllerMaster.disciplinas.get(i).getPeriodoIdeal() <= 3) {
					try {
						if (preBarreiraSelected[flag_pre_s] == flag_pre) {
							printWriter.println(controllerMaster.disciplinas.get(i).getAll());
							flag_pre_s++;
						}
					} catch (Exception e) {}
					flag_pre++;
				}
				if (controllerMaster.disciplinas.get(i).getPeriodoIdeal() >= 4) {
					try {
						if (posBarreiraSelected[flag_pos_s] == flag_pos) {
							printWriter.println(controllerMaster.disciplinas.get(i).getAll());
							flag_pos_s++;
						}
					} catch (Exception e) {}
					flag_pos++;
				}
			}
			
			printWriter.close();
		} catch (Exception e) {
			System.out.println ("Erro" + e.getMessage());
		}
    }
}
