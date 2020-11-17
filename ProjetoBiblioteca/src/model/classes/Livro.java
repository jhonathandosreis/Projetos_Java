/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import model.controle.AreaControle;
import model.controle.AutorControle;
import model.controle.EditoraControle;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Livro {

    //ATRIBUTOS
    private int id = 0;
    private String titulo = "";
    private int isbn = 0;
    private String anoDePublicacao = null;
    private String edicao = "";
    private String descricao = "";
    private Editora editora = null;
    private Autor autor = null;
    private Area areaDoLivro = null;

    //CONSTRUTOR DEFAULT
    public Livro() {

    }

  
    //CONSTRUTOR PASSANDO PARAMETROS
    public Livro(int id, String titulo, int isbn, String anoDePublicacao, String edicao, String descricao, 
            Editora editora, Autor nomeAutor, Area nomeAreaDoLivro) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoDePublicacao = anoDePublicacao;
        this.edicao = edicao;
        this.descricao = descricao;
        this.editora = editora;
        this.autor = nomeAutor;
        this.areaDoLivro = nomeAreaDoLivro;
    }
    
    //CONSTRUTOR PASSANDO OBJETO PARAMETRO
    public Livro(Livro livro) {
        id = livro.id;
        titulo = livro.titulo;
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the anoDePublicacao
     */
    public String getAnoDePublicacao() {
        return anoDePublicacao;
    }

    /**
     * @param anoDePublicacao the anoDePublicacao to set
     */
    public void setAnoDePublicacao(String anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    
    /**
     * @return the edicao
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the editora
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the areaDoLivro
     */
    public Area getAreaDoLivro() {
        return areaDoLivro;
    }

    /**
     * @param areaDoLivro the areaDoLivro to set
     */
    public void setAreaDoLivro(Area areaDoLivro) {
        this.areaDoLivro = areaDoLivro;
    }
    
    
   
    
    
     public Livro(String strDados)throws Exception { 
        
        String vetorString[] = strDados.split(";");
        if(vetorString.length < 9)throw new Exception("Faltam dados na String");
        id = Integer.parseInt(vetorString[0]);
        titulo = (vetorString[1]);
        isbn = Integer.parseInt(vetorString[2]);
        anoDePublicacao = (vetorString[3]);
        edicao = (vetorString[4]);
        descricao = (vetorString[5]);
        editora = new EditoraControle().recuperar(Integer.parseInt(vetorString[6])); 
        autor = new AutorControle().recuperar(Integer.parseInt(vetorString[7]));      
        areaDoLivro = new AreaControle().recuperar(Integer.parseInt(vetorString[8]));     
       
    }


     @Override
    public String toString(){
        
        String saida = id + ";";
        saida += titulo + ";";
        saida += isbn + ";";
        saida += anoDePublicacao + ";";
        saida += edicao + ";";
        saida += descricao + ";";
        saida += editora.getId() + ";";  
        saida += autor.getId() + ";";
        saida += areaDoLivro.getId() + ";";

        return saida;
    }   

   
}

   