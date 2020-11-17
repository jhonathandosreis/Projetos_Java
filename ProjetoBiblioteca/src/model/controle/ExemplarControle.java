/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import model.classes.Exemplar;
import model.interfaces.ICRUDExemplar;
import model.persistencia.ExemplarPersistencia;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class ExemplarControle implements ICRUDExemplar {

    private ICRUDExemplar objeto = null;

    public ExemplarControle() throws Exception {
        this.objeto = new ExemplarControle(EnumArquivoTxt.EXEMPLAR.getNomeDoArquivo());
    }

    public ExemplarControle(String nomeDoArquivo) throws Exception {
        this.objeto = new ExemplarPersistencia(nomeDoArquivo);

    }

    @Override
    public void incluir(Exemplar objeto) throws Exception {

        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Exemplar> recuperar() throws Exception {

        return this.objeto.recuperar();
    }
    
    public Exemplar recuperar(String nomeExemplar)throws Exception{
        Exemplar retorno = null;
        for(Exemplar areaDoExemplar : this.objeto.recuperar()) {
            if(areaDoExemplar.getLivro().getTitulo().toLowerCase().equals(nomeExemplar.toLowerCase())){
                retorno = areaDoExemplar;
                break;
            }
        }
        return retorno;
    }

   
    public Exemplar recuperar(int id) throws Exception {
        Exemplar retorno = null;
        for (Exemplar exemplar : this.objeto.recuperar()) {
            if (exemplar.getId() == id) {
                retorno = exemplar;
            }
        }
        return retorno;
    }
    
    @Override
    public void excluir(int id) throws Exception {

        this.objeto.excluir(id);
    }

    @Override
    public void alterar(Exemplar exemplarAntigo, Exemplar ExemplarAtual) throws Exception {

        this.objeto.alterar(exemplarAntigo, ExemplarAtual);
    }

}
