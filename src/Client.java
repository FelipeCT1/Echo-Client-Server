import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8888);){
            System.out.println("Connected");

            while (true) {

                BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter outgoing = new PrintWriter(socket.getOutputStream(), true);

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                outgoing.println(input);
                System.out.println(incoming.readLine());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
