package by.bsuir.ausuikevich.server.entity;

import by.bsuir.ausuikevich.constant.Access;
import by.bsuir.ausuikevich.constant.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FactoryMethod {
    public static Info getInfo(List<String> params, Entity entity){
        if(entity.equals(Entity.STUDENT)){
            return new StudentInfo(params.get(0), Float.parseFloat(params.get(1)));
        }else {
            return new UserInfo(params.get(0), params.get(1), Access.valueOf(params.get(2).toUpperCase()));
        }
    }
}
