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
import model.classes.Emprestimo;
import model.interfaces.ICRUDEmprestimo;

/**
 * @author GUSTAVO
 * 
 * @author JHONATHAN
 * 
 * @author MIGUEL
 */
public class EmprestimoPersistencia implements ICRUDEmprestimo{

   //ATRIBUTOS
    private String nomeDoArquivoNoDisco = "";

    //Metodos
    public EmprestimoPersistencia(String nomeDoArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeDoArquivoNoDisco;
    }

    @Override
    public void incluir(Emprestimo objeto) throws Exception {
        try {
            //GERA O ID QUANDO OS DADOS É INCLUIDO
            GeradorID idEmprestimo = new GeradorID();

            objeto.setId(idEmprestimo.getId());

            //CRIA O ARQUIVO
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);

            //CRIA O BUFFER DO ARQUIVO
            BufferedWriter bw = new BufferedWriter(fw);

            //ESCREVE NO ARQUIVO
            bw.write(objeto.toString() + "\n");

            //FECHA O ARQUIVO
            bw.close();

            idEmprestimo.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Emprestimo> recuperar() throws Exception {
        try {
            ArrayList<Emprestimo> listaDeEmprestimo = new ArrayList<Emprestimo>();

            FileReader fr = new FileReader(nomeDoArquivoNoDisco);

            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Emprestimo objetoEmprestimo = new Emprestimo(linha);
                listaDeEmprestimo.add(objetoEmprestimo);
            }
            br.close();

            return listaDeEmprestimo;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            ArrayList<Emprestimo> listaDeEmprestimo = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeEmprestimo.size(); pos++) {
                Emprestimo aux = listaDeEmprestimo.get(pos);
                if (id != aux.getId()) { //PRECISA TESTAR
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Emprestimo emprestimoAntigo, Emprestimo emprestimoAtual) throws Exception {
        try {
            ArrayList<Emprestimo> listaDeEmprestimo = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeEmprestimo.size(); pos++) {

                Emprestimo aux = listaDeEmprestimo.get(pos);

                if (emprestimoAntigo.getId() != (aux.getId())) { //PRECISA TESTAR if (!editoraAntiga.getNome().equalsIgnoreCase(aux.getNome())) {
                    bw.write(aux.toString() + "\n");

                } else {
                    bw.write(emprestimoAtual.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
}
