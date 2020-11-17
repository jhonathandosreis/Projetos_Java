/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import model.controle.ExemplarControle;
import model.controle.LivroControle;
import model.controle.ColaboradorControle;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.classesExtras.TipoDeStatus;


/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Emprestimo {

    //ATRIBUTOS
    private int id = 0;
    private Date dataEmprestimo = null;
    private Colaborador nomeColaborador = null;
    private Exemplar exemplar = null;
    private Livro livro = null;
    private TipoDeStatus status = null;

    //CONSTRUTOR PADRÃO
    public Emprestimo() {

    }
    

    public Emprestimo(Emprestimo emprestimo) {
        id = emprestimo.id;
       
    }
     

    //CONSTRUTOR PASSANDO PARAMETRO
    public Emprestimo(int id, Date dataEmprestimo, Livro livro, Exemplar exemplar,Colaborador nomeColaborador, TipoDeStatus status) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.nomeColaborador = nomeColaborador;
        this.exemplar = exemplar;
        this.livro = livro;
        this.status = status;
    }

    //VETOR DE STRING PARA PERCORRER ATE ENCONTRAR O -> ;
    public Emprestimo(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 6) {
            throw new Exception("Faltam dados na String");
        }
        id = Integer.parseInt(vetorString[0]);
        livro = new LivroControle().recuperar(Integer.parseInt(vetorString[1]));
        exemplar = new ExemplarControle().recuperar(Integer.parseInt(vetorString[2]));
        nomeColaborador = new  ColaboradorControle().recuperar(Integer.parseInt(vetorString[3]));
        dataEmprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(vetorString[4]);
        status = TipoDeStatus.getTipo(Integer.parseInt(vetorString[5]));

    }

    
    //METODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }


    public Exemplar getExemplar() {
        return exemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
     
    public Colaborador getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(Colaborador nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }
     public TipoDeStatus getStatus() {
        return status;
    }

   
    public void setStatus(TipoDeStatus status) {
        this.status = status;
    }
    

    //USADO PARA SEPARAR POR ; OS DADOS INSERIDOS NO BANCO
    @Override
    public String toString() {

        String saida = id + ";";
        saida += livro.getId() + ";";
        saida += exemplar.getId() + ";";
        saida += nomeColaborador.getId() + ";";
        saida += new SimpleDateFormat("dd/MM/yyyy").format(dataEmprestimo) + ";";
        saida += status.getStatus() + ";";
     
        return saida;
    }

   

  

   
}
