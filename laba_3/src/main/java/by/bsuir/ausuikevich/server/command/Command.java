package by.bsuir.ausuikevich.server.command;

import java.util.Map;

public interface Command {
    boolean execute(Map<String, Object> params);
}
