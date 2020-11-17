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


public enum TipoDeColaborador {

    //ATRIBUTOS
    ADVOGADO(1), ESTAGIARIO(2), FUNCIONARIO(3);

    private static Map<Integer, TipoDeColaborador> listaChave;
    private int tipo;

    //CONSTRUTOR PASSANDO PARAMETRO
    private TipoDeColaborador(int tipo) {
        this.tipo = tipo;

    }

    //METODOS
    public int getTipo() {
        return tipo;
    }

    public static TipoDeColaborador getTipo(int tipo) {
        return listaChave.get(tipo);
    }

     //Bloco estatico que popula o hashmap com as relacoes entre tipo e elementos da enum
    static {
        listaChave = new HashMap<Integer, TipoDeColaborador>();
        for (TipoDeColaborador tc : values()) {
            listaChave.put(tc.getTipo(), tc);
        }

    }
}
