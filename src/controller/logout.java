package controller;

import java.awt.event.*;

import javax.swing.JOptionPane;

import view.view_ver2;
import view.control_panel.view_user.view_dangnhap;
public class logout implements ActionListener{
    private view_ver2 c;

    public logout (view_ver2 c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        Integer n = JOptionPane.showConfirmDialog(null, "Ban co chac muon dang xuat tai khoang nay!", "notification", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            this.c.getFrame().dispose();
            new view_dangnhap();
        } else {
            return;
        }

    }
    
}
