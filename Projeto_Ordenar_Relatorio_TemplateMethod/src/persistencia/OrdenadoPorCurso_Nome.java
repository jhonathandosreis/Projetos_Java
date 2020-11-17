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
public class OrdenadoPorCurso_Nome extends AlunoPesistenciaTemplateMethod {

    public OrdenadoPorCurso_Nome(String nome) {
        super(nome);

    }

    @Override
    public boolean ordenarObjetos(RelatorioAluno curso1, RelatorioAluno curso2) {
        if (curso1.getCurso().compareToIgnoreCase(curso2.getCurso()) <= 0 && curso1.getNome().compareToIgnoreCase(curso2.getNome()) <= 0)return true;
        else return false;
        
    }

}
