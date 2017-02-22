/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s12017_201403877;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author CodigoG
 */
public class MenuPrincipal extends javax.swing.JFrame {

    ListaPalabraDiccionario palabras = new ListaPalabraDiccionario();
    ColaLetras letras =  new ColaLetras();
    MatrizOrtogonal matriz = new MatrizOrtogonal();
    int contador = 0;
    int tamañoMatriz = 0;
    Graphviz generar = new Graphviz();
    int a = 12;
    int b = 2;
    int c = 4;
    int d = 5;
    int e = 12;
    int f = 1;
    int g = 2;
    int h = 2;
    int i = 6;
    int j = 1;
    //int k = ;
    int l = 4;
    int m = 2;
    int n = 5;
    int ñ = 1;
    int o = 9;
    int p = 2;
    int q = 1;
    int r = 5;
    int s = 6;
    int t = 4;
    int u = 5;
    int v = 1;
    //int w = ;
    int x = 1;
    int y = 1;
    int z = 1;
            
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        jButton2.setEnabled(false);  
        while(a>0 || (b>0 || (c>0 || (d>0 || (e>0 || (f>0 || (g>0 || (h>0 || (i>0 || (j>0 || (l>0 || (m>0 || 
                (n>0 || (ñ>0 || (o>0 || (p>0 || (q>0 || (r>0 || (s>0 || (t>0 || (u>0 || (v>0 || (x>0 || (y>0 || z>0) ))))))))))))))))))))))){
            añadirCola();
        }
        letras.mostrarElementos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Leer Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Jugar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        SAXBuilder builder = new SAXBuilder();
        jFileChooser1.showOpenDialog(this);
        //File xmlFile = new File("C:\\Users\\CodigoG\\Desktop\\prueba.xml");
        File xmlFile = jFileChooser1.getSelectedFile();
        
