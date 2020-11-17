/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Autor {
    
    
    //ATRIBUTOS
    private int id = 0;
    private String nomeAutor = "";
    
    
    //CONSTRUTOR DEFAULT
    
    public Autor() {

    }
    
    //CONSTRUTOR PASSANDO PARAMETRO
    public Autor(String nome, int id) {
        this.nomeAutor = nome;
        this.id = id;
    }

     //CONSTRUTOR PASSANDO OBJETO PARAMETRO
    public Autor(Autor autor) {
        id = autor.id;
        nomeAutor = autor.nomeAutor;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeAutor
     */
    public String getNomeAutor() {
        return nomeAutor;
    }

    /**
     * @param nomeAutor the nomeAutor to set
     */
    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
    
    //VETOR DE STRING PARA PERCORRER 
    public Autor(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 2) {
            throw new Exception("Faltam dados na String");
        }

        id = Integer.parseInt(vetorString[0]);
        nomeAutor = vetorString[1];

    }

    //SAIDA TXT 
    @Override
    public String toString() {

        String saida = id + ";";
        saida += nomeAutor + ";";
        return saida;

    }
    
}
