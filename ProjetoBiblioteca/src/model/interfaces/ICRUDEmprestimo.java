/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.ArrayList;
import model.classes.Emprestimo;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public interface ICRUDEmprestimo {
    
    //DESCRIÇÃO DE METODOS
    void incluir(Emprestimo objeto) throws Exception;

    public ArrayList<Emprestimo> recuperar() throws Exception;

    void excluir(int id) throws Exception;

    void alterar(Emprestimo emprestimoAntigo, Emprestimo emprestimoAtual) throws Exception;
    
}
