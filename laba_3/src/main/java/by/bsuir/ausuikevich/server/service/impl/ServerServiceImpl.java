package by.bsuir.ausuikevich.server.service.impl;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.dao.impl.ServerDaoImpl;
import by.bsuir.ausuikevich.server.entity.Info;
import by.bsuir.ausuikevich.server.service.ServerService;

import java.util.*;

public class ServerServiceImpl implements ServerService {
    public static ServerServiceImpl instance;
    private ServerDaoImpl serverDao = ServerDaoImpl.getInstance();

    private ServerServiceImpl(){}

    public static ServerServiceImpl getInstance(){
        if(instance == null){
            instance = new ServerServiceImpl();
        }
        return instance;
    }

    @Override
    public void addStudent(String name, float mark) {
        Map<String, Object> params = new HashMap<>();
        params.put(Params.NAME, name);
        params.put(Params.MARK, mark);
        serverDao.add(params, Params.STUDENTS_PATH, Entity.STUDENT);
    }

    @Override
    public List<Info> getEntity(Entity entity) {
        if(entity.equals(Entity.USER)){
            return serverDao.get(Params.USERS_PATH, Entity.USER);
        }else {
            return serverDao.get(Params.STUDENTS_PATH, Entity.STUDENT);
        }
    }

    @Override
    public void editStudent(String oldName, String newName, float newMark) {
        List<String[]> params = new ArrayList<>();
        params.add(new String[]{Params.NAME, newName});
        params.add(new String[]{Params.MARK, String.valueOf(newMark)});
        serverDao.edit(oldName,params, Params.STUDENTS_PATH);
    }
}
