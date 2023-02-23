package view.control_panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import controller.modifier_set_limit.set_limit;
import view.view_ver2;

public class limit_pn extends KGradientPanel{
    private view_ver2 c;
	private JTextField textField = new JTextField();

    public limit_pn (view_ver2 c) {
        this.c = c;
		setkStartColor(new Color(11, 135, 147));
		setkEndColor(new Color(54, 0, 51));
		setBackground(Color.LIGHT_GRAY);
		setkBorderRadius(100);
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setkStartColor(new Color(255, 255, 255));
		gradientPanel_3.setkEndColor(new Color(255, 255, 255));
		gradientPanel_3.setOpaque(false);
		gradientPanel_3.setkBorderRadius(100);
		
		JLabel lblNewLabel_3 = new JLabel("Set limit");
		lblNewLabel_3.setIcon(new ImageIcon(limit_pn.class.getResource("/view/resource/icons8-lock-70.png")));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 47));
		
		KButton btnSet = new KButton();
		btnSet.setkHoverStartColor(new Color(254, 214, 227));
		btnSet.setkHoverEndColor(new Color(168, 237, 234));
		btnSet.setkForeGround(new Color(0, 0, 0));
		btnSet.setkEndColor(new Color(94, 231, 223));
		btnSet.setkBackGroundColor(new Color(180, 144, 202));
		btnSet.setFocusPainted(false);
		btnSet.setContentAreaFilled(false);
		btnSet.setBorderPainted(false);
		btnSet.setOpaque(false);
		btnSet.setBackground(Color.LIGHT_GRAY);
		btnSet.setkBorderRadius(60);
		btnSet.setFont(new Font("JetBrains Mono", Font.PLAIN, 27));
		btnSet.setText("Set");
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addGap(89)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(99)))
					.addGap(0))
				.addGroup(Alignment.TRAILING, gl_gradientPanel_2.createSequentialGroup()
					.addGap(150)
					.addComponent(btnSet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(133))
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(129)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(gradientPanel_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		
		textField = new JTextField();
		textField.setFont(new Font("JetBrains Mono", Font.PLAIN, 38));
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setOpaque(false);
		textField.setColumns(10);
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addGap(20)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
					.addGap(27))
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		setLayout(gl_gradientPanel_2);
        btnSet.addActionListener(new set_limit(this.c, this));
    }

    public view_ver2 getC() {
        return c;
    }

    public JTextField getTextField() {
        return textField;
    }
}
