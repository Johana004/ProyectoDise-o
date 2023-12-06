
package Controller;

import Model.Candidate;
import Model.CandidateDAO;
import Model.DBConnection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Johana
 */
public class CtrlCandidate {
    CandidateDAO cd= new CandidateDAO();
    int id;

    public void loadDataCandidate(JTable tblCandidates) {
        DBConnection db = new DBConnection();
        DefaultTableModel model = (DefaultTableModel) tblCandidates.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        tblCandidates.setRowSorter(order);
        model.setRowCount(0);
        List<Candidate> candidates = cd.readCandidates();
        for (Candidate candidate : candidates) {
            Object[] row = {candidate.getId(), candidate.getId_number(),candidate.getName(),candidate.getLast_name(),candidate.getSecond_name(),candidate.getAge(),
                candidate.getVotes(),candidate.getPolitic_party()};
            model.addRow(row);
        }
    }
    public void addCandidate(JTextField IDNum,JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField Vote,JTextField PoliticP) {
        try{
            this.cd.createCandidate(new Candidate(Integer.parseInt(IDNum.getText()), Name.getText(),LastNm.getText(),SecondNm.getText(),Integer.parseInt(Age.getText()),Integer.parseInt(Vote.getText()),PoliticP.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo agregar el Candidato");
        }
    }
    public void updateCandidate(JTextField IDNum,JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField Vote,JTextField PoliticP) {
         try{
            this.cd.updateCandidates(new Candidate(this.id,Integer.parseInt(IDNum.getText()), Name.getText(),LastNm.getText(),SecondNm.getText(),Integer.parseInt(Age.getText()),Integer.parseInt(Vote.getText()),PoliticP.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo actualizar el Candidato");
        }
    }
    public void deleteCandidate() {
        this.cd.deleteCandidate(id);
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

    public void clearFields(JTextField IDNum,JTextField Name,JTextField LastNm,JTextField SecondNm,JTextField Age,JTextField Vote,JTextField PoliticP) {
        IDNum.setText("");
        Name.setText("");
        LastNm.setText("");
        SecondNm.setText("");
        Age.setText("");
        Vote.setText("");
        PoliticP.setText("");
    }
}
