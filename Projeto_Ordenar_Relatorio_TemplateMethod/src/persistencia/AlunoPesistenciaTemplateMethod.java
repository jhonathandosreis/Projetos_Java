/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classeDeDados.RelatorioAluno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author miguelneto
 */
public abstract class AlunoPesistenciaTemplateMethod {
    
    //atributos 
    private String nomeDoArquivo;
    
    //construtores 
   
    public AlunoPesistenciaTemplateMethod(String nome){
        nomeDoArquivo = nome;
    }
    
   //Metodo abstrato que ira compor o algoritmo de ordenacao da listagem
    public abstract boolean ordenarObjetos(RelatorioAluno nome1, RelatorioAluno nome2 );

    //public abstract boolean ePrimeiro(RelatorioAluno nome, RelatorioAluno curso, RelatorioAluno situacao, RelatorioAluno enfase);

     public ArrayList<RelatorioAluno> listagemDeRelatorio()throws Exception{ //esqueleto do codigo
        try{
            ArrayList<RelatorioAluno> array = new ArrayList<RelatorioAluno>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            int pos = 0;
            while((linha=br.readLine())!=null){
                RelatorioAluno aux = new RelatorioAluno(linha);
                array.add(aux);
                pos++;
            }
            br.close();
          
            //algoritmo de Ordenação bolha - BUBLESORT
            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {
                    
                    if (!ordenarObjetos(array.get(i),array.get(j))) {    //aplicacao TemplatMethod
                        RelatorioAluno temp = array.get(j);
                        array.set(j, array.get(i));
                        array.set(i, temp);
                    }
                }
            }
            return array;
        }catch(Exception erro){
            throw erro;
        } 
    }
    
    
}
