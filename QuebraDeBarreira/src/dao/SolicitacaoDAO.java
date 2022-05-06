package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class SolicitacaoDAO {
    
    public SolicitacaoDAO(){}

    //Recupera todas as disciplinas do pedido
    public List<Disciplina> recuperarDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("src/dao/solicitacao.csv"));
            disciplinas.addAll(extrairDados(br));
        }
        catch(Exception e){
            System.out.println("Erro ao recuperar solicitacao: " + e.getMessage());
        }
        
        return disciplinas;
    } 

    //Lẽ o arquivo e coloca os dados em uma lista de disciplinas
    private List<Disciplina> extrairDados(BufferedReader br){
        List<Disciplina> list = new ArrayList<Disciplina>();
        String str;
        int cont = 0;

        try{
            while ((str = br.readLine()) != null) {
                if(cont > 1){
                    String[] linha = str.split(",");
                    Disciplina disciplina = new Disciplina();     
                    int periodoIdeal = (!linha[6].equals("")) ? Integer.parseInt(linha[6]) : 9;
                    int horas = (!linha[7].equals("")) ? Integer.parseInt(linha[7]) : -1;
                    int cargaHoraria = (!linha[9].equals("")) ? Integer.parseInt(linha[9]) : -1;  
    
                    disciplina.setCodigoCurso(linha[0]);
                    disciplina.setVersaoCurso(linha[1]);
                    disciplina.setEstrutura(linha[2]);
                    disciplina.setCodigoDisciplina(linha[3]);
                    disciplina.setNomeUnidade(linha[4]);
                    disciplina.setNomeDisciplina(linha[5]);
                    disciplina.setTipo(linha[8]);
                    disciplina.setSituacao(linha[10]);
                    disciplina.setPeriodoIdeal(periodoIdeal);
                    disciplina.setCargaHoraria(cargaHoraria);
                    disciplina.setHoras(horas);

                    list.add(disciplina);
                }
                cont++;
            }

        }
        catch(Exception e){
            System.out.println("Erro ao extrair dados do pedido: ");
            e.printStackTrace();
        }

        return list;
    }
}
