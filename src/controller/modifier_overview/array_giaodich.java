package controller.modifier_overview;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import modul.giaodich;

public class array_giaodich {
    
    public String[][] array_giaodich_ (ArrayList<giaodich> lst_giaodich) {
        String[][] array_giaodich = new String[lst_giaodich.size()][10];
        Locale lc = new Locale("us", "US");
        NumberFormat numf = NumberFormat.getCurrencyInstance(lc);

        for (int i = 0; i < lst_giaodich.size(); i++) {
            array_giaodich[i][0] = lst_giaodich.get(i).getThoigian() + "";
            array_giaodich[i][1] = lst_giaodich.get(i).getMagiaodich() + "";
            array_giaodich[i][2] = lst_giaodich.get(i).getLido() + "";
            array_giaodich[i][3] = lst_giaodich.get(i).getMuctieuchi() + "";
            array_giaodich[i][4] = lst_giaodich.get(i).getMadanhmuc().getMadanhmuc() + "";
            array_giaodich[i][5] = numf.format(Double.parseDouble(lst_giaodich.get(i).getKhoangchi() + "")) + "";
            array_giaodich[i][6] = lst_giaodich.get(i).getMota() + "";
            array_giaodich[i][7] = lst_giaodich.get(i).getPhuongthuc() + "";
            array_giaodich[i][8] = lst_giaodich.get(i).getEmail_nguoinhan() + "";
            array_giaodich[i][9] = lst_giaodich.get(i).getEmail_nguoigui() + "";
        }
        return array_giaodich;
    }
}
