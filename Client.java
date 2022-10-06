import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 8000);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String endCodeWord = "OVER AND OUT";
            System.out.println(
                    "This chat system is like a walkie talkie, you (client) and the server get turns to send a 1 line message at a time. Send \""
                            + endCodeWord + "\" to end the session anytime!");
            while (true) {
                System.out.print("From Client (you): ");
                String outgoing = sc.nextLine();
                dos.writeUTF(outgoing);
                dos.flush();
                if (outgoing.equals(endCodeWord)) {
                    System.out.println("Ending session...");
                    break;
                }
                String incoming = dis.readUTF();
                if (incoming.equals(endCodeWord)) {
                    System.out.println("The server is ending the session...");
                    break;
                }
                System.out.println("From Server: " + incoming);
            }
            dos.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}