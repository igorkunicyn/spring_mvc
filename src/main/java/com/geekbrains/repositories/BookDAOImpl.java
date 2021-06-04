package com.geekbrains.repositories;

import com.geekbrains.BookDAO;
import com.geekbrains.entites.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM book";
        List<Book> listBook = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    book.setDescription(rs.getString("description"));
                    book.setYear(rs.getInt("year"));
                    return book;
                });

        return listBook;
//        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));

    }

    @Override
    public void save(Book book) {
        if (book.getId() > 0) {
            // update
            String sql = "UPDATE book SET title=?, description=?, year=? WHERE id=?";
            jdbcTemplate.update(sql, book.getTitle(), book.getDescription(), book.getYear(), book.getId());
        } else {
            // insert
            String sql = "INSERT INTO book (title, description, year)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, book.getTitle(), book.getDescription(), book.getYear());
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM book WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Book getById(long id) {
        String sql = "SELECT * FROM book WHERE id=" + id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Book.class));
    }

}
