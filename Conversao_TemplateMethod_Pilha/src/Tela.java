import classes.*;

public class Tela extends javax.swing.JFrame {
    int vetor[];

    public Tela() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_ValorParaConverter = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_Binario = new javax.swing.JButton();
        jButton_Octal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_RESPOSTA = new javax.swing.JTextArea();
        jButton_Hexa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Valor Decimal para converter:");

        jLabel2.setText("Converter para:");

        jButton_Binario.setText("Binário");
        jButton_Binario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BinarioActionPerformed(evt);
            }
        });

        jButton_Octal.setText("Octal");
        jButton_Octal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OctalActionPerformed(evt);
            }
        });

        jTextArea_RESPOSTA.setColumns(20);
        jTextArea_RESPOSTA.setRows(5);
        jScrollPane1.setViewportView(jTextArea_RESPOSTA);

        jButton_Hexa.setText("Hexadecimal");
        jButton_Hexa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HexaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Binario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Octal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Hexa))
                            .addComponent(jTextField_ValorParaConverter))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_ValorParaConverter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton_Binario)
                    .addComponent(jButton_Octal)
                    .addComponent(jButton_Hexa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BinarioActionPerformed
        Binaria base = new Binaria();
        AcoesParaBotoes(base);  
    }//GEN-LAST:event_jButton_BinarioActionPerformed

    private void jButton_OctalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OctalActionPerformed
        Octal base = new Octal();
        AcoesParaBotoes(base);
    }//GEN-LAST:event_jButton_OctalActionPerformed

    private void jButton_HexaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HexaActionPerformed
          String valor = jTextField_ValorParaConverter.getText();
          int x = Integer.parseInt(valor);
          String HEXA = Integer.toHexString(x);
          String saida = "Conversão de 10 para base 16 \n"+HEXA.toUpperCase();
          jTextArea_RESPOSTA.setText(saida);
//        Hexadecimal base = new Hexadecimal();
//        AcoesParaBotoes(base);
        
    }//GEN-LAST:event_jButton_HexaActionPerformed
    private void AcoesParaBotoes(AbsPilhaDivisao base) {

        base.setA(Integer.parseInt(jTextField_ValorParaConverter.getText()));
        base.setTamanho(base.tamanhoDaPilha(base.getA(), base.base())); //Seto os valores
        vetor = new int[base.getTamanho()];  //CRIO UM VETOR DE TAMANHO GET TAMANHO
        base.setResto(vetor);              // SETO O VETOR DA CLASSE COMO  O  VETOR CRIADO (Dimensões)
        base.mudancaDeBase(base.getA());  // CHAMO O METODO MUDANCA PASSANDO VALOR INSERIDO PELO USUARIO Para converter de acordo com a base criada
        String saida = "Conversão de " + base.getA() + " para base " + base.base() + " \n";
  //        for (int i = vetor.length - 1; i >= 0; i--) {  // Como é pilha mostro os valores inversamente
 //            saida += base.getResto()[i];
//        }
        saida+=DesenpilharImprimir(base);
        jTextArea_RESPOSTA.setText(saida);
    }
    
     private String DesenpilharImprimir (AbsPilhaDivisao pilha){
        int ImprimirPilhaOrdenada [] = new int [pilha.quantidadeElementos()];
        String saida = "";
        int i = 0;
         while (!pilha.estaVazia()) { 
             int valor = pilha.consultar();
             ImprimirPilhaOrdenada[i] = valor;
             saida+=ImprimirPilhaOrdenada[i];
             i++;
             pilha.retirar();
         }
           
           return saida;
        }
     

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Binario;
    private javax.swing.JButton jButton_Hexa;
    private javax.swing.JButton jButton_Octal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_RESPOSTA;
    private javax.swing.JTextField jTextField_ValorParaConverter;
    // End of variables declaration//GEN-END:variables
}
