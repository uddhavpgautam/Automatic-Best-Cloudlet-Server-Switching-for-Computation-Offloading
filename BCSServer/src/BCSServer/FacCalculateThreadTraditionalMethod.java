package BCSServer;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
class FacCalculateThreadTraditionalMethod extends Thread {

    private final int j;
    private BigInteger factor;
    private final JTextArea OutputTraditionalMethodTextArea;

    FacCalculateThreadTraditionalMethod(int j, BigInteger factor, JTextArea OutputTraditionalMethodTextArea) {
        this.j = j;
        this.factor = factor;
        this.OutputTraditionalMethodTextArea = OutputTraditionalMethodTextArea;
    }

    @Override
    public void run() {
//     
        for (int i = 1; i <= j; i++) {
            factor = factor.multiply(BigInteger.valueOf(i));
        }
        OutputTraditionalMethodTextArea.append("Factorial of " + j + " = " + factor.toString() + "\n");
        try {
            //        Write same thing to socket
//            System.out.println("Result Writing to Socket!");
            
            SocketAcceptandListenerServer.out.writeBytes("Factorial of " + j + " = " + factor.toString() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(FacCalculateThreadTraditionalMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        factor = factor.multiply(BigInteger.valueOf(1));

    }

}
