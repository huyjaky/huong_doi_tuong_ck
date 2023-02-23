package controller;

import java.awt.event.*;

import view.view_ver2;
public class limit_controller implements ActionListener{
    private view_ver2 c;
    public limit_controller (view_ver2 c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        this.c.add_pn_limit();
    }
    
}
