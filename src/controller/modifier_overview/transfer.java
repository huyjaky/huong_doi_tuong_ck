package controller.modifier_overview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import controller.window_listener;
import modul.transfer_history;
import view.view_ver2;
import view.control_panel.overview_pn;
public class transfer implements ActionListener{
    private view_ver2 c;
    private overview_pn c_;

    public transfer (view_ver2 c, overview_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    public ArrayList<transfer_history> lst_transfer (ResultSet rs) {
        ArrayList <transfer_history> lst_transfer = new ArrayList<>();

        try {
            while (rs.next()) {
                String nguoinhan = rs.getString(1);
                Double khoangchi = rs.getDouble(2);

                transfer_history transfer = new transfer_history(nguoinhan, khoangchi);
                lst_transfer.add(transfer);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_transfer;
    }

    public ArrayList<transfer_history> lst_transfer_history (String email) {
        ArrayList<transfer_history> lst_transfer_history = new ArrayList<>();

        try {
            String command= "SELECT giaodich.nguoinhan, giaodich.khoangchi FROM giaodich WHERE giaodich.nguoigui = ? AND giaodich.phuongthucgiaodich = 'Transfer'";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            lst_transfer_history = lst_transfer(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lst_transfer_history;
    }

    public String[][] array_transfer_history () {
        ArrayList<transfer_history> lst = lst_transfer_history(this.c.getEmail());
        String [][] array_transfer_history = new String[lst.size()][2];

        for (int i = 0; i < lst.size(); i++) {
            array_transfer_history[i][0] = lst.get(i).getNguoinhan();
            Locale lc = new Locale("us", "US");
            NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
            array_transfer_history[i][1] = numf.format(lst.get(i).getKhoangchi()) + "";
        }
        
        return array_transfer_history;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        this.c_.refresh();
        this.c_.setTemp(array_transfer_history());
        this.c_.add_table_transfer();

    }
    
}
