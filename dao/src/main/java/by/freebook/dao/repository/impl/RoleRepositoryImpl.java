package by.freebook.dao.repository.impl;

import by.freebook.dao.model.Role;
import by.freebook.dao.repository.AbstractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleRepositoryImpl extends AbstractRepository<Role> {

    private RoleRepositoryImpl() {
    }

    private static class RoleRepositoryImplHolder {
        private static final RoleRepositoryImpl HOLDER_INSTANCE = new RoleRepositoryImpl();
    }

    public static RoleRepositoryImpl getInstance() {
        return RoleRepositoryImplHolder.HOLDER_INSTANCE;
    }

    @Override
    protected String findAllSqlQuery() {
        return "SELECT * FROM public.role;";
    }

    @Override
    protected String findSqlQuery() {
        return "SELECT * FROM public.role WHERE id = ?";
    }

    @Override
    protected String removeSqlQuery() {
        return "DELETE FROM public.role WHERE id= ?";
    }

    @Override
    protected String saveSqlQuery(Boolean flag) {
        if (flag) {
            return "INSERT INTO public.role (name) VALUES (?)";
        } else {
            return "UPDATE public.role SET name=? WHERE id=?";
        }
    }

    @Override
    protected List<Role> getItemList(ResultSet rs) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Role getItem(ResultSet rs) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void prepareForSave(Role entity, PreparedStatement ps, Boolean flag) throws SQLException {
        // TODO Auto-generated method stub

    }

}
