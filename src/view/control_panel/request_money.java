package view.control_panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import controller.input_transaction.code_transaction_controller;
import view.view_ver2;
import javax.swing.LayoutStyle.ComponentPlacement;

public class request_money extends KGradientPanel{
    private view_ver2 c;
	private	JLabel email_label = new JLabel();
	private JTextField	textField_1 = new JTextField();

    public request_money (view_ver2 c) {
        this.c = c;
        this.email_label.setText("Email: " + this.c.getEmail());
		setkStartColor(new Color(24, 90, 157));
		setkEndColor(new Color(67, 206, 162));
		setBackground(Color.LIGHT_GRAY);
		setkBorderRadius(100);
		
		email_label.setHorizontalAlignment(SwingConstants.CENTER);
		email_label.setFont(new Font("JetBrains Mono", Font.PLAIN, 32));
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setkStartColor(Color.WHITE);
		gradientPanel_3.setkEndColor(Color.WHITE);
		gradientPanel_3.setOpaque(false);
		gradientPanel_3.setkBorderRadius(100);
		
		KButton btnCode = new KButton();
		btnCode.setkHoverStartColor(new Color(254, 214, 227));
		btnCode.setkHoverEndColor(new Color(168, 237, 234));
		btnCode.setkForeGround(new Color(0, 0, 0));
		btnCode.setkEndColor(new Color(94, 231, 223));
		btnCode.setkBackGroundColor(new Color(180, 144, 202));
		btnCode.setFont(new Font("JetBrains Mono", Font.PLAIN, 35));
		btnCode.setText("Recharge code");
		btnCode.setFocusPainted(false);
		btnCode.setOpaque(false);
		btnCode.setBorderPainted(false);
		btnCode.setkBorderRadius(60);
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(email_label, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(104)
					.addComponent(btnCode, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
					.addGap(72))
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(106)
					.addComponent(email_label, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gradientPanel_3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(285, Short.MAX_VALUE))
		);
		
		textField_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
		textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_1.setColumns(10);
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addGap(23)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
					.addGap(31))
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		setLayout(gl_gradientPanel_2);

		btnCode.addActionListener(new code_transaction_controller(this.c, this));
    }

	public view_ver2 getC() {
		return c;
	}

	public JLabel getEmail_label() {
		return email_label;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}
}
