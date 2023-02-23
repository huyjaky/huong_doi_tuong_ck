package controller.modifier_category;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.window_listener;
import view.view_ver2;
import view.control_panel.category_pn;
public class insert implements ActionListener{
    private view_ver2 c;
    private category_pn c_;

    public insert (view_ver2 c, category_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    public String create_madanhmuc () {
        String madanhmuc = "";
        try {
            String command = "SELECT COUNT(1) FROM danhmucchi";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Integer count = rs.getInt(1);

            Random rn = new Random();
            Integer i = rn.nextInt(0, 999);

            madanhmuc = "dm" + (count + 1) + i;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return madanhmuc;
    }

    public void create_danhmuc (String madanhmuc) {
        try {
            String command = "INSERT INTO danhmucchi VALUES (?, ?)";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, madanhmuc);
            ps.setString(2, this.c_.getName_tag().getText());

            Integer n = ps.executeUpdate();
            System.out.println(n);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public Integer create_quanly (String madanhmuc) {
        Integer n = 0;
        try {
            String command = "INSERT INTO quanlydanhmuc VALUES (?, ?)";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            ps.setString(2, madanhmuc);

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
        String name_tag = this.c_.getName_tag().getText();
        System.out.println(name_tag);

        if (name_tag.equals("")) {
            JOptionPane.showMessageDialog(null, "Name tag null", "error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String madanhmuc = create_madanhmuc();
            create_danhmuc(madanhmuc); System.out.println("check");
            create_quanly(madanhmuc); System.out.println("check1");

            String [] temp = {madanhmuc, this.c_.getName_tag().getText()};
            DefaultTableModel dtm = (DefaultTableModel) this.c_.getTable_1().getModel();
            dtm.addRow(temp);
        }
    }
    
}
