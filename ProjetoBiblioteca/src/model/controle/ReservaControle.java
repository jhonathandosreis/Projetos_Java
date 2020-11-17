/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import model.classes.Reserva;
import model.interfaces.ICRUDReserva;
import model.persistencia.ReservaPersistencia;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public class ReservaControle implements ICRUDReserva {
private ICRUDReserva objeto = null;
//    EmprestimoControle controleEmprestimo = null;
//    ExemplarControle controleExemplar = null;
//    Exemplar ExemplarAntigo = null;
//    Exemplar ExemplarAtual = null;
    

    public ReservaControle() throws Exception {
       this.objeto = new ReservaControle(EnumArquivoTxt.RESERVA.getNomeDoArquivo());
    }
    
    public ReservaControle(String nomeDoArquivo) throws Exception {
        this.objeto = new ReservaPersistencia(nomeDoArquivo);
        
    }

    @Override
    public void incluir(Reserva objeto) throws Exception {
        
//            controleEmprestimo = new EmprestimoControle(EnumArquivoTxt.EMPRESTIMO.getNomeDoArquivo());
//            ArrayList<Emprestimo> listaEmprestimo = controleEmprestimo.recuperar();
//            for (Emprestimo emprestimo : listaEmprestimo) {
//              int dat =  objeto.getDataDaReserva().compareTo(emprestimo.getDataDevolucao());
//              if(dat >=0){
//           ExemplarAntigo = emprestimo.getExemplar();
//           ExemplarAtual = ExemplarAntigo;
//           ExemplarAtual.setTipoDeStatus(TipoDeStatus.RESERVADO);
//           controleExemplar.alterar(ExemplarAntigo, ExemplarAtual);
//            this.objeto.incluir(objeto);
//              }
//              else throw new Exception("Não Existe exemplares disponiveis para esta data");
//                  }
           
            
            
                    
          this.objeto.incluir(objeto);   
        
    }

    @Override
    public ArrayList<Reserva> recuperar() throws Exception {
        
        return this.objeto.recuperar();
    }
    
    public Reserva recuperar(int id) throws Exception {
        Reserva retorno = null;
        for (Reserva reserva : this.objeto.recuperar()) {
            if (reserva.getId() == id) {
                retorno = reserva;
            }
        }
        return retorno;
    }
    
    @Override
    public void excluir(int id) throws Exception {
        
        this.objeto.excluir(id);
    }

    @Override
    public void alterar(Reserva reservaAntiga, Reserva reservaNova) throws Exception {
       
        this.objeto.alterar(reservaAntiga, reservaNova);
    }
    
    
    
}
