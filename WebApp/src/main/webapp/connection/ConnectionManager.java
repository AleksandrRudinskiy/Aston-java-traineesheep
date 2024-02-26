package main.webapp.connection;

import main.webapp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private final Connection connection = new ConnectionAccess().makeConnection();
    private final String catalog = "cats";

    private DatabaseMetaData metaData = getMetaData();


    public List<User> getUsers() throws SQLException {
        String query = "select * from cat_user";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            users.add(user);
        }
        resultSet.close();
        return users;

    }

    public void addUser(User user) throws SQLException {
        String query = "insert into cat_user values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getLogin());
        statement.executeUpdate();
    }

    public void updateUser(User user) throws SQLException {
        List<User> users = getUsers();
        for (User itemUser : users) {
            if (itemUser.getId().equals(user.getId())) {
                String query = "update cat_user set username = ?, nickname = ? where id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getName());
                statement.setString(2, user.getLogin());
                statement.setString(3, user.getId());
                statement.executeUpdate();
                break;
            }

        }
        addUser(user);
    }

    public User getUserById(String id) throws SQLException {
        String query = "select * from cat_user where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        User user = null;
        while (resultSet.next()) {
            user = new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
        return user;
    }

    public void deleteUserById(String id) throws SQLException {
        String query = "delete from cat_user where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id);
        statement.executeUpdate();

    }


    private DatabaseMetaData getMetaData() {
        try {
            connection.setCatalog(catalog);
            System.out.println(connection.getCatalog());
            System.out.println(connection.isReadOnly());
            return metaData = connection.getMetaData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
