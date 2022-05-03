package controller;

public class ControllerPrincipal {
	int historico;
	int grade;
	ControllerMaster controllerMaster;
	
	public ControllerPrincipal() {
		this.historico = 0;
		this.grade = 0;
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
		this.historico = 1;
		return verificaNevegaTelaSelecao();
	}
	
	/* Funcao responsavel por cuidar da importacao da grade */
	public boolean importarGrade() {
		this.grade = 1;
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
