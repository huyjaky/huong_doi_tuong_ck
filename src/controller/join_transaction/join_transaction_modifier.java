package controller.join_transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import controller.window_listener;
import view.view_ver2;
import view.control_panel.join_transaction;
public class join_transaction_modifier implements ActionListener{
    private view_ver2 c;
    private join_transaction c_;

    public join_transaction_modifier (view_ver2 c, join_transaction c_) {
        this.c = c;
        this.c_ = c_;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
        try {
            String command = "INSERT INTO quanlygiaodich VALUES (?, ?);";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c_.getTextField().getText());
            ps.setString(2, this.c.getEmail());

            Integer n = ps.executeUpdate();
            System.out.println(n);
            JOptionPane.showConfirmDialog(null, "Done", "notification",JOptionPane.OK_OPTION);
            this.c.add_pn_join_transaction();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showConfirmDialog(null, "Code does not exist", "error",JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
    }
}
