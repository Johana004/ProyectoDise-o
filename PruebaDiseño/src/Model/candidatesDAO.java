
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.*;
/**
 *
 * @author Cliente
 */
public class candidatesDAO {
    
    public candidatesDAO() {

    }

 public void createCandidate(candidates cand) {
        DBConnection db = new DBConnection();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO candidates (name,last_name,second_name,age,photo,politic_party,votes,id_number) VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, cand.getName());
            ps.setString(2, cand.getLast_name());
            ps.setString(3, cand.getSecond_name());
            ps.setInt(4, cand.getAge());
            ps.setString(5, cand.getPhoto()); // Guarda la foto como byte
            ps.setString(6, cand.getPolitic_party());
            ps.setInt(7, cand.getVotes());
            ps.setInt(8, cand.getId_number());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
   public void upCandidates(candidates candidate) {
        DBConnection db = new DBConnection();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement("UPDATE candidates SET  name=?, last_name=?, second_name=?,age=?,photo=?,politic_party=?,id_number=? WHERE id=?");
            ps.setInt(1, candidate.getId());
            ps.setString(2, candidate.getName());
            ps.setString(3, candidate.getLast_name());
            ps.setString(4, candidate.getSecond_name());
            ps.setInt(5, candidate.getAge());
            ps.setString(6, candidate.getPhoto());
            ps.setString(7, candidate.getPolitic_party());
            ps.setInt(8, candidate.getId_number());
           
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el candidato, error: " + e.toString());
            System.err.println(e);
        } finally {
            db.disconnect();
        }
    }

    
    public List<candidates> readCandidates() {
        DBConnection db = new DBConnection();
        List<candidates> Candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates;";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_number = resultSet.getInt("id_number");
                int age = resultSet.getInt("age");
                int votes = resultSet.getInt("votes");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("Last_name");
                String second_name = resultSet.getString("second_name");
                String photo = resultSet.getString("photo");
                String politic_party = resultSet.getString("politic_party");
                Candidates.add(new candidates(id, id_number, age, votes, name, last_name, second_name,photo, politic_party));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Candidates;
    }

   public void deleteCandidate(int id) {
        DBConnection db = new DBConnection();
        String sql = "DELETE FROM candidates WHERE id=?";

        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Candidato eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }








}
