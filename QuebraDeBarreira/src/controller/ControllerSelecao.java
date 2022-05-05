package controller;

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
    	// System.out.println ("COD_CURSO,NUM_VERSAO,DESCR_ESTRUTURA,COD_DISCIPLINA,NOME_UNIDADE,NOME_DISCIPLINA,PERIODO_IDEAL,NUM_HORAS,TIPO_DISCIPLINA,CH_TOTAL,SITUACAO_VERSAO");
		// System.out.println (",,,,,,,,,,");
		// System.out.println (materiasPreBarreira.get(0).toString());

		for (int i = 0; i < posBarreiraSelected.length; i++) {
			System.out.println (posBarreiraSelected[i]);
		}
	
		int j = 0;
		int flag_pre = 0;
		int flag_pos = 0;
		for(int i = 0; i < controllerMaster.disciplinas.size(); i++) {
    		if (controllerMaster.disciplinas.get(i).getPeriodoIdeal() <= 3) {
    			try {
					if (preBarreiraSelected[flag_pre] == i) {
						System.out.println(controllerMaster.disciplinas.get(i).getNomeDisciplina());
						flag_pre++;
					}
				} catch (Exception e) {}
    		}
			try {
				if (posBarreiraSelected[flag_pos] == j) {
					System.out.println (controllerMaster.disciplinas.get(i).getNomeDisciplina());
					flag_pos++;
				}
			} catch (Exception e) {}
			j++;
    	}
    }
}
