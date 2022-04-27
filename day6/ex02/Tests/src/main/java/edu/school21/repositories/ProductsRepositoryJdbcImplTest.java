package edu.school21.repositories;

import edu.school21.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class ProductsRepositoryJdbcImpl implements ProductsRepository {

    private final Connection connection;

    public ProductsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> findAll() {
        final String query = "SELECT * FROM products";
        List<Product> ret = new LinkedList<>();
        ResultSet results = null;

        try {

            PreparedStatement statement = connection.prepareStatement(query);
            results = statement.executeQuery();
            while (results.next()) {
                ret.add(new Product(
                        results.getLong("id"),
                        results.getString("name"),
                        results.getLong("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ret);
    }

    @Override
    public Optional<Product> findById(Long id) {
        final String query = "SELECT * FROM products WHERE id= ?";
        ResultSet results = null;
        Product ret = null;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            results = statement.executeQuery();
            if (results.next()) {
                ret = new Product(
                        results.getLong("id"),
                        results.getString("name"),
                        results.getLong("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Optional.ofNullable(ret));
    }

    @Override
    public void update(Product product) {
        final String query = "UPDATE products SET name=?, price=? WHERE id=?";

        try {
            if (findById(product.getId()).isPresent()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, product.getName());
                statement.setLong(2, product.getPrice());
                statement.setLong(3, product.getId());
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Product product) {
        final String query = "INSERT INTO products (name, price) VALUES (?, ?)";
        ResultSet results = null;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setLong(2, product.getPrice());
            statement.execute();
            results = connection.createStatement().executeQuery("CALL IDENTITY()");
            if (results.next()) {
                product.setId(results.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        final String query = "DELETE FROM products WHERE id=?";

        try {
            if (findById(id).isPresent()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, id);
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}