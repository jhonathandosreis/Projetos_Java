package model.util;

import model.classesExtras.EnumArquivoTxt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author JHONATHAN
 */



    
   public class GeradorID {

    //ATRIBUTOS
    private int id = 0;
    private File arquivo = null;
    String nomeDoArquivo = EnumArquivoTxt.IDGERADO.getNomeDoArquivo();

    //METODOS
    public GeradorID() throws Exception {
        File arquivo = new File(nomeDoArquivo);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
            id = getProximoId();
            finalize();
        }

        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();

        if (linha == null) {
            id = getProximoId();
            finalize();
            linha = br.readLine();
        }
        id = Integer.parseInt(linha);
        br.close();
    }

    public int getId() {
        return ++id;
    }

    public void finalize() throws Exception {

        //CRIA O ARQUIVO
        FileWriter fw = new FileWriter(nomeDoArquivo, false);
        //CRIA O BUFFER DO ARQUIVO
        BufferedWriter bw = new BufferedWriter(fw);
        //ESCREVE NO ARQUIVO
        String saida = id + "";
        bw.write(saida);
        //FECHA O ARQUIVO
        bw.close();
    }

    private int getProximoId() throws Exception {

        try {
            int maior = 0;
            int numeroLido = 0;

            for (EnumArquivoTxt enumArquivo : EnumArquivoTxt.values()) {            // Para cada item do EnumArquivoTxt
                arquivo = new File(enumArquivo.getNomeDoArquivo());                 // Cria uma nova instncia de arquivo (File)
                if (arquivo.exists()) {                                             // Verifica se o arquivo do EnumArquivoTxt existe
                    FileReader fr = new FileReader(enumArquivo.getNomeDoArquivo()); // Se existir, abre um FileReader
                    
                    BufferedReader br = new BufferedReader(fr);
                    String linha = br.readLine();

                    while ((linha = br.readLine()) != null) {                       // Enquanto existirem linhas
                        // numeroLido RECEBE a primeira posicao da linha separada por split convertida para inteiro
                        numeroLido = Integer.parseInt(linha.split(";")[0]);         
                        if (numeroLido > maior) {                                   // Se o numeroLido for maior que o maior lido ate agora
                            maior = numeroLido;                                     // maior RECEBE o numeroLido
                        }
                    }

                    br.close();
                }
            }

            return maior;   //Retorna o maior nmero utilizado encontrado nos arquivos.
        } catch (Exception e) {

            throw new Exception("Não possível ler o arquivo " + arquivo.getCanonicalPath() + "\n" + e);
        }
    }

}