package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.Daogiaodich;
import DAO.Daouser;
import view.view_ver2;
public class refresh_btn implements ActionListener{
    private view_ver2 c;

    public refresh_btn (view_ver2 c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Daouser user = new Daouser(); user.reset_limit(this.c.getEmail());
        String wallet = user.get_wallet(this.c.getEmail()) + "  ";
        String limit = user.get_limit(this.c.getEmail()) + "  ";
        this.c.getLblNewLabel_3().setText(wallet.substring(0, wallet.indexOf(".") + 2)); this.c.getLblNewLabel_3().validate();
        this.c.getLimit_label().setText(limit.substring(0, limit.indexOf(".") + 2)); this.c.getLimit_label().validate();
        
        Daogiaodich daogiaodich = new Daogiaodich(this.c.getEmail());
        String sum = daogiaodich.sum_giaodich_per_month() + "  ";
        this.c.getLimit_label_1().setText(sum.substring(0, sum.indexOf(".") + 2)); this.c.getLimit_label_1().validate();
        String avg = daogiaodich.get_daydiff() + "  ";
        this.c.getAvg_money().setText(avg.substring(0, avg.indexOf(".") + 2)); this.c.getAvg_money().validate();
    }
    
}
