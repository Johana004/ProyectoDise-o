
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
public class CandidateDAO {
    
    public CandidateDAO() {
    }
    public void createCandidate(Candidate cand) {
        DBConnection db = new DBConnection();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO candidates (id_number,name,last_name,second_name,age,votes,politic_party) VALUES(?,?,?,?,?,?,?)");
            ps.setInt(1, cand.getId_number());
            ps.setString(2, cand.getName());
            ps.setString(3, cand.getLast_name());
            ps.setString(4, cand.getSecond_name());
            ps.setInt(5, cand.getAge());
            ps.setInt(6, cand.getVotes());
            ps.setString(7, cand.getPolitic_party());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el candidato");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se insertó correctamente el candidato: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
   public void updateCandidates(Candidate cand) {
        DBConnection db = new DBConnection();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement("UPDATE candidates SET id_number=?, name=?, last_name=?, second_name=?,age=?,votes=?,politic_party=? WHERE id=?");
            ps.setInt(1, cand.getId_number());
            ps.setString(2, cand.getName());
            ps.setString(3, cand.getLast_name());
            ps.setString(4, cand.getSecond_name());
            ps.setInt(5, cand.getAge());
            ps.setInt(6, cand.getVotes());
            ps.setString(7, cand.getPolitic_party());
            ps.setInt(8, cand.getId());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se insertó correctamente el candidato: " + e.toString());
            System.err.println(e);
        } finally {
            db.disconnect();
        }
    }
    public List<Candidate> readCandidates() {
        DBConnection db = new DBConnection();
        List<Candidate> Candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates;";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_number = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                String last_name = resultSet.getString("Last_name");
                String second_name = resultSet.getString("second_name");
                int age = resultSet.getInt("age");
                int votes= resultSet.getInt("votes");
                String politic_party = resultSet.getString("politic_party");
                Candidates.add(new Candidate(id, id_number,name, last_name, second_name, age, votes, politic_party));
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
            JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar el candidato: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }








}
