
package Model;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author Cliente
 */
public class UserDAO {
      // Method to create a new result record in the database
    public void createUser(User user) {
    DBConnection db = new DBConnection();
    String consultaSQL = "INSERT INTO users (name, last_name, second_name, id_number, age, address, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try {
        PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setString(1, user.getName());
        ps.setString(2, user.getLast_name());
        ps.setString(3, user.getSecond_name());
        ps.setInt(4, user.getId_number());
        ps.setInt(5, user.getAge());
        ps.setString(6, user.getAddress());
        ps.setString(7, user.getPassword());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error, no se pudo insertar el usuario: " + e.getMessage());
    } finally {
        db.disconnect();
    }
}   
    public List<User> readUser() {
        DBConnection db = new DBConnection();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("last_name");
            String secondName = resultSet.getString("second_name");
            int idNumber = resultSet.getInt("id_number");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");
            String password = resultSet.getString("password");
            User user = new User(id, name, lastName, secondName, idNumber, age, address, password);
            users.add(user);
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    } finally {
        db.disconnect();
    }
    return users;
}
    public void updateUser(User user) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE users SET name=?, last_name=?, second_name=?, id_number=?, age=?, address=?, password=? WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getSecond_name());
            ps.setInt(4, user.getId_number());
            ps.setInt(5, user.getAge());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo modificar el usuario: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    public void deleteUser(int id) {
        DBConnection db = new DBConnection();
        String consultaSQL = "DELETE FROM users WHERE id=?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "El usuario fue eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar el usuario: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }  
}
