package WalkieTalkie;

import java.io.*;
import java.util.*;
import java.net.*;
import utils.ColorPrinter;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 8000);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String endCodeWord = "OVER AND OUT";
            System.out.println(
                    ColorPrinter.printf(
                            "$YELLOW_BRIGHT{This chat system is like a walkie talkie, you (server) and the client get turns to send a 1 line message at a time.}\n$CYAN{Send} ")
                            +
                            ColorPrinter.println("\"" + endCodeWord + "\"", "PURPLE_BOLD_BRIGHT")
                            + ColorPrinter.println(" to end the session anytime!", "CYAN"));
            while (true) {
                System.out.print(ColorPrinter.println("From Client (YOU): ", "YELLOW_BOLD")
                        + ColorPrinter.WHITE_BRIGHT);
                String outgoing = sc.nextLine();
                System.out.print(ColorPrinter.RESET);
                dos.writeUTF(outgoing);
                dos.flush();
                if (outgoing.equals(endCodeWord)) {
                    System.out.println(ColorPrinter.println("Ending session...", "RED_BOLD_BRIGHT"));
                    break;
                }
                String incoming = dis.readUTF();
                if (incoming.equals(endCodeWord)) {
                    System.out.println(ColorPrinter.println("The server is ending the session...", "RED_BOLD_BRIGHT"));
                    break;
                }
                System.out.println(
                        ColorPrinter.println("From Server: ", "BLUE_BRIGHT")
                                + ColorPrinter.println(incoming, "BLACK_BRIGHT"));
            }
            dos.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}