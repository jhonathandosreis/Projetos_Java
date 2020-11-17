/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import model.classesExtras.EnumCDD;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Area {
    
    //ATRIBUTOS
    private int id = 0;
    private String nomeArea = "";
    private EnumCDD cdd = null;

    //CONSTRUTOR DEFAULT
    public Area() {

    }

    //CONSTRUTOR PASSANDO PARAMETRO
    public Area(String nome, int id, EnumCDD cdd) {
        this.nomeArea = nome;
        this.id = id;
        this.cdd = cdd;
    }
    
   
     //CONSTRUTOR PASSANDO OBJETO PARAMETRO
    
    public void setCdd(EnumCDD cdd) {
        this.cdd = cdd;
    }
    
    public EnumCDD getCdd() {
        return cdd;
    }

    public Area(Area area) {
        id = area.id;
        nomeArea = area.nomeArea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

  
    
    //VETOR DE STRING PARA PERCORRER 
    public Area(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 3) {
            throw new Exception("Faltam dados na String");
        }

        id = Integer.parseInt(vetorString[0]);
        nomeArea = vetorString[1];
cdd = EnumCDD.getTipo(vetorString[2]);
    }

    //SAIDA TXT 
    @Override
    public String toString() {

        String saida = id + ";";
        saida += nomeArea + ";";
         saida += cdd.getTipo() + ";";
        return saida;

    }
    
    
    
}
