package view.control_panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.k33ptoo.components.KGradientPanel;

import controller.modifier_transfer.card_controller;
import controller.modifier_transfer.direct_controller;
import view.view_ver2;

public class transfer_pn extends KGradientPanel{
    private view_ver2 c;


    public transfer_pn (view_ver2 c) {
		this.c = c;
		setkGradientFocus(800);
		setkStartColor(new Color(182, 251, 255));
		setkEndColor(new Color(131, 164, 212));
		setBackground(Color.LIGHT_GRAY);
		setkBorderRadius(100);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setOpaque(false);
		
		JLabel lblNewLabel_5 = new JLabel("Transfer");
		lblNewLabel_5.setFont(new Font("JetBrains Mono", Font.ITALIC, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel direct_btn = new JLabel("Direct transfer");
		direct_btn.setFont(new Font("JetBrains Mono", Font.ITALIC, 25));
		direct_btn.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addGap(29)
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(direct_btn, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 335, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addComponent(panel_5_1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(direct_btn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		panel_5_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton direct_transfer_btn = new JButton("");
		direct_transfer_btn.setIcon(new ImageIcon(transfer_pn.class.getResource("/view/resource/give-money.png")));
		direct_transfer_btn.setOpaque(false);
		direct_transfer_btn.setBorderPainted(false);
		direct_transfer_btn.setContentAreaFilled(false);
		direct_transfer_btn.setFocusPainted(false);
		panel_5_1.add(direct_transfer_btn);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton card_btn = new JButton("");
		card_btn.setIcon(new ImageIcon(transfer_pn.class.getResource("/view/resource/credit-cards-payment.png")));
		card_btn.setFocusPainted(false);
		card_btn.setOpaque(false);
		card_btn.setContentAreaFilled(false);
		card_btn.setBorderPainted(false);
		panel_5.add(card_btn);
		setLayout(gl_gradientPanel_2);

		card_btn.addActionListener(new card_controller(this.c));
		direct_transfer_btn.addActionListener(new direct_controller(this.c));
    } 
}
