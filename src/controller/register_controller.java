package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DAO.Daouser;
import controller.login_register_listener.login_register_window_listener;
import modul.user;
import view.view_ver2;
import view.control_panel.view_user.register;
public class register_controller implements ActionListener{
    private register c;

    public register_controller (register c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daouser user = new Daouser();

        String pass = new String(this.c.getPasswordField().getPassword());
        Pattern regex_email = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Pattern regex_pass = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})");

        String email = this.c.getTextField().getText();
        if (regex_email.matcher(email).find() == false) {
            JOptionPane.showConfirmDialog(null, "wrong email format!", "error", JOptionPane.OK_OPTION);
            return;
        }

        if (user.check_exist(email).size() != 0) {
            JOptionPane.showConfirmDialog(null, "Email already exists!", "error", JOptionPane.OK_OPTION);
            return;
        }

        if (regex_pass.matcher(pass).find() == false) {
            JOptionPane.showConfirmDialog(null, "Password must contain at least one uppercase letter, six lowercase letters and one special character", "error", JOptionPane.OK_OPTION);
            return;
        }

        String re_enter_pass = new String(this.c.getPasswordField_1().getPassword());
        if (regex_pass.matcher(re_enter_pass).find() == false) {
            JOptionPane.showConfirmDialog(null, "Password must contain at least one uppercase letter, six lowercase letters and one special character", "error", JOptionPane.OK_OPTION);
            return;
        }

        if (!pass.equals(re_enter_pass)) {
            JOptionPane.showConfirmDialog(null, "nhap mat khau khong trung khop!", "error", JOptionPane.OK_OPTION);
            return;
        }

        try {
            user user_o = new user(email, this.c.getTextField_1().getText(), re_enter_pass);
            user.insert(user_o);
            String command = "INSERT INTO quanlydanhmuc VALUES (?, ?)";
            PreparedStatement ps = login_register_window_listener.connect.prepareStatement(command);
            ps.setString(2, email);
            ps.setString(1, "dm0");

            Integer n = ps.executeUpdate();
            System.out.println(n);
        } catch (Exception a) {
            // TODO: handle exception
            a.printStackTrace();
            return;
        }
        new view_ver2(email);
        this.c.dispose();
    }

    
}
