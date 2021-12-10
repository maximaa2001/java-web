package by.bsuir.ausuikevich.server;

import by.bsuir.ausuikevich.constant.CommandType;
import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.command.AuthCommand;
import by.bsuir.ausuikevich.server.command.CheckAccessCommand;
import by.bsuir.ausuikevich.server.command.Command;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Connection implements Runnable {
    private Socket socket;
    private Server server;
    private BufferedWriter writer;
    private BufferedReader reader;

    public Connection(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        sendCommand("SERVER IS READY\n");
        sendCommand("INPUT YOUR NAME\n");
        try {
            String name = reader.readLine();
            sendCommand("INPUT YOUR PASSWORD\n");
            String password = reader.readLine();
            Map<String, Object> params = new HashMap<>();
            params.put(Params.NAME, name);
            params.put(Params.PASSWORD, password);
            Command command = new AuthCommand();
            boolean bool = command.execute(params);
            if (bool) {
                CommandType[] values = CommandType.values();
                while (true) {
                    sendCommand("INPUT COMMAND\n");
                    String s = reader.readLine();
                    Optional<CommandType> any = Arrays.stream(values).
                            filter(value -> value.name().equals(s.toUpperCase())).findAny();
                    if (any.isPresent()) {
                        Map<String, Object> param = new HashMap<>();
                        param.put(Params.SOCKET, socket);
                        params.put(Params.CHOOSE_COMMAND, any.get());
                        Command check = new CheckAccessCommand();
                        if (check.execute(params)) {
                            any.get().getCommand().execute(param);
                        } else {
                            sendCommand("UNAVAILABLE COMMAND\n");
                        }
                    } else if (s.equals("STOP")) {
                        writer.close();
                        reader.close();
                        socket.close();
                        sendCommand("STOP\n");
                        break;
                    } else {
                        sendCommand("UNKNOW COMMAND\n");
                    }
                }
            } else {
                sendCommand("USER IS NOT EXIST\n");
            }
            server.removeConnection(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendCommand(String message) {
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
