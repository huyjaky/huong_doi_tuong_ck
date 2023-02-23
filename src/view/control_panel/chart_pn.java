package view.control_panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import view.chart_money_stream;
import view.chart_panel;
import view.view_ver2;

public class chart_pn extends JPanel{
    private view_ver2 c;
    
    public chart_pn (view_ver2 c) {
        this.c = c;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane(); 
		add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.lightGray);
		scrollPane.setViewportView(panel_5);
		
		JPanel pie_chart_pn = new JPanel();
		pie_chart_pn.setLayout(new GridLayout(1, 0, 0, 0)); pie_chart_pn.add(new chart_panel(this.c));
		
		JPanel bar_chart_pn = new JPanel();
		bar_chart_pn.setLayout(new GridLayout(1, 0, 0, 0)); bar_chart_pn.add(new chart_money_stream(this.c));

		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(pie_chart_pn, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
						.addComponent(bar_chart_pn, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(pie_chart_pn, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bar_chart_pn, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
    }
}
