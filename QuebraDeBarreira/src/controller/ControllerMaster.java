package controller;

import dao.DisciplinasDAO;
import dao.HistoricoDAO;
import view.ViewMaster;

public class ControllerMaster {
	ViewMaster viewMaster;
	DisciplinasDAO disciplinasDAO;
	HistoricoDAO historicoDAO;
	
	public ControllerMaster(ViewMaster viewMaster) {	
		this.viewMaster = viewMaster;
		this.disciplinasDAO = new DisciplinasDAO();
		this.historicoDAO = new HistoricoDAO();
	}
	
	public void navegaTelaPrincipal() {
		viewMaster.carregaViewPrincipal();
	}
	
	public void navegaTelaSelecao() {
		viewMaster.carregaViewSelecao();
	}
	
	public void navegaTelaSolicitacao() {
		viewMaster.carregaViewSolicitacao();
	}
}
