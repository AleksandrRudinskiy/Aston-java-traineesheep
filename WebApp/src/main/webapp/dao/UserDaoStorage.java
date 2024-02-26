package main.webapp.dao;

import main.webapp.connection.ConnectionManager;
import main.webapp.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoStorage {
    private final ConnectionManager connectionManager;

    public UserDaoStorage() {
        connectionManager = new ConnectionManager();
    }

    public List<User> getUsers() throws SQLException {
        return connectionManager.getUsers();
    }

    public void addUser(User user) throws SQLException {
        connectionManager.addUser(user);
    }

    public void updateUser(User user) throws SQLException {
        connectionManager.updateUser(user);
    }

    public User getUserById(String id) throws SQLException {
        return connectionManager.getUserById(id);
    }

    public void deleteUserById(String id) throws SQLException {
        connectionManager.deleteUserById(id);
    }

}
