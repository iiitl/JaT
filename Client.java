import java.net.*;
import java.io.*;

public class Client implements Runnable {
    String hostName;
    int portNumber;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    boolean exit;
    String endCodeWord = "OVER AND OUT";

    public Client(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.exit = false;
    }

    public void run() {
        try {
            client = new Socket(hostName, portNumber);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            MessageHandler incomingHandler = new MessageHandler();
            Thread t = new Thread(incomingHandler);
            t.start();

            String incomingMessage;
            while ((incomingMessage = in.readLine()) != null) {
                System.out.println(incomingMessage);
            }
        } catch (IOException e) {
            exit();
        }
    }

    class MessageHandler implements Runnable {
        public void run() {
            try {
                // Take inputs
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String message;
                // while (!exit && (message = reader.readLine()) != endCodeWord) {
                // // Send them to the server
                // out.println(message);
                // }
                while (!exit) {
                    message = reader.readLine();
                    // To replace the input from the console
                    System.out.print(String.format("\033[%dA", 1)); // Move up
                    System.out.print("\033[2K"); // Erase line content
                    if (message.equals(endCodeWord)) {
                        reader.close();
                        exit();
                    } else {
                        out.println(message);
                    }
                }
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
                exit();
            }
        }
    }

    public void exit() {
        out.println("has disconnected");
        exit = true;
        try {
            in.close();
            out.close();
            if (!client.isClosed()) {
                client.close();
            }
        } catch (IOException e) {
            // TODO: handle exception
            // ignore
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java Client <host name> <port number>");
            System.exit(1);
        }
        Client client = new Client(args[0], Integer.parseInt(args[1]));
        client.run();
    }
}
