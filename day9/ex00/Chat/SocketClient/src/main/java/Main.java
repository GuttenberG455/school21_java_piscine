import java.io.*;
import java.net.Socket;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
class Parser {

    @Parameter(names = {"--server-port"})
    private Integer port;

    public Integer getPort() {
        return port;
    }
}

public class Main {

    private static Socket clientSocket = null;
    private static BufferedReader reader = null;
    private static BufferedReader in = null;
    private static BufferedWriter out = null;

    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            JCommander.newBuilder().addObject(parser).build().parse(args);
            clientSocket = new Socket("localhost", parser.getPort());

            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String serverMsg = in.readLine();
            System.out.println(serverMsg);
            String clientIn1 = reader.readLine();
            out.write(clientIn1 + "\n");
            out.flush();
            serverMsg = in.readLine();
            System.out.println(serverMsg);
            String username = reader.readLine();
            out.write(username + "\n");
            out.flush();
            serverMsg = in.readLine();
            System.out.println(serverMsg);
            String password = reader.readLine();
            out.write(password + "\n");
            out.flush();
            serverMsg = in.readLine();
            System.out.println(serverMsg);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}