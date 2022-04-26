package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;

import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final Connection dataSource;
    UserRepositoryJdbcImpl userRepository;
    ChatroomRepositoryJdbcImpl chatroomRepository;

    public MessagesRepositoryJdbcImpl(Connection dataSource, UserRepositoryJdbcImpl users, ChatroomRepositoryJdbcImpl chatrooms) {
        this.dataSource = dataSource;
        this.userRepository = users;
        this.chatroomRepository = chatrooms;
    }

    @Override
    public Optional<Message> findById(Long id) {
        String query = "SELECT * FROM chat.messages WHERE id=?";
        Message ret = null;
        ResultSet resultSet = null;

        try {
            PreparedStatement statement = dataSource.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ret = new Message(
                        resultSet.getLong("id"),
                        userRepository.findById(resultSet.getLong("author")).orElse(null),
                        chatroomRepository.findById(resultSet.getLong("room")).orElse(null),
                        resultSet.getString("text"),
                        resultSet.getTimestamp("timestamp").toLocalDateTime()
                );
            statement.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (Optional.ofNullable(ret));
    }

    @Override
    public void save(Message message) {
        final String query = "INSERT INTO chat.messages (author, room, text, timestamp) VALUES (?, ?, ?, ?) RETURNING *";

        ResultSet resultSet = null;
        try {
            if (userRepository.findById(message.getAuthor().getId()).isPresent()
                    && chatroomRepository.findById(message.getChatroom().getId()).isPresent()) {
                PreparedStatement statement = dataSource.prepareStatement(query);
                statement.setLong(1, message.getAuthor().getId());
                statement.setLong(2, message.getChatroom().getId());
                statement.setString(3, message.getText());
                statement.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
                resultSet = statement.executeQuery();
                resultSet.next();
                message.setId(resultSet.getLong("id"));
            } else {
                System.err.println("Error! Wrong user or chatroom id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Message message) {
        final String query = "UPDATE chat.messages SET author=?, room=?, text=?, timestamp=? WHERE id=?;";

        ResultSet resultSet = null;
        try {
            if (userRepository.findById(message.getAuthor().getId()).isPresent()
                    && chatroomRepository.findById(message.getChatroom().getId()).isPresent()) {
                PreparedStatement statement = dataSource.prepareStatement(query);
                statement.setLong(1, message.getAuthor().getId());
                statement.setLong(2, message.getChatroom().getId());
                statement.setString(3, message.getText());
                statement.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
                statement.setLong(5, message.getId());
                statement.execute();
            } else {
                System.err.println("Error! Wrong user or chatroom id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
