/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.classesExtras.TipoDeStatus;
import model.controle.LivroControle;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Exemplar {

    //ATRIBUTOS
    private int id = 0;
    private Date anoDePublicacao = null;
    private Date dataDeAquisicao = null;
    private float precoDeCompra = 0;
    private TipoDeStatus tipoDeStatus = null;
    private String Descricao = "";
    private Livro livro = null;
    

    //CONSTRUTOR DEFAULT
    public Exemplar() {

    }

      //CONSTRUTOR COM PARAMETRO OBJETO
    public Exemplar(Exemplar exemplar){
        id = exemplar.id;
        livro = exemplar.livro;
    }
    
   
    //CONSTRUTOR PASSANDO PARAMETRO
    public Exemplar(Date anoDePublicacao, Date dataDeAquisicao, float precoDeCompra, int edicao,
            TipoDeStatus tipoDeStatus, String descricao, Livro livro) {
        this.anoDePublicacao = anoDePublicacao;
        this.dataDeAquisicao = dataDeAquisicao;
        this.precoDeCompra = precoDeCompra;
        this.tipoDeStatus = tipoDeStatus;
        this.Descricao = descricao;
        this.livro = livro;
    }

    //VETOR DE STRING PARA PERCORRER ATE ENCONTRAR O -> ;
    public Exemplar(String strDados) throws Exception {

        String vetorString[] = strDados.split(";");
        if (vetorString.length < 7) {
            throw new Exception("Faltam dados na String");
        }

        id = Integer.parseInt(vetorString[0]);
        anoDePublicacao = new SimpleDateFormat("dd/MM/yyyy").parse(vetorString[1]);
        precoDeCompra = Float.parseFloat(vetorString[2]);
        dataDeAquisicao = new SimpleDateFormat("dd/MM/yyyy").parse(vetorString[3]);
        Descricao = (vetorString[4]);
        livro = new LivroControle().recuperar(Integer.parseInt(vetorString[5]));
        tipoDeStatus = TipoDeStatus.getTipo(Integer.parseInt(vetorString[6]));

      
    }

  

   

    //METODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(Date anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public Date getDataDeAquisicao() {
        return dataDeAquisicao;
    }

    public void setDataDeAquisicao(Date dataDeAquisicao) {
        this.dataDeAquisicao = dataDeAquisicao;
    }

    public float getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(float precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public TipoDeStatus getTipoDeStatus() {
        return tipoDeStatus;
    }

    public void setTipoDeStatus(TipoDeStatus tipoDeStatus) {
        this.tipoDeStatus = tipoDeStatus;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    //USADO PARA SEPARAR POR ; OS DADOS INSERIDOS NO BANCO
    @Override
    public String toString() {

        String saida = id + ";";
        saida += new SimpleDateFormat("dd/MM/yyyy").format(anoDePublicacao) + ";";
        saida += precoDeCompra + ";";
        saida += new SimpleDateFormat("dd/MM/yyyy").format(dataDeAquisicao) + ";";
        saida += Descricao + ";";
        saida += livro.getId() + ";";
        saida += tipoDeStatus.getStatus() + ";";
        return saida;
        
         
    }
}
