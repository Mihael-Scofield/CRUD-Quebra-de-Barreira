package controller;

public class ControllerPrincipal {
	int historicoFlag;
	int grade;
	ControllerMaster controllerMaster;
 	
	public ControllerPrincipal(ControllerMaster controllerMaster) {
		this.controllerMaster = controllerMaster;
		this.historicoFlag = 0;
		this.grade = 0;
	}
	
	
	/* Responsavel por cuidar da importacao do historico */
	public boolean importarHistorico() {  
		try {
			controllerMaster.historico = controllerMaster.historicoDAO.recuperarHistorico();
			this.historicoFlag = 1;
		} catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
		return verificaNevegaTelaSelecao();
	}
	
	/* Funcao responsavel por cuidar da importacao da grade */
	public boolean importarGrade() {
		try {
			controllerMaster.disciplinas = controllerMaster.disciplinasDAO.recuperarDisciplinas();
			this.grade = 1;
		} catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
		return verificaNevegaTelaSelecao();
	}
	
	/* Navega da tela principal para a Tela de Selecao */
	public boolean verificaNevegaTelaSelecao() {
		// Navega apenas se ambos os valores tiver
		if ((historicoFlag == 1) && (grade == 1)) {
			return true;
		} return false;
	}
}
