package edu.school21.sockets.app;

import edu.school21.sockets.server.Server;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
class Parser {

    @Parameter(names = {"--port"})
    private String port;

    public String getPort() {
        return port;
    }
}
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        JCommander.newBuilder().addObject(parser).build().parse(args);
        Server server = new Server(parser.getPort());
        server.runServer();

    }
}
