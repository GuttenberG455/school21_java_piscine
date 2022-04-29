package school21.spring.service.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public User findById(Long id) {
        try {
            return (User)jdbcTemplate.queryForObject("SELECT * FROM public.user WHERE id=?", new BeanPropertyRowMapper(User.class), new Object[]{id});
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM public.user", new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO public.user VALUES (?, ?)", user.getId(), user.getEmail());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE public.user SET email = ? WHERE id=?", user.getEmail(), user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM public.user WHERE id=?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = (User)jdbcTemplate.queryForObject("SELECT * FROM public.user WHERE email=?", new BeanPropertyRowMapper<>(User.class), new Object[]{email});
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}