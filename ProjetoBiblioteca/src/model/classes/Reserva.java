/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import model.controle.ColaboradorControle;
import model.controle.LivroControle;
import model.controle.ExemplarControle;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public class Reserva {
        //ATRIBUTOS
    private int id = 0;
    private Date dataDaReserva = null;
    private String descricao = "";
    private Colaborador colaborador = null;
    private Livro livro = null;
    private Exemplar exemplar = null;
    
    
    //CONSTRUTOR DEFAULT
    public Reserva() {
        
    }   
    
    public Reserva(Reserva reserva) {
        id = reserva.id;
       
    }
    //CONSTRUTOR PASSANDO PARAMETRO
    public Reserva(int id, String descricao, Date dataDaReserva, Colaborador colaborador, Livro livro, Exemplar exemplar) {
        
        //ATRIBUTOS
        this.id = id;
        this.descricao = descricao;
        this.dataDaReserva = dataDaReserva;
        this.colaborador = colaborador;
        this.livro = livro;
        this.exemplar = exemplar;
    }
    
    //VETOR DE STRING PARA PERCORRER ATE ENCONTRAR O -> ;
     public Reserva(String strDados)throws Exception { 
        String vetorString[] = strDados.split(";");
        if(vetorString.length < 6)throw new Exception("Faltam dados na String");
        id = Integer.parseInt(vetorString[0]);
        dataDaReserva = new SimpleDateFormat("dd/MM/yyyy").parse(vetorString[1]);
        descricao = vetorString[2];
       colaborador = new ColaboradorControle().recuperar(Integer.parseInt(vetorString[3]));
        livro = new LivroControle().recuperar(Integer.parseInt(vetorString[4]));
        exemplar = new ExemplarControle().recuperar(Integer.parseInt(vetorString[5]));
        
    }   
    //METODOS
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDaReserva() {
        return dataDaReserva;
    }

    public void setDataDaReserva(Date dataDaReserva) {
        this.dataDaReserva = dataDaReserva;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    
    public Exemplar getExemplar() {
        return exemplar;
    }

    
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    
    //USADO PARA SEPARAR POR ; OS DADOS INSERIDOS NO BANCO
    @Override
    public String toString() {

        String saida = id + ";";
        saida += new SimpleDateFormat("dd/MM/yyyy").format(dataDaReserva) + ";";
        saida += descricao + ";";
        saida += colaborador.getId() + ";";
        saida += livro.getId() + ";";
        saida+= exemplar.getId() + ";";
        return saida;
    }

    
}
