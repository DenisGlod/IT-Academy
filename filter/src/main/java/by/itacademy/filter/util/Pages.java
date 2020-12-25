package by.itacademy.filter.util;

public enum Pages {
    INDEX("/"),
    USER("/page/user.html"),
    ADMIN("/page/admin.html"),
    TEACHER("/page/teacher.html"),
    PAGE404("/404.html"),
    PAGE401("/401.html");

    private final String name;

    Pages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
