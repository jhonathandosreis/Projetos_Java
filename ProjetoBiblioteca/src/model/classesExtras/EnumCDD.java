/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classesExtras;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miguelneto
 */
public enum EnumCDD {
    
     //ATRIBUTOS
    DIREITO("340"),
    DIREITO_PUBLICO("341"),
    DIREITO_INTERNACIONALPÚBLICO("341.1"),
    DIREITO_PENAL_INTERNACIONAL("341.14"),
    DIREITO_CONSTITUCIONAL("341.2"),
    DIREITOS_FUNDAMENTAIS("341.27"),
    DIREITO_ELEITORAL("341.28"),
    DIREITO_ADMINISTRATIVO("341.3"),
    DIREITO_AMBIENTAL("341.347"),
    DIREITO_ECONÔMICO("341.378"),
    DIREITO_FINANCEIRO("341.38"),
    DIREITO_TRIBUTÁRIO("341.39"),
    DIREITO_PROCESSUAL("341.4"),
    DIREITO_PROCESSUAL_PENAL("341.43"),
    DIREITO_PROCESSUAL_CIVIL("341.46"),
    DIREITO_PENAL("341.5"),
    DIREITO_PENITENCIÁRIO_DIREITO_DE_EXECUÇÕES_PENAIS("341.58"),
    DIREITO_PREVIDENCIÁRIO_SEGURIDADE_SOCIAL("341.6"),
    DIREITO_MILITAR("341.7"),
    DIREITO_PENAL_MILITAR("341.75"),
    DIREITO_AÉREO_CÓDIGO_DO_AR("341.8"),
    DIREITO_AÉREO_MILITAR("341.87"),
    DIREITO_APLICADO_À_TELECOMUNICAÇÃO("341.88"),
    DIREITO_ESPACIAL("341.89"),
    DIREITO_PRIVADO("342"),
    DIREITO_CIVIL("342.1"),
    DIREITO_DAS_COISAS_DIREITOS_REAIS_COISAS_E_BENS("342.12"),
    DIREITO_DE_FAMÍLIA("342.16"),
    DIREITO_DAS_SUCESSÕES("342.165"),
    DIREITO_DO_MENOR("342.17"),
    DIREITO_COMERCIAL("342.2"),
    DIREITO_BANCÁRIO("342.234"),
    DIREITOS_INTELECTUAIS_PROPRIEDADE_INDUSTRIAL("342.27"),
    DIREITO_AUTORAL_DIREITO_ARTÍSTICO_E_LITERÁRIO("342.28"),
    DIREITO_MARÍTIMO("342.29"),
    DIREITO_AERONÁUTICO("342.299"),
    DIREITO_INTERNACIONAL_PRIVADO("342.3"),
    DIREITO_DO_CONSUMIDOR("342.5"),
    DIREITO_DO_TRABALHO("342.6"),
    DIREITO_PROCESSUAL_DO_TRABALHO("342.68");

    private static Map<String, EnumCDD> relations;

    private String tipo;

    //CONSTRUTOR PASSANDO PARAMETRO
    EnumCDD(String tipo) {
        this.tipo = tipo;
    }

    //METODOS
    public String getTipo() {
        return tipo;
    }

    public static EnumCDD getTipo(String tipo) {
        return relations.get(tipo);
    }

    //Bloco estatico que popula o hashmap com as relacoes entre tipo e
    //elementos da enum
    static {
        relations = new HashMap<String, EnumCDD>();
        for (EnumCDD cdd : values()) {
            relations.put(cdd.getTipo(), cdd);
        }
    }
    
}
