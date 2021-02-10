package by.freebook.dao.repository;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private final String url;
    private final String user;
    private final String password;
    private final String driverName;

    @SneakyThrows
    private DataSource() {
        Properties dbProperties = new Properties();
        dbProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        url = dbProperties.getProperty("url");
        user = dbProperties.getProperty("user");
        password = dbProperties.getProperty("password");
        driverName = dbProperties.getProperty("driverName");
        Class.forName(driverName);
    }

    private static class DataSourceHolder {
        private static final DataSource HOLDER_INSTANCE = new DataSource();
    }

    public static DataSource getInstance() {
        return DataSourceHolder.HOLDER_INSTANCE;
    }

    @SneakyThrows
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
