package by.bsuir.ausuikevich.constant;

import by.bsuir.ausuikevich.server.command.*;

public enum CommandType {
    GET_STUDENTS(new GetStudentsCommand()),
    EDIT_STUDENT(new EditStudentCommand()),
    CREATE_STUDENT(new CreateStudentCommand()),
    AUTH(new AuthCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
