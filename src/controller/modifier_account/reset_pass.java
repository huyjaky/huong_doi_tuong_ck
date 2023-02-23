package controller.modifier_account;

import java.awt.event.*;

import view.view_ver2;
public class reset_pass implements ActionListener{
    private view_ver2 c;

    public reset_pass (view_ver2 c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        this.c.add_pn_reset_pass();
    }
    
}
