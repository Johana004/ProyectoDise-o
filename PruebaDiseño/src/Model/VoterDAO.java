package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Voter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class VoterDAO {

    public VoterDAO() {
    }

    public void createVoter(Voter vot) {
        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO voters (name, last_name, second_name, id_number, age, address, password) VALUES (?, ?, ?, ?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, vot.getName());
            ps.setString(2, vot.getLast_name());
            ps.setString(3, vot.getSecond_name());
            ps.setInt(4, vot.getID_number());
            ps.setInt(5, vot.getAge());
            ps.setString(6, vot.getAddress());
            ps.setString(7, vot.getPassword());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Votante insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public List<Voter> readVoters() {
        DBConnection db = new DBConnection();
        List<Voter> voter = new ArrayList<>();
        String sql = "SELECT * FROM voters;";
        try (PreparedStatement ps = db.getConnection().prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("last_name");
                String second_name = resultSet.getString("second_name");
                int ID_number = resultSet.getInt("id_number");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String password = resultSet.getString("password");
                voter.add(new Voter(id, name, ID_number));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return voter;
    }

    public void updateVoters(Voter vot) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE voters SET idNumber=?,name=?, lastName=?,vote=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, vot.getName());
            ps.setString(2, vot.getLast_name());
            ps.setString(3, vot.getSecond_name());
            ps.setInt(4, vot.getID_number());
            ps.setInt(5, vot.getAge());
            ps.setString(6, vot.getAddress());
            ps.setString(7, vot.getPassword());
            ps.setInt(8, vot.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public void deleteVoter(int id) {
        DBConnection db = new DBConnection();
        String sql = "DELETE FROM voters WHERE id=?";
        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Candidato eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar el candidato: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public Voter autentiVoter(String IDNumber, String Password) {
        DBConnection db = new DBConnection();
        Voter voter = null;
        String sql = "SELECT * FROM voters WHERE id_number = ? AND PASSWORD = ?;";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, IDNumber);
            ps.setString(2, sql);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("last_name");
                String second_name = resultSet.getString("second_name");
                int ID_number = resultSet.getInt("id_number");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String password = resultSet.getString("password");
                voter = (new Voter(id, name, ID_number));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return voter;
    }
}
