package controller.modifier_overview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.Daodanhmuchi;
import view.view_ver2;
import view.control_panel.overview_pn;
public class category implements ActionListener{
    private view_ver2 c;
    private overview_pn c_;
    public category (view_ver2 c, overview_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daodanhmuchi danhmucchi = new Daodanhmuchi(this.c);
        ArrayList<modul.danhmucchi> lst_danhmucchi = danhmucchi.show_value();

        this.c_.refresh();
        this.c_.setTemp(new arr_category().array_danhmucchi(lst_danhmucchi));
        this.c_.add_table_danhmucchi();
    }
    
}
