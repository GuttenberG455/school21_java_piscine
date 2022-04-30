package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl extends JdbcTemplate implements UsersRepository {
    
    @Autowired
    @Qualifier("dataSource")
    public void setRepository(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public UsersRepositoryImpl() {
    }
    
    @Override
    public User findById(Long id) {
        try {
            return (User) super.queryForObject("SELECT * FROM sockets2.users WHERE id=?", new BeanPropertyRowMapper(User.class), new Object[]{id});
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return super.query("SELECT * FROM sockets2.users", new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void save(User user) {
        super.update("INSERT INTO sockets2.users (login, password) VALUES (?, ?)", user.getLogin(), user.getPassword());
    }

    @Override
    public void update(User user) {
        super.update("UPDATE sockets2.users SET login = ?, password = ? WHERE id=?", user.getLogin(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(Long id) {
        super.update("DELETE FROM sockets2.users WHERE id=?", id);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try {
            return Optional.of(Objects.requireNonNull(super.queryForObject("SELECT * FROM sockets2.users WHERE login = ?",
                    (us, count) -> new User(us.getLong(1), us.getString(2), us.getString(3)), login)));
        } catch (Exception e) {
        }
        return Optional.empty();
    }
}
