package by.freebook.dao.repository.impl;

import by.freebook.dao.exception.DatabaseException;
import by.freebook.dao.model.Role;
import by.freebook.dao.model.User;
import by.freebook.dao.model.UserData;
import by.freebook.dao.repository.AbstractRepository;
import by.freebook.dao.repository.DataSource;
import by.freebook.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ROLE_ID = "role_id";
    private static final String USER_DATA_ID = "user_data_id";

    private UserRepositoryImpl() {
    }

    private static class UserRepositoryImplHolder {
        private static final UserRepositoryImpl HOLDER_INSTANCE = new UserRepositoryImpl();
    }

    public static UserRepositoryImpl getInstance() {
        return UserRepositoryImplHolder.HOLDER_INSTANCE;
    }

    private String findUserByLoginPasswordSqlQuery() {
        return "SELECT * FROM public.user WHERE email=? AND password=?";
    }

    @Override
    protected String findAllSqlQuery() {
        return "SELECT * FROM public.user";
    }

    @Override
    protected String findSqlQuery() {
        return "SELECT * FROM public.user WHERE id = ?";
    }

    @Override
    protected String removeSqlQuery() {
        return "DELETE FROM public.user WHERE id= ?";
    }

    @Override
    protected String saveSqlQuery(Boolean flag) {
        if (flag) {
            return "INSERT INTO public.user (email, password, role_id, user_data_id) VALUES (?, ?, ?, ?)";
        } else {
            return "UPDATE public.user SET email=?, password=?, role_id=?, user_data_id=? WHERE id=?";
        }
    }

    @Override
    protected List<User> getItemList(ResultSet rs) throws SQLException {
        var result = new ArrayList<User>();
        while (rs.next()) {
            var user = new User()
                    .withEmail(rs.getString(EMAIL))
                    .withPassword(rs.getString(PASSWORD))
                    .withRole(
                            new Role()
                                    .withId(rs.getInt(ROLE_ID)))
                    .withUserData(
                            new UserData()
                                    .withId(rs.getInt(USER_DATA_ID)))
                    .withId(rs.getInt(ID));
            result.add(user);
        }
        return result;
    }

    @Override
    protected User getItem(ResultSet rs) throws SQLException {
        User user = null;
        while (rs.next()) {
            user = new User()
                    .withEmail(rs.getString(EMAIL))
                    .withPassword(rs.getString(PASSWORD))
                    .withRole(
                            new Role()
                                    .withId(rs.getInt(ROLE_ID)))
                    .withUserData(
                            new UserData()
                                    .withId(rs.getInt(USER_DATA_ID)))
                    .withId(rs.getInt(ID));
        }
        return user;
    }

    @Override
    protected void prepareForSave(User entity, PreparedStatement ps, Boolean flag) throws SQLException {
        if (flag) {
            ps.setString(1, entity.getEmail());
            ps.setString(2, entity.getPassword());
            ps.setLong(3, entity.getRole().getId());
            ps.setLong(4, entity.getUserData().getId());
        } else {
            ps.setString(1, entity.getEmail());
            ps.setString(2, entity.getPassword());
            ps.setLong(3, entity.getRole().getId());
            ps.setLong(4, entity.getUserData().getId());
            ps.setLong(5, entity.getId());
        }
    }

    @Override
    public Optional<User> findUserByLoginPassword(User entity) {
        DataSource dataSource = DataSource.getInstance();
        Optional<User> result = Optional.empty();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(findUserByLoginPasswordSqlQuery());
             ResultSet rs = executePreparedStatement(ps, entity)) {
            result = Optional.ofNullable(getItem(rs));
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new DatabaseException(e);
        }
        return result;
    }

    private ResultSet executePreparedStatement(PreparedStatement ps, User entity) throws SQLException {
        ps.setString(1, entity.getEmail());
        ps.setString(2, entity.getPassword());
        return ps.executeQuery();
    }

}
