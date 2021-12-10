package by.bsuir.ausuikevich.server.entity;

import by.bsuir.ausuikevich.constant.Access;
import by.bsuir.ausuikevich.constant.Params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserInfo implements Info {
    private String name;
    private String password;
    private Access access;

    public UserInfo(String name, String password, Access access) {
        this.name = name;
        this.password = password;
        this.access = access;
    }

    @Override
    public Map<String, Object> getInfo() {
        Map<String, Object> params = new HashMap<>();
        params.put(Params.NAME, name);
        params.put(Params.PASSWORD, password);
        params.put(Params.ACCESS, access);
        return params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", access=" + access +
                '}';
    }
}
