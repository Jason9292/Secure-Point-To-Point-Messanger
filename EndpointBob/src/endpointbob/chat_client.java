/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpointbob;

import java.net.*;	//for Socket, ServerSocket, and InetAddress
import java.io.*;	//for IOException and Input/OutputStream
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author JasonatUSF
 */
public class chat_client extends javax.swing.JFrame {

    /**
     * Creates new form chat_client
     */
    
    static Socket sock;
    static DataInputStream in;
    static DataOutputStream out;
    
    public chat_client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        pSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pResult = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        cipher_area = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ipAddy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        IPCon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Password:");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        pSubmit.setText("Submit");
        pSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pSubmitActionPerformed(evt);
            }
        });

        jLabel2.setText("Result:");

        pResult.setEnabled(false);

        cipher_area.setColumns(20);
        cipher_area.setRows(5);
        jScrollPane2.setViewportView(cipher_area);

        jLabel3.setText("Plaintext:");

        jLabel4.setText("Ciphertext:");

        jLabel5.setText("Enter IP Address:");

        jLabel6.setText("Connected to:");

        IPCon.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addComponent(ipAddy)
                                .addComponent(IPCon))
                            .addGap(21, 21, 21)
                            .addComponent(pSubmit)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pResult, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pSubmit)
                    .addComponent(jLabel2)
                    .addComponent(pResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ipAddy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IPCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        // This function will send encrypted text, same that the server uses:
        byte[] encrypt;
        String encrypted = "";
        String k = "e1fb98d4c389679c";                                          //64 bit key
        
        /*Converting the key into an 8 byte array given a
        function from the DES.java project*/
        long k1 = Long.decode("0x" + k.substring(0,8)).longValue();
        long k2 = Long.decode("0x" + k.substring(8,16)).longValue();
        byte[] key = DES.twoLongsTo8ByteArray(k2,k1);
        
        IDESRound round = new OneRound();
        
        try{                                                                    //making sure password is correct, if not message wont send
            if (pResult.getText().equals("Correct")){
                String msgOut = "";
                msgOut = msg_text.getText().trim();
                
                cipher_area.setText(cipher_area.getText().trim() + "\n YOU: ");
                
                //take out the white space of the message
                 String[] msgSplit = msgOut.split(" ");
                 String[] here = new String[msgSplit.length];
                 
                 //convert each of those messages into hexadecimal
                 for (int i = 0; i < msgSplit.length; i++){
                     here[i] = String.format("%040x", new BigInteger(1, msgSplit[i].getBytes()));
                 }
                 
                 //removing the 0's from infront of the hexadecimal until its a 16 digit hexa number (64 bits)
                 for (int i = 0; i < here.length; i++){
                     while (here[i].substring(0,1).equals("0")){
                        here[i] = here[i].substring(2);
                        if (here[i].length() == 16){
                           break;
                        }
                     }
                 }
                 
                 //convert string into byte array, encode it, then convert into string, and send off
                 for (int i = 0; i < here.length; i++){
                     long d1 = Long.decode("0x" + here[i].substring(0,8)).longValue();
                     long d2 = Long.decode("0x" + here[i].substring(8,16)).longValue();
                     
                     byte[] data = DES.twoLongsTo8ByteArray(d2, d1);
                     encrypt = DES.encode(data, key, round);
                     encrypted = DES.byteArrayToString(encrypt);
                         
                     out.writeUTF(encrypted);
                     cipher_area.setText(cipher_area.getText().trim() + " " + encrypted);
                 }     
                
                 msg_area.setText(msg_area.getText().trim() + "\n YOU: " + msgOut + "\n");
                 cipher_area.append("\n");
            }
        }catch(Exception e){
            msg_area.setText("Error sending.");
        }
        
    }//GEN-LAST:event_msg_sendActionPerformed

    private void pSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pSubmitActionPerformed
        // TODO add your handling code here:
        String data = password.getText();
        data = data + "E1F53135E559C253";
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(data.getBytes());
            byte[] messageDigestSHA256 = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte bytes : messageDigestSHA256) {
                stringBuffer.append(String.format("%02x", bytes & 0xff));
            }
            
            String pass = stringBuffer.toString();
            
            if (pass.equals("f24b7b2c02de108bfd5fe70d26a81845de5b6d8bb56265fc50d0ed0815dcb495")){
                pResult.setText("Correct");
            }
            else{
                pResult.setText("Incorrect");
            } 
        }
        catch (Exception e) {
            pResult.setText("Error");
        }
        IPCon.setText(ipAddy.getText());
    }//GEN-LAST:event_pSubmitActionPerformed

    
    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_client().setVisible(true);
            }
        });
        
        try {
            TimeUnit.SECONDS.sleep(10);                           //delay attempted to connection 
        }
        catch(Exception e) {
            msg_area.setText("Good luck next time");
        }
        
        byte[] output;
        String k = "e1fb98d4c389679c";
        
        long k1 = Long.decode("0x" + k.substring(0,8)).longValue();
        long k2 = Long.decode("0x" + k.substring(8,16)).longValue();
        
        byte[] key = DES.twoLongsTo8ByteArray(k2,k1);
        
        IDESRound round = new OneRound();
             
        String IP = IPCon.getText().trim();
        
        try {
            sock = new Socket(IP,1201);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
            String incoming="";
            
            while(!incoming.equals("exit"))
            {     
                incoming = in.readUTF();
                
                long d1 = Long.decode("0x" + incoming.substring(0,8)).longValue();
                long d2 = Long.decode("0x" + incoming.substring(8,16)).longValue();
                
                byte[] data = DES.twoLongsTo8ByteArray(d2,d1);
                output = DES.decode(data,key,round);
                
                String s = "";
                s = DES.byteArrayToString(output);
                
                while (s.substring(0,1) == "0"){
                    s = s.substring(2);
                }
                
                StringBuilder finalText = new StringBuilder();
                for (int i = 0; i < s.length(); i+=2) {
                    String str = s.substring(i, i+2);
                    finalText.append((char)Integer.parseInt(str, 16));
                }
                msg_area.append(" " + finalText);
                cipher_area.setText(cipher_area.getText().trim()+"\n Alice: "+incoming);
            }
        } catch (Exception e) {
            msg_area.setText("Alice disconnected.");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField IPCon;
    private static javax.swing.JTextArea cipher_area;
    private javax.swing.JTextField ipAddy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    private static javax.swing.JTextField pResult;
    private javax.swing.JButton pSubmit;
    private javax.swing.JTextField password;
    // End of variables declaration//GEN-END:variables
}
