package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl extends JdbcTemplate implements UsersRepository {

    JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl() {
    }

    public UsersRepositoryImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public User findById(Long id) {
        try {
            return (User)jdbcTemplate.queryForObject("SELECT * FROM public.userChat WHERE id=?", new BeanPropertyRowMapper(User.class), new Object[]{id});
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM public.userChat", new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO public.userChat (login, password) VALUES (?, ?)", user.getLogin(), user.getPassword());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE public.userChat SET login = ?, password = ? WHERE id=?", user.getLogin(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM public.userChat WHERE id=?", id);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM public.userChat WHERE login = ?", new BeanPropertyRowMapper<>(User.class), new Object[]{login});
            return (Optional.ofNullable(user));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
