package controller.input_transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Random;

import javax.swing.JOptionPane;

import controller.window_listener;
import view.view_ver2;
import view.control_panel.request_money;
public class code_transaction_controller implements ActionListener{
    private view_ver2 c;
    private request_money c_;

    public code_transaction_controller (view_ver2 c, request_money c_) {
        this.c = c;
        this.c_ = c_;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
            String magiaodich = "";
            LocalDateTime now = LocalDateTime.now();
            Double khoangchi = Double.parseDouble(this.c_.getTextField_1().getText());

            try {
                Statement st = window_listener.connect.createStatement();
                String command_count = "SELECT COUNT(1) FROM quanlytaikhoancanhan.giaodich";
                ResultSet count = st.executeQuery(command_count);
                count.next();
                int a = count.getInt(1);

                Random rn = new Random();
                Integer i = rn.nextInt(0, 999);

                magiaodich = "gd" + (a + 1) + i;

                String command = "insert into giaodich (magiaodich, thoigian, khoangchi, phuongthucgiaodich, nguoinhan) values ('" + magiaodich + "', '" + now + "', " + khoangchi + ", 'Transfer', '" + this.c.getEmail() + "')";
                String command_ = "INSERT INTO quanlygiaodich (magiaodich, email) VALUES ( '" + magiaodich + "', '" + this.c.getEmail() + "')";
                Integer n_ = st.executeUpdate(command);
                Integer n__ = st.executeUpdate(command_);

                System.out.println(n__);
                System.out.println(n_);
                JOptionPane.showMessageDialog(null, "ma giao dich la: " + magiaodich);
            } catch (Exception a) {
                // TODO: handle exception
                a.printStackTrace();
            }
    }
    
}
