/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

/**
 *
 * @author Juan Pedro Gil
 */
public class Recorrido extends javax.swing.JFrame {

    /**
     * Creates new form Recorrido
     */
    public Recorrido() {
        initComponents();
        txtARecorrido.setText(Gramatica.camino);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtARecorrido = new javax.swing.JTextArea();
        btnOk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Recorrido de la gramática");

        txtARecorrido.setEditable(false);
        txtARecorrido.setColumns(20);
        txtARecorrido.setRows(5);
        jScrollPane1.setViewportView(txtARecorrido);

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("start with programa;\n\nprograma ::= PALABRA_RESERVADA_NUEVO principal funciones | PALABRA_RESERVADA_NUEVO principal ;\n\nprincipal ::=  PALABRA_RESERVADA_EJECUTAR  SIMBOLO_AGRUPACION_DOSP lineascodigo SIMBOLO_AGRUPACION_PCOMA | lineascodigo ;\n\n\nlineascodigo ::= lineacodigo | ; \n\nlineacodigo ::= lineacodigo linea | linea ;\n\nlinea ::= invocarmetodo FIN_LINEA | crearvariable FIN_LINEA | cambiarvalor FIN_LINEA | buclecondicion ; \t\n\ninvocarmetodo ::= IDENTIFICADOR SIMBOLO_AGRUPACION_PABRE parametrosenvio SIMBOLO_AGRUPACION_PACIERRA;\n\nparametrosenvio ::= parenvio | ;\n\nparenvio ::= parenvio COMA penvio | penvio;\n\npenvio ::= IDENTIFICADOR | valor ; \n\nvalor ::= NUM_FLOTANTE | NUM_ENTERO;\n\ncrearvariable ::= tipodato IDENTIFICADOR | tipodato IDENTIFICADOR SIMBOLO_ASIGNACION asignvalor;\n\ntipodato ::= PALABRA_RESERVADA_ENT | PALABRA_RESERVADA_DEC ;\n\nasignvalor ::= operasignacion ;\n\noperasignacion ::= expresion |invocarmetodo ; \n\nexpresion ::= valor x | h;\nx::= valor x | j ;\nj ::= valor | t;\nh::= t epri;\nepri ::= OP_ARITMETICO_ADD t epri| OP_ARITMETICO_SUB t epri |  ; \n\nt ::= f tpri;\ntpri ::= OP_ARITMETICO_MUL f tpri| OP_ARITMETICO_DIV f tpri |  ;\n\nf ::= valor | IDENTIFICADOR | SIMBOLO_AGRUPACION_PABRE expresion SIMBOLO_AGRUPACION_PACIERRA; \n\ncambiarvalor ::= IDENTIFICADOR SIMBOLO_ASIGNACION cambvalor;\n\ncambvalor ::= expresion ; \n\nbuclecondicion ::= condicionif | buclewhile ; \n\ncondicionif ::= condicionsi;\n\ncondicionsi ::= PALABRA_RESERVADA_SI SIMBOLO_AGRUPACION_PABRE condicion SIMBOLO_AGRUPACION_PACIERRA SIMBOLO_AGRUPACION_DOSP PALABRA_RESERVADA_CIERTO SIMBOLO_AGRUPACION_DOSP lineascodigo  SIMBOLO_AGRUPACION_PCOMA PALABRA_RESERVADA_FALSO SIMBOLO_AGRUPACION_DOSP lineascodigo SIMBOLO_AGRUPACION_PCOMA SIMBOLO_AGRUPACION_PCOMA;\n\ncondicion ::= valor condicional valor | valor condicional IDENTIFICADOR | IDENTIFICADOR condicional valor | IDENTIFICADOR condicional IDENTIFICADOR;\n\ncondicional ::= OP_RELACIONAL_IIGUAL | OP_RELACIONAL_MAIGUAL | OP_RELACIONAL_MEIGUAL | OP_RELACIONAL_DIFERENTE | OP_RELACIONAL_MAQUE | OP_RELACIONAL_MEQUE ;\n\nbuclewhile ::= PALABRA_RESERVADA_BUCLE SIMBOLO_AGRUPACION_PABRE condicion SIMBOLO_AGRUPACION_PACIERRA SIMBOLO_AGRUPACION_DOSP lineascodigo SIMBOLO_AGRUPACION_PCOMA ;\n\nfunciones  ::= funciones funcion | funcion;\n\nfuncion ::= PALABRA_RESERVADA_NUEVO IDENTIFICADOR SIMBOLO_AGRUPACION_PABRE parametrosin SIMBOLO_AGRUPACION_PACIERRA SIMBOLO_AGRUPACION_DOSP lineascodigo SIMBOLO_AGRUPACION_PCOMA;\n\nparametrosin ::= parametros | ; \n\nparametros ::= parametros COMA parametro | parametro;\n\nparametro ::= tipodato IDENTIFICADOR;");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

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
            java.util.logging.Logger.getLogger(Recorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recorrido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea txtARecorrido;
    // End of variables declaration//GEN-END:variables
}
