package by.freebook.dao.repository;

import by.freebook.dao.exception.ApplicationException;
import by.freebook.dao.exception.DatabaseException;
import by.freebook.dao.model.Entity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public abstract class AbstractRepository<T extends Entity> implements Repository<T> {
    protected static final String ID = "id";

    private final DataSource dataSource = DataSource.getInstance();

    protected abstract String findAllSqlQuery();

    protected abstract String findSqlQuery();

    protected abstract String removeSqlQuery();

    protected abstract String saveSqlQuery(Boolean flag);

    protected abstract List<T> getItemList(ResultSet rs) throws SQLException;

    protected abstract T getItem(ResultSet rs) throws SQLException;

    protected abstract void prepareForSave(T entity, PreparedStatement ps, Boolean flag) throws SQLException;

    @Override
    public List<T> findAll() {
        List<T> result = new ArrayList<T>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(findAllSqlQuery());
             ResultSet rs = ps.executeQuery()) {
            result = getItemList(rs);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new DatabaseException(e);
        }
        return result;
    }

    @Override
    public Optional<T> find(Integer id) {
        ResultSet rs = null;
        Optional<T> result = Optional.empty();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(findSqlQuery())) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            result = Optional.ofNullable(getItem(rs));
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new DatabaseException(e);
        } finally {
            close(rs);
        }
        return result;
    }

    @Override
    public Optional<T> save(T entity) {
        Boolean flag = Objects.isNull(entity.getId());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(saveSqlQuery(flag))) {
            if (flag) {
                prepareForSave(entity, ps, flag);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    entity.setId(rs.getInt(ID));
                    return Optional.of(entity);
                }
            } else {
                prepareForSave(entity, ps, flag);
                if (ps.executeUpdate() > 0) {
                    return Optional.of(entity);
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new DatabaseException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> remove(Integer id) {
        Optional<T> entity;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(removeSqlQuery())) {
            entity = find(id);
            if (entity.isPresent()) {
                ps.setLong(1, entity.get().getId());
                if (ps.executeUpdate() > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new DatabaseException(e);
        }
        return Optional.empty();
    }

    public void close(AutoCloseable autoCloseable) {
        try {
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApplicationException(e);
        }
    }
}
