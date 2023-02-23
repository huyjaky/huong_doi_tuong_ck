package view.control_panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import controller.modifier_account.reset_pass;
import view.view_ver2;
import javax.swing.SwingConstants;

public class account_pn extends KGradientPanel{
    private view_ver2 c;

	private	JLabel lblNewLabel_6 = new JLabel("User Name");
	private	JLabel lblNewLabel_6_2 = new JLabel("Password");
	private	JLabel lblNewLabel_6_1 = new JLabel("Email");

    public account_pn (view_ver2 c) {
    	setOpaque(false);
        this.c = c;
		setkStartColor(new Color(255, 209, 148));
		setkEndColor(new Color(112, 225, 245));
		setBackground(Color.LIGHT_GRAY);
		setkBorderRadius(100);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(account_pn.class.getResource("/view/resource/avatar.png")));
		
		JPanel panel_5 = new JPanel();
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNewLabel_6.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		
		lblNewLabel_6_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		
		lblNewLabel_6_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
		
		KButton btnResetPassword = new KButton();
		btnResetPassword.setkForeGround(new Color(0, 0, 0));
		btnResetPassword.setFocusPainted(false);
		btnResetPassword.setkHoverStartColor(new Color(254, 214, 227));
		btnResetPassword.setkHoverEndColor(new Color(168, 237, 234));
		btnResetPassword.setkEndColor(new Color(94, 231, 223));
		btnResetPassword.setkBackGroundColor(new Color(180, 144, 202));
		btnResetPassword.setForeground(Color.BLACK);
		btnResetPassword.setFont(new Font("JetBrains Mono", Font.PLAIN, 17));
		btnResetPassword.setText("RESET PASSWORD");
		btnResetPassword.setBorderPainted(false);
		btnResetPassword.setOpaque(false);
		btnResetPassword.setkBorderRadius(40);
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6_2, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
						.addComponent(lblNewLabel_6_1, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(342)
					.addComponent(btnResetPassword, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addGap(105))
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_6_1, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_6_2, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
							.addGap(11)))
					.addGap(43)
					.addComponent(btnResetPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		setLayout(gl_gradientPanel_2);

		btnResetPassword.addActionListener(new reset_pass(this.c));
    }

    public view_ver2 getC() {
        return c;
    }

    public JLabel getLblNewLabel_6() {
        return lblNewLabel_6;
    }

    public JLabel getLblNewLabel_6_2() {
        return lblNewLabel_6_2;
    }

    public JLabel getLblNewLabel_6_1() {
        return lblNewLabel_6_1;
    }
}
