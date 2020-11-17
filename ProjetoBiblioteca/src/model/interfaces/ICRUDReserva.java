/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.ArrayList;
import model.classes.Reserva;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public interface ICRUDReserva {
    
    //DESCRIÇÃO DE METODOS
    void incluir(Reserva objeto) throws Exception;

    public ArrayList<Reserva> recuperar() throws Exception;

    void excluir(int id) throws Exception;

    void alterar(Reserva reservaAntiga, Reserva reservaAtual) throws Exception;
    
}
