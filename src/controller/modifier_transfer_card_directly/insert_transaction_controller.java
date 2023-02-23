package controller.modifier_transfer_card_directly;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DAO.Daogiaodich;
import DAO.Daouser;
import controller.window_listener;
import modul.user;
import view.view_ver2;
import view.control_panel.transfer_pn_modifier.card;

public class insert_transaction_controller implements ActionListener{
    private card c;
    private view_ver2 c_;

    public insert_transaction_controller (card c, view_ver2 c_) {
        this.c = c;
        this.c_ = c_;
    }

    public void change_label (Double sodu) {
        this.c_.getLblNewLabel_3().setText(sodu + ""); this.c_.getLblNewLabel_3().validate();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        Daouser user = new Daouser();
        String email_code_ = this.c.getMoney_receiver().getText();
		ArrayList<user> lst_user = user.check_exist1(email_code_);

        Integer n = JOptionPane.showConfirmDialog(null, "Are you sure with the decision to add!", "notification!", JOptionPane.YES_NO_OPTION);

        if (this.c.getMoney_receiver().getText().equals(this.c_.getEmail())) {
            JOptionPane.showConfirmDialog(null, "This email is yours!", "error", JOptionPane.OK_OPTION);
            return;
        } 
		Pattern regex_email = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

        if (n == 0) {

            String magiaodich = null;
            String madanhmuc = (String) this.c.getComboBox().getSelectedItem(); //madanhmuc = madanhmuc.substring(0, madanhmuc.indexOf(" ") - 1); 
            
            LocalDateTime now = LocalDateTime.now(); 

            String lido = this.c.getReason().getText();
            String muctieuchi = this.c.getSpending_goals().getText();
            String mota = this.c.getDescribe().getText();
            String phuongthuc = "Transfer";
            String email_code = this.c.getMoney_receiver().getText();


            try {
                Statement st = window_listener.connect.createStatement();
                Double sum = Double.parseDouble(this.c_.getLimit_label_1().getText());
                Double limit = Double.parseDouble(this.c_.getLimit_label().getText());
                Double wallet = Double.parseDouble(this.c_.getLblNewLabel_3().getText());

                if (lst_user.size() == 0 && email_code.contains("gd") && regex_email.matcher(email_code_).find() == false) {
                    // nguoi tao ma la nguoi nhan
                    String command__ = "SELECT quanlygiaodich.email, giaodich.khoangchi FROM quanlygiaodich INNER JOIN giaodich WHERE giaodich.magiaodich = quanlygiaodich.magiaodich AND giaodich.magiaodich = ?";
                    PreparedStatement ps = window_listener.connect.prepareStatement(command__);
                    ps.setString(1, email_code);

                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    
                    String email_maker = rs.getString(1);
                    Double khoangchi = rs.getDouble(2);
                    if (khoangchi > wallet) {
                        JOptionPane.showMessageDialog(null, "not enough money!!", "error", JOptionPane.OK_OPTION);
                        return;
                    } else if (khoangchi + sum > limit && limit != 0) {
                        JOptionPane.showMessageDialog(null, "you have exceeded your spending limit!", "error", JOptionPane.OK_OPTION);
                        return;
                    }


                    String command___ = "UPDATE giaodich SET lydo = ?, muctieuchi = ?, mota = ?, madanhmuc = ?, nguoinhan = ?, nguoigui = ? WHERE giaodich.magiaodich = ?";
                    PreparedStatement ps_ = window_listener.connect.prepareStatement(command___);
                    ps_.setString(1, lido);
                    ps_.setString(2, muctieuchi);
                    ps_.setString(3, mota);
                    ps_.setString(4, madanhmuc.substring(0, madanhmuc.indexOf(" ") - 1));
                    ps_.setString(5, email_maker);
                    ps_.setString(6, this.c_.getEmail());
                    ps_.setString(7, email_code);


                    Integer a = ps_.executeUpdate();
                    if (a != 0) {
                        JOptionPane.showMessageDialog(null, "Thanh cong", "notification", JOptionPane.OK_OPTION);
                        
                        // ----------------------- plus wallet -------------------
                        String update_wallet = "UPDATE nguoidung SET nguoidung.Sodu = nguoidung.Sodu + ? WHERE nguoidung.email = (SELECT giaodich.nguoinhan FROM giaodich WHERE giaodich.magiaodich = ?)";
                        PreparedStatement ps__ = window_listener.connect.prepareStatement(update_wallet);
                        ps__.setDouble(1, khoangchi);
                        ps__.setString(2, email_code);

                        Integer m = ps__.executeUpdate();
                        System.out.println(m);

                        // ----------------------- minus wallet --------------------
                        String minus_wallet = "UPDATE nguoidung SET nguoidung.Sodu = nguoidung.Sodu - ? WHERE nguoidung.email = ?";

                        PreparedStatement ps1  = window_listener.connect.prepareStatement(minus_wallet);

                        ps1.setDouble(1, khoangchi);
                        ps1.setString(2, this.c_.getEmail());

                        Integer n___ = ps1.executeUpdate();
                        System.out.println(n___);

                        // ----------------------- write history --------------------
                        String add_transaction = "INSERT INTO quanlygiaodich VALUES (?, ?)";
                        PreparedStatement ps2 = window_listener.connect.prepareStatement(add_transaction);
                        ps2.setString(1, email_code);
                        ps2.setString(2, this.c_.getEmail());

                        n___ = ps2.executeUpdate();
                        change_label(wallet - khoangchi);
                    } else {
                        JOptionPane.showMessageDialog(null, "Email/Code does not exist", "error", JOptionPane.OK_OPTION);
                    }
                    return ;
                }
                Double khoangchi = Double.parseDouble(this.c.getSpending_range().getText());

                if (khoangchi > wallet) {
                    JOptionPane.showConfirmDialog(null, "not enough money!", "error", JOptionPane.OK_OPTION);
                    return;
                } else if (khoangchi + sum > limit && limit != 0) {
                    JOptionPane.showConfirmDialog(null, "you have reached the payment limit of: " + limit, "notification", JOptionPane.OK_OPTION);
                    return;
                }
                change_label(wallet - khoangchi);

                Double num = Double.parseDouble(this.c_.getLimit_label().getText());
                if (num != 0) {
                    if (khoangchi > num) {
                        JOptionPane.showConfirmDialog(null, "you have set transaction limit as " + num, "error", JOptionPane.OK_OPTION);
                        return;
                    }
                }


                // ----------------------- create code transaction --------------------
                String command_count = "SELECT COUNT(1) FROM quanlytaikhoancanhan.giaodich";
                ResultSet count = st.executeQuery(command_count);
                count.next();
                int a = count.getInt(1);

                Random rn = new Random();
                Integer i = rn.nextInt(0, 999);

                magiaodich = "gd" + (a + 1) + i;

                // ----------------------- create transaction --------------------
                String command = "insert into giaodich (magiaodich, thoigian, lydo, muctieuchi, madanhmuc, khoangchi, mota, phuongthucgiaodich, nguoinhan, nguoigui) values ('" + magiaodich + "', '" + now +"', '" + lido + "', '" + muctieuchi + "', '"+madanhmuc.substring(0, madanhmuc.indexOf(" ") - 1)+"', '"+khoangchi+"', '"+mota+"', '" + phuongthuc + "', '" + email_code + "', '" +this.c_.getEmail() + "')";
                String command_ = "INSERT INTO quanlygiaodich (magiaodich, email) VALUES ( '" + magiaodich + "', '" + this.c_.getEmail() + "')";
                Integer n_ = st.executeUpdate(command);
                Integer n__ = st.executeUpdate(command_);


                // ----------------------- plus wallet --------------------
                String minus_wallet = "UPDATE nguoidung SET nguoidung.Sodu = nguoidung.Sodu - ? WHERE nguoidung.email = ?";

                PreparedStatement ps1  = window_listener.connect.prepareStatement(minus_wallet);

                ps1.setDouble(1, khoangchi);
                ps1.setString(2, this.c_.getEmail());

                Integer n___ = ps1.executeUpdate();
                System.out.println(n___);

                // ----------------------- minus wallet --------------------
                String update_wallet = "UPDATE nguoidung SET nguoidung.Sodu = nguoidung.Sodu + ? WHERE nguoidung.email = ?";
                PreparedStatement ps__ = window_listener.connect.prepareStatement(update_wallet);
                ps__.setDouble(1, khoangchi);
                ps__.setString(2, email_code);

                Integer m = ps__.executeUpdate();
                System.out.println(m);

                // ----------------------- avg per day --------------------
                Daogiaodich daogiaodich = new Daogiaodich(this.c_.getEmail());
                String avg = daogiaodich.get_daydiff() + "";
                this.c_.getAvg_money().setText(avg.substring(0, avg.indexOf(".") + 2)); this.c_.getAvg_money().validate();

                // ----------------------- clean warning -------------------
                System.out.println(n___);
                System.out.println(n__);
                System.out.println(n_);
                JOptionPane.showMessageDialog(null, "Done!");

                this.c_.add_pn_modifier_card();
            } catch (Exception a) {
                // TODO: handle exception
                a.printStackTrace();
            }

            JOptionPane.showConfirmDialog(null, "Code: \n" + magiaodich, "Notification", JOptionPane.OK_OPTION);
        } else {
            return;
        }
    }
}
