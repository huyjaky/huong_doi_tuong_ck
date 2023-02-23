package controller.modifier_overview;

import java.util.ArrayList;

import modul.danhmucchi;

public class arr_category {

    public String[][] array_danhmucchi (ArrayList<danhmucchi> lst_danhmucchi) {
        String[][] array_danhmucchi = new String[lst_danhmucchi.size()][2];

        for (int index = 0; index < lst_danhmucchi.size(); index++) {
            array_danhmucchi[index][0] = lst_danhmucchi.get(index).getMadanhmuc() + "";
            array_danhmucchi[index][1] = lst_danhmucchi.get(index).getTendanhmuc() + "";
        }
        return array_danhmucchi;
    }
}
