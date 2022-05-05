package controller;

public class ControllerPrincipal {
	int historico;
	int grade;
	ControllerMaster controllerMaster;
	
	public ControllerPrincipal(ControllerMaster controllerMaster) {
		this.controllerMaster = controllerMaster;
		this.historico = 0;
		this.grade = 0;
	}
	
	
	/* Responsavel por cuidar da importacao do historico */
	public boolean importarHistorico() {  
		try {
			controllerMaster.historicoDAO.recuperarHistorico();
			this.historico = 1;
		} catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
		return verificaNevegaTelaSelecao();
	}
	
	/* Funcao responsavel por cuidar da importacao da grade */
	public boolean importarGrade() {
		try {
			controllerMaster.disciplinasDAO.recuperarDisciplinas();
			this.grade = 1;
		} catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
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
