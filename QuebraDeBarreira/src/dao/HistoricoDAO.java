package dao;

import java.io.*;
import java.util.*;

import model.Aluno;
import model.Curso;
import model.RegistroHistorico;

public class HistoricoDAO{

    public HistoricoDAO(){}

    public List<RegistroHistorico> recuperarHistorico(){   
        List<RegistroHistorico> historico = new ArrayList<RegistroHistorico>();

        try (BufferedReader br = new BufferedReader(new FileReader("dao/historico.csv"))) {
            String str;
            int cont = 0;
            while ((str = br.readLine()) != null) {
                if(cont > 1){
                    String[] linha = str.split(";");
                    RegistroHistorico registro = new RegistroHistorico();    
                    int mediaFinal = (linha[6].equals("")) ? -1 : Integer.parseInt(linha[6]);          

                    registro.setAluno(new Aluno(linha[1], linha[0]));
                    registro.setCurso(new Curso(linha[2], linha[3], Integer.parseInt(linha[4])));
                    registro.setCodigoDisciplina(linha[10]);
                    registro.setNomeDisciplina(linha[11]);
                    registro.setDescricaoDisciplina(linha[13]);
                    registro.setCargaHorariaDisciplina(Integer.parseInt(linha[12]));
                    registro.setAno(Integer.parseInt(linha[5]));
                    registro.setMediaFinal(mediaFinal);
                    registro.setSituacaoItem(Integer.parseInt(linha[7]));
                    registro.setPeriodo(linha[8]);
                    registro.setSituacao(linha[9]);
                    registro.setSigla(linha[15]);
                    registro.setFrequancia((linha[14].equals("")) ? -1 : Integer.parseInt(linha[14]));
                    historico.add(registro);
                }
                cont++;
            }
            String teste = historico.get(0).getNomeDisciplina() +
                    " / " + historico.get(0).getCodigoDisciplina(); // +
                    // " / " historico.get(0).getNomeDisciplina() +
                    // " / " historico.get(0).getNomeDisciplina() +
                    // " / " historico.get(0).getNomeDisciplina();
            System.out.println(teste);            
        }
        catch(Exception e){
            System.out.println("Erro ao ler o arquivo: " + e);
        }

        return historico;        
    }

    public List<RegistroHistorico> recuperarRegistroDisciplinasAprovadas(){
        HistoricoDAO historicoDAO = new HistoricoDAO();
        List<RegistroHistorico> historico = historicoDAO.recuperarHistorico();
        List<RegistroHistorico> disciplinasCursadas = new ArrayList<RegistroHistorico>();

        for(RegistroHistorico disciplina: historico){
             if(disciplina.getSituacao().equals("Aprovado")){
                disciplinasCursadas.add(disciplina);
            }
        }
        return disciplinasCursadas;
    } 

    public List<RegistroHistorico> recuperarDisciplinasPeriodo(String ano, String periodo){
        List<RegistroHistorico> historico = recuperarHistorico();
        List<RegistroHistorico> list = new ArrayList<RegistroHistorico>();

        for(RegistroHistorico registro: historico){
            if(Integer.toString(registro.getAno()).equals(ano) && periodo.equals(registro.getPeriodo())){
                list.add(registro);
            }
        }

        return list;
    }

}