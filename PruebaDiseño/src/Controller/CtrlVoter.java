
package Controller;

import Model.Candidate;
import Model.CandidateDAO;
import Model.DBConnection;
import Model.VoterDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Model.*;
import View.Vote;
/**
 *
 * @author allys
 */
public class CtrlVoter {
    VoterDAO vr= new VoterDAO();
    int id;
    
    public void loadDataVoters(JTable tblVoters) {
        DBConnection db = new DBConnection();
        DefaultTableModel model = (DefaultTableModel) tblVoters.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        tblVoters.setRowSorter(order);
        model.setRowCount(0);
        List<Voter> voters = vr.readVoters();
        for (Voter Voters : voters) {
            Object[] row = {Voters.getId(), Voters.getID_number(),Voters.getName(),Voters.getLast_name(),Voters.getSecond_name(),Voters.getAge(),Voters.getAddress(),Voters.getPassword()};
            model.addRow(row);
        }
    }
    public void addVoter(JTextField id_number,JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField address,JTextField password) {
        try{
            this.vr.createVoter(new Voter(Name.getText(),LastNm.getText(),SecondNm.getText(),Integer.parseInt(id_number.getText()), Integer.parseInt(Age.getText()),address.getText(),password.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo agregar el Candidato");
        }
    }
    public void updateCandidate(JTextField id_number,JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField address,JTextField password) {
         try{
            this.vr.updateVoters(new Voter(this.id,Name.getText(),LastNm.getText(),SecondNm.getText(),Integer.parseInt(id_number.getText()), Integer.parseInt(Age.getText()),address.getText(),password.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo actualizar el Candidato");
        }
    }
    public void deleteCandidate() {
        this.vr.deleteVoter(this.id);
    }
    public void selectedRow(JTable tblCandidates, JTextField IDNum,JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField Vote,JTextField PoliticP) {
        try {
            int row = tblCandidates.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(tblCandidates.getValueAt(row, 0).toString());
                IDNum.setText((tblCandidates.getValueAt(row, 1).toString()));
                Name.setText((tblCandidates.getValueAt(row, 2).toString()));
                LastNm.setText(tblCandidates.getValueAt(row, 3).toString());
                SecondNm.setText(tblCandidates.getValueAt(row, 4).toString());
                Age.setText(tblCandidates.getValueAt(row, 5).toString());
                Vote.setText(tblCandidates.getValueAt(row, 6).toString());
                PoliticP.setText(tblCandidates.getValueAt(row, 7).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }
    }
     public void authenticateVoter(String ID, String password) {
        Voter voters = null;
        voters = vr.autentiVoter(ID, password);
        Vote voteForms = new Vote();
    }
    public void clearFields(JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField id_number,JTextField address,JTextField password) {
        Name.setText("");
        LastNm.setText("");
        SecondNm.setText("");
        Age.setText("");
        address.setText("");
        password.setText("");
        id_number.setText("");
    }
}
