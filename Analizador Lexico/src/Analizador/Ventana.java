package Analizador;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cherne
 */
public class Ventana extends javax.swing.JFrame {

    
    List<List> lista;
    List<List> listaFuncion;
    ArrayList<String[]> tablaSimbolos;
    boolean banderaErrorLexico;
    int errores;
    Gramatica g=new Gramatica();
    ArrayList<String> gramatica=new ArrayList<String>();
    boolean comparacion=false;
    boolean soloVDD=false,soloVDDComparacion=false,declararFuncion=false,insertar_parametros=false;
    String numComparacion=null,varComparacion=null;    
    boolean bandVariable,bandVariable2;
    boolean bandFuncion;
    boolean bandComparacion;
    String comparando1,comparando2,salidaComparacion;
    /**
     * Creates new form Ventana
     */
    DefaultStyledDocument doc;
    public Ventana() {
        
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attrGray = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.gray);
        final AttributeSet attrGreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet attrBlue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        final AttributeSet attrRed = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
        final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        
        doc = new DefaultStyledDocument() {
            @Override
            public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {                     

                        if (text.substring(wordL, wordR).matches("(\\W)*(APG)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(ACTM)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(BOO)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(CJT)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(CLX)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(COM)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
                        else if (text.substring(wordL, wordR).matches("(\\W)*(DET)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(ECD)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(EFEC)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(ENT)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(EXC)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(FLO)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(FLS)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(FUNC)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(GIRAI)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(GIRAD)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(LUZ)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(MOVAD)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(MOVAT)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(NT)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(S)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(SN)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(SPD)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        else if (text.substring(wordL, wordR).matches("(\\W)*(VDD)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); 
                        
                        
                        else
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        wordL = wordR;
                    }
                    wordR++;
                }
            }
        };
        
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255,204,0));
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) d.getWidth() , (int) d.getHeight()-50);
       
        //El path debe ser el de donde tienes la carpeta
        this.setResizable(false);
        bandComparacion=false;
        bandFuncion=false;
        bandVariable=false;
        bandVariable2=false;
        tablaSimbolos = new ArrayList();
        txtAreaCodigo.requestFocus();
        txtAreaNum.setCaretPosition(0);
        //txtAreaCodigo.setTabSize(2);
        errores=0;
         comparando1="";
         comparando2="";
         salidaComparacion="";
         lista=new ArrayList<List>();
         listaFuncion=new ArrayList<List>();
         lista.add(new ArrayList<String>());
         lista.add(new ArrayList<Integer>());
         lista.add(new ArrayList<Integer>());
         lista.add(new ArrayList<Integer>());
         listaFuncion.add(new ArrayList<String>());
         listaFuncion.add(new ArrayList<Integer>());
         listaFuncion.add(new ArrayList<Integer>());
        //txtAreaSalida.setFont(txtAreaSalida.getFont().deriveFont(16f));
        //txtAreaCodigo.setFont(txtAreaCodigo.getFont().deriveFont(16f));                        
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
        jSplitPane1 = new javax.swing.JSplitPane();
        txtAreaCodigo = new javax.swing.JTextPane(doc);
        txtAreaNum = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSalida = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTS = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnLexico = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnTabla = new javax.swing.JButton();
        btnRecorrido = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_ALexico = new javax.swing.JButton();
        btnOptimizacion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(30);
        jSplitPane1.setDividerSize(2);

        //txtAreaCodigo.setColumns(20);
        txtAreaCodigo.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        //txtAreaCodigo.setRows(5);
        txtAreaCodigo.setText("FUNC EFEC:\n\n;");
        jSplitPane1.setRightComponent(txtAreaCodigo);

        txtAreaNum.setEditable(false);
        //txtAreaNum.setColumns(20);
        txtAreaNum.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        //txtAreaNum.setRows(5);
        txtAreaNum.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31\n32\n33\n34\n35\n36\n37\n38\n39\n40\n41\n42\n43\n44\n45\n46\n47\n48\n49\n50\n51\n52\n53\n54\n55\n56\n57\n58\n59\n60\n61\n62\n63\n64\n65\n66\n67\n68\n69\n70\n71\n72\n73\n74\n75\n76\n77\n78\n79\n80\n81\n82\n83\n84\n85\n86\n87\n88\n89\n90\n91\n92\n93\n94\n95\n96\n97\n98\n99\n100\n101\n102\n103\n104\n105\n106\n107\n108\n109\n110\n111\n112\n113\n114\n115\n116\n117\n118\n119\n120\n121\n122\n123\n124\n125\n126\n127\n128\n129\n130\n131\n132\n133\n134\n135\n136\n137\n138\n139\n140\n141\n142\n143\n144\n145\n146\n147\n148\n149\n150\n151\n152\n153\n154\n155\n156\n157\n158\n159\n160\n161\n162\n163\n164\n165\n166\n167\n168\n169\n170\n171\n172\n173\n174\n175\n176\n177\n178\n179\n180\n181\n182\n183\n184\n185\n186\n187\n188\n189\n190\n191\n192\n193\n194\n195\n196\n197\n198\n199\n200\n201\n202\n203\n204\n205\n206\n207\n208\n209\n210\n211\n212\n213\n214\n215\n216\n217\n218\n219\n220\n221\n222\n223\n224\n225\n226\n227\n228\n229\n230\n231\n232\n233\n234\n235\n236\n237\n238\n239\n240\n241\n242\n243\n244\n245\n246\n247\n248\n249\n250\n251\n252\n253\n254\n255\n256\n257\n258\n259\n260\n261\n262\n263\n264\n265\n266\n267\n268\n269\n270\n271\n272\n273\n274\n275\n276\n277\n278\n279\n280\n281\n282\n283\n284\n285\n286\n287\n288\n289\n290\n291\n292\n293\n294\n295\n296\n297\n298\n299\n300\n301\n302\n303\n304\n305\n306\n307\n308\n309\n310\n311\n312\n313\n314\n315\n316\n317\n318\n319\n320\n321\n322\n323\n324\n325\n326\n327\n328\n329\n330\n331\n332\n333\n334\n335\n336\n337\n338\n339\n340\n341\n342\n343\n344\n345\n346\n347\n348\n349\n350\n351\n352\n353\n354\n355\n356\n357\n358\n359\n360\n361\n362\n363\n364\n365\n366\n367\n368\n369\n370\n371\n372\n373\n374\n375\n376\n377\n378\n379\n380\n381\n382\n383\n384\n385\n386\n387\n388\n389\n390\n391\n392\n393\n394\n395\n396\n397\n398\n399\n400\n401\n402\n403\n404\n405\n406\n407\n408\n409\n410\n411\n412\n413\n414\n415\n416\n417\n418\n419\n420\n421\n422\n423\n424\n425\n426\n427\n428\n429\n430\n431\n432\n433\n434\n435\n436\n437\n438\n439\n440\n441\n442\n443\n444\n445\n446\n447\n448\n449\n450\n451\n452\n453\n454\n455\n456\n457\n458\n459\n460\n461\n462\n463\n464\n465\n466\n467\n468\n469\n470\n471\n472\n473\n474\n475\n476\n477\n478\n479\n480\n481\n482\n483\n484\n485\n486\n487\n488\n489\n490\n491\n492\n493\n494\n495\n496\n497\n498\n499\n500\n501\n502\n503\n504\n505\n506\n507\n508\n509\n510\n511\n512\n513\n514\n515\n516\n517\n518\n519\n520\n521\n522\n523\n524\n525\n526\n527\n528\n529\n530\n531\n532\n533\n534\n535\n536\n537\n538\n539\n540\n541\n542\n543\n544\n545\n546\n547\n548\n549\n550\n551\n552\n553\n554\n555\n556\n557\n558\n559\n560\n561\n562\n563\n564\n565\n566\n567\n568\n569\n570\n571\n572\n573\n574\n575\n576\n577\n578\n579\n580\n581\n582\n583\n584\n585\n586\n587\n588\n589\n590\n591\n592\n593\n594\n595\n596\n597\n598\n599\n600\n601\n602\n603\n604\n605\n606\n607\n608\n609\n610\n611\n612\n613\n614\n615\n616\n617\n618\n619\n620\n621\n622\n623\n624\n625\n626\n627\n628\n629\n630\n631\n632\n633\n634\n635\n636\n637\n638\n639\n640\n641\n642\n643\n644\n645\n646\n647\n648\n649\n650\n651\n652\n653\n654\n655\n656\n657\n658\n659\n660\n661\n662\n663\n664\n665\n666\n667\n668\n669\n670\n671\n672\n673\n674\n675\n676\n677\n678\n679\n680\n681\n682\n683\n684\n685\n686\n687\n688\n689\n690\n691\n692\n693\n694\n695\n696\n697\n698\n699\n700\n701\n702\n703\n704\n705\n706\n707\n708\n709\n710\n711\n712\n713\n714\n715\n716\n717\n718\n719\n720\n721\n722\n723\n724\n725\n726\n727\n728\n729\n730\n731\n732\n733\n734\n735\n736\n737\n738\n739\n740\n741\n742\n743\n744\n745\n746\n747\n748\n749\n750\n751\n752\n753\n754\n755\n756\n757\n758\n759\n760\n761\n762\n763\n764\n765\n766\n767\n768\n769\n770\n771\n772\n773\n774\n775\n776\n777\n778\n779\n780\n781\n782\n783\n784\n785\n786\n787\n788\n789\n790\n791\n792\n793\n794\n795\n796\n797\n798\n799\n800\n801\n802\n803\n804\n805\n806\n807\n808\n809\n810\n811\n812\n813\n814\n815\n816\n817\n818\n819\n820\n821\n822\n823\n824\n825\n826\n827\n828\n829\n830\n831\n832\n833\n834\n835\n836\n837\n838\n839\n840\n841\n842\n843\n844\n845\n846\n847\n848\n849\n850\n851\n852\n853\n854\n855\n856\n857\n858\n859\n860\n861\n862\n863\n864\n865\n866\n867\n868\n869\n870\n871\n872\n873\n874\n875\n876\n877\n878\n879\n880\n881\n882\n883\n884\n885\n886\n887\n888\n889\n890\n891\n892\n893\n894\n895\n896\n897\n898\n899\n900\n901\n902\n903\n904\n905\n906\n907\n908\n909\n910\n911\n912\n913\n914\n915\n916\n917\n918\n919\n920\n921\n922\n923\n924\n925\n926\n927\n928\n929\n930\n931\n932\n933\n934\n935\n936\n937\n938\n939\n940\n941\n942\n943\n944\n945\n946\n947\n948\n949\n950\n951\n952\n953\n954\n955\n956\n957\n958\n959\n960\n961\n962\n963\n964\n965\n966\n967\n968\n969\n970\n971\n972\n973\n974\n975\n976\n977\n978\n979\n980\n981\n982\n983\n984\n985\n986\n987\n988\n989\n990\n991\n992\n993\n994\n995\n996\n997\n998\n999\n1000\n");
        jSplitPane1.setLeftComponent(txtAreaNum);

        jScrollPane1.setViewportView(jSplitPane1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("AutoSiembra");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Salida"));

        txtAreaSalida.setEditable(false);
        txtAreaSalida.setColumns(20);
        txtAreaSalida.setRows(5);
        txtAreaSalida.setBorder(null);
        jScrollPane2.setViewportView(txtAreaSalida);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("COMPONENTES LEXICOS"));
        jScrollPane3.setFocusTraversalPolicyProvider(true);
        jScrollPane3.setFocusable(false);

        tableTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TOKEN", "LEXEMA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTS.setFocusable(false);
        jScrollPane3.setViewportView(tableTS);
        if (tableTS.getColumnModel().getColumnCount() > 0) {
            tableTS.getColumnModel().getColumn(0).setResizable(false);
            tableTS.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableTS.getColumnModel().getColumn(1).setResizable(false);
            tableTS.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        //btnLexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lexico.png"))); // NOI18N
        btnLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLexicoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLexico);

        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sintactico.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

       // btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Limpiar.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiar);

