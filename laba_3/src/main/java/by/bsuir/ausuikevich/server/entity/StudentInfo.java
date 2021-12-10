package by.bsuir.ausuikevich.server.entity;

import by.bsuir.ausuikevich.constant.Params;

import java.util.HashMap;
import java.util.Map;

public class StudentInfo implements Info {
    private String name;
    private float mark;

    public StudentInfo(String name, float mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public Map<String, Object> getInfo() {
        Map<String, Object> params = new HashMap<>();
        params.put(Params.NAME, name);
        params.put(Params.MARK, mark);
        return params;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
