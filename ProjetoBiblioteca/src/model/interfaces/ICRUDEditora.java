
package model.interfaces;
import java.util.ArrayList;
import model.classes.Editora;
/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public interface ICRUDEditora {
   
   //DESCRIÇÃO DE METODOS
   void incluir(Editora objeto)throws Exception;
   public ArrayList<Editora> recuperar() throws Exception;
   void excluir(int id) throws Exception;
   void alterarEditora(Editora editoraAntiga , Editora editoraAtual)throws Exception;
    
}
