package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view_ver2;
public class join_transaction_controller implements ActionListener{
    private view_ver2 c;

    public join_transaction_controller (view_ver2 c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        this.c.add_pn_join_transaction();
    }
    
}
