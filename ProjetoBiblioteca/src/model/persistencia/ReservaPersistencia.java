/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model.util.GeradorID;
import model.classes.Reserva;
import model.interfaces.ICRUDReserva;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public class ReservaPersistencia implements ICRUDReserva {

    //ATRIBUTOS
    private String nomeDoArquivoNoDisco = "";

    //CONSTRUTOR PASSANDO O PARAMETRO
    public ReservaPersistencia(String nomeDoArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeDoArquivoNoDisco;
    }

    //METODOS ABSTRATOS DA CLASSE MODEL.INTERFACES
    @Override
    public void incluir(Reserva objeto) throws Exception {
        try {
            //GERA O ID QUANDO OS DADOS É INCLUIDO
            GeradorID idReserva = new GeradorID();

            objeto.setId(idReserva.getId());

            //CRIA O ARQUIVO
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);

            //CRIA O BUFFER DO ARQUIVO
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(objeto.toString() + "\n");

            //FECHA O ARQUIVO
            bw.close();

            idReserva.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Reserva> recuperar() throws Exception {
        try {
            ArrayList<Reserva> listaDeReserva = new ArrayList<Reserva>();

            FileReader fr = new FileReader(nomeDoArquivoNoDisco);

            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Reserva objetoReserva = new Reserva(linha);
                listaDeReserva.add(objetoReserva);
            }
            br.close();

            return listaDeReserva;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<Reserva> listaDeReserva = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeReserva.size(); pos++) {
                Reserva aux = listaDeReserva.get(pos);
                if (id != aux.getId()) {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Reserva reservaAntiga, Reserva reservaNova) throws Exception {
        try {
            ArrayList<Reserva> listaDeReserva = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeReserva.size(); pos++) {

                Reserva aux = listaDeReserva.get(pos);

                if (reservaAntiga.getId() != (aux.getId())) { //PRECISA TESTAR
                    bw.write(aux.toString() + "\n");
                } else {
                    bw.write(reservaNova.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}
