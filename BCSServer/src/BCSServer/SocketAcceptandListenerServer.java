package BCSServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

class SocketAcceptandListenerServer extends Thread {

    public static Socket clienSocket;
    private BufferedReader br;
    private String clientSentence;
    private UtilitiesFunctions utl;
    private boolean bool = true;
    private final ServerSocket sc;
    private final JTextArea textAreaServer;
    private final String[] value = new String[2];
    public static  DataOutputStream out;

    SocketAcceptandListenerServer(ServerSocket serverSock, JTextArea OutputTraditionalMethodTextArea) {
        this.sc = serverSock;
        this.textAreaServer = OutputTraditionalMethodTextArea;
    }

    @Override
    public void run() {
        while (bool) {

            try {
                SocketAcceptandListenerServer.clienSocket = sc.accept();
                System.out.println("Accepted");
                br = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
                this.out = new DataOutputStream(clienSocket.getOutputStream());

                while (bool) {

                    System.out.println("clientSentence");
                    int i = 0;
                    System.out.println("Vlue of i:"+i);
                    try {
                        while (((clientSentence = br.readLine()) != null) && i <= 1) {
                            value[i] = clientSentence;
                            System.out.println(value[i]);
                            i++;
                            System.out.println("Vlue of i:"+i);
                        }
                        i = 0;
                        if (!clientSentence.isEmpty()) {
                            System.out.println("Socket has value");
                            System.out.println("It has: " + clientSentence);
                        } else {
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(SocketAcceptandListenerServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    BCSServer.StartRange.setText(value[0]);
                    BCSServer.EndRange.setText(value[1]);
                    br.readLine(); // to finish last \n character
                    
                }

            } catch (IOException ex) {
//                if (!sc.isClosed()) {
                    try {
                        sc.close();
                        clienSocket.close();
                        if (sc.isClosed()) {
                            System.out.println("server is closed now");
                        }
                        this.bool = false;
                    } catch (IOException ex1) {
                        Logger.getLogger(SocketAcceptandListenerServer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
//                }
                Logger.getLogger(SocketAcceptandListenerServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
