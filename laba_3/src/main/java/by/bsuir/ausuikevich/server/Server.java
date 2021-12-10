package by.bsuir.ausuikevich.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<Connection> connections;

    public Server() throws IOException {
        serverSocket = new ServerSocket(3500);
        connections = new ArrayList<>();
    }

    public void waitConnection() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            Connection connection = new Connection(socket, this);
            Thread thread = new Thread(connection);
            connections.add(connection);
            thread.start();
        }
    }

    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }
}
