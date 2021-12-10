package by.bsuir.ausuikevich.server.command;

import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.service.impl.ServerServiceImpl;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class EditStudentCommand implements Command{
    private static final ServerServiceImpl serverService = ServerServiceImpl.getInstance();
    private BufferedWriter writer;
    private  BufferedReader reader;

    @Override
    public boolean execute(Map<String, Object> params) {
        Socket socket = (Socket) params.get(Params.SOCKET);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendMessage("INPUT OLD NAME STUDENT\n");
            String oldName = reader.readLine();
            sendMessage("INPUT NEW NAME STUDENT\n");
            String newName = reader.readLine();
            sendMessage("INPUT NEW MARK STUDENT\n");
            String newMark = reader.readLine();
            try {
                serverService.editStudent(oldName, newName, Float.parseFloat(newMark));
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
