package Controller;

import Model.User;
import Model.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    public void updateUser(User user) throws SQLException {
        userDAO.updateUser(user);
    }

    public void deleteUser(String cpf) throws SQLException {
        userDAO.deleteUser(cpf);
    }

    public List<User> listUsers(String filter) throws SQLException {
        return userDAO.listUsers(filter);
    }
}

