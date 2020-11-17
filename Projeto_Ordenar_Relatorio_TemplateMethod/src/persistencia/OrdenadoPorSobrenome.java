/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classeDeDados.RelatorioAluno;

/**
 *
 * @author miguelneto
 */
public class OrdenadoPorSobrenome extends AlunoPesistenciaTemplateMethod{

    public OrdenadoPorSobrenome(String nome) {
        super(nome);
    }

    @Override
    public boolean ordenarObjetos(RelatorioAluno nome1, RelatorioAluno nome2) {
        String primeironome = nome1.getNome();
        String segundonome = nome2.getNome();

        if(pegarsobrenome(primeironome).compareToIgnoreCase(pegarsobrenome(segundonome)) <= 0) return true;
        else return false;
    }
    
  
    
    public static String pegarsobrenome (String nome1){
        
    String sobrenome="";
    String nomeCompleto1 = nome1; 
    boolean ultimonomeinvalido = true;
    int qtdnome1 = nomeCompleto1.trim().split(" ").length; // define qual quantos nomes tem separando por espaço (trim) para retirar espaços no inicio e fim 
    
        if( !nomeCompleto1.split(" ")[qtdnome1-1].toUpperCase().equals("JUNIOR") && 
            !nomeCompleto1.split(" ")[qtdnome1-1].toUpperCase().equals("NETO")   &&  // se o ultimo nome não for nenhum desses atribui sobrenome ao ultimo nome e muda a booleana pra false
            !nomeCompleto1.split(" ")[qtdnome1-1].toUpperCase().equals("FILHO")  ){
            ultimonomeinvalido = false;
            sobrenome = nomeCompleto1.split(" ")[qtdnome1-1]; 
        }
        else sobrenome = nomeCompleto1.split(" ")[qtdnome1-2];  // se for um dos nomes invalidos para sobrenome atribui o antepenultimo para sobrenome
    
    String nomeFormatado = sobrenome+", ";
        if(ultimonomeinvalido){
            for(int i = 0 ; i < qtdnome1-2; i++){
                nomeFormatado += nomeCompleto1.split(" ")[i]+" ";
            }
            nomeFormatado += nomeCompleto1.split(" ")[qtdnome1-1];
        }
        else {
            for(int i = 0 ; i < qtdnome1-1; i++){
                nomeFormatado += nomeCompleto1.split(" ")[i]+" ";
            }
        }
        
        return nomeFormatado;
    
   }
    
}

      