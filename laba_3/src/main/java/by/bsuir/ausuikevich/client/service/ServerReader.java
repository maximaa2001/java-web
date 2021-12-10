package by.bsuir.ausuikevich.client.service;

import by.bsuir.ausuikevich.client.Client;
import by.bsuir.ausuikevich.server.entity.Info;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerReader implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private Client client;
    private boolean nextObject;

    public ServerReader(Socket socket, Client client) throws IOException {
        this.socket = socket;
        this.client = client;
        this.nextObject = false;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!nextObject) {
                    String line = reader.readLine();
                    System.out.println(line);
                    if (line.equals("STOP") || line.equals("USER IS NOT EXIST")) {
                        reader.close();
                        socket.close();
                        client.closeConnection();
                        break;
                    }
                } else {
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    ArrayList<Info> o = (ArrayList<Info>) objectInputStream.readObject();
                    System.out.println(o);
                    nextObject = false;
                    objectInputStream.close();
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextObject() {
        nextObject = true;
    }
}
