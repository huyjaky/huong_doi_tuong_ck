package controller.modifier_set_limit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DAO.Daouser;
import controller.window_listener;
import view.view_ver2;
import view.control_panel.limit_pn;
public class set_limit implements ActionListener{
    private view_ver2 c;
    private limit_pn c_;
    public set_limit (view_ver2 c, limit_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daouser user = new Daouser();
        String pass = user.get_pass(this.c.getEmail());
        System.out.println(pass);
        String enter_pass = JOptionPane.showInputDialog(null, "Enter the password: ", "notification", JOptionPane.OK_OPTION);
        System.out.println(enter_pass);
        if (pass.equals(enter_pass)) {
            Integer n = JOptionPane.showConfirmDialog(null, "Are you sure with your decision?!", "error", JOptionPane.OK_OPTION);
            if (n == 0) {
                Double limit = 0d;
                Double sum = 0d;
                try {
                    limit = Double.parseDouble(this.c_.getTextField().getText());
                    sum = Double.parseDouble(this.c.getLimit_label_1().getText());
                    if (limit < sum) {
                        JOptionPane.showMessageDialog(null, "The limit amount cannot be less than the amount spent!", "error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String command = "UPDATE nguoidung SET nguoidung.gioihan = ? WHERE nguoidung.email = ?";
                    PreparedStatement ps = window_listener.connect.prepareStatement(command);
                    ps.setDouble(1, limit);
                    ps.setString(2, this.c.getEmail());

                    Integer a = ps.executeUpdate();
                    System.out.println(a);
                } catch (Exception e) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog(null, "wrong data type", "error", JOptionPane.OK_OPTION);
                    return;
                }
                this.c.getLimit_label().setText(limit + ""); this.c.getLimit_label().validate();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong password!", "notification", JOptionPane.OK_OPTION);
            return;
        }
    }
    
}
