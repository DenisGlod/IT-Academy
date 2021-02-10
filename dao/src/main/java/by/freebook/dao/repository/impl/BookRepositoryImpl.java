package by.freebook.dao.repository.impl;

import by.freebook.dao.model.Book;
import by.freebook.dao.repository.AbstractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl extends AbstractRepository<Book> {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AUTHOR = "author";
    private static final String PUBLISHER = "publisher";
    private static final String BINDING = "binding";
    private static final String AGE_RESTRICTIONS = "age_restrictions";
    private static final String ISBN = "isbn";
    private static final String DESCRIPTION = "description";
    private static final String PUBLISHING_YEAR = "publishing_year";

    private BookRepositoryImpl() {
    }

    private static class BookRepositoryImplHolder {
        private static final BookRepositoryImpl HOLDER_INSTANCE = new BookRepositoryImpl();
    }

    public static BookRepositoryImpl getInstance() {
        return BookRepositoryImplHolder.HOLDER_INSTANCE;
    }

    @Override
    protected String findAllSqlQuery() {
        return "SELECT * FROM public.book;";
    }

    @Override
    protected String findSqlQuery() {
        return "SELECT * FROM public.book WHERE id = ?";
    }

    @Override
    protected String removeSqlQuery() {
        return "DELETE FROM public.book WHERE id= ?";
    }

    @Override
    protected String saveSqlQuery(Boolean flag) {
        if (flag) {
            return "INSERT INTO public.book (name, author, publisher, binding, age_restrictions, isbn, description, publishing_year) VALUES (?,?,?,?,?,?,?,?)";
        } else {
            return "UPDATE public.book SET name=?, author=?, publisher=?, binding=?, age_restrictions=?, isbn=?, description=?, publishing_year=? WHERE id=?";
        }
    }

    @Override
    protected List<Book> getItemList(ResultSet rs) throws SQLException {
        var result = new ArrayList<Book>();
        while (rs.next()) {
            Book bookEntity = new Book()
                    .withName(rs.getString(NAME))
                    .withAuthor(rs.getString(AUTHOR))
                    .withPublisher(rs.getString(PUBLISHER))
                    .withBinding(rs.getString(BINDING))
                    .withAgeRestrictions(rs.getString(AGE_RESTRICTIONS))
                    .withIsbn(rs.getString(ISBN))
                    .withDescription(rs.getString(DESCRIPTION))
                    .withPublishingYear(rs.getInt(PUBLISHING_YEAR))
                    .withId(rs.getInt(ID));
            result.add(bookEntity);
        }
        return result;
    }

    @Override
    protected Book getItem(ResultSet rs) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void prepareForSave(Book entity, PreparedStatement ps, Boolean flag) throws SQLException {
        // TODO Auto-generated method stub

    }

}
