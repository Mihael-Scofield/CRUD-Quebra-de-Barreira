package Control;

import java.util.*;

import DAO.DisciplinasDAO;
import DAO.HistoricoDAO;
import Model.Disciplina;
import Model.RegistroHistorico;

public class Disciplinas {
    public Disciplinas(){}

    public void imprimirDisciplinasOfertadas(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        DisciplinasDAO disciplinasDao = new DisciplinasDAO();
        List<Disciplina> disciplinasOfertadas = disciplinasDao.recuperarDisciplinas();
        List<RegistroHistorico> disciplinasAprovadas = historicoDAO.recuperarRegistroDisciplinasAprovadas();
        List<Disciplina> disciplinasRestantes = new ArrayList<Disciplina>();

        disciplinasRestantes.addAll(disciplinasOfertadas);

        System.out.println("Disciplinas ofertadas ainda não cursadas\n");

        //Remove as já concluídas
        for(Disciplina disciplina: disciplinasOfertadas){
            for(RegistroHistorico disciplinaAprovada: disciplinasAprovadas){
                if(disciplinaAprovada.getCodigoDisciplina().equals(disciplina.getCodigoDisciplina())){
                    disciplinasRestantes.remove(disciplina);
                }
            }
        }

        Collections.sort(disciplinasRestantes, (d1, d2) -> {
            return Integer.toString(d1.getPeriodoIdeal()).compareTo(Integer.toString(d2.getPeriodoIdeal()));
        });

        for(int i = 1; i < 10; i++){
            System.out.println("\n******************************************************************************************************************");
            if(i < 9){
                System.out.println(i + "o. Período\n");
            }
            else{
                System.out.println("Optativas\n");
            }
            
            for(Disciplina disciplina: disciplinasRestantes){
                if(i == disciplina.getPeriodoIdeal()){
                    System.out.println(disciplina.getCodigoDisciplina() + " - " + disciplina.getNomeDisciplina());
                }
            }
            
            System.out.println("******************************************************************************************************************\n");
        }
    }

    public void imprimirDisciplinasRestantesBarreira(){

        HistoricoDAO historicoDAO = new HistoricoDAO();
        DisciplinasDAO disciplinasDao = new DisciplinasDAO();
        List<Disciplina> disciplinasBarreira = disciplinasDao.recuperarDisciplinasBarreira();
        List<RegistroHistorico> disciplinasAprovadas = historicoDAO.recuperarRegistroDisciplinasAprovadas();
        List<Disciplina> disciplinasRestantes = new ArrayList<Disciplina>();

        disciplinasRestantes.addAll(disciplinasBarreira);

        System.out.println("Disciplinas restantes da barreira\n");

        //Remove as já comcluídas
        for(Disciplina disciplinaBarreira: disciplinasBarreira){
            for(RegistroHistorico disciplinaAprovada: disciplinasAprovadas){
                if(disciplinaAprovada.getCodigoDisciplina().equals(disciplinaBarreira.getCodigoDisciplina())){
                    disciplinasRestantes.remove(disciplinaBarreira);
                }
            }
        }

        for(Disciplina disciplina: disciplinasRestantes){
            System.out.println(disciplina.getNomeDisciplina() + " - " + disciplina.getCodigoDisciplina());
        }
        System.out.println("");
    }

    public void imprimirDisciplinasRestantesCurso(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        DisciplinasDAO disciplinasDao = new DisciplinasDAO();
        List<Disciplina> disciplinasOfertadas = disciplinasDao.recuperarDisciplinas();
        List<RegistroHistorico> disciplinasAprovadas = historicoDAO.recuperarRegistroDisciplinasAprovadas();
        List<Disciplina> disciplinasRestantes = new ArrayList<Disciplina>();

        disciplinasRestantes.addAll(disciplinasOfertadas);

        System.out.println("Disciplinas restantes da grade\n");

        //Remove as já concluídas
        for(Disciplina disciplina: disciplinasOfertadas){
            for(RegistroHistorico disciplinaAprovada: disciplinasAprovadas){
                if(disciplinaAprovada.getCodigoDisciplina().equals(disciplina.getCodigoDisciplina())){
                    disciplinasRestantes.remove(disciplina);
                }
            }
        }

        Collections.sort(disciplinasRestantes, (d1, d2) -> {
            return Integer.toString(d1.getPeriodoIdeal()).compareTo(Integer.toString(d2.getPeriodoIdeal()));
        });

        for(int i = 1; i < 10; i++){
            System.out.println("\n******************************************************************************************************************");
            if(i < 9){
                System.out.println(i + "o. Período\n");
            }
            else{
                System.out.println("Optativas\n");
            }
            
            for(Disciplina disciplina: disciplinasRestantes){
                if(i == disciplina.getPeriodoIdeal()){
                    System.out.println(disciplina.getCodigoDisciplina() + " - " + disciplina.getNomeDisciplina());
                }
            }
            
            System.out.println("******************************************************************************************************************\n");
        }
    }

    public void calcularNumeroDisciplinas(){
        int ira = 0;
    }
}
