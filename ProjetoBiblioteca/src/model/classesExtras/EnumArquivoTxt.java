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

public enum EnumArquivoTxt {

    AREADOLIVRO("AreaDoLivro.txt"),
    AUTOR("Autor.txt"),
    COLABORADOR("Colaborador.txt"),
    EDITORA("Editoras.txt"),
    EMPRESTIMO("Emprestimo.txt"),
    EXEMPLAR("Exemplar.txt"),
    LIVRO("Livro.txt"),
    RESERVA("Reserva.txt"),
    IDGERADO("IdGerado.txt");

    private String nomeDoArquivo;

    private static Map<String, EnumArquivoTxt> relations;

    EnumArquivoTxt(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public static EnumArquivoTxt getNomeDoArquivo(String nomeArquivo) {
        return relations.get(nomeArquivo);
    }
    
    //Bloco estatico que popula o hashmap com as relacoes entre tipo e
    //elementos da enum
    static {
        relations = new HashMap<String, EnumArquivoTxt>();
        for (EnumArquivoTxt nome : values()) {
            relations.put(nome.getNomeDoArquivo(), nome);
        }
    }
}
