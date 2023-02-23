package controller.modifier_account.process_pass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import controller.window_listener;
import view.view_ver2;
import view.control_panel.account_pn_modifier.reset_pass;
public class process_reset implements ActionListener{
    private reset_pass c;
    private String pass;
    private view_ver2 c_;

    public process_reset (reset_pass c, String pass, view_ver2 c_) {
        this.c = c;
        this.pass = pass;
        this.c_ = c_;
    }

    public Integer change_pass (String pass) {
        Integer n = 0;

        try {
            String command = "UPDATE nguoidung SET nguoidung.PASSWORD = ? WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, pass);
            ps.setString(2, this.c_.getEmail());

            n = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
		Pattern regex_pass = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})");
        String oldpass = this.c.getOld_text().getText();
        String newpass = this.c.getNew_text().getText();

        if (oldpass.equals(this.pass)) {
            if (regex_pass.matcher(newpass).find()) {
                change_pass(newpass);
                JOptionPane.showMessageDialog(null, "Change password successfully", "notification", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Password must contain at least one uppercase letter, one special character, and six lowercase letters", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong password", "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
}
