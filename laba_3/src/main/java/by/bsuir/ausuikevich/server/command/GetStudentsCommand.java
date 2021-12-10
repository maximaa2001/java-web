package by.bsuir.ausuikevich.server.command;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.entity.Info;
import by.bsuir.ausuikevich.server.service.impl.ServerServiceImpl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetStudentsCommand implements Command{
    private static final ServerServiceImpl serverService = ServerServiceImpl.getInstance();

    @Override
    public boolean execute(Map<String, Object> params) {
        Socket socket = (Socket) params.get(Params.SOCKET);
        List<Info> entity = serverService.getEntity(Entity.STUDENT);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            objectOutputStream.writeObject(entity);
            objectOutputStream.flush();
        }catch (IOException  e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
