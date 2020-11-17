/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.ArrayList;
import model.classes.Livro;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public interface ICRUDLivro {
    
    //DESCRIÇÃO DE METODOS
   void incluir(Livro objeto)throws Exception;
   public ArrayList<Livro> recuperar() throws Exception;
   void excluir(int id) throws Exception;
   void alterar(Livro livroAntiga , Livro livroAtual)throws Exception;
   
           
}
