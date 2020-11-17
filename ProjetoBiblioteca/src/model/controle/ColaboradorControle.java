/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import java.util.ArrayList;
import model.classes.Colaborador;
import model.persistencia.ColaboradorPersistencia;
import model.interfaces.ICRUDColaborador;
import model.classesExtras.EnumArquivoTxt;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */

//Objetivo da controller >> Vefificar e mandar <<
public class ColaboradorControle implements ICRUDColaborador {

    private ICRUDColaborador objeto = null;

    public ColaboradorControle() throws Exception{
        this.objeto = new ColaboradorControle(EnumArquivoTxt.COLABORADOR.getNomeDoArquivo());
    }
    

    public ColaboradorControle(String nomeDoArquivoNoDisco) throws Exception {
        this.objeto = new ColaboradorPersistencia(nomeDoArquivoNoDisco);
    }

    @Override
    public void incluir(Colaborador objeto) throws Exception {
//
//        String nome = objeto.getNome().trim().toLowerCase();
//
//        String invalidos = "1234567890'\"!@#$%&*()-_=+{}[]/?<>;:";
//        for (int i = 0; i < invalidos.length(); i++) {
//            if (nome.contains("" + invalidos.charAt(i))) {
//                throw new Exception("Apenas letras sem caracteres !");
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
//            throw new Exception("Duas letras iguais !");
//        }
//
//        if (objeto.getTipoColaborador().equals(TipoDeColaborador.ADVOGADO)
//                && objeto.getOAB().equals("")) {
//            throw new Exception("O campo OAB é obrigatório para advogados!");
//        }
//        
//        if(objeto.getOAB().length()>1 && objeto.getEstado().equals("")){
//            throw new Exception("UF não informado! Insira UF da OAB");
//        }
//        // recuperar a lista e salvar em uma varivel
//        ArrayList<Colaborador> lista = this.objeto.recuperar();
//
//        //percorrer a lista procurando um colaborador com o mesmo email, mesma oab ou mesma matricual
//        for (int i = 0; i < lista.size(); i++) {
//
//            if (objeto.getEmail().equals(lista.get(i).getEmail())) {
//                // se encontrar, lança exceçao.
//                throw new Exception("Já existe um colaborador com o mesmo E-Mail!");
//            }
//
//            if (objeto.getOAB() == lista.get(i).getOAB()) {
//                throw new Exception("Já existe um colaborador com a mesma OAB!");
//            }
//
//            if (objeto.getMatricula() == lista.get(i).getMatricula()) {
//                throw new Exception("Já existe um colaborador com essa matricula!");
//            }
//        }
//        do {
//            nome = new String(objeto.getNome().trim().replace("  ", " "));
//
//            objeto.setNome(nome);
//
//        } while (nome.contains("  "));

        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Colaborador> recuperar() throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando recuperar os dados");

        return this.objeto.recuperar();
    }
    
    public Colaborador recuperar(int id) throws Exception {
        Colaborador retorno = null;
        for (Colaborador colaborador : this.objeto.recuperar()) {
            if (colaborador.getId() == id) {
                retorno = colaborador;
            }
        }
        return retorno;
    }

    public Colaborador recuperar(String nomeColaborador) throws Exception {
        Colaborador retorno = null;
        for (Colaborador colaborador : this.objeto.recuperar()) {
            if (colaborador.getNome().toLowerCase().equals(nomeColaborador.toLowerCase())) {
                retorno = colaborador;
                break;
            }
        }
        return retorno;
    }

    @Override
    public void excluir(int id ) throws Exception {
       
        this.objeto.excluir(id);
    }

    @Override
    public void alterar(Colaborador colaboradorAntigo, Colaborador colaboradorAtual) throws Exception {
//       String nome = colaboradorAtual.getNome().trim().toLowerCase();
//
//        String invalidos = "1234567890'\"!@#$%&*()-_=+{}[]/?<>;:";
//        for (int i = 0; i < invalidos.length(); i++) {
//            if (nome.contains("" + invalidos.charAt(i))) {
//                throw new Exception("Apenas letras sem caracteres !");
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
//            throw new Exception("Duas letras iguais !");
//        }
//
//        if (colaboradorAtual.getTipoColaborador().equals(TipoDeColaborador.ADVOGADO)
//                && colaboradorAtual.getOAB().equals("")) {
//            throw new Exception("O campo OAB é obrigatório para advogados!");
//        }
//        
//        if(colaboradorAtual.getOAB().length()>1 && colaboradorAtual.getEstado().equals("")){
//            throw new Exception("UF não informado! Insira UF da OAB");
//        } 
        this.objeto.alterar(colaboradorAntigo, colaboradorAtual);
    }

}
