/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import model.classes.Autor;
import model.interfaces.ICRUDAutor;
import model.persistencia.AutorPersistencia;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class AutorControle implements ICRUDAutor {

    private ICRUDAutor objeto = null;

    public AutorControle() throws Exception {
        this.objeto = new AutorControle(EnumArquivoTxt.AUTOR.getNomeDoArquivo());
    }

    public AutorControle(String nomeArquivoNoDisco) throws Exception {
        this.objeto = new AutorPersistencia(nomeArquivoNoDisco);
    }

    @Override
    public void incluir(Autor objeto) throws Exception {

//        String nome = objeto.getNomeAutor().trim().toLowerCase();
//
//        String invalidosN = "1234567890";
//
//        String invalidosE = "'\"!@#$%&*()-_=+{}[]/?<>;:";
//
//        ArrayList<Autor> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas editoras cadastradas com mesmo nome
//            if (objeto.getNomeAutor().equals(lista.get(i).getNomeAutor())) {
//                throw new Exception("Já existe um Autor com mesmo nome cadastrado!");
//            }
//        }
//
//        for (int i = 0; i < invalidosN.length(); i++) {
//
//            if (nome.contains("" + invalidosN.charAt(i))) {
//                throw new Exception("Campo nome não pode conter números!");
//            }
//            if (nome.contains("" + invalidosE.charAt(i))) {
//                throw new Exception("Campo nome não pode conter caracteres especiais!");
//            }
//        }
//
//        if (nome.equals("")) {
//            throw new Exception("Informe o nome!");
//        }
//
//        if (nome.length() <= 1) { //se o tamanho do nome for menor ou igual a 1 "exeção invalida"
//            throw new Exception("O nome precisa ter pelo menos dois caracteres!");
//        }
//
//        if ((nome.charAt(0) == nome.charAt(1)) && nome.length() == 2) {
//            throw new Exception("Duas letras iguais no início do nome");
//        }
        this.objeto.incluir(objeto);

    }

    @Override
    public ArrayList<Autor> recuperar() throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando recuperar os dados");
        return this.objeto.recuperar();
    }

    public Autor recuperar(String nomeAutor) throws Exception {
        Autor retorno = null;
        for (Autor autor : this.objeto.recuperar()) {
            if (autor.getNomeAutor().toLowerCase().equals(nomeAutor.toLowerCase())) {
                retorno = autor;
                break;
            }
        }
        return retorno;
    }

    public Autor recuperar(int id) throws Exception {
        Autor retorno = null;
        for (Autor autor : this.objeto.recuperar()) {
            if (autor.getId() == id) {
                retorno = autor;
            }
        }
        return retorno;
    }

    @Override
    public void excluir(int id) throws Exception {

        this.objeto.excluir(id);
    }

    @Override
    public void alterarAutor(Autor autorAntiga, Autor autorAtual) throws Exception {

//        ArrayList<Autor> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas editoras cadastradas com mesmo nome
//            if (autorAtual.getNomeAutor().equals(lista.get(i).getNomeAutor())) {
//                throw new Exception("Já existe um Autor com mesmo nome cadastrado!");
//            }
//        }
//
//        if (autorAtual.getNomeAutor().equals("")) {
//
//            throw new Exception("Informe o nome!");
//        }
        this.objeto.alterarAutor(autorAntiga, autorAtual);
    }

}