        try{
            Document document = (Document)builder.build(xmlFile);            
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren();            
            
            for (int i = 0; i < list.size(); i++) {
                Element node = (Element)list.get(i);
                if (node.getName() == "dimension"){
                    tamañoMatriz = Integer.parseInt(node.getValue());
                    matriz.CrearMAtriz(tamañoMatriz);
                    matriz.MostrarMatriz(tamañoMatriz);
                    //tamañoMatriz = Integer.parseInt(node.getValue());
                    //System.out.println("Dimension: " + node.getValue());
                }
                if (node.getName() == "dobles"){
                    List listTemp = node.getChildren();
                    //System.out.println("Dobles:");
                    for (int j = 0; j < listTemp.size(); j++) {
                        Element node11 = (Element)listTemp.get(j);   
                        matriz.agregarDoble(Integer.parseInt(node11.getChildText("x")), Integer.parseInt(node11.getChildText("y")));
                        /*System.out.println("Valor x: " + node11.getChildText("x"));
                        System.out.println("Valor y: " + node11.getChildText("y"));*/
                    }
                }        
                if (node.getName() == "triples"){
                    List listTemp = node.getChildren();
                    //System.out.println("Triples:");
                    for (int j = 0; j < listTemp.size(); j++) {
                        Element node11 = (Element)listTemp.get(j);
                        matriz.agregarTriple(Integer.parseInt(node11.getChildText("x")), Integer.parseInt(node11.getChildText("y")));
                        /*System.out.println("Valor x: " + node11.getChildText("x"));
                        System.out.println("Valor y: " + node11.getChildText("y"));*/
                    }
                }
                if (node.getName() == "diccionario"){
                    List listTemp = node.getChildren();
                    //System.out.println("Palabras:");
                    for (int j = 0; j < listTemp.size(); j++) {
                        Element node11 = (Element)listTemp.get(j);
                        palabras.agregarFinal(node11.getValue().toLowerCase());
                        //System.out.println(node11.getValue());                       
                    }
                }
            }
            jButton2.setEnabled(true);
            matriz.MostrarMatriz(tamañoMatriz);
            palabras.mostrarElementos();
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        } catch (JDOMException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AddJugadores añadir = new AddJugadores();
        añadir.letras = letras;
        añadir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
                
            }
        });
    }

    public void crearMatriz(){
        for (int k = 0; k < 10; k++) {
            
        }
    }
    
    public void añadirCola(){
        int numeroAscii = ThreadLocalRandom.current().nextInt(65, 91);
        //System.out.printf("%c",numeroAscii);        
        switch (numeroAscii){
            case 'A':
                if (a>0){                   
                    letras.agregar_final("A",1,a);
                    a--;
                    contador++;
                }
                break;
            case 'B':
                if (b>0){
                    letras.agregar_final("B",3,b);
                    b--;
                    contador++;
                }
                break;
            case 'C':
                if (c>0){
                    letras.agregar_final("C",3,c);
                    c--;
                    contador++;
                }
                break;
            case 'D':
                if (d>0){
                    letras.agregar_final("D",2,d);
                    d--;
                    contador++;
                }
                break;
            case 'E':
                if (e>0){
                    letras.agregar_final("E",1,e);
                    e--;
                    contador++;
                }
                break;
            case 'F':
                if (f>0){
                    letras.agregar_final("F",4,f);
                    f--;
                    contador++;
                }
                break;
            case 'G':
                if (g>0){
                    letras.agregar_final("G",2,g);
                    g--;
                    contador++;
                }
                break;
            case 'H':
                if (h>0){
                    letras.agregar_final("H",4,h);
                    h--;
                    contador++;
                }
                break;
            case 'I':
                if (i>0){
                    letras.agregar_final("I",1,i);
                    i--;
                    contador++;
                }
                break;
            case 'J':
                if (j>0){
                    letras.agregar_final("J",8,j);
                    j--;
                    contador++;
                }
                break;
            case 'L':
                if (l>0){
                    letras.agregar_final("L",1,l);
                    l--;
                    contador++;
                }
                break;
            case 'M':
                if (m>0){
                    letras.agregar_final("M",3,m);
                    m--;
                    contador++;
                }
                break;
            case 'N':
                if (n>0){
                    letras.agregar_final("N",1,n);
                    n--;
                    contador++;
                }
                break;
            case 'O':
                if (o>0){
                    letras.agregar_final("O",1,o);
                    o--;
                    contador++;
                }
                break;
            case 'P':
                if (p>0){
                    letras.agregar_final("P",3,p);
                    p--;
                    contador++;
                }
                break;
            case 'Q':
                if (q>0){
                    letras.agregar_final("Q",5,q);
                    q--;
                    contador++;
                }
                break;
            case 'R':
                if (r>0){
                    letras.agregar_final("R",1,r);
                    r--;
                    contador++;
                }
                break;
            case 'S':
                if (s>0){
                    letras.agregar_final("S",1,s);
                    s--;
                    contador++;
                }
                break;
            case 'T':
                if (t>0){
                    letras.agregar_final("T",1,t);
                    t--;
                    contador++;
                }
                break;
            case 'U':
                if (u>0){
                    letras.agregar_final("U",1,u);
                    u--;
                    contador++;
                }
                break;
            case 'V':
                if (v>0){
                    letras.agregar_final("V",4,v);
                    v--;                   
                    contador++;
                }
                break;
            case 'X':
                if (x>0){
                    letras.agregar_final("X",8,x);
                    x--;
                    contador++;
                }
                break;
            case 'Y':
                if (y>0){
                    letras.agregar_final("Y",4,y);
                    y--;
                    contador++;
                }
                break;
            case 'Z':
                if (z>0){
                    letras.agregar_final("Z",10,z);
                    z--;
                    contador++;
                }
                break;
            default:
                if (ñ>0){
                    letras.agregar_final("Ñ",8,ñ);
                    ñ--;
                    contador++;
                }
        } 
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
