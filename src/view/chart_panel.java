package view;

import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import controller.window_listener;  

public class chart_panel extends JPanel {  
    private static final long serialVersionUID = 1L;  
    private view_ver2 c;

    public chart_panel(view_ver2 c) {  
        this.c = c;

        DefaultPieDataset<String> dataset = createDataset();  
        setSize(20, 40);


        //Create chart  
        JFreeChart chart= ChartFactory.createPieChart("Spending rate", dataset, true, true, true);
        setLayout(new GridLayout(0, 1, 0, 0));

        ChartPanel panel=new ChartPanel(chart); panel.setLayout(new GridLayout(1, 0));
        add(panel);
    }  
    
    private DefaultPieDataset<String> createDataset() {  
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();  
        ArrayList<String[]> lst = lst();
        System.out.println(lst);
        for (int i = 0; i < lst.size(); i++) {
            dataset.setValue(lst.get(i)[0], Double.parseDouble(lst.get(i)[1]));
        }


        return dataset;  
    }  

    public ArrayList<String[]> lst () {
        ArrayList<String[]> lst = new ArrayList<>();

        try {
            String command = "SELECT danhmucchi.tendanhmuc, "
                            + "    case "
                            + "       when SUM(giaodich.khoangchi) IS NULL then 0"
                            + "        ELSE SUM(giaodich.khoangchi)"
                            + "    END AS khoangchi"
                            + " FROM danhmucchi"
                            + " INNER JOIN giaodich"
                            + " INNER JOIN quanlydanhmuc"
                            + " WHERE quanlydanhmuc.madanhmuc = giaodich.madanhmuc"
                            + " AND quanlydanhmuc.email = ?"
                            + " AND quanlydanhmuc.madanhmuc = danhmucchi.madanhmucchi"
                            + " AND giaodich.nguoigui = ?"
                            + " GROUP BY danhmucchi.tendanhmuc";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            ps.setString(2, this.c.getEmail());

            ResultSet rs = ps.executeQuery();
            lst = lst_group(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst;
    }

    public ArrayList<String[]> lst_group (ResultSet rs) {
        ArrayList<String[]> lst = new ArrayList<>();

        try {
            while (rs.next()) {
                String danhmuc = rs.getString(1);
                Double khoangchi = rs.getDouble(2);
                String[] array = new String[2];
                array[0] = danhmuc;
                array[1] = khoangchi + "";
                lst.add(array);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(lst.get(0)));
        return lst;
    }
}