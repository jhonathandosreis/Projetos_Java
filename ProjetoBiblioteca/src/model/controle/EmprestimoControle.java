/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import model.classes.Emprestimo;
import model.interfaces.ICRUDEmprestimo;
import model.persistencia.EmprestimoPersistencia;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public class EmprestimoControle implements ICRUDEmprestimo{

   private ICRUDEmprestimo objeto = null;
    
    public EmprestimoControle() throws Exception {
        this.objeto = new EmprestimoControle(EnumArquivoTxt.EMPRESTIMO.getNomeDoArquivo());
    }
    
    public EmprestimoControle(String nomeDoArquivo) throws Exception {
        this.objeto = new EmprestimoPersistencia(nomeDoArquivo);
        
    }
    
    @Override
    public void incluir(Emprestimo objeto) throws Exception {
        
        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Emprestimo> recuperar() throws Exception {
        
        return this.objeto.recuperar();
    }
    
    public Emprestimo recuperar(int id) throws Exception {
        Emprestimo retorno = null;
        for (Emprestimo emprestimo : this.objeto.recuperar()) {
            if (emprestimo.getId() == id) {
                retorno = emprestimo;
            }
        }
        return retorno;
    }

    
    @Override
    public void excluir(int id) throws Exception {
        
        this.objeto.excluir(id);
    }

    @Override
    public void alterar(Emprestimo emprestimoAntigo, Emprestimo emprestimoAtual) throws Exception {
//        if(emprestimoAtual.getExemplar().getId() != emprestimoAntigo.getExemplar().getId()){
//            throw new Exception("Não pode alterar campo exemplar!");
//        }
        
        this.objeto.alterar(emprestimoAntigo, emprestimoAtual);
    } 
    
}
