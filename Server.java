import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(8000);
            Socket s = ss.accept();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String endCodeWord = "OVER AND OUT";
            System.out.println("This chat system is like a walkie talkie, you (server) and the client get turns to send a 1 line message at a time. Send \"" + endCodeWord + "\" to end the session anytime!");
            while(true) {
                String incoming = dis.readUTF();
                if(incoming.equals(endCodeWord)) {
                    System.out.println("The client is ending the session...");
                    break;
                }
                System.out.println("From Client: " + incoming);
                System.out.print("From Server (you): ");
                String outgoing = sc.nextLine();
                dos.writeUTF(outgoing);
                dos.flush();
                if(outgoing.equals(endCodeWord)) {
                    System.out.println("Ending session...");
                    break;
                }
            }
            ss.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
