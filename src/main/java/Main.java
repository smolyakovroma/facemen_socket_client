import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {

//        try (Socket socket = new Socket("ferma.facecoin.ru", 8001)) {
//            System.out.println(socket);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Socket socket = null;
        DataOutputStream os = null;
        DataInputStream is = null;
        BufferedReader br = null;

        try {
            socket = new Socket("ferma.facecoin.ru", 8001);
            br = new BufferedReader(new InputStreamReader(System.in));
            os = new DataOutputStream(socket.getOutputStream());
            is = new DataInputStream(socket.getInputStream());

            while (!socket.isOutputShutdown()) {

// ждём консоли клиента на предмет появления в ней данных
                if (br.ready()) {
                    System.out.println("Client start writing in channel...");
                }
            }


        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
    }
}
