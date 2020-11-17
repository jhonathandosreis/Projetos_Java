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
public class OrdenadoPorSituacao_Nome extends AlunoPesistenciaTemplateMethod{

    public OrdenadoPorSituacao_Nome(String nome) {
        super(nome);
    }

    @Override
    public boolean ordenarObjetos(RelatorioAluno nome1, RelatorioAluno nome2) {
       if(nome1.getSituacao().compareToIgnoreCase(nome2.getSituacao()) <= 0 
          && nome1.getNome().compareToIgnoreCase(nome2.getNome()) <= 0) return true;
        else return false;
    }
    
}
