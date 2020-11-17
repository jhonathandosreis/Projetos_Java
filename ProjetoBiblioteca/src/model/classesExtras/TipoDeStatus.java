/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classesExtras;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */

public enum TipoDeStatus {
    
    //ATRIBUTOS
     ATIVO(1), INATIVO(2), PENDENTE(3), EMPRESTADO(4), RESERVADO(5), DISPONIVEL(6), FINALIZADO(7);
    
    private static Map<Integer, TipoDeStatus> relations;
    
    private int status;
    
    TipoDeStatus(int status){
        this.status = status;        
    }
    public int getStatus(){
       return status; 
    }
    
    public static TipoDeStatus getTipo(int status) {
        return relations.get(status);
    }

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e
     * elementos da enum
     */
    static {
        relations = new HashMap<Integer, TipoDeStatus>();
        for (TipoDeStatus tipostatus : values()) {
            relations.put(tipostatus.getStatus(), tipostatus);
        }
    }
    
}
