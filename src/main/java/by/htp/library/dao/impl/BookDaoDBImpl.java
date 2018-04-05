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

	private static final String SQL_CREATE_BOOK = "INSERT INTO book (title, description, author) VALUES";
	private static final String SQL_READ_BOOKS = "SELECT * FROM book";
	private static final String SQL_READ_BOOK_BY_ID = "SELECT * FROM book WHERE book_id = ";
	private static final String SQL_READ_BOOKS_BY_TITLE = "SELECT * FROM book WHERE title = ";
	private static final String SQL_UPDATE_BOOK_BY_ID = "UPDATE book SET book_id = book_id + 1 WHERE book_id = ";
	private static final String SQL_DELETE_BOOK_BY_ID = "DELETE FROM book WHERE book_id = ";

	public void create(Book entity) {
		
		Connection connection = connect();
		
		try {
			
			Statement st = connection.createStatement();
			String title = entity.getTitle();
			String description = entity.getDescription();
			String author = entity.getAuthor();

			st.executeUpdate(SQL_CREATE_BOOK + " ('" + title + "', '" + description + "', '" + author + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect(connection);
	}

	public List<Book> readAll() {

		List<Book> books = new ArrayList<>();
		Connection connection = connect();

		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_READ_BOOKS);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return books;
	}
	
	public Book read(int id) {
		
		Connection connection = connect();
		Book book = new Book();

		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_READ_BOOK_BY_ID + id);

			while (rs.next()) {
				book.setId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return book;
	}

	public List<Book> readByTitle(String title) {

		List<Book> books = new ArrayList<>();

		Connection connection = connect();

		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_READ_BOOKS_BY_TITLE + "'" + title + "'");

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));

				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return books;
	}

	public void update(int id) {
		
		Connection connection = connect();
		
		try {
			
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_UPDATE_BOOK_BY_ID + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect(connection);
	}

	public void delete(int id) {
		
		Connection connection = connect();

		try {
			
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_DELETE_BOOK_BY_ID + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}
}
