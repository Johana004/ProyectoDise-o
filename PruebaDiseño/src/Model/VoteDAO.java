
package Model;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Vote;

/**
 *
 * @author allys
 */
public class VoteDAO {

    public VoteDAO() {
    }
        public void createVote(Vote vote) {
        DBConnection db = new DBConnection();
        String SQL = "INSERT INTO vote (voter_id,candidate_id,date_vote) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL);
            ps.setInt(1, vote.getVoter_id());
            ps.setInt(2, vote.getCandidate_id());
            ps.setDate(3, (Date) vote.getDate_vote());
            ps.execute();
            JOptionPane.showMessageDialog(null, "El voto se agregó correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se agregó el voto " + e.toString());
        } finally {
            db.disconnect();
        }
    }
    public List<Vote> readVote() {
        DBConnection db = new DBConnection();
        List<Vote> votes = new ArrayList<>();
        String consultaSQL = "SELECT * FROM votes";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int voter_id= resultSet.getInt("voter id");
                int candidate_id= resultSet.getInt("candidate id");
                Date date_vote= resultSet.getDate("date vote");
                votes.add(new Vote(id,voter_id,candidate_id,date_vote));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return votes;
    }
    public void updateVote(Vote vote) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE votes SET  voter_id=?, candidate_id=?, date_vote=? WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, vote.getVoter_id());
            ps.setInt(2, vote.getCandidate_id());
            ps.setDate(3, (Date) vote.getDate_vote());
            ps.setInt(4, vote.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "La actualización del voto fue exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo realizar la actualización del voto:" + e.toString());
        } finally {
            db.disconnect();
        }
    }
    public void delete(int id) {
        DBConnection db = new DBConnection();
        String consultaSQL = "DELETE FROM votes WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ejecución exitosa, el voto ha sido eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error,no se pudo eliminar el voto: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
}
