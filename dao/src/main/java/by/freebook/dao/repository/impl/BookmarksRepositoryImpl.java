package by.freebook.dao.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.freebook.dao.model.Bookmarks;
import by.freebook.dao.repository.AbstractRepository;

public class BookmarksRepositoryImpl extends AbstractRepository<Bookmarks> {

    private BookmarksRepositoryImpl() {
    }

    private static class BookmarksRepositoryImplHolder {
	private static final BookmarksRepositoryImpl HOLDER_INSTANCE = new BookmarksRepositoryImpl();
    }

    public static BookmarksRepositoryImpl getInstance() {
	return BookmarksRepositoryImplHolder.HOLDER_INSTANCE;
    }

    @Override
    protected String findAllSqlQuery() {
	return "SELECT * FROM public.bookmarks;";
    }

    @Override
    protected String findSqlQuery() {
	return "SELECT * FROM public.bookmarks WHERE id = ?";
    }

    @Override
    protected String removeSqlQuery() {
	return "DELETE FROM public.bookmarks WHERE id= ?";
    }

    @Override
    protected String saveSqlQuery(Boolean flag) {
	if (flag) {
	    return "INSERT INTO public.bookmarks (user_id, book_id) VALUES (?,?)";
	} else {
	    return "UPDATE public.bookmarks SET user_id=?, book_id=? WHERE id=?";
	}
    }

    @Override
    protected List<Bookmarks> getItemList(ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected Bookmarks getItem(ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected void prepareForSave(Bookmarks entity, PreparedStatement ps, Boolean flag) throws SQLException {
	// TODO Auto-generated method stub

    }

}
