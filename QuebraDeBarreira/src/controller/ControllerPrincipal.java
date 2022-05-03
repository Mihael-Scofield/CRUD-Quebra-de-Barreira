package controller;

import dao.HistoricoDAO;
import dao.DisciplinasDAO;

public class ControllerPrincipal {
	int historico;
	int grade;
	ControllerMaster controllerMaster;
	DisciplinasDAO disciplinasDAO;
	HistoricoDAO historicoDAO;

	
	public ControllerPrincipal() {
		this.historico = 0;
		this.grade = 0;
		disciplinasDAO = new DisciplinasDAO();
		historicoDAO = new HistoricoDAO();
	}
	
	public int getHistorico() {
		return historico;
	}
	
	public void setHistorico(int historico) {
		this.historico = historico;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	/* Responsavel por cuidar da importacao do historico */
	public boolean importarHistorico() {  
		try {
			historicoDAO.recuperarHistorico();
			this.historico = 1;
		} catch (Exception e) {	}
		return verificaNevegaTelaSelecao();
	}
	
	/* Funcao responsavel por cuidar da importacao da grade */
	public boolean importarGrade() {
		try {
			disciplinasDAO.recuperarDisciplinas();
			this.grade = 1;
		} catch (Exception e) {	}
		return verificaNevegaTelaSelecao();
	}
	
	/* Navega da tela principal para a Tela de Selecao */
	public boolean verificaNevegaTelaSelecao() {
		// Navega apenas se ambos os valores tiver
		if ((historico == 1) && (grade == 1)) {
			return true;
		} return false;
	}
}
