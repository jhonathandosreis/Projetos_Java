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
import model.classes.Area;
import model.classes.Autor;
import model.interfaces.ICRUDAutor;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class AutorPersistencia implements ICRUDAutor{
    //Atributos 
    private String nomeDoArquivoNoDisco = "";

    //METODOS
    public AutorPersistencia(String nomeArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeArquivoNoDisco;
    }

    @Override
    public void incluir(Autor objeto) throws Exception {
        try {
            
            GeradorID idAutor = new GeradorID();
            
            objeto.setId(idAutor.getId());
            
            //Colocar os comandos para gravar no arquivo texto
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(objeto.toString() + "\n"); 
            bw.close();
            
            idAutor.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Autor> recuperar() throws Exception {
       
        try {

            ArrayList<Autor> listaDeAutor = new ArrayList<Autor>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Autor objetoAutor = new Autor(linha);
                listaDeAutor.add(objetoAutor);
            }
            br.close();

            return listaDeAutor;
        } catch (Exception erro) {
            throw erro;
          }
    }
    
    @Override
    public void excluir(int id) throws Exception {
     try {
            ArrayList<Autor> listaDeAutor = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

          for (int pos = 0; pos < listaDeAutor.size(); pos++) {
                Autor aux = listaDeAutor.get(pos);
                if (id != aux.getId()) {
                    bw.write(aux.toString() + "\n");
                }

            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }  }

    @Override
    public void alterarAutor(Autor autorAntiga, Autor autorAtual) throws Exception {
       

        try {
            ArrayList<Autor> listaDeAutor = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeAutor.size(); pos++) {
                Autor aux = listaDeAutor.get(pos);

                if (!autorAntiga.getNomeAutor().equalsIgnoreCase(aux.getNomeAutor())) {
                    bw.write(aux.toString() + "\n");
                } else {
                    bw.write(autorAtual.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }  }

   
}
