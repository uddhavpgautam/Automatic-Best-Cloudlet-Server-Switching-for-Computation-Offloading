package BCSClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class BCSClient extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    UtilitiesFunctions utl = new UtilitiesFunctions();
    private Socket clientSock;
    private DataOutputStream out;

    /**
     * Creates new form NewJFrame
     */
    public BCSClient() {
        initComponents();
        EndRange.setVisible(false);
        StartRange.setVisible(false);
        OutputTraditionalMethodTextArea.setVisible(false);
        CalculateFactorial.setVisible(false);
        Calculate.setVisible(false);
        To.setVisible(false);
        ResultLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CalculateFactorial = new javax.swing.JLabel();
        EndRange = new javax.swing.JTextField();
        StartRange = new javax.swing.JTextField();
        To = new javax.swing.JLabel();
        OutputScrollBar = new javax.swing.JScrollPane();
        OutputTraditionalMethodTextArea = new javax.swing.JTextArea();
        PortValue = new javax.swing.JTextField();
        ConnectServer = new javax.swing.JButton();
        IPServer = new javax.swing.JTextField();
        ResultLabel = new javax.swing.JLabel();
        Calculate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BCS Client");
        setResizable(false);

        CalculateFactorial.setText("Calculate Factorial");

        EndRange.setText("12");
        EndRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndRangeActionPerformed(evt);
            }
        });

        StartRange.setText("2");

        To.setText("to");

        OutputTraditionalMethodTextArea.setColumns(20);
        OutputTraditionalMethodTextArea.setRows(5);
        OutputScrollBar.setViewportView(OutputTraditionalMethodTextArea);

        PortValue.setText("12345");

        ConnectServer.setText("Connect Server");
        ConnectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectServerActionPerformed(evt);
            }
        });

        IPServer.setText("127.0.0.1");

        ResultLabel.setText("Result From The Server");

        Calculate.setText("Calculate");
        Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OutputScrollBar, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(ResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CalculateFactorial)
                        .addGap(33, 33, 33)
                        .addComponent(StartRange, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(To)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EndRange, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IPServer, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PortValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConnectServer)
                    .addComponent(Calculate))
                .addGap(0, 791, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConnectServer)
                    .addComponent(IPServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalculateFactorial)
                    .addComponent(StartRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(To)
                    .addComponent(Calculate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(OutputScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EndRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndRangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndRangeActionPerformed

    private void ConnectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectServerActionPerformed
        String portval = PortValue.getText();
        String ipText = IPServer.getText();
        System.out.println(portval);
        System.out.println(ipText);
        if (utl.isInteger(portval)) {
            if (utl.isOutOfRange(portval)) {

                try {
                    int portint = Integer.parseInt(portval);
                    System.out.println(portint);
                    clientSock = new Socket(ipText, portint);

                    if (clientSock.isConnected()) {
                        System.out.println("Conn Successful!");
                        EndRange.setVisible(true);
                        StartRange.setVisible(true);
                        OutputTraditionalMethodTextArea.setVisible(true);
                        CalculateFactorial.setVisible(true);
                        Calculate.setVisible(true);
                        To.setVisible(true);
                        PortValue.setVisible(false);
                        IPServer.setVisible(false);
                        ConnectServer.setVisible(false);
                    }

                    // listen on socket for any messages from server and finally close the socket
                    SocketAcceptandListenerClient sat = new SocketAcceptandListenerClient(clientSock, OutputTraditionalMethodTextArea);
                    sat.start();
                } catch (IOException ex) {
                    try {
                        System.out.println("Server is not running!"); 
                        //close the reader and socket
                        clientSock.close();
                    } catch (IOException ex1) {
                        System.out.println("Server is not running!"); 
                    }
                }
            }
        }
    }//GEN-LAST:event_ConnectServerActionPerformed

    private void CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateActionPerformed
        OutputTraditionalMethodTextArea.setText("");
        ResultLabel.setVisible(true);
        String j1 = StartRange.getText();
        String j2 = EndRange.getText();

        try {
            out = new DataOutputStream(clientSock.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(BCSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out.writeBytes(j1 + "\n" + j2 + "\n");
            System.out.println("Socket Written Part: "+j1 + "\n" + j2 + "\n");
//            out.writeBytes(j2 + "\n"); // same things, we can write in one line as above
        } catch (IOException ex) {
            Logger.getLogger(BCSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CalculateActionPerformed

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
            java.util.logging.Logger.getLogger(BCSClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BCSClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BCSClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BCSClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BCSClient().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Calculate;
    public static javax.swing.JLabel CalculateFactorial;
    public static javax.swing.JButton ConnectServer;
    public static javax.swing.JTextField EndRange;
    public static javax.swing.JTextField IPServer;
    private javax.swing.JScrollPane OutputScrollBar;
    public static javax.swing.JTextArea OutputTraditionalMethodTextArea;
    public static javax.swing.JTextField PortValue;
    public static javax.swing.JLabel ResultLabel;
    public static javax.swing.JTextField StartRange;
    public static javax.swing.JLabel To;
    // End of variables declaration//GEN-END:variables

} //end