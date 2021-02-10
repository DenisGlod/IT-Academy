package by.freebook.dao.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.freebook.dao.model.UserData;
import by.freebook.dao.repository.AbstractRepository;

public class UserDataRepositoryImpl extends AbstractRepository<UserData> {

    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String AGE = "age";

    private UserDataRepositoryImpl() {
    }

    private static class UserDataRepositoryImplHolder {
	private static final UserDataRepositoryImpl HOLDER_INSTANCE = new UserDataRepositoryImpl();
    }

    public static UserDataRepositoryImpl getInstance() {
	return UserDataRepositoryImplHolder.HOLDER_INSTANCE;
    }

    @Override
    protected String findAllSqlQuery() {
	return "SELECT * FROM public.user_data;";
    }

    @Override
    protected String findSqlQuery() {
	return "SELECT * FROM public.user_data WHERE id = ?";
    }

    @Override
    protected String removeSqlQuery() {
	return "DELETE FROM public.user_data WHERE id= ?";
    }

    @Override
    protected String saveSqlQuery(Boolean flag) {
	if (flag) {
	    return "INSERT INTO public.user_data (first_name, last_name, middle_name, age) VALUES (?, ?, ?, ?)";
	} else {
	    return "UPDATE public.user_data SET first_name=?, last_name=?, middle_name=?, age=? WHERE id=?";
	}
    }

    @Override
    protected List<UserData> getItemList(ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected UserData getItem(ResultSet rs) throws SQLException {
	UserData user = null;
	while (rs.next()) {
	    user = new UserData()
		    .withFirstName(rs.getString(FIRST_NAME))
		    .withLastName(rs.getString(LAST_NAME))
		    .withMiddleName(rs.getString(MIDDLE_NAME))
		    .withAge(rs.getDate(AGE))
		    .withId(rs.getInt(ID));
	}
	return user;
    }

    @Override
    protected void prepareForSave(UserData entity, PreparedStatement ps, Boolean flag) throws SQLException {
	if (flag) {
	    ps.setString(1, entity.getFirstName());
	    ps.setString(2, entity.getLastName());
	    ps.setString(3, entity.getMiddleName());
	    ps.setDate(4, entity.getAge());
	} else {
	    ps.setString(1, entity.getFirstName());
	    ps.setString(2, entity.getLastName());
	    ps.setString(3, entity.getMiddleName());
	    ps.setDate(4, entity.getAge());
	    ps.setLong(5, entity.getId());
	}

    }

}
