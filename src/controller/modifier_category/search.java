package controller.modifier_category;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.Daodanhmuchi;
import modul.danhmucchi;
import view.view_ver2;
import view.control_panel.category_pn;
public class search implements ActionListener{
    private view_ver2 c;
    private category_pn c_;

    public search (view_ver2 c, category_pn c_) {
        this.c = c;
        this.c_ = c_;
    }

    public String[][] array_danhmucchi (ArrayList<danhmucchi> lst) {
        String[][] array_danhmucchi = new String[lst.size()][2];

        for (int i = 0; i < lst.size(); i++) {
            array_danhmucchi[i][0] = lst.get(i).getMadanhmuc();
            array_danhmucchi[i][1] = lst.get(i).getTendanhmuc();
        }
        return array_danhmucchi;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        String name = this.c_.getTextField().getText();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "null", "error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Daodanhmuchi daodanhmuchi = new Daodanhmuchi(this.c);
            ArrayList<danhmucchi> lst_danhmucchi = daodanhmuchi.search_through_name(name);
            if (lst_danhmucchi.size() == 0) {
                JOptionPane.showMessageDialog(null, "No valid results found", "error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                this.c_.setTemp(array_danhmucchi(lst_danhmucchi));
                this.c_.refresh();
                this.c_.add_table();
            }
        }

    }
    
}
