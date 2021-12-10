package by.bsuir.ausuikevich.server.dao;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.server.entity.Info;

import java.util.List;
import java.util.Map;

public interface ServerDao {
    List<Info> get(String path, Entity entity);
    void add(Map<String, Object> params, String path, Entity entity);
    void edit(String name, List<String[]> parameters, String path);
}
