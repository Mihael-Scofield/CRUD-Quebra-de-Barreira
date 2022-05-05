package controller;

import java.util.ArrayList;

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
    
    public void geraCSV(int[] preBarreiraSelected, int[] posBarreiraSelected, ArrayList<String> materiasPreBarreira, ArrayList<String> materiasPosBarreira ) {
    	
    }
}
