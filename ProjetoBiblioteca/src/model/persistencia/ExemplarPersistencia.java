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
import model.classes.Exemplar;
import model.interfaces.ICRUDExemplar;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public class ExemplarPersistencia implements ICRUDExemplar{

   //ATRIBUTOS
    private String nomeDoArquivoNoDisco = "";

    //CONSTRUTOR PASSANDO O PARAMETRO
    public ExemplarPersistencia(String nomeDoArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeDoArquivoNoDisco;
    }

    //METODOS ABSTRATOS DA MODEL.INTERFACE
    @Override
    public void incluir(Exemplar objeto) throws Exception {

        try {
            //GERA O ID QUANDO OS DADOS SÃO INCLUIDO
            GeradorID idExemplar = new GeradorID();
            int x = idExemplar.getId();

            objeto.setId(x);

            //CRIA O ARQUIVO
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);

            //CRIA O BUFFER DO ARQUIVO
            BufferedWriter bw = new BufferedWriter(fw);

            //ESCREVE NO ARQUIVO
            bw.write(objeto.toString() + "\n");

            //FECHA O ARQUIVO
            bw.close();

            idExemplar.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Exemplar> recuperar() throws Exception {
        try {
            ArrayList<Exemplar> listaDeExemplar = new ArrayList<Exemplar>();

            FileReader fr = new FileReader(nomeDoArquivoNoDisco);

            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Exemplar objetoExemplar = new Exemplar(linha);
                listaDeExemplar.add(objetoExemplar);
            }

            br.close();

            return listaDeExemplar;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<Exemplar> listaDeExemplar = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeExemplar.size(); pos++) {
                Exemplar aux = listaDeExemplar.get(pos);
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
    public void alterar(Exemplar exemplarAntigo, Exemplar ExemplarNovo) throws Exception {
        try {
            ArrayList<Exemplar> listaDeExemplar = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeExemplar.size(); pos++) {

                Exemplar aux = listaDeExemplar.get(pos);

                if (exemplarAntigo.getId() != (aux.getId())) {
                    bw.write(aux.toString() + "\n"); //PRECISA TESTAR
                } else {
                    bw.write(ExemplarNovo.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}
