/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.util.regex.Pattern;
import javax.swing.JEditorPane;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import jsyntaxpane.syntaxkits.CSyntaxKit;
import jsyntaxpane.syntaxkits.CppSyntaxKit;
import jsyntaxpane.syntaxkits.JavaSyntaxKit;
//import jsyntaxpane.syntaxkits.CppSyntaxKit;


/**
 *
 * @author Cherne
 */
public class Codigo_Arduino extends javax.swing.JFrame {
    public String codigo,declaracion,globales;

    /**
     * Creates new form Codigo_Arduino
     */
    public Codigo_Arduino() {
        initComponents();
        //codigo = "FUNC EFEC : ENT y = 1| ; FUNC pegar: ENT z = 2| ;";
        codigo = "FUNC EFEC : ENT x=1| ; \n FUNC pegar() : ENT z=2| ;";
        
        jEditorPane1.setEditorKit(new CSyntaxKit());
        jEditorPane1.setFont(new java.awt.Font("Arial", 0, 24));
        codigo = codigo.replaceAll("\\s", " ");
        codigo = codigo.replaceAll(Pattern.quote("("), " ( ");
        codigo = codigo.replaceAll(Pattern.quote(")"), " ) ");
        codigo = codigo.replaceAll(Pattern.quote("|")," ");
        codigo = codigo.replaceAll("'+'", " + ");
        codigo = codigo.replaceAll("'-'", " - ");
        codigo = codigo.replaceAll("'*'", " * ");
        codigo = codigo.replaceAll("'/'", " / ");
        codigo = codigo.replaceAll(Pattern.quote("="), " = ");
        String resultado = generarCodigo(codigo);
        jEditorPane1.setText(generarCodigo(codigo));
        jEditorPane1.getText().replaceAll(Pattern.quote("|"),";");
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jEditorPane1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String generarCodigo(String codido){
        String [] codigo_generado = new String[3];
        declaracion=globales="";

        String aux[] = codido.split(" ");
        String setup = "//Declaracion\n"+
                        "Servo ser1;\n" +
                        "Servo ser2;\n" +
                        "char rxChar;\n" +
                        "int out=11;\n" +
                        "int out2=12;\n" +
                        "int out3=13;\n" +
                        "int out4 = 10;\n\n"+
                        "//SETUP\n"+
                        "void setup(){\n" +
                        "  pinMode(out,OUTPUT);\n" +
                        "  pinMode(out2,OUTPUT);\n" +
                        "  pinMode(out3,OUTPUT);\n" +
                        "  pinMode(out4,OUTPUT);\n" +
                        "  Serial.begin(9600); \n" +
                        "}";
        declaracion(aux);
        return setup+"\n"+globales+"\n"+declaracion;             

    }
    
    public void declaracion(String[] aux){
        declaracion = "";
        for(int i = 0; i<aux.length;i++){           
            switch(aux[i]){
                case "FUNC":{
                    declaracion+="void ";
                    i++;
                    switch(aux[i]){
                        case "EFEC":{
                            declaracion+="loop(){\n";
                            i++;
                            i++;
                            break;
                        }
                        default:{
                            declaracion+=aux[i]+"(";
                            i++;
                            i++;
                            while(!aux[i].equals(")")){
                                switch(aux[i]){
                                    case "ENT":{
                                        declaracion+="int "+aux[++i];
                                        break;
                                    }
                                    case "FLO":{
                                        declaracion+="float "+aux[++i];
                                        break;
                                    }
                                    case "BOO":{
                                        declaracion+="boolean "+aux[++i];
                                        break;
                                    }
                                    case ",":{
                                        declaracion+=",";
                                        break;
                                    }   
                                }
                                i++;
                            }
                            declaracion+="){\n";
                            i++;
                            i++;
                            break;
                        }
                    }
                    while(!aux[i].equals(";")){
                        switch(aux[i]){
                            case "ENT":{
                                declaracion+="int "+aux[++i]+" "+aux[++i]+" "+aux[++i]+";";
                                declaracion+="\n";
                                break;
                            }
                            case "FLO":{
                                declaracion+="float "+aux[++i]+" "+aux[++i]+" "+aux[++i]+";";
                                declaracion+="\n";
                                break;
                            }
                            case "BOO":{
                                declaracion+="boolean "+aux[++i]+" "+aux[++i]+" "+aux[++i]+";";
                                declaracion+="\n";
                                break;
                            }
                            
                            //Aqui va el despuche de las demas palabras reservadas

                        }
                        i++;
                        
                    }
                    declaracion+="}\n";
                    i++;
                    break; 
                }
                case "ENT":{
                    globales+="int "+aux[++i]+" "+aux[++i]+" "+aux[++i]+";";
                    globales+="\n";
                    break;
                }
                case "FLO":{
                    globales+="float "+aux[++i]+" "+aux[++i]+" "+aux[++i]+";";
                    globales+="\n";
                    break;
                }
                case "BOO":{
                    globales+="boolean "+aux[++i]+" "+aux[++i]+" "+aux[++i]+";";
                    globales+="\n";
                    break;
                }
                
                
                
                
            }   
        }
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
            java.util.logging.Logger.getLogger(Codigo_Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Codigo_Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Codigo_Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Codigo_Arduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Codigo_Arduino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
