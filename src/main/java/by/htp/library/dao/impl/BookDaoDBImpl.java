package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.htp.library.bean.Book;
import by.htp.library.dao.BookDao;

import static by.htp.library.dao.util.DBConnectionHelper.*;

public class BookDaoDBImpl implements BookDao {

	private static final String SQL_SELECT_BOOKS = "SELECT * FROM book";
	private static final String SQL_SELECT_BOOKS_BY_TITLE = "SELECT * FROM book WHERE title = ";

	public void create(Book entity) {

	}

	public Book read(int id) {

		return null;
	}

	public List<Book> readAll() {

		List<Book> books = new ArrayList<>();

		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));

				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return books;
	}

	public List<Book> readByTitle(String title) {

		List<Book> books = new ArrayList<>();

		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS_BY_TITLE + "'" + title + "'");

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));

				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return books;
	}

	public void update(Book entity) {

	}

	public void delete(int id) {

	}
}
