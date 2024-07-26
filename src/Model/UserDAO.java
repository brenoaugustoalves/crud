package Model;

import Util.DatabaseConnection;
import Util.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users (name,email, cpf, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCpf());
            stmt.setString(4, PasswordUtils.hashPassword(user.getPassword()));

            stmt.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET name=?, email=?, password=? WHERE cpf=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, PasswordUtils.hashPassword(user.getPassword()));
            stmt.setString(4, user.getCpf());

            stmt.executeUpdate();
        }
    }

    public void deleteUser(String cpf) throws SQLException {
        String query = "DELETE FROM users WHERE cpf=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }

    public List<User> listUsers(String filter) throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE name LIKE ? OR email LIKE ? OR cpf LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            String filterLike = "%" + filter + "%";
            stmt.setString(1, filterLike);
            stmt.setString(2, filterLike);
            stmt.setString(3, filterLike);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }
        return users;
    }
}
