package controller.modifier_overview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.Daogiaodich;
import view.view_ver2;
import view.control_panel.overview_pn;
public class request_mn implements ActionListener{
    private view_ver2 c;
    private overview_pn c_;

    public request_mn (view_ver2 c, overview_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    public String[][] array_request_mn (ArrayList<modul.request_mn> lst) {
        String [][] array_request_mn = new String[lst.size()][4];
        
        for (int i = 0; i < lst.size(); i++) {
            array_request_mn[i][0] = lst.get(i).getThoigian() + "";
            array_request_mn[i][1] = lst.get(i).getKhoangchi() + "";
            array_request_mn[i][2] = lst.get(i).getPhuongthuc() + "";
            array_request_mn[i][3] = lst.get(i).getNguoigui() + "";
        }
        return array_request_mn;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daogiaodich daogiaodich = new Daogiaodich(this.c.getEmail());
        ArrayList<modul.request_mn> lst_request_mn = daogiaodich.lst_request_mn();
        String [][] array_request_mn = array_request_mn(lst_request_mn);
        
        this.c_.refresh();
        this.c_.setTemp(array_request_mn);
        this.c_.add_table_request_money();
    }
    
}
