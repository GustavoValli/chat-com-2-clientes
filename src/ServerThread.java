import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private final Socket client1;
    private final Socket client2;

    public ServerThread(Socket client1, Socket client2) {
        this.client1 = client1;
        this.client2 = client2;
    }

    @Override
    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(client2.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String message;

            PrintStream printStream = new PrintStream(client1.getOutputStream());

            while ((message = bufferedReader.readLine()) != null) {
                printStream.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
