/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gui;

import model.classesExtras.EnumArquivoTxt;
import model.classesExtras.TipoDeColaborador;
import model.classesExtras.TipoDeStatus;
import model.controle.ColaboradorControle;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.classes.Colaborador;

/**
 * @author GUSTAVO
 *
 * @author JHONATHAN
 *
 * @author MIGUEL
 */
public class TelaColaborador extends javax.swing.JFrame {

    ColaboradorControle controleColaborador = null;

    Colaborador colaboradorAntigo;
    Colaborador colaboradorAtual;

    String cargoDoColaborador = "";
    String statusDoColaborador = "";

    JComboBox<String> combo = new JComboBox<String>();

    // lISTA DE COLABORADORES ATUALIZADA NA MEMORIA
    ArrayList<Colaborador> listaDecolaboradores = new ArrayList<Colaborador>();

    /**
     * Creates new form TelaColaborador
     */
    public TelaColaborador() {
        initComponents();

        try {

            controleColaborador = new ColaboradorControle(EnumArquivoTxt.COLABORADOR.getNomeDoArquivo());
            colaboradorAntigo = new Colaborador();
            colaboradorAtual = new Colaborador();

            // Atualiza a lista de colaborades com o contedo do arquivo
           listaDecolaboradores = controleColaborador.recuperar();
            //imprime a lista de colaboradores na grid
           imprimirDadosnaGrid(listaDecolaboradores);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
        jTextFieldOab.setEnabled(true);
        jComboBoxEstados.setEnabled(true);
        jComboBoxSimNao.setSelectedItem("SIM");
        jComboBoxEstados.setSelectedIndex(-1);
        setLocationRelativeTo(null);
    }

    private void limparTela() {

        String t = "";
        
        jTextFieldNome.setText(t);
        jTextFieldEmail.setText(t);
        jTextFieldOab.setText(t);
        jTextFieldMatricula.setText(t);
        jTextFieldTelefone.setText(t);
        jComboBoxEstados.setSelectedIndex(-1);
        jComboBox_CARGO.setSelectedIndex(0);
    }

    private void imprimirDadosnaGrid(ArrayList<Colaborador> lista) {
        DefaultTableModel model = (DefaultTableModel) jTableTabelaCadastroColaborador.getModel();
        model.setNumRows(0);

        for (int pos = 0; pos < lista.size(); pos++) {

            String[] linha = new String[9];
            Colaborador aux = lista.get(pos);

            linha[0] = "" + aux.getId();
            linha[1] = aux.getNome().toUpperCase().toUpperCase();
            linha[2] = "" + aux.getMatricula();
            linha[3] = aux.getEmail().toUpperCase().toUpperCase();
            linha[4] = "" + aux.getTelefone();
            linha[5] = "" + aux.getTipoColaborador();
            linha[6] = "" + aux.getOAB();
            linha[7] = "" + aux.getEstado().toUpperCase();
            linha[8] = "" + aux.getTipoStatus();
            model.addRow(linha);
        }

    }

    public void preencherFormulario() {

        String posicaoid = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 0).toString().toUpperCase();
        String posicaoNome = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 1).toString().toUpperCase();
        String posicaoMatricula = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 2).toString().toUpperCase();
        String posicaoEmail = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 3).toString().toUpperCase();
        String posicaoTelefone = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 4).toString().toUpperCase();
        String posicaoTipo = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 5).toString().toUpperCase();
        String posicaoOAB = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 6).toString().toUpperCase();
        String posicaoEstado = jTableTabelaCadastroColaborador.getValueAt(jTableTabelaCadastroColaborador.getSelectedRow(), 7).toString().toUpperCase();
        

        jTextFieldNome.setText(posicaoNome);

        colaboradorAntigo.setId(Integer.parseInt(posicaoid));
        colaboradorAntigo.setNome(posicaoNome);
        jTextFieldMatricula.setText(posicaoMatricula);
        jTextFieldEmail.setText(posicaoEmail);
        jTextFieldTelefone.setText(posicaoTelefone);
        jComboBox_CARGO.setSelectedItem(posicaoTipo);
        
        jComboBoxEstados.setSelectedItem(posicaoEstado);
        jTextFieldOab.setText(posicaoOAB);

        //**HABILITAR CAMPOS E LIMPAR**\\
        
        if (posicaoOAB.equals("")) {
            jComboBoxSimNao.setSelectedItem("NÃO");
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

        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabelaCadastroColaborador = new javax.swing.JTable();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_CARGO = new javax.swing.JComboBox<>();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldOab = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSimNao = new javax.swing.JComboBox<>();
        jComboBoxEstados = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox_Status = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/blur.jpeg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar/ Pesquisar Colaborador");
        setMinimumSize(new java.awt.Dimension(1077, 720));
        setPreferredSize(new java.awt.Dimension(1077, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTabelaCadastroColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Matricula", "Email", "Telefone", "Cargo", "OAB", "UF", "Status"
            }
        ));
        jTableTabelaCadastroColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTabelaCadastroColaboradorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabelaCadastroColaborador);
        if (jTableTabelaCadastroColaborador.getColumnModel().getColumnCount() > 0) {
            jTableTabelaCadastroColaborador.getColumnModel().getColumn(7).setPreferredWidth(5);
            jTableTabelaCadastroColaborador.getColumnModel().getColumn(8).setPreferredWidth(5);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 980, 390));

        jButtonCadastrar.setText("INCLUIR");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, 90, 50));

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, 90, 50));

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 630, 90, 50));

        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 630, 90, 50));

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 40));

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 910, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/magnifying-glass.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, 60));

        jLabel1.setText("Matricula");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));
        getContentPane().add(jTextFieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 210, -1));

        jLabel3.setText("Cargo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 50));

        jComboBox_CARGO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione o Cargo>", "ADVOGADO", "ESTAGIARIO", "FUNCIONARIO" }));
        jComboBox_CARGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CARGOActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_CARGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 240, -1));
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 340, -1));

        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 30));
        getContentPane().add(jTextFieldOab, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 120, -1));

        jLabel6.setText("Nº OAB");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 50, 30));
        getContentPane().add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 240, -1));

        jLabel5.setText("Telefone");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, -1, 30));

        jComboBoxSimNao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));
        jComboBoxSimNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSimNaoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSimNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 80, -1));

        jComboBoxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RR", "RS", "SC", "SE", "SP", "TO" }));
        getContentPane().add(jComboBoxEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 70, -1));

        jLabel11.setText("UF");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, 50));

        jLabel9.setText("Contém OAB");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, 50));

        jLabel12.setText("Pesquisar");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 890, -1));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel17.setText("_ _ _ _ _ _ _ ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 70, 30));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel13.setText("F A T E S G ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, 20));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel18.setText("B i b l i o ");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 100, 40));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("_ _ _ _ _ _ _ _ _ ");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 90, 30));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel14.setText("P r o j e t o");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 20));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText(" t e c h");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 20));

        jComboBox_Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));
        getContentPane().add(jComboBox_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 130, -1));

        jLabel8.setText("Status");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagem/blur corte tela principal.jpeg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed

        try {

          if (jComboBoxEstados.getSelectedIndex() == -1) {
                colaboradorAtual.setEstado("");
            } else {
                colaboradorAtual.setEstado(jComboBoxEstados.getSelectedItem().toString());
            }
  
            colaboradorAtual.setNome(jTextFieldNome.getText().toUpperCase());
            colaboradorAtual.setMatricula(Integer.parseInt(jTextFieldMatricula.getText()));
            colaboradorAtual.setEmail(jTextFieldEmail.getText());
            colaboradorAtual.setTelefone(Integer.parseInt(jTextFieldTelefone.getText()));
            colaboradorAtual.setTipoColaborador(TipoDeColaborador.valueOf(jComboBox_CARGO.getSelectedItem().toString()));
            colaboradorAtual.setOAB(jTextFieldOab.getText());
            colaboradorAtual.setTipoStatus(TipoDeStatus.valueOf(jComboBox_Status.getSelectedItem().toString()));
            colaboradorAtual.setMulta(0);

            controleColaborador.incluir(colaboradorAtual);

            imprimirDadosnaGrid(controleColaborador.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso!");

            listaDecolaboradores = controleColaborador.recuperar();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jComboBox_CARGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CARGOActionPerformed

        if (jComboBox_CARGO.getSelectedItem().equals("ADVOGADO")) {
            jComboBoxSimNao.setSelectedItem("SIM");
            jTextFieldOab.setEnabled(true);
            jComboBoxEstados.setEnabled(true);
        } else {
            jComboBoxSimNao.setSelectedItem("NÃO");
            jTextFieldOab.setText("");
            jComboBoxEstados.setEnabled(false);
            jTextFieldOab.setEnabled(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_CARGOActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {

            if ( jTextFieldNome.getText().equals(""))  JOptionPane.showMessageDialog(null, "Selecione um nome para excluir !", "ERRO", JOptionPane.ERROR_MESSAGE);
            else { 

            controleColaborador.excluir(colaboradorAntigo.getId());

            imprimirDadosnaGrid(controleColaborador.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Exclusão Realizada com sucesso");

            listaDecolaboradores = controleColaborador.recuperar();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        try {
            
             if (jComboBoxEstados.getSelectedIndex() == -1) {
                colaboradorAtual.setEstado("");
            } else {
                colaboradorAtual.setEstado(jComboBoxEstados.getSelectedItem().toString());
            }

            colaboradorAtual.setId(colaboradorAntigo.getId()); 
            colaboradorAtual.setNome(jTextFieldNome.getText().toUpperCase());
            colaboradorAtual.setMatricula(Integer.parseInt(jTextFieldMatricula.getText()));
            colaboradorAtual.setEmail(jTextFieldEmail.getText().toUpperCase());
            colaboradorAtual.setTelefone(Integer.parseInt(jTextFieldTelefone.getText()));
            colaboradorAtual.setTipoColaborador(TipoDeColaborador.valueOf(jComboBox_CARGO.getSelectedItem().toString()));
            colaboradorAtual.setOAB(jTextFieldOab.getText());
            colaboradorAtual.setTipoStatus(TipoDeStatus.valueOf("ATIVO"));
            colaboradorAtual.setMulta(0);


            controleColaborador.alterar(colaboradorAntigo, colaboradorAtual);

            imprimirDadosnaGrid(controleColaborador.recuperar());

            limparTela();

            JOptionPane.showMessageDialog(rootPane, "Alteração Realizada com sucesso");

            listaDecolaboradores = controleColaborador.recuperar();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTableTabelaCadastroColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaCadastroColaboradorMouseClicked

        try {

            //  jButtonCadastrar.setEnabled(false);
            preencherFormulario();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTableTabelaCadastroColaboradorMouseClicked

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed

        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jComboBoxSimNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSimNaoActionPerformed

 if (jComboBoxSimNao.getSelectedItem().equals("SIM")) {
            jTextFieldOab.setEnabled(true);
            jComboBoxEstados.setEnabled(true);
        } else {
            jTextFieldOab.setText("");
            jTextFieldOab.setEnabled(false);
            jComboBoxEstados.setEnabled(false);
            jComboBoxEstados.setSelectedIndex(-1);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSimNaoActionPerformed

    private void jTextFieldPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyPressed

try {

            String textoDigitado = jTextFieldPesquisar.getText().toLowerCase(); // texto digitado na jtextfield em minuscula
            
            ArrayList<Colaborador> resultadoPesquisa = new ArrayList<>(); //lista vazia com o resultado da pesquisa
            //colaboradores == lista recuperada do arquivo
            for (Colaborador colaborador : listaDecolaboradores) {

                if ((colaborador.getNome().toLowerCase().trim().contains(textoDigitado)) 
                           
                        || (("" + colaborador.getId()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (colaborador.getEmail().toLowerCase().trim().contains(textoDigitado))
                        
                        || (colaborador.getOAB().toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + colaborador.getTelefone()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + colaborador.getMatricula()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + colaborador.getTipoColaborador()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + colaborador.getTipoStatus()).toLowerCase().trim().contains(textoDigitado))
                        
                        || (("" + colaborador.getEstado()).toLowerCase().trim().contains(textoDigitado))){
                   
                    resultadoPesquisa.add(colaborador); // INCLUI O RESULTADO ENCONTRADO NA LISTA
                }
            }
            imprimirDadosnaGrid(resultadoPesquisa);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
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
            java.util.logging.Logger.getLogger(TelaColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxEstados;
    private javax.swing.JComboBox<String> jComboBoxSimNao;
    private javax.swing.JComboBox<String> jComboBox_CARGO;
    private javax.swing.JComboBox jComboBox_Status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabelaCadastroColaborador;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldOab;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
