/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.ArrayList;
import model.classes.Exemplar;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */

public interface ICRUDExemplar {
    
    //DESCRIÇÃO DE METODOS
    void incluir(Exemplar objeto) throws Exception;

    public ArrayList<Exemplar> recuperar() throws Exception;

    void excluir(int id) throws Exception;

    void alterar(Exemplar exemplarAntigo, Exemplar ExemplarNovo) throws Exception;
    
}
