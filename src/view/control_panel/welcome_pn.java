package view.control_panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.k33ptoo.components.KGradientPanel;

import view.view_ver2;

public class welcome_pn extends KGradientPanel{
    private view_ver2 c;
    private JLabel label_welcome = new JLabel("");

    public welcome_pn (view_ver2 c) {
    	setBackground(Color.LIGHT_GRAY);
        this.c = c;

		setkBorderRadius(100);
		setkStartColor(Color.pink);
		setkEndColor(Color.WHITE);
		
		label_welcome.setText("Welcome " + this.c.getEmail());
		label_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		label_welcome.setFont(new Font("JetBrains Mono", Font.ITALIC, 31));
		GroupLayout gl_panel_welcome = new GroupLayout(this);
		gl_panel_welcome.setHorizontalGroup(
			gl_panel_welcome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_welcome.createSequentialGroup()
					.addGap(18)
					.addComponent(label_welcome, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_welcome.setVerticalGroup(
			gl_panel_welcome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_welcome.createSequentialGroup()
					.addGap(65)
					.addComponent(label_welcome, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(54))
		);
		setLayout(gl_panel_welcome);
    }

}
