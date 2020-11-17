/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.ArrayList;
import model.classes.Autor;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public interface ICRUDAutor {
    
    //DESCRIÇÃO DE METODOS
   void incluir(Autor objeto)throws Exception;
   public ArrayList<Autor> recuperar() throws Exception;
   void excluir(int id) throws Exception;
   void alterarAutor(Autor autorAntiga , Autor autorAltual)throws Exception;
    
}
