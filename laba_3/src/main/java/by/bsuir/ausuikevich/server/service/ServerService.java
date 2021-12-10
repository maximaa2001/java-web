package by.bsuir.ausuikevich.server.service;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.server.entity.Info;

import java.util.List;

public interface ServerService {
    void addStudent(String name, float mark);
    List<Info> getEntity(Entity entity);
    void editStudent(String oldName, String newName, float newMark);
}
