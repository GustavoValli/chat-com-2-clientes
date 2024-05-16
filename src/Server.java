import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4000);
        Socket client1 = serverSocket.accept();
        Socket client2 = serverSocket.accept();
        System.out.println("Clients connected!");

        new ServerThread(client1, client2).start();

        InputStreamReader inputStreamReader1 = new InputStreamReader(client1.getInputStream());
        BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);
        String message1;
        PrintStream printStream1 = new PrintStream(client2.getOutputStream());

        /*

        InputStreamReader inputStreamReader2 = new InputStreamReader(client2.getInputStream());
        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
        String message2;
        PrintStream printStream2 = new PrintStream(client1.getOutputStream());

        while (client1.isConnected() && client2.isConnected()) {
            if ((message1 = bufferedReader1.readLine()) != null) {
                printStream1.println(message1);
            }
            if ((message2 = bufferedReader2.readLine()) != null) {
                printStream2.println(message2);
            }
        }

         */

        while ((message1 = bufferedReader1.readLine()) != null) {
            printStream1.println(message1);
        }
    }
}
