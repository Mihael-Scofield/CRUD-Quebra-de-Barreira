package controller;

public class ControllerSelecao {
    ControllerMaster controllerMaster;
    
    public ControllerSelecao (ControllerMaster controllerMaster) {
        this.controllerMaster = controllerMaster;
    }

    public void Exporta () {
        System.out.println(controllerMaster.disciplinas.get(0));
    }
    
}
