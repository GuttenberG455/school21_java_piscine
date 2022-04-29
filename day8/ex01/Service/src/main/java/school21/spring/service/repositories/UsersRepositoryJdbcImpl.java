package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource ds) {
        this.dataSource = ds;
    }

    @Override
    public User findById(Long id) {
        final String QUERY = "SELECT * FROM public.user WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setLong(1, id);
            ResultSet results = preparedStatement.executeQuery();
            if (results.next()) {
                String email = results.getString("email");
                return new User(id, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> findAll() {
        final String QUERY = "SELECT * FROM public.user";
        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                Long id = results.getLong(1);
                String email = results.getString(2);
                users.add(new User(id, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // TODO: 4/28/22 all another methods

    @Override
    public void save(User user) {
        final String QUERY = "INSERT INTO public.user (id, email) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            if (preparedStatement.executeUpdate() != 1) {
                throw new IllegalStateException("Error! User has not been added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        final String QUERY = "UPDATE public.user SET email=? WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        final String QUERY = "DELETE FROM public.user WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        final String QUERY = "SELECT * FROM public.user WHERE email=" + "'" + email + "'";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getLong(1),
                        resultSet.getString(2));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
