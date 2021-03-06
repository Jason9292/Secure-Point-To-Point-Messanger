/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpointalice;

import java.net.*;	//for Socket, ServerSocket, and InetAddress
import java.io.*;	//for IOException and Input/OutputStream
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author JasonatUSF
 */
public class chatServer extends javax.swing.JFrame {

    /**
     * Creates new form chatServer
     */
    
    /*Socket components required to send/receive
    messages on this port and IP address */
    static ServerSocket servSock;
    static Socket clntSock;
    static DataInputStream in;
    static DataOutputStream out;
    
    public chatServer() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        submitP = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        pResult = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cipher_area = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel2.setText("Result:");

        submitP.setText("Submit");
        submitP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPActionPerformed(evt);
            }
        });

        pResult.setEnabled(false);

        jLabel3.setText("Plaintext:");

        cipher_area.setColumns(20);
        cipher_area.setRows(5);
        jScrollPane2.setViewportView(cipher_area);

        jLabel4.setText("Ciphertext:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(msg_text)
                            .addGap(18, 18, 18)
                            .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitP)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(pResult, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel3)
                        .addGap(194, 194, 194)
                        .addComponent(jLabel4)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(submitP)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        // This function will send the encrypted text:
        byte[] encrypt;
        String encrypted = "";
        String k = "e1fb98d4c389679c";                                              //64 bit hexadecimal key
        /*Converting the key into an 8 byte array given a
        function from the DES.java project*/
        long k1 = Long.decode("0x" + k.substring(0,8)).longValue();
        long k2 = Long.decode("0x" + k.substring(8,16)).longValue();
        byte[] key = DES.twoLongsTo8ByteArray(k2,k1);
        
        IDESRound round = new OneRound();
        
        try{
            /*
            Making sure the password is correct,
            if not none of this code will run
            */
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

    private void submitPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPActionPerformed
        // TODO add your handling code here:
        String data = password.getText();                       //get the user's inputed password
        data = data + "E1F53135E559C253";                       //add salt to that password
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");           //Hash that password incase of dictionary attacks
            messageDigest.update(data.getBytes());
            byte[] messageDigestSHA256 = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte bytes : messageDigestSHA256) {
                stringBuffer.append(String.format("%02x", bytes & 0xff));
            }
            
            String pass = stringBuffer.toString();
            
            if (pass.equals("f24b7b2c02de108bfd5fe70d26a81845de5b6d8bb56265fc50d0ed0815dcb495")){       //compare hashed value to correctly hashed value
                pResult.setText("Correct");
            }
            else{
                pResult.setText("Incorrect");
            } 
        }
        catch (Exception e) {
            pResult.setText("Error");
        }
    }//GEN-LAST:event_submitPActionPerformed

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
            java.util.logging.Logger.getLogger(chatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chatServer().setVisible(true);
            }
        });
        String incoming = "";
        /*
        Need to use the same key for encryption as decryption
        */
        byte[] output;
        String k = "e1fb98d4c389679c";                                      //have same key for decryption as encryption
        
        long k1 = Long.decode("0x" + k.substring(0,8)).longValue();
        long k2 = Long.decode("0x" + k.substring(8,16)).longValue();
        
        byte[] key = DES.twoLongsTo8ByteArray(k2,k1);
        
        IDESRound round = new OneRound();

        try {
            /*
            Where the port is specified, if this is
            changed must change the port on the client
            */
            servSock = new ServerSocket(1201);                              //set up server on this port 
            clntSock = servSock.accept();
            
            in = new DataInputStream(clntSock.getInputStream());
            out = new DataOutputStream(clntSock.getOutputStream());
            
            /*
            Password check again
            */
            while(!incoming.equals("exit") && pResult.getText().equals("Correct"))      //Server won't receive messages if password is incorrect
            {
                incoming = in.readUTF();
                /*
                Convert incoming string into an 8 byte array so we can
                decode it using supplied DES functions
                */
                long d1 = Long.decode("0x" + incoming.substring(0,8)).longValue();
                long d2 = Long.decode("0x" + incoming.substring(8,16)).longValue();
                
                byte[] data = DES.twoLongsTo8ByteArray(d2,d1);
                output = DES.decode(data,key,round);                        //decrypt the message
                
                String s = "";
                s = DES.byteArrayToString(output);
                
                /*
                Remove all the 0's that were added while padding
                */
                while (s.substring(0,1) == "0"){
                    s = s.substring(2);
                }
                
                /*
                Convert from hex back to normal text
                */
                StringBuilder finalText = new StringBuilder();
                for (int i = 0; i < s.length(); i+=2) {
                    String str = s.substring(i, i+2);
                    finalText.append((char)Integer.parseInt(str, 16));
                }
                msg_area.append(" " + finalText);
                cipher_area.setText(cipher_area.getText().trim()+"\n Bob: "+incoming);
            }
        }catch(Exception e){
            msg_area.setText("Bob disconnected.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea cipher_area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    private static javax.swing.JTextField pResult;
    private javax.swing.JTextField password;
    private javax.swing.JButton submitP;
    // End of variables declaration//GEN-END:variables
}
