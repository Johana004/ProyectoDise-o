
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
        String consultaSQL = "INSERT INTO voters (id, name, ID_number) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, vot.getId());
            ps.setString(2, vot.getName());
            ps.setInt(3, vot.getID_number());
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
                int ID_number = resultSet.getInt("ID_number");
                voter.add(new Voter(id,name, ID_number ));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return voter ;
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
}
