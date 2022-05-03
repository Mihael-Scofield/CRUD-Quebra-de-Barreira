package controller;

import view.ViewMaster;

public class ControllerMaster {
	ViewMaster viewMaster;
	
	public ControllerMaster(ViewMaster viewMaster) {	
		this.viewMaster = viewMaster;
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
