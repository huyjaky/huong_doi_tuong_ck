package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DAO.Daouser;
import modul.user;
import view.view_ver2;
import view.control_panel.view_user.login;
public class login_controller implements ActionListener{
    private login c;

    public login_controller (login c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("check");
            Daouser user = new Daouser();

            Pattern regex_email = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
            Pattern regex_pass = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})");

            String email = this.c.getText_email().getText();
            String pass = new String(this.c.getText_pass().getPassword());

            if (regex_email.matcher(email).find() == false || regex_pass.matcher(pass).find() == false) {
                JOptionPane.showConfirmDialog(null, "Enter the wrong email or password, please re-enter!", "error", JOptionPane.OK_OPTION);
                return;
            } 
            try {
                user nguoidung = user.login(email, pass).get(0);
                if (nguoidung != null && nguoidung.getPassword().equals(pass)) {
                    new view_ver2(email);
                    this.c.dispose();
                } else {
                    JOptionPane.showConfirmDialog(null, "Enter the wrong email or password, please re-enter!", "error", JOptionPane.OK_OPTION);
                    return;
                }
            } catch (Exception a) {
                // TODO: handle exception
                JOptionPane.showConfirmDialog(null, "Enter the wrong email or password, please re-enter!", "error", JOptionPane.OK_OPTION);
                return;
            }
        
    }
    
}
