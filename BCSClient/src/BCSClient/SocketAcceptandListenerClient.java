package BCSClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

class SocketAcceptandListenerClient extends Thread {

    private final JTextArea msgshowingAreabodyPanellChat;
    private BufferedReader br;
    private String serverSentence;
    private final Socket clientSocket;

    SocketAcceptandListenerClient(Socket clientSock, JTextArea OutputTraditionalMethodTextArea) {
        this.clientSocket = clientSock;
        this.msgshowingAreabodyPanellChat = OutputTraditionalMethodTextArea;
        
    }

    @Override
    public void run() {
        while (true) {
            try {
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                serverSentence = br.readLine();
                if (serverSentence != null && !serverSentence.isEmpty()) {
                    msgshowingAreabodyPanellChat.append(serverSentence+"\n");
                }

            } catch (IOException ex) {
                try {
                    br.close();
                } catch (IOException ex1) {
                    Logger.getLogger(SocketAcceptandListenerClient.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        }

    }

}
