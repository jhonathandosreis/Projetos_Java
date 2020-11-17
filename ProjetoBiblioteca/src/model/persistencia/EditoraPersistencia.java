package model.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model.classes.Editora;
import model.interfaces.ICRUDEditora;
import model.util.GeradorID;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class EditoraPersistencia implements ICRUDEditora {

    //Atributos 
    private String nomeDoArquivoNoDisco = "";

    //METODOS
    public EditoraPersistencia(String nomeArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeArquivoNoDisco;
    }

    @Override
    public void incluir(Editora objeto) throws Exception {
        try {
            
            GeradorID idEditora = new GeradorID();
            
            objeto.setId(idEditora.getId());
            
            //Colocar os comandos para gravar no arquivo texto
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(objeto.toString() + "\n"); 
            bw.close();
            
            idEditora.finalize();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<Editora> recuperar() throws Exception {
        try {

            ArrayList<Editora> listaDeEditora = new ArrayList<Editora>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while ((linha = br.readLine()) != null) {
                Editora objetoEditora = new Editora(linha);
                listaDeEditora.add(objetoEditora);
            }
            br.close();

            return listaDeEditora;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(int id) throws Exception {
       

        try {
            ArrayList<Editora> listaDeEditora = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeEditora.size(); pos++) {
                Editora aux = listaDeEditora.get(pos);
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
    public void alterarEditora(Editora editoraAntiga, Editora editoraAtual) throws Exception {

        try {
            ArrayList<Editora> listaDeEditora = recuperar();
            //cria o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);

            // criar o buffer do arquivo     
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < listaDeEditora.size(); pos++) {
                Editora aux = listaDeEditora.get(pos);

                if (!editoraAntiga.getNome().equalsIgnoreCase(aux.getNome())) {
                    bw.write(aux.toString() + "\n");
                } else {
                    bw.write(editoraAtual.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

}
