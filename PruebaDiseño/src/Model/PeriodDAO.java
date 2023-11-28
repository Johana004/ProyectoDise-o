
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Period;
import java.sql.Date;
/**
 *
 * @author allys
 */
public class PeriodDAO {

    public PeriodDAO() {
    }
    public void createPeriod(Period period) {
        DBConnection db = new DBConnection();
        String SQL = "INSERT INTO periods (name,start_date, end_date) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL);
            ps.setString(1, period.getName());
            ps.setDate(2, (Date) period.getStart_date());
            ps.setDate(3, (Date) period.getEnd_date());
            ps.execute();
            JOptionPane.showMessageDialog(null, "El periodo se agregó correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se registró el periodo " + e.toString());
        } finally {
            db.disconnect();
        }
    }
    public List<Period> readPeriod() {
        DBConnection db = new DBConnection();
        List<Period> periods = new ArrayList<>();
        String consultaSQL = "SELECT * FROM periods";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name= resultSet.getString("name");
                Date start_date = resultSet.getDate("start date");
                Date end_date = resultSet.getDate("end date");
                periods.add(new Period(id,name,start_date,end_date));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return periods;
    }
    public void updatePeriod(Period period) {
        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE periods SET  name=?, start_date=?, end_date=? WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, period.getName());
            ps.setDate(2, (Date) period.getStart_date());
            ps.setDate(3, (Date) period.getEnd_date());
            ps.execute();
            JOptionPane.showMessageDialog(null, "La actualización del periodo fue exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo realizar la actualización del periodo:" + e.toString());
        } finally {
            db.disconnect();
        }
    }
    public void delete(int id) {
        DBConnection db = new DBConnection();
        String consultaSQL = "DELETE FROM periods WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Ejecución exitosa, el periodo ha sido eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error,no se pudo eliminar el periodo: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
}
