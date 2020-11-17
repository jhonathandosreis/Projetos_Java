/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import model.classesExtras.EnumArquivoTxt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model.util.GeradorID;
import model.classes.Colaborador;
import model.interfaces.ICRUDColaborador;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class ColaboradorPersistencia implements ICRUDColaborador {

    //ATRIBUTOS
    private String nomeDoArquivoNoDisco = "";

    //CONSTRUTORES
    public ColaboradorPersistencia() {

    }

    public ColaboradorPersistencia(String nomeDoArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeDoArquivoNoDisco;

    }

    @Override
    public void incluir(Colaborador objeto) throws Exception {
        try {

            GeradorID idColaborador = new GeradorID();

            objeto.setId(idColaborador.getId());

            //Colocar os comandos para gravar no arquivo texto
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true); // FileWriter serve para escrever diretamente no arquivo
            BufferedWriter bw = new BufferedWriter(fw); // cria um buffer para armazenar oque for escrito no arquivo
            bw.write(objeto.toString() + "\n"); //coloca fixa no buff 
            bw.close();

            idColaborador.finalize();

        } catch (Exception erro) {
           throw new Exception("Erro ao alterar o objeto no arquivo " + EnumArquivoTxt.COLABORADOR.getNomeDoArquivo() + "\n" + erro);
        }
    }

    @Override
    public ArrayList<Colaborador> recuperar() throws Exception {

        try {

            ArrayList<Colaborador> listaDeColaborador = new ArrayList<Colaborador>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";

            while ((linha = br.readLine()) != null) {

                Colaborador objetoColaborador = new Colaborador(linha);

                listaDeColaborador.add(objetoColaborador);

            }

            br.close();

            return listaDeColaborador;

        } catch (Exception erro) {
           
          throw new Exception("Erro ao alterar o objeto no arquivo " + EnumArquivoTxt.COLABORADOR.getNomeDoArquivo() + "\n" + erro);
        }

    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<Colaborador> listaDeColaborador = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeColaborador.size(); pos++) {
                Colaborador aux = listaDeColaborador.get(pos);
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
    public void alterar(Colaborador colaboradorAntigo, Colaborador colaboradorAtual) throws Exception {
        
        try {
            ArrayList<Colaborador> listaDeColaborador = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeColaborador.size(); pos++) {

                Colaborador aux = listaDeColaborador.get(pos);

                if (!colaboradorAntigo.getNome().equalsIgnoreCase(aux.getNome())) {
                    bw.write(aux.toString() + "\n");
                } else {
                    bw.write(colaboradorAtual.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw new Exception("Erro ao alterar o objeto no arquivo " + EnumArquivoTxt.COLABORADOR.getNomeDoArquivo() + "\n" + erro);
        }
    }

}
