package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DAO.Daogiaodich;
import DAO.Daouser;
import dataunit.dataunit;
import view.view_ver2;
public class window_listener implements WindowListener{
    private view_ver2 c;
    public static Connection connect;

    public window_listener (view_ver2 c) {
        this.c = c;
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        // TODO Auto-generated method stub
        Integer n = 0;

        try {
            // String command = "UPDATE nguoidung SET nguoidung.Sodu = ?, nguoidung.gioihan = ? WHERE nguoidung.email = '" + this.c.getEmail() + "'";
            String command_ = "DELETE giaodich, quanlygiaodich FROM giaodich INNER JOIN quanlygiaodich WHERE giaodich.magiaodich = quanlygiaodich.magiaodich AND giaodich.nguoigui = 'empty'";
            // PreparedStatement ps = c.prepareStatement(command);
            PreparedStatement ps_ = window_listener.connect.prepareStatement(command_);
            // ps.setDouble(1, Double.parseDouble(this.c.getLblNewLabel_3().getText())); 
            // ps.setDouble(2, Double.parseDouble(this.c.getLimit_label().getText()));

            // n = ps.executeUpdate();
            n = ps_.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(n);

        dataunit.closeConnection(window_listener.connect);
        return;
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        // TODO Auto-generated method stub
        connect = dataunit.getConnection();

        this.c.getLabel_welcome().setText("Welcome " + this.c.getEmail());
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
