package edu.school21.sockets.repositories;

import edu.school21.sockets.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MessagesRepositoryImpl extends JdbcTemplate implements MessagesRepository {

    @Autowired
    @Qualifier("dataSource")
    public void setRepository(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public MessagesRepositoryImpl() {
    }

    @Override
    public Message findById(Long id) {
        try {
            return (Message) super.queryForObject("SELECT * FROM sockets2.messages WHERE id=?", new BeanPropertyRowMapper(Message.class), new Object[]{id});
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List findAll() {
        return super.query("SELECT * FROM sockets2.messages", new BeanPropertyRowMapper(Message.class));
    }

    @Override
    public void save(Message message) {
        super.update("INSERT INTO sockets2.messages (text, author, sendingTime) VALUES (?, ?, ?)", message.getText(), message.getAuthor(), LocalDateTime.now());
    }

    @Override
    public void update(Message message) {
        super.update("UPDATE sockets2.messages SET text=?, author=?, sendingtime=?", message.getText(), message.getAuthor(), LocalDateTime.now());
    }

    @Override
    public void delete(Long id) {
        super.update("DELETE FROM sockets2.messages WHERE id=?", id);
    }


}
