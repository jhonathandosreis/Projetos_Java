/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import model.classes.Area;
import model.interfaces.ICRUDArea;
import model.persistencia.AreaPersistencia;

/**
 *
 * @author miguelneto
 */
public class AreaControle implements ICRUDArea {

    private ICRUDArea objeto = null;

    public AreaControle() throws Exception {

        this.objeto = new AreaControle(EnumArquivoTxt.AREADOLIVRO.getNomeDoArquivo());

    }

    public AreaControle(String nomeArquivoNoDisco) throws Exception {
        this.objeto = new AreaPersistencia(nomeArquivoNoDisco);
    }

    @Override
    public void incluir(Area objeto) throws Exception {

//        ArrayList<Area> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas areas cadastradas com mesmo nome
//            if (objeto.getCdd().equals(lista.get(i).getCdd())) {
//                // se encontrar, lança exceçao.
//                throw new Exception("Já existe uma Área do Livro com mesmo nome cadastrado!");
//            }
//
//        }

        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Area> recuperar() throws Exception {

        return this.objeto.recuperar();
    }

    public Area recuperar(String nomeArea) throws Exception {

        Area retorno = null;

        for (Area area : this.objeto.recuperar()) {
            if (area.getNomeArea().toLowerCase().equals(nomeArea.toLowerCase())) {
                retorno = area;
                break;
            }
        }
        return retorno;
    }

    public Area recuperar(int id) throws Exception {
        
        Area retorno = null;
       
        for (Area area : this.objeto.recuperar()) {
            if (area.getId() == id) {
                retorno = area;
            }
        }
        return retorno;
    }

    @Override
    public void excluir(int id) throws Exception {

        this.objeto.excluir(id);
    }

    @Override
    public void alterarArea(Area areaAntiga, Area areaAtual) throws Exception {
//
//        ArrayList<Area> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas areas cadastradas com mesmo nome
//            if (areaAtual.getCdd().equals(lista.get(i).getCdd())) {
//                // se encontrar, lança exceçao.
//                throw new Exception("Já existe uma Área do Livro com mesmo nome cadastrado!");
//            }
//
//        }
        this.objeto.alterarArea(areaAntiga, areaAtual);
    }

}
