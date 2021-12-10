package by.bsuir.ausuikevich.client;

import by.bsuir.ausuikevich.client.service.ServerReader;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedWriter writer;
    private ServerReader serverReader;
    private Thread thread;
    private Scanner scanner;
    private boolean isExit;

    public Client() throws IOException {
        socket = new Socket("localhost", 3500);
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        scanner = new Scanner(System.in);
        isExit = false;
    }

    public void start() throws IOException {
        serverReader = new ServerReader(socket, this);
        thread = new Thread(serverReader);
        thread.start();
        input();
    }

    private void input() throws IOException {
        while (!isExit) {
            String line = scanner.nextLine();
            writer.write(line + "\n");
            writer.flush();
            if (line.equals("GET_STUDENTS")) {
                serverReader.nextObject();
            }
        }
    }

    public void closeConnection() throws IOException {
        isExit = true;
        writer.close();
    }
}
