package by.bsuir.ausuikevich.server.command;

import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.service.impl.ServerServiceImpl;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class CreateStudentCommand implements Command{
    private static final ServerServiceImpl serverService = ServerServiceImpl.getInstance();
    private BufferedWriter writer;
    private BufferedReader reader;

    @Override
    public boolean execute(Map<String, Object> params) {
        Socket socket = (Socket) params.get(Params.SOCKET);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendMessage("INPUT NAME STUDENT\n");
            String name = reader.readLine();
            sendMessage("INPUT MARK STUDENT\n");
            String mark = reader.readLine();
            try {
                serverService.addStudent(name, Float.parseFloat(mark));
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void sendMessage(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }
}
