package by.bsuir.ausuikevich.constant;

public enum Entity {
    USER("src/main/resources/users.xml"),
    STUDENT("src/main/resources/students.xml");
    private final String path;

    Entity(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
