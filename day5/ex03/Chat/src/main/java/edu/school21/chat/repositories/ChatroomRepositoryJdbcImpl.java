package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ChatroomRepositoryJdbcImpl implements ChatroomRepository {
    private final Connection dataSource;
    private final UserRepositoryJdbcImpl userRepository;

    public ChatroomRepositoryJdbcImpl(Connection dataSource, UserRepositoryJdbcImpl ur) {
        this.dataSource = dataSource;
        this.userRepository = ur;
    }

    @Override
    public Optional<Chatroom> findById(Long id) {
        String query = "SELECT * FROM chat.rooms WHERE id=?";
        Chatroom ret = null;
        ResultSet resultSet = null;

        try {
            PreparedStatement statement = dataSource.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ret = new Chatroom(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        userRepository.findById(resultSet.getLong("owner")).orElse(null),
                        new ArrayList<>()
                );
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (Optional.ofNullable(ret));
    }
}
