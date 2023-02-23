package controller.modifier_overview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.Daogiaodich;
import modul.giaodich;
import view.view_ver2;
import view.control_panel.overview_pn;
public class transaction implements ActionListener{
    private view_ver2 c;
    private overview_pn c_;

    public transaction (view_ver2 c, overview_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daogiaodich daogiaodich = new Daogiaodich(this.c.getEmail());
        ArrayList<giaodich> lst_giaodich = daogiaodich.show_value();

        this.c_.refresh();
        this.c_.setTemp(new array_giaodich().array_giaodich_(lst_giaodich));
        this.c_.add_table_giaodich();
    }
}
