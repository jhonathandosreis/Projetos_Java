package model.classes;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Editora {

    //ATRIBUTOS
    private int id = 0;
    private String nomeEditora = "";

    //CONSTRUTOR DEFAULT
    public Editora() {

    }

    //CONSTRUTOR PASSANDO PARAMETRO
    public Editora(String nome, int id) {
        this.nomeEditora = nome;
        this.id = id;
    }

    
     //CONSTRUTOR PASSANDO OBJETO PARAMETRO
    public Editora(Editora editora) {
        id = editora.id;
        nomeEditora = editora.nomeEditora;
    }

    /**
     * @return the id
     */
    public int getId() {

        return id;

    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nomeEditora;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nomeEditora = nome;
    }

    //VETOR DE STRING PARA PERCORRER 
    public Editora(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 2) {
            throw new Exception("Faltam dados na String");
        }

        id = Integer.parseInt(vetorString[0]);
        nomeEditora = vetorString[1];

    }

    //SAIDA TXT 
    @Override
    public String toString() {

        String saida = id + ";";
        saida += nomeEditora + ";";
        return saida;

    }
}
