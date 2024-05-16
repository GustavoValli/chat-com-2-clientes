import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4000);
        Scanner scanner = new Scanner(System.in);

        new ClientThread(socket).start();
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        while (socket.isConnected()) {
            printStream.println(scanner.nextLine());
        }
    }
}
