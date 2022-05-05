package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DisciplinasDAO;
import dao.HistoricoDAO;
import model.Disciplina;
import model.RegistroHistorico;
import view.ViewMaster;

public class ControllerMaster {
	ViewMaster viewMaster;
	DisciplinasDAO disciplinasDAO;
	HistoricoDAO historicoDAO;
	List<Disciplina> disciplinas;
	List<RegistroHistorico> historico;
	
	public ControllerMaster(ViewMaster viewMaster) {	
		this.viewMaster = viewMaster;
		this.disciplinasDAO = new DisciplinasDAO();
		this.historicoDAO = new HistoricoDAO();
		this.disciplinas = new ArrayList<Disciplina>();
		this.historico = new ArrayList<RegistroHistorico>();
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
