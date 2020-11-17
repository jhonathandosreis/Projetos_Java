/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import model.classes.Livro;
import model.interfaces.ICRUDLivro;
import model.persistencia.LivroPersistencia;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class LivroControle implements ICRUDLivro {

    private ICRUDLivro objeto = null;

    public LivroControle() throws Exception {

        this.objeto = new LivroControle(EnumArquivoTxt.LIVRO.getNomeDoArquivo());

    }

    public LivroControle(String nomeDoArquivoNoDisco) throws Exception {
        this.objeto = new LivroPersistencia(nomeDoArquivoNoDisco);
    }

    @Override
    public void incluir(Livro objeto) throws Exception {
        
//         ArrayList<Livro> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas editoras cadastradas com mesmo nome
//            if (objeto.getTitulo().equals(lista.get(i).getTitulo()) && objeto.getEdicao().equals(lista.get(i).getEdicao())) {
//            throw new Exception("Esta Edição já está cadatrada para este Título!");
//            }
//        }
//        
//        if (objeto.getTitulo().equals("")) {
//
//            throw new Exception("Escreva o Título do Livro !");
//        
//        }
        

        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Livro> recuperar() throws Exception {
     
        return this.objeto.recuperar();
    }

    public Livro recuperar(String nomeLivro) throws Exception {
        Livro retorno = null;
        for (Livro livro : this.objeto.recuperar()) {
            if (livro.getTitulo().toLowerCase().equals(nomeLivro.toLowerCase())) {
                retorno = livro;
                break;
            }
        }
        return retorno;
    }

    public Livro recuperar(int id) throws Exception {
        Livro retorno = null;
        for (Livro livro : this.objeto.recuperar()) {
            if (livro.getId() == id) {
                retorno = livro;
            }
        }
        return retorno;
    }

    @Override
    public void excluir(int id) throws Exception {
      
        this.objeto.excluir(id);
    }

    @Override
    public void alterar(Livro livroAntiga, Livro livroAtual) throws Exception {
       
        this.objeto.alterar(livroAntiga, livroAtual);
    }

}
