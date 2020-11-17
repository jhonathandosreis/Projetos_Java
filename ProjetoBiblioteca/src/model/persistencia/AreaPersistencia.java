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
import model.interfaces.ICRUDArea;

/**
 *
 * @author miguelneto
 */
public class AreaPersistencia implements ICRUDArea{
    
    //Atributos 
    private String nomeDoArquivoNoDisco = "";

    //METODOS
    public AreaPersistencia(String nomeArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeArquivoNoDisco;
    }
    

    @Override
    public void incluir(Area objeto) throws Exception {
      try {
            //GERA O ID QUANDO OS DADOS É INCLUIDO
            GeradorID idArea = new GeradorID();
            
            objeto.setId(idArea.getId());
            
            //Colocar os comandos para gravar no arquivo texto
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(objeto.toString() + "\n"); 
            bw.close();
            
            idArea.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Area> recuperar() throws Exception {
       try {

            ArrayList<Area> listaArea = new ArrayList<Area>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Area objetoArea = new Area(linha);
                listaArea.add(objetoArea);
            }
            br.close();

            return listaArea;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
     try {
            ArrayList<Area> listaAreas = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaAreas.size(); pos++) {
                Area aux = listaAreas.get(pos);
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
    public void alterarArea(Area areaAntiga, Area areaAtual) throws Exception {
    try {
            ArrayList<Area> listaArea = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaArea.size(); pos++) {
                Area aux = listaArea.get(pos);

                if (!areaAntiga.getNomeArea().equalsIgnoreCase(aux.getNomeArea())) {
                    bw.write(aux.toString() + "\n");
                } else {
                    bw.write(areaAtual.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}
