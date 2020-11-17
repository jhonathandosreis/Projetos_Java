package model.controle;

import model.classesExtras.EnumArquivoTxt;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.classes.Editora;
import model.interfaces.ICRUDEditora;
import model.persistencia.EditoraPersistencia;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class EditoraControle implements ICRUDEditora {

    private ICRUDEditora objeto = null;

    // Varre o Enum TXT pelo HaspMap
    public EditoraControle() throws Exception {
        this.objeto = new EditoraControle(EnumArquivoTxt.EDITORA.getNomeDoArquivo());
    }

    public EditoraControle(String nomeArquivoNoDisco) throws Exception {
        this.objeto = new EditoraPersistencia(nomeArquivoNoDisco);
    }

    @Override
    public void incluir(Editora objeto) throws Exception {
//        ArrayList<Editora> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas editoras cadastradas com mesmo nome
//            if (objeto.getNome().equals(lista.get(i).getNome())) {
//                throw new Exception("Já existe uma Editora com mesmo nome cadastrado!");
//            }
//        }
//            if (objeto.getNome().equals("")) {
//                throw new Exception("Informe o nome!");
//            }
//        

        this.objeto.incluir(objeto);

    }

    public Editora recuperar(String nomeEditora) throws Exception {
        Editora retorno = null;
        for (Editora editora : this.objeto.recuperar()) {
            if (editora.getNome().toLowerCase().equals(nomeEditora.toLowerCase())) {
                retorno = editora;
                break;
            }
        }
        return retorno;
    }

    public Editora recuperar(int id) throws Exception {
        Editora retorno = null;
        for (Editora editora : this.objeto.recuperar()) {
            if (editora.getId() == id) {
                retorno = editora;
            }
        }
        return retorno;
    }

    @Override
    public ArrayList<Editora> recuperar() throws Exception {
        System.out.println("Estou na controle verificando e "
                + "mandando recuperar os dados");
        return this.objeto.recuperar();
    }

    @Override
    public void excluir(int id) throws Exception {

        this.objeto.excluir(id);
    }

    @Override
    public void alterarEditora(Editora editoraAntiga, Editora editoraAtual) throws Exception {

//        
//        ArrayList<Editora> lista = this.objeto.recuperar();
//
//        for (int i = 0; i < lista.size(); i++) {
//            //Verifica se existe duas editoras cadastradas com mesmo nome
//            if (editoraAtual.getNome().equals(lista.get(i).getNome())) {
//                throw new Exception("Já existe uma Editora com mesmo nome cadastrado!");
//            }
//        }
//        if (editoraAtual.getNome().equals("")) {
//
//            throw new Exception("Informe o nome!");
//        }
        
        this.objeto.alterarEditora(editoraAntiga, editoraAtual);
    }

}
