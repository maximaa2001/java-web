package by.bsuir.ausuikevich.server.command;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.entity.Info;
import by.bsuir.ausuikevich.server.entity.UserInfo;
import by.bsuir.ausuikevich.server.service.impl.ServerServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AuthCommand implements Command{
    private static final ServerServiceImpl serverService = ServerServiceImpl.getInstance();
    
    @Override
    public boolean execute(Map<String, Object> params) {
        List<Info> entity = serverService.getEntity(Entity.USER);
        String name = params.get(Params.NAME).toString();
        String password = params.get(Params.PASSWORD).toString();
        Optional<UserInfo> any = entity.stream().map(el -> (UserInfo) el).filter(el -> el.getName().equals(name) && el.getPassword().equals(password)).findAny();
        if(any.isPresent()){
            return true;
        }else {
           return false;
        }
    }
}