//        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Abrir.png"))); // NOI18N
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

   //     btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnTabla.setText("Tabla de simbolos");
        btnTabla.setFocusable(false);
        btnTabla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTabla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTabla);

        btnRecorrido.setText("Recorrido");
        btnRecorrido.setFocusable(false);
        btnRecorrido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecorrido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorridoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRecorrido);

        //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arduino.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        btn_ALexico.setText("Análisis Léxico");
        btn_ALexico.setFocusable(false);
        btn_ALexico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ALexico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_ALexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ALexicoActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_ALexico);

        btnOptimizacion.setText("Optimización");
        btnOptimizacion.setFocusable(false);
        btnOptimizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOptimizacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOptimizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptimizacionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOptimizacion);

        jButton3.setText("Automata");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Integrantes del Equipo"));

        jLabel2.setText("14400941       Gil Llanos Juan Pedro");

        jLabel3.setText("14400944       González Arellano Ernesto");

        jLabel4.setText("14400968       Monroy Salcedo Jose de Jesus");

        jLabel5.setText("14401007      Sanchez Carrillo Betsy del Carmen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(20, 20, 20))
        );

        //jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Hojita.png"))); // NOI18N

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compilar");

        jMenuItem5.setText("Léxico");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Sintáctico");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Compilar");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Correr");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        menuAyuda.setText("Ayuda");
        menuAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAyudaMouseClicked(evt);
            }
        });
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 18140, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private int findLastNonWordChar (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
    
    private void btnLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLexicoActionPerformed
        // TODO add your handling code here:
        Gramatica.camino="";
        String errorSemantico="",func_llamada="";
        String funcion="";
        banderaErrorLexico = false;
        insertar_parametros=false;
        boolean esFuncion=false,funcionParametros=false;
        int contar_par=0;
        File codigo = new File("Codigo.txt");
        PrintWriter writer;
        errores=0;
        boolean simbolo=false,declaracion=false,asignacion=false;
        comparacion=false;
        soloVDD=false;
        soloVDDComparacion=false;
        String nombreID="",tipo="";
        String[] auxSimbolo=new String[0];//Guarda los datos que se insertarÃ¡n en la tabla de sÃ­mbolos

        try{
            writer = new PrintWriter(codigo);
            writer.print(txtAreaCodigo.getText());
            writer.close();
        }catch(FileNotFoundException e){
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
            Lexer lexer = new Lexer(reader);
            String resultado="\n\n";
            DefaultTableModel model = (DefaultTableModel)tableTS.getModel();
            while(model.getRowCount()!=0){
                model.removeRow(0);   
            }
            while(true){
                Token token = lexer.yylex();
                if(token == null){
                    tableTS.setModel(model);
                    
                    resultado+="     Numero de errores: "+errores;

                    txtAreaSalida.setText(resultado+"\n"+errorSemantico);
                    return;
                }else{
                    if(token.toString().equals("PALABRA_RESERVADA")||token.toString().equals("SIMBOLO_AGRUPACION")||token.toString().equals("SIMBOLO_ASIGNACION")
                            || token.toString().equals("OP_SINTAXIS")||token.toString().equals("FIN_LINEA")
                            ||token.toString().equals("OP_RELACIONAL")||token.toString().equals("OP_ARITMETICO")){
                        gramatica.add(lexer.lexeme+"");
                    }else{
                        gramatica.add(token.toString()+"");
                    }
                }
                /*if(declaracion){
                    auxSimbolo[0]=lexer.lexeme;
                    if(!tabla.revisar(token.toString())){
                        //JOptionPane.showMessageDialog(this, "ErrorSemantico "+auxSimbolo[0]);
                        errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" ya se encuentra declarado, linea "+lexer.linea+1+"\n";
                    }else{
                        auxSimbolo[2]=""+(lexer.linea+1);
                        auxSimbolo[4]=funcion;
                        if(tabla.nuevoSimbolo(auxSimbolo)){
                            JOptionPane.showMessageDialog(this, "Exito en tabla de simbolos");
                        }else{
                            JOptionPane.showMessageDialog(this, "Error en tabla de simbolos");
                        }
                    }

                    declaracion=false;
                    simbolo=false;
                }*/
                switch(token){
                    //Quitar la cosa que lo muestra
                    case CADENA_DESCONOCIDA:     
                        bandFuncion=false;
                        bandComparacion=false;
                        bandVariable=false;
                        model.addRow(new Object[]{token,lexer.lexeme});
                        banderaErrorLexico = true;
                        resultado+="Error léxico, cadena no valida: "+lexer.lexeme +",Linea: "+(lexer.linea+1)+"\n";
                        errores++;
                        break;
                    case SIMBOLO_DESCONOCIDO: 
                        bandFuncion=false;
                        bandComparacion=false;
                        bandVariable=false;
                        model.addRow(new Object[]{token,lexer.lexeme});
                        banderaErrorLexico = true;
                        resultado+="Error léxico, simbolo desconocido: "+lexer.lexeme +",Linea: "+(lexer.linea+1)+"\n";
                        errores++;
                        break;
                    case IDENTIFICADOR:
                        salidaComparacion="";
                        if(bandComparacion){
                             comparando2=lexer.lexeme;
                             if(comparando1.equals(comparando2)){
                                 salidaComparacion= "Comparación entre el mismo operando, en la linea: "+(lexer.linea+1)+"\n";
                             }
                        }
                        else{comparando1=lexer.lexeme;}
                        bandComparacion=false;
                        buscarVariable(lexer.lexeme);
                        buscarFuncion(lexer.lexeme);
                        if(bandVariable){
                             lista.get(0).add(nombreID);
                             lista.get(1).add(1);
                             lista.get(2).add(lexer.linea+1);
                              bandVariable2=true;
                        }
                        if(bandFuncion){
                             listaFuncion.get(0).add(nombreID);
                             listaFuncion.get(1).add(1);
                             listaFuncion.get(2).add(lexer.linea+1);
                         }bandFuncion=false;
                        /*if(declararFuncion){
                            auxSimbolo=new String[5];
                            auxSimbolo[0]=lexer.lexeme;
                            auxSimbolo[1]="FUNC";
                            funcion=lexer.lexeme;
                            auxSimbolo[2]=lexer.linea+1+"";
                            tabla.nuevoSimbolo(auxSimbolo);
                        }*/
                        if(declararFuncion){
                            funcion=lexer.lexeme;
                        }
                        if(tabla.sacarTipo(lexer.lexeme).equals("FUNC")){
                            esFuncion=true;
                        }else{
                            esFuncion=false;
                        }
                        if(asignacion){
                            asignacion=false;
                                if(tabla.sacarFuncion(nombreID).equals(funcion)){
                                if(tabla.sacarFuncion(lexer.lexeme).equals(funcion)){
                                    tabla.actualizar(nombreID, tabla.sacarValorParametro(lexer.lexeme,funcion));
                                }else{
                                    if(tabla.sacarFuncionParametro(lexer.lexeme, funcion)){
                                        tabla.actualizar(nombreID, tabla.sacarValorParametro(lexer.lexeme,funcion));
                                    }else{
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" la variable no pertenece a la función "+funcion+", linea "+(lexer.linea+1)+"\n";
                                    }
                                }
                            }else{
                                if(tabla.sacarFuncion(lexer.lexeme).equals(funcion)){
                                    tabla.actualizar_parametro(nombreID, tabla.sacarValorParametro(lexer.lexeme,funcion));
                                }else{
                                    if(tabla.sacarFuncionParametro(lexer.lexeme, funcion)){
                                        tabla.actualizar_parametro(nombreID, tabla.sacarValorParametro(lexer.lexeme,funcion));
                                    }else{
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" la variable no pertenece a la función "+funcion+", linea "+(lexer.linea+1)+"\n";
                                    }
                                }
                            }
                        }
                        /*if(!insertar_parametros){
                            if(tabla.revisar(lexer.lexeme)){
                                if(tabla.sacarTipo(lexer.lexeme)!=null){
                                    if(tabla.sacarTipo(lexer.lexeme).equals("BOO")){
                                        soloVDDComparacion=true;
                                    }
                                }
                            }
                        }*/
                        nombreID=lexer.lexeme;
                        if(comparacion){
                            String tipo1,tipo2;
                            tipo1=tabla.sacarTipo(varComparacion);
                            tipo2=tabla.sacarTipo(lexer.lexeme);
                            if(!tipo1.equals(tipo2)){
                                //JOptionPane.showMessageDialog(this, "Error semÃ¡ntico");
                                errorSemantico+="Error semántico: "+varComparacion+" no se puede comparar con "+lexer.lexeme+
                                        " porque son de tipos incompatibles, linea "+(lexer.linea+1)+"\n";
                            }
                            comparacion=false;
                        }
                        varComparacion=lexer.lexeme;
                        if(!insertar_parametros){
                            func_llamada=lexer.lexeme;
                        }
                        if(insertar_parametros && tabla.contarParametros(func_llamada)>0 && !funcionParametros){ 
                                if(!tabla.sacarTipo(lexer.lexeme).equals(tabla.sacarTipoParametro(func_llamada, contar_par))){
                                    errorSemantico+="Error semántico: "+lexer.lexeme+" no es del tipo "+tabla.sacarTipoParametro(func_llamada, contar_par)+
                                            " porque son de tipos incompatibles, linea "+(lexer.linea+1)+"\n";
                                }
                            contar_par++;
                        }
                        break;
                    case PALABRA_RESERVADA:
                        bandFuncion=false;
                        bandVariable=false;
                        bandComparacion=false;
                        //comparando1="";
                        comparando2="";
                        
                        
                        if(lexer.lexeme.equals("EFEC")){
                            funcion="EFEC";
                        }
                        if(lexer.lexeme.equals("FUNC")){
                            declararFuncion=true;
                            bandFuncion=true;
                        }else{
                            declararFuncion=false;
                        }
                        if(lexer.lexeme.equals("ENT") || lexer.lexeme.equals("FLO") || lexer.lexeme.equals("BOO")){
                            declaracion=true;
                            auxSimbolo=new String[5];
                            auxSimbolo[1]=lexer.lexeme;
                            tipo=lexer.lexeme;
                            bandVariable=true;
                        }
                        if(lexer.lexeme.equals("VDD")||lexer.lexeme.equals("FLS")){
                            if(asignacion){
                                if(!soloVDD){
                                    //JOptionPane.showMessageDialog(this, "Error semÃ¡ntico");
                                    errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" es un tipo incompatible, linea "+(lexer.linea+1)+"\n";
                                }else{
                                    asignacion=false;
                                    if(tabla.sacarFuncion(nombreID).equals(funcion)){
                                        tabla.actualizar(nombreID,lexer.lexeme);
                                    }else{
                                        //JOptionPane.showMessageDialog(this,"Error semÃ¡ntico, la variable no pertenece a la funciÃ³n");
                                        errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" la variable no pertenece a la funciÃ³n "+funcion+", linea "+(lexer.linea+1)+"\n";
                                    }
                                }
                            }
                        }
                        if(lexer.lexeme.equals("BOO")){
                            soloVDD=true;
                        }else{
                            soloVDD=false;
                        }
                        model.addRow(new Object[]{token,lexer.lexeme});
                        break;
                    case SIMBOLO_ASIGNACION:
                        asignacion=true;
                        model.addRow(new Object[]{token,lexer.lexeme});
                        bandComparacion=false;
                        bandFuncion=false;
                        // comparando1="";
                        if(bandVariable2){
                            lista.get(3).add(1);
                            bandVariable=false;
                        }
                        bandVariable2=false;
                        break;
                    case NUM_ENTERO:
                        if(asignacion){
                            if(tabla.sacarFuncion(lexer.lexeme)!=null){
                                if(tipo.equals("ENT")||tipo.equals("FLO")){
                                    asignacion=false;

                                        if(tabla.sacarFuncion(nombreID).equals(funcion)){
                                            tabla.actualizar(nombreID,lexer.lexeme);
                                        }else{
                                            //JOptionPane.showMessageDialog(this,"Error semÃ¡ntico, la variable no pertenece a la funciÃ³n");
                                            errorSemantico+="Error semántico: "+lexer.lexeme+" la variable no pertenece a la función "+funcion+", linea "+(lexer.linea+1)+"\n";
                                        }
                                }else{
                                    //JOptionPane.showMessageDialog(this,"Error semÃ¡ntico");
                                    errorSemantico+="Error semántico: "+lexer.lexeme+" es un tipo incompatible, linea "+(lexer.linea+1)+"\n";
                                }
                            }else{
                                    if(!tabla.revisar_parametro(nombreID, funcion)){
                                        if(tabla.sacarTipoParametro(nombreID, funcion).equals("ENT") || tabla.sacarTipoParametro(nombreID, funcion).equals("FLO")){
                                            tabla.actualizar_parametro(nombreID,lexer.lexeme);
                                        }
                                    }else{
                                        //JOptionPane.showMessageDialog(this,"Error semÃ¡ntico, la variable no pertenece a la funciÃ³n");
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" la variable no pertenece a la funciÃ³n "+funcion+", linea "+(lexer.linea+1)+"\n";
                                    }
                                }
                        }
                        if(comparacion){
                            if(numComparacion==null){
                                if(!tabla.revisar(varComparacion)){
                                    if(tabla.sacarTipo(varComparacion).equals("ENT")||tabla.sacarTipo(varComparacion).equals("FLO")){
                                    
                                    }else{
                                        //JOptionPane.showMessageDialog(this, "Error semantico");
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" no se puede comparar con "+varComparacion+" porque son de diferente tipo, linea "+(lexer.linea+1)+"\n";
                                    }
                                }else{
                                    if(tabla.sacarTipoParametro(varComparacion,funcion).equals("ENT")||tabla.sacarTipoParametro(varComparacion,funcion).equals("FLO")){
                                    
                                    }else{
                                        //JOptionPane.showMessageDialog(this, "Error semantico");
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" no se puede comparar con "+varComparacion+" porque son de diferente tipo, linea "+(lexer.linea+1)+"\n";
                                    }
                                }
                                comparacion=false;
                            }
                            
                        }else{
                            numComparacion=null;
                        }
                        numComparacion=lexer.lexeme;
                        model.addRow(new Object[]{token,lexer.lexeme});
                        bandComparacion=false;
                        bandFuncion=false;
                        bandVariable=false;
                         //comparando1="";
                        comparando2="";
                        break;
                    case NUM_FLOTANTE:
                        if(asignacion){
                            if(tipo.equals("FLO")){
                                asignacion=false;
                                if(tabla.sacarFuncion(nombreID).equals(funcion)){
                                    tabla.actualizar(nombreID,lexer.lexeme);
                                }else{
                                    //JOptionPane.showMessageDialog(this,"Error semÃ¡ntico, la variable no pertenece a la funciÃ³n");
                                    errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" la variable no pertenece a la funciÃ³n "+funcion+", linea "+(lexer.linea+1)+"\n";
                                }
                            }else{
                                //JOptionPane.showMessageDialog(this,"Error semÃ¡ntico");
                                errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" es un tipo incompatible, linea "+(lexer.linea+1)+"\n";
                            }
                        }
                        if(comparacion){
                            if(numComparacion==null){
                                if(!tabla.revisar(varComparacion)){
                                    if(tabla.sacarTipo(varComparacion).equals("ENT")||tabla.sacarTipo(varComparacion).equals("FLO")){
                                    
                                    }else{
                                        //JOptionPane.showMessageDialog(this, "Error semantico");
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" no se puede comparar con "+varComparacion+" porque son de diferente tipo, linea "+(lexer.linea+1)+"\n";
                                    }
                                }else{
                                    if(tabla.sacarTipoParametro(varComparacion,funcion).equals("ENT")||tabla.sacarTipoParametro(varComparacion,funcion).equals("FLO")){
                                    
                                    }else{
                                        //JOptionPane.showMessageDialog(this, "Error semantico");
                                        errorSemantico+="Error semántico: "+lexer.lexeme+" no se puede comparar con "+varComparacion+" porque son de diferente tipo, linea "+(lexer.linea+1)+"\n";
                                    }
                                }
                                comparacion=false;
                            }else{
                                
                            }
                            
                        }else{
                            numComparacion=null;
                        }
                        numComparacion=lexer.lexeme;
                        model.addRow(new Object[]{token,lexer.lexeme});
                        bandComparacion=false;
                        bandFuncion=false;
                        bandVariable=false;
                         //comparando1="";
                        comparando2="";
                        break;
                    case OP_RELACIONAL:
                        comparacion=true;
                        if(soloVDDComparacion){
                            if(!lexer.lexeme.equals("==")){
                                //JOptionPane.showMessageDialog(this, "Error semantico");
                                errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" no se puede utilizar para comparar valores booleanos, linea "+(lexer.linea+1)+"\n";
                            }
                        }
                        bandFuncion=false;
                        bandVariable=false;
                        bandComparacion=false;
                        javax.swing.JOptionPane.showMessageDialog(this, "Op Relacional="+lexer.lexeme);  
                        if(lexer.lexeme.equals(">")||lexer.lexeme.equals("<")||lexer.lexeme.equals(">=")||lexer.lexeme.equals("<=")
                                ||lexer.lexeme.equals("==")||lexer.lexeme.equals("!=")){
                            bandComparacion=true;
                        }
                        break;
                        case SIMBOLO_AGRUPACION:
                            if(lexer.lexeme.equals("(")){
                                if(declararFuncion || esFuncion){
                                    insertar_parametros=true;
                                    if(declararFuncion){
                                        funcionParametros=true;
                                    }
                                }
                            }
                            if(lexer.lexeme.equals(")")){
                                insertar_parametros=false;
                                funcionParametros=false;
                                contar_par=0;
                            }
                        break;
                        case FIN_LINEA:
                            numComparacion=null;
                            bandComparacion=false;
                        bandFuncion=false;
                        if(bandVariable2){
                            lista.get(3).add(2);
                            bandVariable=false;
                        }
                        bandVariable2=false;
                         //comparando1="";
                        comparando2="";
                            break;
                        case OP_SINTAXIS:
                            bandComparacion=false;
                        bandFuncion=false;
                        bandVariable=false;
                        //comparando1="";
                        comparando2="";
                            break;
                    default:
                        model.addRow(new Object[]{token,lexer.lexeme});
                        
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_btnLexicoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtAreaCodigo.setText("");
        txtAreaSalida.setText("");
        
        DefaultTableModel model = (DefaultTableModel)tableTS.getModel();
            while(model.getRowCount()!=0){
                model.removeRow(0);   
            }
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        JFileChooser archivo=new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("txt","txt");
        archivo.setFileFilter(filtro);
        archivo.addChoosableFileFilter(filtro);
        int option= archivo.showOpenDialog(this);
        String path="";
        if(option == JFileChooser.APPROVE_OPTION){
            path=archivo.getSelectedFile().getPath();
            try{
                
                BufferedReader bf=new BufferedReader(new FileReader(path));
                String temp="";
                String bfRead;
                while((bfRead=bf.readLine())!=null){
                    temp+=bfRead+"\n";
                }
                txtAreaCodigo.setText(temp);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo");
            }
        }
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        JFileChooser guardar=new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("txt","txt");
        guardar.setFileFilter(filtro);
        int opcion=guardar.showSaveDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION){
            File path=guardar.getSelectedFile();
            try{
                FileWriter archivo=new FileWriter(path+".txt");
                archivo.write(txtAreaCodigo.getText());
                archivo.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"No se pudo guardar el archivo");
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        //Abrir
        btnAbrirActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //Limpiar
        btnLimpiarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        //Guardar
        btnGuardarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //Salir
        System.exit(0);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //Lexico
        btnLexicoActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: 
        //////////////////////////////////////////
        g.programa(gramatica);
        //Analisis Sintáctico
        File codigo = new File("Codigo.txt");
        PrintWriter writer;
        errores=0;
        txtAreaSalida.setText("");
        try{
            writer = new PrintWriter(codigo);
            writer.print(txtAreaCodigo.getText());
            writer.close();
        }catch(FileNotFoundException e){
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
            String[] archivoPrueba = {"Codigo.txt"};
            AnalizadorSintactico.main(archivoPrueba);
            String resultado="\n\n";
            DefaultTableModel model = (DefaultTableModel)tableTS.getModel();
            while(model.getRowCount()!=0){
                model.removeRow(0);   
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*if(!AnalizadorSintactico.cadStatic.equals("")){
            txtAreaSalida.setText(AnalizadorSintactico.cadStatic);
        }*/
        //Analisis Léxico
        banderaErrorLexico = false;
        codigo = new File("Codigo.txt");
        errores=0;

        try{
            writer = new PrintWriter(codigo);
            writer.print(txtAreaCodigo.getText());
            writer.close();
        }catch(FileNotFoundException e){
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
            Lexer lexer = new Lexer(reader);
            String resultado="\n\n";
            DefaultTableModel model = (DefaultTableModel)tableTS.getModel();
            while(model.getRowCount()!=0){
                model.removeRow(0);   
            }
            boolean para=true;
            while(para){
                Token token = lexer.yylex();
                if(token == null){
                    tableTS.setModel(model);
                    if(errores>0){
                        AnalizadorSintactico.cadStatic+="\n"+resultado;
                        mostrar();
                    }
                    para=false;
                }
                if(para){
                switch(token){
                    //Quitar la cosa que lo muestra
                    case CADENA_DESCONOCIDA:                        
                        model.addRow(new Object[]{token,lexer.lexeme});
                        banderaErrorLexico = true;
                        resultado+="ERROR, cadena no valida: "+lexer.lexeme +",Linea: "+(lexer.linea+1)+"\n";
                        errores++;
                        break;
                    case SIMBOLO_DESCONOCIDO:                        
                        model.addRow(new Object[]{token,lexer.lexeme});
                        banderaErrorLexico = true;
                        resultado+="ERROR, simbolo desconocido: "+lexer.lexeme +",Linea: "+(lexer.linea+1)+"\n";
                        errores++;
                        break;
                    default:
                        model.addRow(new Object[]{token,lexer.lexeme});
                        
                } 
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaActionPerformed
        // TODO add your handling code here:
        try{
            Tabla_Simbolos_Grafica tabla_grafica=new Tabla_Simbolos_Grafica();
            tabla_grafica.generarTabla(tabla.tabla,tabla.parametros);
            tabla_grafica.setVisible(true);
        }catch(Exception e){

        }
    }//GEN-LAST:event_btnTablaActionPerformed

    private void btnRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridoActionPerformed
        // TODO add your handling code here:
        Recorrido r=new Recorrido();
        r.setVisible(true);
    }//GEN-LAST:event_btnRecorridoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Codigo_Arduino arduino = new Codigo_Arduino();
        arduino.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        arduino.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_ALexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ALexicoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Gramatica.camino="";
        String errorSemantico="",funcionActual="";
        String funcion="";
        banderaErrorLexico = false;
        insertar_parametros=false;
        File codigo = new File("Codigo.txt");
        PrintWriter writer;
        errores=0;
        boolean simbolo=false,declaracion=false,asignacion=false;
        comparacion=false;
        soloVDD=false;
        soloVDDComparacion=false;
        String nombreID="",tipo="";
        String[] auxSimbolo=new String[0];//Guarda los datos que se insertarÃ¡n en la tabla de sÃ­mbolos
        tabla=new Tabla_Simbolos();
        tabla.inicializar();

        try{
            writer = new PrintWriter(codigo);
            writer.print(txtAreaCodigo.getText());
            writer.close();
        }catch(FileNotFoundException e){
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
            Lexer lexer = new Lexer(reader);
            String resultado="\n\n";
            DefaultTableModel model = (DefaultTableModel)tableTS.getModel();
            while(model.getRowCount()!=0){
                model.removeRow(0);   
            }
            while(true){
                Token token = lexer.yylex();
                if(token == null){
                    tableTS.setModel(model);
                    
                    resultado+="     Numero de errores: "+errores;

                    txtAreaSalida.setText(resultado+"\n"+errorSemantico);
                    return;
                }else{
                    if(token.toString().equals("PALABRA_RESERVADA")||token.toString().equals("SIMBOLO_AGRUPACION")||token.toString().equals("SIMBOLO_ASIGNACION")
                            || token.toString().equals("OP_SINTAXIS")||token.toString().equals("FIN_LINEA")
                            ||token.toString().equals("OP_RELACIONAL")||token.toString().equals("OP_ARITMETICO")){
                        gramatica.add(lexer.lexeme+"");
                    }else{
                        gramatica.add(token.toString()+"");
                    }
                }
                if(declaracion){
                    auxSimbolo[0]=lexer.lexeme;
                    if(!tabla.revisar(token.toString()) || !tabla.revisar_parametro(lexer.lexeme, funcion)){
                        //JOptionPane.showMessageDialog(this, "ErrorSemantico "+auxSimbolo[0]);
                        errorSemantico+="Error semÃ¡ntico: "+lexer.lexeme+" ya se encuentra declarado, linea "+(lexer.linea+1)+"\n";
                    }else{
                        if(insertar_parametros){
                           if(tabla.revisar_parametro(lexer.lexeme, funcion)) {
                            auxSimbolo[2]=""+(lexer.linea+1);
                            auxSimbolo[4]=funcion; 
                            tabla.nuevos_parametros(auxSimbolo);
                           }else{
                               errorSemantico+="Error semántico: "+lexer.lexeme+" ya se encuentra declarado en los parametros de la función, linea "+(lexer.linea+1)+"\n";
                           }
                        }else{
                            auxSimbolo[2]=""+(lexer.linea+1);
                            auxSimbolo[4]=funcion;
                            if(tabla.nuevoSimbolo(auxSimbolo)){
                                JOptionPane.showMessageDialog(this, "Exito en tabla de simbolos");
                            }else{
                                JOptionPane.showMessageDialog(this, "Error en tabla de simbolos");
                            }
                        }
                    }

                    declaracion=false;
                    simbolo=false;
                }
                switch(token){
                    //Quitar la cosa que lo muestra
                    case CADENA_DESCONOCIDA:                        
                        model.addRow(new Object[]{token,lexer.lexeme});
                        banderaErrorLexico = true;
                        resultado+="Error lÃ©xico, cadena no valida: "+lexer.lexeme +",Linea: "+(lexer.linea+1)+"\n";
                        errores++;
                        break;
                    case SIMBOLO_DESCONOCIDO:                        
                        model.addRow(new Object[]{token,lexer.lexeme});
                        banderaErrorLexico = true;
                        resultado+="Error lÃ©xico, simbolo desconocido: "+lexer.lexeme +",Linea: "+(lexer.linea+1)+"\n";
                        errores++;
                        break;
                    case IDENTIFICADOR:
                        if(declararFuncion){
                            auxSimbolo=new String[5];
                            auxSimbolo[0]=lexer.lexeme;
                            auxSimbolo[1]="FUNC";
                            funcion=lexer.lexeme;
                            auxSimbolo[2]=lexer.linea+1+"";
                            tabla.nuevoSimbolo(auxSimbolo);
                        }
                        nombreID=lexer.lexeme;
                        break;
                    case PALABRA_RESERVADA:
                        if(lexer.lexeme.equals("EFEC")){
                            funcion="EFEC";
                        }
                        if(lexer.lexeme.equals("FUNC")){
                            declararFuncion=true;
                        }else{
                            declararFuncion=false;
                        }
                        if(lexer.lexeme.equals("ENT") || lexer.lexeme.equals("FLO") || lexer.lexeme.equals("BOO")){
                            declaracion=true;
                            auxSimbolo=new String[5];
                            auxSimbolo[1]=lexer.lexeme;
                            tipo=lexer.lexeme;
                        }
                        model.addRow(new Object[]{token,lexer.lexeme});
                        break;
                    case SIMBOLO_AGRUPACION:
                        if(lexer.lexeme.equals("(")){
                            if(declararFuncion){
                                insertar_parametros=true;
                            }
                        }
                        if(lexer.lexeme.equals(")")){
                            insertar_parametros=false;
                        }
                        bandComparacion=false;
                        bandFuncion=false;
                        bandVariable=false;
                         //comparando1="";
                        comparando2="";
                        break;
                    case OP_ARITMETICO:
                        bandComparacion=false;
                        bandFuncion=false;
                        bandVariable=false;
                         //comparando1="";
                        comparando2="";
                        break;
                    default:
                        model.addRow(new Object[]{token,lexer.lexeme});
                        
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ALexicoActionPerformed

    private void btnOptimizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptimizacionActionPerformed
        // TODO add your handling code here:
        String salida="";
        for(int i=0;i<lista.get(1).size();i++){
             if(Integer.parseInt(lista.get(1).get(i)+"")==1){
                 salida+="Variable: "+lista.get(0).get(i)+" jamás usada en la linea: "+lista.get(2).get(i)+"\n";
             }
        
            if(lista.get(1).get(i).equals(2)){
                    if(lista.get(3).get(i).equals(2)){
                         salida+="Variable: "+lista.get(0).get(i)+" jamás usada en la linea: "+lista.get(2).get(i)+"\n";
                    }
            }
        }
        for(int i=0;i<listaFuncion.get(1).size();i++){
          if(listaFuncion.get(1).get(i).equals(1)){
               salida+="Funcion: "+listaFuncion.get(0).get(i)+" jamás usada en la linea: "+listaFuncion.get(2).get(i)+"\n";
           }
         }txtAreaSalida.setText(salida+salidaComparacion);
            salidaComparacion="";
         lista.get(0).clear();
         lista.get(1).clear();
         lista.get(2).clear();
         listaFuncion.get(0).clear();
         listaFuncion.get(1).clear();
         listaFuncion.get(2).clear();
    }//GEN-LAST:event_btnOptimizacionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:\
        ArrayList<String> a = lexemas(); 
        Automata at = new Automata();
        String string =at.iniciar(a);
        if(Automata.bandera && Automata.errores){
            if(a.get(a.size()-1).equals(";")){
                JOptionPane.showMessageDialog(this,"Recorrido de automata correcto");txtAreaSalida.setText(string);
            }
            else JOptionPane.showMessageDialog(this,"Programa no termina con ;");txtAreaSalida.setText(string);
        }
        else {JOptionPane.showMessageDialog(this,"Error en automata");txtAreaSalida.setText(string);}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        // TODO add your handling code here:
        /*Ayuda a= new Ayuda();
        a.setVisible(true);*/
    }//GEN-LAST:event_menuAyudaActionPerformed

    private void menuAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAyudaMouseClicked
        // TODO add your handling code here:
        Ayuda a= new Ayuda();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuAyudaMouseClicked
        
    private ArrayList<String> lexemas (){
        File codigo = new File("Codigo.txt");
        PrintWriter writer;
        ArrayList<String> array = new ArrayList<>();
        try{
            writer = new PrintWriter(codigo);
            writer.print(txtAreaCodigo.getText());
            writer.close();
        }catch(FileNotFoundException e){
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
            Lexer lexer = new Lexer(reader);
            while(true){
                Token token = lexer.yylex();
                if(token == null){
                    return array;
                }
                switch(token){
                    case IDENTIFICADOR:
                        array.add("IDENTIFICADOR");
                        break;
                    case NUM_FLOTANTE:
                        array.add("NUM_FLO");
                        break;
                    case NUM_ENTERO:
                        array.add("NUM_ENT");
                        break;
                    default:
                        array.add(lexer.lexeme);
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
	
    public static void mostrar(){
        if(AnalizadorSintactico.cadStatic.equals("Sin errores sintácticos")){
            txtAreaSalida.setForeground(Color.blue);
        }else{
            txtAreaSalida.setForeground(Color.red);
        }
        txtAreaSalida.setText(txtAreaSalida.getText()+"\n"+AnalizadorSintactico.cadStatic);
    }
     public boolean buscarFuncion(String nomFuncion){
         for(int i=0;i<listaFuncion.get(0).size();i++){               
            if(nomFuncion.equals(listaFuncion.get(0).get(i))){
                Integer newValor=Integer.parseInt(listaFuncion.get(1).get(i)+"")+1;
                listaFuncion.get(1).set(i, newValor);
                return true;      
             }
        }return false;
     }
     public boolean buscarVariable(String variable){
         for(int i=0;i<lista.get(0).size();i++){
            if(lista.get(0).get(i).equals(variable)){
               Integer newValor=Integer.parseInt(lista.get(1).get(i)+"")+1;
                lista.get(1).set(i, newValor);
                return true;
            }      
         }return false;
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    
    
    
    Tabla_Simbolos tabla;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLexico;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnOptimizacion;
    private javax.swing.JButton btnRecorrido;
    private javax.swing.JButton btnTabla;
    private javax.swing.JButton btn_ALexico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JTable tableTS;
    private javax.swing.JTextPane txtAreaCodigo;
    private javax.swing.JTextPane txtAreaNum;
    public static javax.swing.JTextArea txtAreaSalida;
    // End of variables declaration//GEN-END:variables
}
