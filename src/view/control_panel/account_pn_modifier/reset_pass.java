package view.control_panel.account_pn_modifier;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.k33ptoo.components.KGradientPanel;

import controller.modifier_account.process_pass.process_reset;
import view.view_ver2;
import com.k33ptoo.components.KButton;

public class reset_pass extends KGradientPanel{
    private view_ver2 c;
	private JTextField	new_text = new JTextField();
    private JTextField old_text = new JTextField();
	private String pass;

    public reset_pass (view_ver2 c, String pass) {
		this.pass = pass;
        this.c = c; 
		setOpaque(false);
		setkStartColor(new Color(245, 120, 220));
		setkEndColor(new Color(182, 206, 232));
		setBackground(Color.LIGHT_GRAY);
		setkBorderRadius(100);
		
		JLabel lblNewLabel_3 = new JLabel("Old Password");
		lblNewLabel_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3_1 = new JLabel("New Password");
		lblNewLabel_3_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setkStartColor(Color.white);
		gradientPanel_3.setkEndColor(Color.WHITE);
		gradientPanel_3.setOpaque(false);
		gradientPanel_3.setkBorderRadius(60);
		
		KGradientPanel gradientPanel_3_1 = new KGradientPanel();
		gradientPanel_3_1.setkEndColor(Color.WHITE);
		gradientPanel_3_1.setkStartColor(Color.WHITE);
		gradientPanel_3_1.setOpaque(false);
		gradientPanel_3_1.kBorderRadius = 60;
		gradientPanel_3_1.setkBorderRadius(60);
		
		KButton reset = new KButton();
		reset.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
		reset.setkHoverStartColor(new Color(55, 236, 186));
		reset.setkHoverEndColor(new Color(114, 175, 211));
		reset.setkForeGround(new Color(0, 0, 0));
		reset.setkEndColor(new Color(177, 244, 207));
		reset.setkBackGroundColor(new Color(152, 144, 227));
		reset.setFocusPainted(false);
		reset.setContentAreaFilled(false);
		reset.setBorderPainted(false);
		reset.setkBorderRadius(50);
		reset.setText("Reset");
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(reset, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
								.addComponent(gradientPanel_3_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))))
					.addGap(158))
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(157)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(gradientPanel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
					.addGap(61)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(gradientPanel_3_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(reset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		
		new_text.setOpaque(false);
		new_text.setColumns(10);
		new_text.setBorder(null);
		GroupLayout gl_gradientPanel_3_1 = new GroupLayout(gradientPanel_3_1);
		gl_gradientPanel_3_1.setHorizontalGroup(
			gl_gradientPanel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(new_text, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3_1.setVerticalGroup(
			gl_gradientPanel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(new_text, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3_1.setLayout(gl_gradientPanel_3_1);
		
		old_text.setBorder(null);
		old_text.setOpaque(false);
		old_text.setColumns(10);
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(old_text, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(old_text, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		setLayout(gl_gradientPanel_2);

        reset.addActionListener(new process_reset(this, this.pass, this.c));
        
    }

	public view_ver2 getC() {
		return c;
	}

	public void setC(view_ver2 c) {
		this.c = c;
	}

	public JTextField getNew_text() {
		return new_text;
	}

	public void setNew_text(JTextField new_text) {
		this.new_text = new_text;
	}

	public JTextField getOld_text() {
		return old_text;
	}

	public void setOld_text(JTextField old_text) {
		this.old_text = old_text;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
