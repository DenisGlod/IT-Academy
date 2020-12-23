package by.itacademy.filter.util;

public enum Pages {
    INDEX("/"),
    USER("/user.html"),
    ADMIN("/admin.html"),
    TEACHER("/teacher.html"),
    LOGIN("/login.html"),
    PAGE404("/404.html"),
    PAGE401("/401.html");

    private String name;

    Pages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
