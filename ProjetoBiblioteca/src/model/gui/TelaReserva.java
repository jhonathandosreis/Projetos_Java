/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gui;

import model.classesExtras.EnumArquivoTxt;
import model.classesExtras.TipoDeStatus;
import model.controle.ColaboradorControle;
import model.controle.ExemplarControle;
import model.controle.LivroControle;
import model.controle.ReservaControle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.classes.Colaborador;
import model.classes.Exemplar;
import model.classes.Livro;
import model.classes.Reserva;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class TelaReserva extends javax.swing.JFrame {

    ReservaControle controleReserva = null;
    ColaboradorControle controleColaborador = null;
    ExemplarControle controleExemplar = null;
    LivroControle controleLivro = null;
    Reserva reservaAntiga = null;
    Reserva reservaAtual = null;
    Exemplar ExemplarAntigo = null;
    Exemplar ExemplarAtual = null;
    //Lista de reserva atualizada na memoria
    ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();

    public TelaReserva() {
        initComponents();

        try {
            controleReserva = new ReservaControle(EnumArquivoTxt.RESERVA.getNomeDoArquivo());
            controleColaborador = new ColaboradorControle(EnumArquivoTxt.COLABORADOR.getNomeDoArquivo());
            controleLivro = new LivroControle(EnumArquivoTxt.LIVRO.getNomeDoArquivo());
            controleExemplar = new ExemplarControle(EnumArquivoTxt.EXEMPLAR.getNomeDoArquivo());
            reservaAntiga = new Reserva();
            reservaAtual = new Reserva();
            formatarCampoParaDataReserva();

            jTextFieldQuantidadeDisponivel.setEnabled(false);
            
            
            ArrayList<Colaborador> listaNovoColaborador = controleColaborador.recuperar();
            for (Colaborador colaborador : listaNovoColaborador) {
                jComboBoxColaborador.addItem(colaborador.getNome().toUpperCase());
            }

            ArrayList<Livro> ListaNovoLivro = controleLivro.recuperar();
            for (Livro livro : ListaNovoLivro) {
                jComboBoxLivro.addItem(livro.getTitulo().toUpperCase());
            }
            //Imprime a lista de reservas na grid ao iniciar o programa
            listaReservas = controleReserva.recuperar();
            imprimirDadosNaGrid(listaReservas);

        } catch (Exception e) {
        }
        setLocationRelativeTo(null);
    }
    //METODOS  

    private void limparTela() {

        String t = "";
        jTextAreaDescricao.setText(t);
        jTextFieldpesquisar.setText(t);
        jFormattedTextField_DT_Reserva.setText(t);
        jComboBoxColaborador.setSelectedItem(0);
        jComboBoxLivro.setSelectedItem(0);
    }

    private void formatarCampoParaDataReserva() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install(jFormattedTextField_DT_Reserva);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir data", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void imprimirDadosNaGrid(ArrayList<Reserva> lista) {

        DefaultTableModel model = (DefaultTableModel) jTableReserva.getModel();
        model.setNumRows(0);

        for (int pos = 0; pos < lista.size(); pos++) {

            String[] linha = new String[5];
            Reserva aux = lista.get(pos);

            linha[0] = "" + aux.getId();
            linha[1] = "" + aux.getColaborador().getNome().toUpperCase();
            linha[2] = "" + new SimpleDateFormat("dd/MM/yyyy").format(aux.getDataDaReserva());
            linha[3] = "" + aux.getLivro().getTitulo().toUpperCase();
            linha[4] = "" + aux.getDescricao().toUpperCase();

            model.addRow(linha);

        }
    }

    public void preencherFormulario() {

        String psicaoIdo = jTableReserva.getValueAt(jTableReserva.getSelectedRow(), 0).toString().toUpperCase();
        String posicaoColaborador = jTableReserva.getValueAt(jTableReserva.getSelectedRow(), 1).toString().toUpperCase();
        String posicaoData = jTableReserva.getValueAt(jTableReserva.getSelectedRow(), 2).toString().toUpperCase();
        String posicaoLivro = jTableReserva.getValueAt(jTableReserva.getSelectedRow(), 3).toString().toUpperCase();
        String posicaoDescricao = jTableReserva.getValueAt(jTableReserva.getSelectedRow(), 4).toString().toUpperCase();

        jFormattedTextField_DT_Reserva.setText(posicaoData);
        jTextAreaDescricao.setText(posicaoDescricao);
        jComboBoxColaborador.setSelectedItem(posicaoColaborador);
        jComboBoxLivro.setSelectedItem(posicaoLivro);
        reservaAntiga.setId(Integer.parseInt(psicaoIdo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldpesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReserva = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxColaborador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxLivro = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jFormattedTextField_DT_Reserva = new javax.swing.JFormattedTextField();
        jTextFieldQuantidadeDisponivel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar/Pesquisar Reserva");
        setMinimumSize(new java.awt.Dimension(1077, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldpesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldpesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 770, -1));

        jTableReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "COLABORADOR", "DATA RESERVA", "LIVRO", "DESCRIÇÃO"
            }
        ));
        jTableReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReservaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableReserva);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 870, 270));

        jLabel6.setText("Pesquisar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, 30));

        jButtonIncluir.setText("RESERVAR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 90, 50));

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, 90, 50));

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, 90, 50));

        jButtonSair.setText("VOLTAR");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 630, 90, 50));

        jLabel2.setText("Data Reserva");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, 30));

        jLabel3.setText("Descrição :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 20));

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 860, -1));

        jLabel4.setText("Colaborador");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 30));

        jComboBoxColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione Colaborador" }));
        jComboBoxColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColaboradorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxColaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 770, 30));

        jLabel1.setText("Livro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, 30));

        jComboBoxLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione Livro" }));
        jComboBoxLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLivroActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 380, 30));

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

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/magnifying-glass.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, 28));
        getContentPane().add(jFormattedTextField_DT_Reserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 140, -1));
        getContentPane().add(jTextFieldQuantidadeDisponivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 60, -1));

        jLabel7.setText("Quantidade");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/blur corte tela principal.jpeg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldpesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpesquisarKeyReleased
        try {
            //Texto digitado na jtextfield em minuscula
            String textoDigitado = jTextFieldpesquisar.getText().toLowerCase();

            //Lista vazia com o resultado da pesquisa
            ArrayList<Reserva> resultadoPesquisa = new ArrayList<>();

            //Reserva == lista recuperada do arquivo
            for (Reserva reserva : listaReservas) {

                if (reserva.getLivro().getTitulo().toLowerCase().trim().contains(textoDigitado)
                        || (("" + reserva.getId()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + reserva.getDescricao()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + reserva.getDataDaReserva()).toLowerCase().trim().contains(textoDigitado))
                        || (("" + reserva.getColaborador().getNome()).toLowerCase().trim().contains(textoDigitado))) {

                    //Inclui o resultado encontrado na pesquisa
                    resultadoPesquisa.add(reserva);
                }
            }
            imprimirDadosNaGrid(resultadoPesquisa);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jTextFieldpesquisarKeyReleased

    private void jTableReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReservaMouseClicked
        try {

            preencherFormulario();

        } catch (Exception erro) {
            JOptionPane.showConfirmDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jTableReservaMouseClicked

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            ArrayList<Exemplar> listaDosExemplares = controleExemplar.recuperar();
            ArrayList<Exemplar> exemplaresDISPONIVEIS = new ArrayList<>();
            int i = 0;
            for (Exemplar exemplar : listaDosExemplares) {
                if (exemplar.getLivro().getTitulo().equalsIgnoreCase(jComboBoxLivro.getSelectedItem().toString())) {
                    if (exemplar.getTipoDeStatus().equals(exemplar.getTipoDeStatus().DISPONIVEL)) {
                        i++;

                        exemplaresDISPONIVEIS.add(exemplar);

                    }

                }

            }

            reservaAtual.setExemplar(exemplaresDISPONIVEIS.get(0));

            reservaAtual.setDataDaReserva(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_DT_Reserva.getText()));
            reservaAtual.setDescricao(jTextAreaDescricao.getText());

            reservaAtual.setColaborador(controleColaborador.recuperar(jComboBoxColaborador.getSelectedItem().toString().toUpperCase()));
            reservaAtual.setLivro(controleLivro.recuperar(jComboBoxLivro.getSelectedItem().toString().toUpperCase()));

            ExemplarAntigo = reservaAtual.getExemplar();
            ExemplarAtual = ExemplarAntigo;
            ExemplarAtual.setTipoDeStatus(TipoDeStatus.RESERVADO);   //ALTERA O STATUS DO EXEMPLAR AO DEVOLVELO PARA DISPONIVEL
            controleExemplar.alterar(ExemplarAntigo, ExemplarAtual);

            controleReserva.incluir(reservaAtual);

            imprimirDadosNaGrid(controleReserva.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Reserva Realizada com sucesso!");

            listaReservas = controleReserva.recuperar();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {

            reservaAtual.setId(reservaAntiga.getId());

            reservaAtual.setDataDaReserva(new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextField_DT_Reserva.getText()));
            reservaAtual.setDescricao(jTextAreaDescricao.getText());

            reservaAtual.setColaborador(controleColaborador.recuperar(jComboBoxColaborador.getSelectedItem().toString().toUpperCase()));
            reservaAtual.setLivro(controleLivro.recuperar(jComboBoxLivro.getSelectedItem().toString().toUpperCase()));

            controleReserva.alterar(reservaAntiga, reservaAtual);

            imprimirDadosNaGrid(controleReserva.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Alteração Realizada com sucesso!");

            listaReservas = controleReserva.recuperar();
        } catch (Exception erro) {
            JOptionPane.showConfirmDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            String posicaoId = jTableReserva.getValueAt(jTableReserva.getSelectedRow(), 0).toString().toUpperCase();  // PEGA O ID DO EMPRESTIMO AO SELECIONAR A LINHA
            Reserva objeto = controleReserva.recuperar(Integer.parseInt(posicaoId));  //RECUPERA O OBJETO PELO ID CAPTURADO
            ExemplarAntigo = objeto.getExemplar();
            ExemplarAtual = ExemplarAntigo;
            ExemplarAtual.setTipoDeStatus(TipoDeStatus.DISPONIVEL);   //ALTERA O STATUS DO EXEMPLAR AO DEVOLVELO PARA DISPONIVEL
            controleExemplar.alterar(ExemplarAntigo, ExemplarAtual);
            controleReserva.excluir(reservaAntiga.getId());

            controleReserva.excluir(reservaAtual.getId());

            imprimirDadosNaGrid(controleReserva.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Exclusão Realizada com sucesso!");

            listaReservas = controleReserva.recuperar();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxColaboradorActionPerformed

    private void jComboBoxLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLivroActionPerformed
        try {
            ArrayList<Exemplar> listaDosExemplares = controleExemplar.recuperar();
            int i = 0;
            for (Exemplar exemplar : listaDosExemplares) {
                if (exemplar.getLivro().getTitulo().equalsIgnoreCase(jComboBoxLivro.getSelectedItem().toString())) {
                    if (exemplar.getTipoDeStatus().equals(exemplar.getTipoDeStatus().DISPONIVEL)) {
                        i++;
                    }

                }

            }
            jTextFieldQuantidadeDisponivel.setText("" + i);
        } catch (Exception ex) {
            Logger.getLogger(TelaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxLivroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxColaborador;
    private javax.swing.JComboBox<String> jComboBoxLivro;
    private javax.swing.JFormattedTextField jFormattedTextField_DT_Reserva;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableReserva;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldQuantidadeDisponivel;
    private javax.swing.JTextField jTextFieldpesquisar;
    // End of variables declaration//GEN-END:variables
}
