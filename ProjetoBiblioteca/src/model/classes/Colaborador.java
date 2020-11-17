
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import model.classesExtras.TipoDeColaborador;
import model.classesExtras.TipoDeStatus;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class Colaborador {

    //ATRIBUTOS
    private int id = 0;
    private String nome = "";
    private String OAB = "";
    private String estado = "";
    private String email = "";
    private int telefone = 0;
    private TipoDeColaborador tipoColaborador = null;
    private int matricula = 0;
    private TipoDeStatus tipoStatus = null;
    private float multa = 0;

    //CONSTRUTOR DEFAULT
    public Colaborador() {

    }
    
    //CONSTRUTOR PASSANDO OBJETO PARAMETRO
    public Colaborador(Colaborador colaborador) {
        id = colaborador.id;
        nome = colaborador.nome;
    }

    //CONSTRUTOR PASSANDO PARAMETROS
    public Colaborador(int id, int matricula, String nome, String OAB, String estado, String email, int telefone,float multa,
            TipoDeColaborador tipoColaborador, TipoDeStatus tipoStatus) {
        
        this.tipoColaborador = tipoColaborador;
        this.matricula = matricula;
        this.nome = nome;
        this.OAB = OAB;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
        this.tipoStatus = tipoStatus;
        this.multa = multa;
    }
    
    //VETOR DE STRING PARA PERCORRER ATE ENCONTRAR O -> ;
    public Colaborador(String strDados) throws Exception {

        String vetorString[] = strDados.split(";");

        if (vetorString.length < 10) {
            throw new Exception("Faltam dados na String");
        }

        id = Integer.parseInt(vetorString[0]);
        nome = vetorString[1];
        matricula = Integer.parseInt(vetorString[2]);
        email = vetorString[3];
        telefone = Integer.parseInt(vetorString[4]);
        tipoColaborador = TipoDeColaborador.getTipo(Integer.parseInt(vetorString[5]));
        OAB = vetorString[6];
        estado = vetorString[7];
        tipoStatus = TipoDeStatus.getTipo(Integer.parseInt(vetorString[8]));
        multa = Float.parseFloat(vetorString[9]);

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOAB() {
        return OAB;
    }

    public void setOAB(String OAB) {
        this.OAB = OAB;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public TipoDeColaborador getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(TipoDeColaborador tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public TipoDeStatus getTipoStatus() {
        return tipoStatus;
    }

    public void setTipoStatus(TipoDeStatus tipoStatus) {
        this.tipoStatus = tipoStatus;
    }
    
    

    public float getMulta() {
        return multa;
    }

 
    public void setMulta(float multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {

        String saida = id + ";";
        saida += nome + ";";
        saida += matricula + ";";
        saida += email + ";";
        saida += telefone + ";";
        saida += tipoColaborador.getTipo() + ";";
        saida += OAB + ";";
        saida += estado + ";";
        saida += tipoStatus.getStatus() + ";";
        saida += multa + ";";

        return saida;

    }


}
