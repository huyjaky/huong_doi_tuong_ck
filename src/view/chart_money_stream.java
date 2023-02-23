package view;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import DAO.Daogiaodich;
import modul.data_type;

public class chart_money_stream extends JPanel{
    private static final long serialVersionUID = 1L;
    private view_ver2 c;
    
    public chart_money_stream (view_ver2 c) {
        this.c = c;

        DefaultCategoryDataset dataset = dataset();
        JFreeChart chart = ChartFactory.createBarChart("Statistical", "Date", "Consumption Index", dataset, PlotOrientation.VERTICAL, true, true, false);

        setLayout(new GridLayout(1,0));
        ChartPanel cp = new ChartPanel(chart); cp.setLayout(new GridLayout(1, 0));
        add(cp);
    }

    public DefaultCategoryDataset dataset() {
        DefaultCategoryDataset dataset =  new DefaultCategoryDataset();
        Daogiaodich daogiaodich = new Daogiaodich(this.c.getEmail());
        ArrayList<data_type> lst_datatype = daogiaodich.lst_data();

        String date;
        Double khoangchi;
        for (int i = 0; i < lst_datatype.size(); i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("E dd-MM-yy");
            date = dateFormat.format(lst_datatype.get(i).getDate());
            khoangchi = lst_datatype.get(i).getKhoangchi();

            dataset.addValue(khoangchi, "Khoang chi", date);
        }
        return dataset;
    }

}
