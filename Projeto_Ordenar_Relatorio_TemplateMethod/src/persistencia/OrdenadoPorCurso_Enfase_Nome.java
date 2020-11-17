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
public class OrdenadoPorCurso_Enfase_Nome extends AlunoPesistenciaTemplateMethod{

    public OrdenadoPorCurso_Enfase_Nome(String nome) {
        super(nome);
    }

    @Override
    public boolean ordenarObjetos(RelatorioAluno nome1, RelatorioAluno nome2) {
        if (nome1.getCurso().equalsIgnoreCase(nome2.getCurso())) {
            if (nome1.getEnfase().equalsIgnoreCase(nome2.getEnfase())) {
                return nome1.getNome().compareToIgnoreCase(nome2.getNome()) <= 0;
            } else {
                return nome1.getEnfase().compareToIgnoreCase(nome2.getEnfase()) <= 0;
            }
        } else {
            return nome1.getCurso().compareToIgnoreCase(nome2.getCurso()) <= 0;
        }
    }
    }
    

