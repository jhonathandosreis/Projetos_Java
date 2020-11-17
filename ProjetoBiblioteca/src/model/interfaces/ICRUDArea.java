/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;
import model.classes.Area;
import java.util.ArrayList;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public interface ICRUDArea {
    
    //DESCRIÇÃO DE METODOS
   void incluir(Area objeto)throws Exception;
   public ArrayList<Area> recuperar() throws Exception;
   void excluir(int id) throws Exception;
   void alterarArea(Area areaAntiga , Area areaAtual)throws Exception;
    
}
