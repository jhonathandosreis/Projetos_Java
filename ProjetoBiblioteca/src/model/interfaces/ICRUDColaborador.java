/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.ArrayList;
import model.classes.Colaborador;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public interface ICRUDColaborador {
    
     void incluir(Colaborador objeto)throws Exception;
    public ArrayList<Colaborador> recuperar()throws Exception;
    void excluir(int id)throws Exception;
    void alterar(Colaborador colaboradorAntigo, Colaborador colaboradorAtual)throws Exception;
}
