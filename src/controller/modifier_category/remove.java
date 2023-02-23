package controller.modifier_category;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.Daodanhmuchi;
import modul.danhmucchi;
import view.view_ver2;
import view.control_panel.category_pn;
public class remove implements ActionListener{
    private view_ver2 c;
    private category_pn c_;

    public remove (view_ver2 c, category_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daodanhmuchi daodanhmuchi = new Daodanhmuchi(this.c);
        Integer row_index = this.c_.getTable_1().getSelectedRow();

        String madanhmuc = "";
        try {
            madanhmuc = this.c_.getTable_1().getModel().getValueAt(row_index, 0) + "";
            
        } catch (Exception e) {
            // TODO: handle exception
            return;
        }

        if (madanhmuc.equals("dm0")) {
            return;
        } else if (!madanhmuc.equals("")) {
            danhmucchi danhmucchi = new danhmucchi(madanhmuc);
            daodanhmuchi.delete(danhmucchi);
            DefaultTableModel dtm = (DefaultTableModel) this.c_.getTable_1().getModel();
            dtm.removeRow(row_index);
            JOptionPane.showMessageDialog(null, "Done!", "notification", JOptionPane.OK_OPTION);
            return;
        }
    }
    
}
