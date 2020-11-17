/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gui;

import model.classesExtras.EnumArquivoTxt;
import model.controle.AreaControle;
import model.controle.AutorControle;
import model.controle.EditoraControle;
import model.controle.LivroControle;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.classes.Area;
import model.classes.Autor;
import model.classes.Editora;
import model.classes.Livro;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class TelaLivro extends javax.swing.JFrame {
    
    AreaControle controleArea = null;
    EditoraControle controleEditora = null;
    AutorControle controleAutor = null;

    LivroControle controleLivro = null;
    Livro livroAntigo;
    Livro livroAtual;
    TelaLivro telaLivro = (this);

    // lISTA DE COLABORADORES ATUALIZADA NA MEMORIA
    ArrayList<Livro> livros = new ArrayList<Livro>();
    

    /**
     * Creates new form TelaLivro
     */
    public TelaLivro() {
        initComponents();
        
           try {

            controleAutor = new AutorControle(EnumArquivoTxt.AUTOR.getNomeDoArquivo());
            controleArea = new AreaControle(EnumArquivoTxt.AREADOLIVRO.getNomeDoArquivo());
            controleEditora = new EditoraControle(EnumArquivoTxt.EDITORA.getNomeDoArquivo());

            controleLivro = new LivroControle(EnumArquivoTxt.LIVRO.getNomeDoArquivo());
            livroAntigo = new Livro();
            livroAtual = new Livro();
            formatarCampoParaData();
            
            
            ArrayList<Autor> listaAtualAutor = controleAutor.recuperar();
            for (Autor addAutor : listaAtualAutor) {
                jComboBoxAutor.addItem(addAutor.getNomeAutor().toUpperCase());
            }
           

            ArrayList<Editora> listaAtualEditora = controleEditora.recuperar();
            for (Editora addEditora : listaAtualEditora) {
                jComboBoxEditora.addItem(addEditora.getNome().toUpperCase());
            }

            ArrayList<Area> listaArea = controleArea.recuperar();
            for (Area addArea : listaArea) {
                jComboBoxAreaDoLivro.addItem(addArea.getNomeArea().toUpperCase());
            }

            //// Atualiza a lista de colaborades com o contedo do arquivo 
            //  ATENCAO ELE NAO CRIA O PRIMEIRO TXT COM O RECUPERAR LISTA ATIVADO 
            livros = controleLivro.recuperar();
            imprimirDadosnaGrid(livros);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        this.setLocationRelativeTo(null);
         
    }
    
    private void limparTela() {

        String t = "";
        jTextFieldTitulo.setText(t);
        jFormattedTextFieldData.setText(t);
        jTextFieldDescricao.setText(t);
        jTextFieldEdicao.setText(t);
        jTextFieldIsbn.setText(t);
        jTextFieldPesquisar.setText(t);
        jComboBoxAreaDoLivro.setSelectedIndex(0);
        jComboBoxAutor.setSelectedIndex(0);
        jComboBoxEditora.setSelectedIndex(0);

    }

    private void formatarCampoParaData() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install(jFormattedTextFieldData);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir data", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void AtualizaComboAutor(){
        
        
        try {
            jComboBoxAutor.removeAllItems();
            ArrayList<Autor> listaAtualAutor = controleAutor.recuperar();
            for (Autor addAutor : listaAtualAutor) {
                jComboBoxAutor.addItem(addAutor.getNomeAutor().toUpperCase());
            }
//            jComboBoxAutor.addItem(nome);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar campo autor");
        }
       

    }
      public void AtualizaComboArea(){
        try {
            
            jComboBoxAreaDoLivro.removeAllItems();
            ArrayList<Area> listaArea = controleArea.recuperar();
            for (Area addArea : listaArea) {
                jComboBoxAreaDoLivro.addItem(addArea.getNomeArea().toUpperCase());
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar campo area");
        }
         
          
      }
        public void AtualizaComboEditora(){
            
        try {
            jComboBoxEditora.removeAllItems();
            ArrayList<Editora> listaAtualEditora = controleEditora.recuperar();
            for (Editora addEditora : listaAtualEditora) {
                jComboBoxEditora.addItem(addEditora.getNome().toUpperCase());
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar campo editora");
        }
            
        }

    private void imprimirDadosnaGrid(ArrayList<Livro> lista) {
       DefaultTableModel model = (DefaultTableModel) jTableLivros.getModel();
        model.setNumRows(0);

        String[] linha = new String[9];

        for (int pos = 0; pos < lista.size(); pos++) {

            Livro aux = lista.get(pos);

            linha[0] = "" + aux.getId();
            linha[1] = "" + aux.getTitulo().toUpperCase();
            linha[2] = "" + aux.getIsbn();
            linha[3] = "" + aux.getAnoDePublicacao();
            linha[4] = "" + aux.getEdicao();
            linha[5] = "" + aux.getDescricao().toUpperCase();
            linha[6] = "" + aux.getAutor().getNomeAutor().toUpperCase();
            linha[7] = "" + aux.getAreaDoLivro().getNomeArea().toUpperCase();
            linha[8] = "" + aux.getEditora().getNome().toUpperCase();
     
            model.addRow(linha);
        }
    }

    public void preencherFormulario() {

        String posicaoid = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 0).toString();
        String posicaoTitulo = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 1).toString();
        String posicaoIsbn = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 2).toString();
        String posicaoDate = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 3).toString();
        String posicaoEdicao = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 4).toString();
        String posicaoDescricao = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 5).toString();
        String posicaoAutorNome = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 6).toString();
        String posicaoAreaDoLivroNome = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 7).toString();
        String posicaoEditoraNome = jTableLivros.getValueAt(jTableLivros.getSelectedRow(), 8).toString();

        jTextFieldTitulo.setText(posicaoTitulo);
        jTextFieldIsbn.setText(posicaoIsbn);
        jFormattedTextFieldData.setText(posicaoDate);
        jTextFieldDescricao.setText(posicaoDescricao);
        jTextFieldEdicao.setText(posicaoEdicao);
        jComboBoxAutor.setSelectedItem(posicaoAutorNome);
        jComboBoxAreaDoLivro.setSelectedItem(posicaoAreaDoLivroNome);
        jComboBoxEditora.setSelectedItem(posicaoEditoraNome);
        

        livroAntigo.setId(Integer.parseInt(posicaoid));
        livroAntigo.setTitulo(posicaoTitulo);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldIsbn = new javax.swing.JTextField();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldEdicao = new javax.swing.JTextField();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxAutor = new javax.swing.JComboBox<>();
        jComboBoxAreaDoLivro = new javax.swing.JComboBox<>();
        jComboBoxEditora = new javax.swing.JComboBox<>();
        jButtonCadastrarAutor = new javax.swing.JButton();
        jButtonCadastrarArea = new javax.swing.JButton();
        jButtonCadastrarEditora = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(1077, 720, 720, 720));
        setMinimumSize(new java.awt.Dimension(1077, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Titulo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        jLabel2.setText("ISBN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jLabel3.setText("Data");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, 30));

        jLabel4.setText("Edição");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, 30));

        jLabel5.setText("Descrição");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));
        getContentPane().add(jTextFieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 410, -1));
        getContentPane().add(jTextFieldIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 70, -1));
        getContentPane().add(jFormattedTextFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 100, -1));
        getContentPane().add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 410, -1));
        getContentPane().add(jTextFieldEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 140, -1));

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, 90, 50));

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 630, 90, 50));

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 90, 50));

        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, 90, 50));

        jLabel6.setText("Autor do Livro");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, 30));

        jLabel7.setText("Área do Livro");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, 30));

        jLabel8.setText("Editora do Livro");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, 30));

        jComboBoxAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Autor" }));
        getContentPane().add(jComboBoxAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 210, -1));

        jComboBoxAreaDoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a Área" }));
        getContentPane().add(jComboBoxAreaDoLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 210, -1));

        jComboBoxEditora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleciona a Editora" }));
        getContentPane().add(jComboBoxEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 210, -1));

        jButtonCadastrarAutor.setText("Cadastrar Autor");
        jButtonCadastrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarAutorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 160, -1));

        jButtonCadastrarArea.setText("Cadastrar Área");
        jButtonCadastrarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarAreaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrarArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 160, -1));

        jButtonCadastrarEditora.setText("Cadastrar Editora");
        jButtonCadastrarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarEditoraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrarEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 160, -1));

        jLabel9.setText("Pesquisar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, -1));

        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 870, -1));

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TITULO", "ISBN", "DATA", "EDIÇÃO", "DESCRIÇÃO", "AUTOR", "ÁREA", "EDITORA"
            }
        ));
        jTableLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLivros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 960, 330));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/magnifying-glass.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 50, 60));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel17.setText("_ _ _ _ _ _ _ ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 70, 30));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel16.setText("F A T E S G ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, 20));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel18.setText("B i b l i o ");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 100, 40));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("_ _ _ _ _ _ _ _ _ ");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 90, 30));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel20.setText("P r o j e t o");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 20));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 153));
        jLabel21.setText(" t e c h");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 20, 140));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/blur corte tela principal.jpeg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        try {
            
            

            livroAtual.setTitulo(jTextFieldTitulo.getText().toUpperCase());
            livroAtual.setIsbn(Integer.parseInt(jTextFieldIsbn.getText()));
            livroAtual.setAnoDePublicacao(jFormattedTextFieldData.getText());
            livroAtual.setEdicao(jTextFieldEdicao.getText().toUpperCase());
            livroAtual.setDescricao(jTextFieldDescricao.getText());

            livroAtual.setAutor(controleAutor.recuperar(jComboBoxAutor.getSelectedItem().toString()));

            livroAtual.setAreaDoLivro(controleArea.recuperar(jComboBoxAreaDoLivro.getSelectedItem().toString()));

            livroAtual.setEditora(controleEditora.recuperar(jComboBoxEditora.getSelectedItem().toString()));
            
            controleLivro.incluir(livroAtual);

            imprimirDadosnaGrid(controleLivro.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso!");

            livros = controleLivro.recuperar();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

try {
            if (jTextFieldTitulo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione um nome para excluir !", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {

                controleLivro.excluir(livroAntigo.getId());

                imprimirDadosnaGrid(controleLivro.recuperar());

                limparTela();

                JOptionPane.showMessageDialog(rootPane, "Exclusão Realizada com sucesso");

                livros = controleLivro.recuperar();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed

  this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

         try {

            livroAtual.setId(livroAntigo.getId());
            livroAtual.setTitulo(jTextFieldTitulo.getText().toUpperCase());
            livroAtual.setIsbn(Integer.parseInt(jTextFieldIsbn.getText()));
            livroAtual.setAnoDePublicacao(jFormattedTextFieldData.getText());
            livroAtual.setEdicao(jTextFieldEdicao.getText().toUpperCase());
            livroAtual.setDescricao(jTextFieldDescricao.getText());

            livroAtual.setAutor(controleAutor.recuperar(jComboBoxAutor.getSelectedItem().toString()));

            livroAtual.setAreaDoLivro(controleArea.recuperar(jComboBoxAreaDoLivro.getSelectedItem().toString()));

            livroAtual.setEditora(controleEditora.recuperar(jComboBoxEditora.getSelectedItem().toString()));
            

          controleLivro.alterar(livroAntigo, livroAtual);

            imprimirDadosnaGrid(controleLivro.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Alteração Realizada com sucesso!");

            livros = controleLivro.recuperar();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivrosMouseClicked

        try {

            preencherFormulario();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_jTableLivrosMouseClicked

    private void jButtonCadastrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarAutorActionPerformed
        
        TelaDoAutor telaAutor = new TelaDoAutor();
        telaAutor.manterTelaLivroAntiga(telaLivro);
        telaAutor.setVisible(true);
        dispose();
   


        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarAutorActionPerformed

    private void jButtonCadastrarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarAreaActionPerformed

       TelaAreaDoLivro telaArea = new TelaAreaDoLivro();
       telaArea.manterTelaLivroAntiga(telaLivro);
        telaArea.setVisible(true);
      

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarAreaActionPerformed

    private void jButtonCadastrarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarEditoraActionPerformed
        
        TelaDaEditora telaEditora = new TelaDaEditora();
        telaEditora.manterTelaLivroAntiga(telaLivro);
        telaEditora.setVisible(true);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarEditoraActionPerformed

    private void jTextFieldPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyPressed

try {
            //Texto digitado na jtextfield em minuscula
            String textoDigitado = jTextFieldPesquisar.getText().toLowerCase();

            //Lista vazia com o resultado da pesquisa
            ArrayList<Livro> resultadoPesquisa = new ArrayList<>();

            //Livro == lista recuperada do arquivo
            for (Livro livro : livros) {

                if (livro.getTitulo().toLowerCase().trim().contains(textoDigitado)
                        || (("" + livro.getEdicao()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getDescricao()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getId()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getAnoDePublicacao()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getIsbn()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getEditora().getNome()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getAutor().getNomeAutor()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + livro.getAreaDoLivro().getNomeArea()).toLowerCase().trim().contains(textoDigitado))) {

                    //Inclui o resultado encontrado na pesquisa    
                    resultadoPesquisa.add(livro);
                }
            }
            imprimirDadosnaGrid(resultadoPesquisa);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrarArea;
    private javax.swing.JButton jButtonCadastrarAutor;
    private javax.swing.JButton jButtonCadastrarEditora;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxAreaDoLivro;
    private javax.swing.JComboBox<String> jComboBoxAutor;
    private javax.swing.JComboBox<String> jComboBoxEditora;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEdicao;
    private javax.swing.JTextField jTextFieldIsbn;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
