package by.bsuir.ausuikevich.server.command;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.constant.Params;
import by.bsuir.ausuikevich.server.entity.UserInfo;
import by.bsuir.ausuikevich.server.service.impl.ServerServiceImpl;

import java.util.Map;
import java.util.Optional;

public class CheckAccessCommand implements Command{
    private static final ServerServiceImpl serverService = ServerServiceImpl.getInstance();
    @Override
    public boolean execute(Map<String, Object> params) {
        Optional<UserInfo> any = serverService.getEntity(Entity.USER).stream()
                .map(el -> (UserInfo) el)
                .filter(el -> el.getName().equals(params.get(Params.NAME)) &&
                        el.getPassword().equals(params.get(Params.PASSWORD))).findAny();
        String[] choose_access = params.get(Params.CHOOSE_COMMAND).toString().split("_");
        if(choose_access[0].equals(any.get().getAccess().name())){
            return true;
        }else {
            return false;
        }
    }
}
