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

import controller.join_transaction.join_transaction_modifier;
import view.view_ver2;
import javax.swing.ImageIcon;

public class join_transaction extends KGradientPanel{
    private view_ver2 c;
	private JTextField	textField = new JTextField();

    public join_transaction (view_ver2 c) {
        this.c = c;
		setkEndColor(new Color(24, 90, 157));
		setkStartColor(new Color(67, 206, 162));
		setOpaque(false);
		setkBorderRadius(100);
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setOpaque(false);
		gradientPanel_3.kStartColor = Color.white;
		gradientPanel_3.setkStartColor(Color.WHITE);
		gradientPanel_3.kEndColor = Color.WHITE;
		gradientPanel_3.setkEndColor(Color.WHITE);
		gradientPanel_3.kBorderRadius = 100;
		gradientPanel_3.setkBorderRadius(100);
		
		textField.setOpaque(false);
		textField.setFont(new Font("JetBrains Mono", Font.PLAIN, 38));
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 873, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addGap(20)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addGap(27))
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 88, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Join");
		lblNewLabel_3.setIcon(new ImageIcon(join_transaction.class.getResource("/view/resource/icons8-join-96.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 47));
		
		KButton btnJoin = new KButton();
		btnJoin.setkHoverStartColor(new Color(254, 214, 227));
		btnJoin.setkHoverEndColor(new Color(168, 237, 234));
		btnJoin.setkForeGround(new Color(0, 0, 0));
		btnJoin.setkEndColor(new Color(94, 231, 223));
		btnJoin.setkBackGroundColor(new Color(180, 144, 202));
		btnJoin.setText("Join");
		btnJoin.setOpaque(false);
		btnJoin.kBorderRadius = 60;
		btnJoin.setkBorderRadius(60);
		btnJoin.setFont(new Font("JetBrains Mono", Font.PLAIN, 27));
		btnJoin.setFocusPainted(false);
		btnJoin.setContentAreaFilled(false);
		btnJoin.setBorderPainted(false);
		btnJoin.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(103)
					.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
					.addGap(72))
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(256)
					.addComponent(btnJoin, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
					.addGap(192))
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(110)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(gradientPanel_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnJoin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(262, Short.MAX_VALUE))
		);
		setLayout(gl_gradientPanel_2);
        btnJoin.addActionListener(new join_transaction_modifier(this.c, this));
    }

    public view_ver2 getC() {
        return c;
    }

    public JTextField getTextField() {
        return textField;
    }
}
