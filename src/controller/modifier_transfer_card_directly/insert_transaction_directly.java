package controller.modifier_transfer_card_directly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Random;

import javax.swing.JOptionPane;

import DAO.Daogiaodich;
import controller.window_listener;
import view.view_ver2;
import view.control_panel.transfer_pn_modifier.direct;

public class insert_transaction_directly implements ActionListener{
    private direct c;
    private view_ver2 c_;

    public insert_transaction_directly (direct c, view_ver2 c_) {
        this.c = c;
        this.c_ = c_;
    }
    public void change_label (Double sodu) {
        this.c_.getLblNewLabel_3().setText(sodu + ""); this.c_.getLblNewLabel_3().validate();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Integer n = JOptionPane.showConfirmDialog(null, "Are you sure with the decision to add!", "notification!", JOptionPane.YES_NO_OPTION);
        if (n == 0) {

            //----------------------- create transaction -------------------------
            String magiaodich = null;
            String madanhmuc = (String) this.c.getComboBox().getSelectedItem(); //madanhmuc = madanhmuc.substring(0, madanhmuc.indexOf(" ") - 1); 
            
            LocalDateTime now = LocalDateTime.now(); 

            String lido = this.c.getReason().getText();
            String muctieuchi = this.c.getSpending_goals().getText();
            Double khoangchi = Double.parseDouble(this.c.getSpending_range().getText());
            Double limit = Double.parseDouble(this.c_.getLimit_label().getText());
            Double wallet = Double.parseDouble(this.c_.getLblNewLabel_3().getText());
            Double sum = Double.parseDouble(this.c_.getLimit_label_1().getText());

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

            String mota = this.c.getDescribe().getText();
            String phuongthuc = "Direct";
            String nguoinhan = this.c.getMoney_receiver().getText();


            try {
                Statement st = window_listener.connect.createStatement();
                String command_count = "SELECT COUNT(1) FROM quanlytaikhoancanhan.giaodich";
                ResultSet count = st.executeQuery(command_count);
                count.next();
                int a = count.getInt(1);

                Random rn = new Random();
                Integer i = rn.nextInt(0, 999);

                magiaodich = "gd" + (a + 1) + i;

                String command = "insert into giaodich (magiaodich, thoigian, lydo, muctieuchi, madanhmuc, khoangchi, mota, phuongthucgiaodich, nguoinhan, nguoigui) values ('" + magiaodich + "', '" + now +"', '" + lido + "', '" + muctieuchi + "', '"+madanhmuc.substring(0, madanhmuc.indexOf(" ") - 1)+"', '"+khoangchi+"', '"+mota+"', '" + phuongthuc + "', '" + nguoinhan + "', '" + this.c_.getEmail() + "')";
                String command_ = "INSERT INTO quanlygiaodich (magiaodich, email) VALUES ( '" + magiaodich + "', '" + this.c_.getEmail() + "')";
                String command__ = "UPDATE nguoidung SET nguoidung.Sodu = nguoidung.Sodu - ? WHERE nguoidung.email = ?";
                Integer n_ = st.executeUpdate(command);
                Integer n__ = st.executeUpdate(command_);

                PreparedStatement ps  = window_listener.connect.prepareStatement(command__);
                ps.setDouble(1, khoangchi);
                ps.setString(2, this.c_.getEmail());
                Integer n___ = ps.executeUpdate();

                Daogiaodich daogiaodich = new Daogiaodich(this.c_.getEmail());
                String avg = daogiaodich.get_daydiff() + "";
                this.c_.getAvg_money().setText(avg.substring(0, avg.indexOf(".") + 2)); this.c_.getAvg_money().validate();

                System.out.println(n___);
                System.out.println(n__);
                System.out.println(n_);
                JOptionPane.showMessageDialog(null, "Donej!");
                this.c_.add_pn_modifier_direct();
            } catch (Exception a) {
                // TODO: handle exception
                a.printStackTrace();
            }

        } else {
            return;
        }
    }
}
