package ru.vostrikov.h2demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.vostrikov.h2demo.models.Book;

import java.util.List;
import java.util.Optional;

public class BookDAO implements DAO<Book>{

    private static final Logger LOG = LoggerFactory.getLogger(BookDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Book> rowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setName(rs.getString("name"));
        book.setAuthorId(rs.getLong("authorId"));
        book.setGenreId(rs.getLong("genreId"));

        return book;
    };

    public BookDAO(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public List<Book> list() {
        String sql = "SELECT * FROM BOOKS";
        return jdbcTemplate.query(sql, rowMapper);
//        return null;
    }

    @Override
    public void create(Book book) {
        String sql = "INSERT INTO BOOKS (name, authorId, genreId) VALUES(?, ?, ?)";
        int insert = jdbcTemplate.update(sql, book.getName(), book.getAuthorId(), book.getGenreId());
        if (insert == 1) LOG.info("Created new book {}", book);
    }

    @Override
    public Optional<Book> get(long id) {
        String sql = "SELECT * FROM BOOKS WHERE = id = ?";
        Book book = null;
        try {
            book = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            LOG.error("Book not found: {}", id);
        }

        return Optional.ofNullable(book);
    }

    @Override
    public void update(Book book, long id) {
        String sql = "UPDATE BOOKS SET name=?, authorId=?, genreId=? WHERE id=?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getAuthorId(), book.getGenreId());
        if (update == 1) LOG.info("Book updated: {}", book);
    }

    @Override
    public void delete(long id) {
        int delete = jdbcTemplate.update("DELETE FROM BOOKS WHERE id=?");
        if (delete == 1) LOG.info("Deleted book: {}", id);
    }
}
