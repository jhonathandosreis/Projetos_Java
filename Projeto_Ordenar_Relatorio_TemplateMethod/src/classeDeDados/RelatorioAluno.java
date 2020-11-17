/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeDeDados;

/**
 *
 * @author miguelneto
 */
public class RelatorioAluno {

    //atributos
    private String nome = "";
    private String curso = "";
    private String situacao = "";
    private String enfase = "";

    //construtores
    public RelatorioAluno() {

    }

    public RelatorioAluno(String nome, String curso, String situacao, String enfase) {
        this.nome = nome;
        this.curso = curso;
        this.enfase = enfase;
        this.situacao = situacao;
    }

    public RelatorioAluno(String str) {
        String[] vetor = str.split(";");
        this.nome = vetor[0];
        this.curso = vetor[1];
        this.situacao = vetor[2];
        this.enfase = vetor[3];
        
    }

    //metodos
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the enfase
     */
    public String getEnfase() {
        return enfase;
    }

    /**
     * @param enfase the enfase to set
     */
    public void setEnfase(String enfase) {
        this.enfase = enfase;
    }

}
