package model.gui;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import model.classesExtras.EnumArquivoTxt;
import model.classesExtras.TipoDeStatus;
import model.controle.ExemplarControle;
import model.controle.LivroControle;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.classes.Exemplar;
import model.classes.Livro;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class TelaExemplar extends javax.swing.JFrame {

    LivroControle controleLivro = null;
    ExemplarControle controleExemplar = null;
    Exemplar exemplarAntigo;
    Exemplar exemplarAtual;

    //Lista de Exemplar atualizada na memoria
    ArrayList<Exemplar> listaExemplares = new ArrayList<Exemplar>();

    public TelaExemplar() {
        initComponents();

        try {

            controleExemplar = new ExemplarControle(EnumArquivoTxt.EXEMPLAR.getNomeDoArquivo());
            controleLivro = new LivroControle(EnumArquivoTxt.LIVRO.getNomeDoArquivo());
            exemplarAntigo = new Exemplar();
            exemplarAtual = new Exemplar();
            formatarCampoAnoPublic();
            formatarCampoDataAquisicao();

            ArrayList<Livro> ListaNovoLivro = controleLivro.recuperar();
            for (Livro livro : ListaNovoLivro) {
                jComboBoxLivro.addItem(livro.getTitulo().toUpperCase());
            }

            //Imprime a lista de exemplares na grid ao iniciar o programa
            listaExemplares = controleExemplar.recuperar();
            imprimirDadosNaGrid(listaExemplares);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
        setLocationRelativeTo(null);

    }

    private void imprimirDadosNaGrid(ArrayList<Exemplar> lista) {

        DefaultTableModel model = (DefaultTableModel) jTableExemplar.getModel();
        model.setNumRows(0);

        String[] linha = new String[8];

        for (int pos = 0; pos < lista.size(); pos++) {

            Exemplar aux = lista.get(pos);

            linha[0] = "" + aux.getId();
            linha[1] = "" + new SimpleDateFormat("dd/MM/yyyy").format(aux.getAnoDePublicacao());
            linha[2] = "" + aux.getPrecoDeCompra();
            linha[3] = "" + new SimpleDateFormat("dd/MM/yyyy").format(aux.getDataDeAquisicao());
            linha[4] = "" + aux.getDescricao().toUpperCase();
            linha[5] = "" + aux.getLivro().getTitulo().toUpperCase();
            linha[6] = "" + aux.getLivro().getEdicao();
            linha[7] = "" + aux.getTipoDeStatus();

            model.addRow(linha);
        }
    }

    public void preencherFormulario() throws Exception {

        String posicaoid = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 0).toString();
        String posicaoAnoDePublicacao = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 1).toString();
        String posicaoPrecoDeCompra = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 2).toString();
        String posicaoDataDeAquisicao = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 3).toString();
        String posicaoDescricao = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 4).toString();
        String posicaoLivro = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 5).toString();
        String posicaoEdicao = jTableExemplar.getValueAt(jTableExemplar.getSelectedRow(), 6).toString();
        

        jFormattedTextField_anoPublic.setText(posicaoAnoDePublicacao);
        jTextFieldPrecoCompra.setText(posicaoPrecoDeCompra);
        jFormattedTextField_datAquisicao.setText(posicaoDataDeAquisicao);
        jTextFieldDescricao.setText(posicaoDescricao);
        jComboBoxEdicao.setSelectedItem(posicaoEdicao);
        
        jComboBoxLivro.setSelectedItem(posicaoLivro);

        exemplarAntigo.setId(Integer.parseInt(posicaoid));

    }

    private void limparTela() {

        String t = "";
        jFormattedTextField_anoPublic.setText(t);
        jFormattedTextField_datAquisicao.setText(t);
        jTextFieldDescricao.setText(t);
        jTextFieldPrecoCompra.setText(t);
        jTextFieldpesquisar.setText(t);
        jComboBoxEdicao.setSelectedItem(0);
        jComboBoxLivro.setSelectedItem(0);
        
    }

    private void formatarCampoAnoPublic() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install(jFormattedTextField_anoPublic);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir data", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void formatarCampoDataAquisicao() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install(jFormattedTextField_datAquisicao);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir data", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jComboBoxLivro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPrecoCompra = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableExemplar = new javax.swing.JTable();
        jTextFieldpesquisar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSpinner_QuantidadeDeExemplar = new javax.swing.JSpinner();
        jFormattedTextField_anoPublic = new javax.swing.JFormattedTextField();
        jFormattedTextField_datAquisicao = new javax.swing.JFormattedTextField();
        jComboBoxEdicao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar/Pesquisar Exemplar");
        setMinimumSize(new java.awt.Dimension(1077, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Data De Publicação");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));

        jComboBoxLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o livro" }));
        jComboBoxLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLivroActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 250, -1));

        jLabel4.setText("Data De Aquisição");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, 30));

        jLabel9.setText("Livro");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        jLabel5.setText("Edição");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, 30));

        jLabel7.setText("Descrição");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, 30));
        getContentPane().add(jTextFieldPrecoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 80, -1));
        getContentPane().add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 310, -1));

        jLabel2.setText("Preço De Compra R$");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, 50));

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 630, 90, 50));

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 90, 50));

        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 90, 50));

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 90, 50));

        jTableExemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ANO PUBLICADO", "VALOR", "AQUISIÇÃO", "DESCRIÇÃO", "LIVRO", "EDIÇÃO", "STATUS"
            }
        ));
        jTableExemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExemplarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableExemplar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 990, 340));

        jTextFieldpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldpesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldpesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 890, -1));

        jLabel8.setText("Pesquisar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/magnifying-glass.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, 60));

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

        jLabel10.setText("Unidades de Exemplares");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, -1, 50));
        getContentPane().add(jSpinner_QuantidadeDeExemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 70, -1));
        getContentPane().add(jFormattedTextField_anoPublic, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 140, -1));
        getContentPane().add(jFormattedTextField_datAquisicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 140, -1));

        jComboBoxEdicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a edição" }));
        jComboBoxEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEdicaoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 250, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/blur corte tela principal.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {

            controleExemplar.excluir(exemplarAntigo.getId());

            imprimirDadosNaGrid(controleExemplar.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Exclusão Realizada com sucesso!");

            listaExemplares = controleExemplar.recuperar();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {

            exemplarAtual.setId(exemplarAntigo.getId());
            exemplarAtual.setAnoDePublicacao(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_anoPublic.getText()));
            exemplarAtual.setPrecoDeCompra(Float.parseFloat(jTextFieldPrecoCompra.getText()));
            exemplarAtual.setDataDeAquisicao(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_datAquisicao.getText()));
            exemplarAtual.setTipoDeStatus(TipoDeStatus.valueOf("DISPONIVEL"));
            exemplarAtual.setDescricao(jTextFieldDescricao.getText());

            exemplarAtual.setLivro(controleLivro.recuperar(jComboBoxEdicao.getSelectedItem().toString()));
            exemplarAtual.setLivro(controleLivro.recuperar(jComboBoxLivro.getSelectedItem().toString()));

            controleExemplar.alterar(exemplarAntigo, exemplarAtual);

            imprimirDadosNaGrid(controleExemplar.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Alteração Realizada com sucesso!");

            listaExemplares = controleExemplar.recuperar();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        try {

            int x = (int) jSpinner_QuantidadeDeExemplar.getValue();
            for (int i = 0; i < x; i++) {

                exemplarAtual.setAnoDePublicacao(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_anoPublic.getText()));
                exemplarAtual.setPrecoDeCompra(Float.parseFloat(jTextFieldPrecoCompra.getText()));
                exemplarAtual.setDataDeAquisicao(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_datAquisicao.getText()));
                exemplarAtual.setTipoDeStatus(TipoDeStatus.valueOf("DISPONIVEL"));
                exemplarAtual.setDescricao(jTextFieldDescricao.getText());

                exemplarAtual.setLivro(controleLivro.recuperar(jComboBoxEdicao.getSelectedItem().toString()));

                exemplarAtual.setLivro(controleLivro.recuperar(jComboBoxLivro.getSelectedItem().toString()));

                controleExemplar.incluir(exemplarAtual);

                imprimirDadosNaGrid(controleExemplar.recuperar());

            }
            limparTela();

            jSpinner_QuantidadeDeExemplar.setValue(1);

            JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso!");

            listaExemplares = controleExemplar.recuperar();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);

        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jTableExemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExemplarMouseClicked
        try {

            preencherFormulario();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jTableExemplarMouseClicked

    private void jTextFieldpesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesquisarKeyReleased
        try {
            //Texto digitado na jtextfield em minuscula
            String textoDigitado = jTextFieldpesquisar.getText().toLowerCase();

            //Lista vazia com o resultado da pesquisa
            ArrayList<Exemplar> resultadoPesquisa = new ArrayList<>();

            //Exemplar == lista recuperada do arquivo
            for (Exemplar exemplares : listaExemplares) {

                if (exemplares.getLivro().getTitulo().toLowerCase().trim().contains(textoDigitado)
                        || (("" + exemplares.getId()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + exemplares.getAnoDePublicacao()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + exemplares.getDataDeAquisicao()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + exemplares.getTipoDeStatus()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + exemplares.getLivro().getEdicao()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + exemplares.getLivro().getDescricao()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + exemplares.getPrecoDeCompra()).toLowerCase().trim().contains(textoDigitado))) {

                    //Inclui o resultado encontrado na pesquisa
                    resultadoPesquisa.add(exemplares);
                }
            }
            imprimirDadosNaGrid(resultadoPesquisa);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jTextFieldpesquisarKeyReleased

    private void jComboBoxLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLivroActionPerformed

       ///// copiar e colar , colocar toupperCase incluir e recuperar 
 
           
        try {
            
            jComboBoxEdicao.removeAllItems();
           
            ArrayList<Livro> ListaNovaEdicao = controleLivro.recuperar();
            
            for (Livro livro : ListaNovaEdicao) {
                if(livro.getTitulo().equals(jComboBoxLivro.getSelectedItem().toString())){
                    jComboBoxEdicao.addItem(livro.getEdicao().toUpperCase());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaExemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jComboBoxLivroActionPerformed

    private void jComboBoxEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEdicaoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEdicaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaExemplar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExemplar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExemplar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExemplar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExemplar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxEdicao;
    private javax.swing.JComboBox<String> jComboBoxLivro;
    private javax.swing.JFormattedTextField jFormattedTextField_anoPublic;
    private javax.swing.JFormattedTextField jFormattedTextField_datAquisicao;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_QuantidadeDeExemplar;
    private javax.swing.JTable jTableExemplar;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldPrecoCompra;
    private javax.swing.JTextField jTextFieldpesquisar;
    // End of variables declaration//GEN-END:variables
}
