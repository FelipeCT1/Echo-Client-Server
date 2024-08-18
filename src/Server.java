import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888);){
            System.out.println("Server started");

            Socket client = serverSocket.accept();
            System.out.println("New connection");

            while (true) {


                PrintWriter outgoing = new PrintWriter(client.getOutputStream(), true);
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String message = incoming.readLine();
                System.out.println("Client: " + message);
                outgoing.println(message);


            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }

    }
}