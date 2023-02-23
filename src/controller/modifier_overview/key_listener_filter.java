package controller.modifier_overview;

import java.awt.event.*;

import view.control_panel.overview_pn;

public class key_listener_filter implements KeyListener{
    private overview_pn c;

    public key_listener_filter(overview_pn c) {
        this.c = c;
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        String typing = this.c.getTextField().getText().toLowerCase();
        this.c.filter(typing);
    }
    
}
