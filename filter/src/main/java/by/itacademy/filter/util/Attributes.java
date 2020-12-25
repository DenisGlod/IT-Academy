package by.itacademy.filter.util;

public enum Attributes {
    USER("user"),
    EXCEPTION_FLAG("exceptionFlag"),
    EXCEPTION_MESSAGE("exceptionMessage"),
    GROUPS("groups");

    private final String name;

    Attributes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
