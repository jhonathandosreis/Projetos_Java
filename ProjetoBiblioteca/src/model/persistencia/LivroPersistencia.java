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
import model.classes.Livro;
import model.interfaces.ICRUDLivro;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class LivroPersistencia implements ICRUDLivro {

   
    //Atributos 
    private String NomeDoArquivoNoDisco = "";

    //METODOS
    public LivroPersistencia(String nomeArquivoNoDisco) {
        this.NomeDoArquivoNoDisco = nomeArquivoNoDisco;
    }

    @Override
    public void incluir(Livro objeto) throws Exception {
        try {

            GeradorID idLivro = new GeradorID();

            objeto.setId(idLivro.getId());

            //Colocar os comandos para gravar no arquivo texto
            FileWriter fw = new FileWriter(NomeDoArquivoNoDisco, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(objeto.toString() + "\n");
            bw.close();
            idLivro.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Livro> recuperar() throws Exception {

        try {

            ArrayList<Livro> listaLivro = new ArrayList<Livro>();
            FileReader fr = new FileReader(NomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Livro objetoLivro = new Livro(linha);
                listaLivro.add(objetoLivro);
            }
            br.close();

            return listaLivro;
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void excluir(int id) throws Exception {

        try {
            ArrayList<Livro> listaLivro = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(NomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaLivro.size(); pos++) {
                Livro aux = listaLivro.get(pos);
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
    public void alterar(Livro livroAntiga, Livro livroAtual) throws Exception {

        try {
            ArrayList<Livro> listaLivro = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(NomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaLivro.size(); pos++) {
                Livro aux = listaLivro.get(pos);

                if (!livroAntiga.getTitulo().equalsIgnoreCase(aux.getTitulo())) {
                    bw.write(aux.toString() + "\n");
                } else {
                    bw.write(livroAtual.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

   
}
