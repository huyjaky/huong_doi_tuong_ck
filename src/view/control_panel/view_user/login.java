package view.control_panel.view_user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import controller.login_controller;
import controller.login_register_listener.login_register_window_listener;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField text_email;
	private JPasswordField text_pass;


	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/view/resource/Untitled_design-removebg-preview.png")));
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkBorderRadius(100);
		gradientPanel.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(85)
							.addComponent(gradientPanel, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
							.addGap(82)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(gradientPanel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		KGradientPanel gradientPanel_1 = new KGradientPanel();
		gradientPanel_1.setkStartColor(Color.WHITE);
		gradientPanel_1.setkEndColor(Color.WHITE);
		gradientPanel_1.setOpaque(false);
		gradientPanel_1.setkBorderRadius(40);
		
		KGradientPanel gradientPanel_1_1 = new KGradientPanel();
		gradientPanel_1_1.setkStartColor(Color.WHITE);
		gradientPanel_1_1.setkEndColor(Color.WHITE);
		gradientPanel_1_1.setOpaque(false);
		gradientPanel_1_1.setkBorderRadius(40);
		
		KButton btnLogin = new KButton();
		btnLogin.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		btnLogin.setText("Login");
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setOpaque(false);
		btnLogin.setkBorderRadius(40);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnRegister.setOpaque(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		GroupLayout gl_gradientPanel = new GroupLayout(gradientPanel);
		gl_gradientPanel.setHorizontalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel.createSequentialGroup()
							.addGap(99)
							.addGroup(gl_gradientPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnRegister, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_gradientPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_gradientPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(gradientPanel_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
								.addGroup(gl_gradientPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(gradientPanel_1_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_gradientPanel.setVerticalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(gradientPanel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(gradientPanel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		text_pass = new JPasswordField();
		text_pass.setBorder(null);
		GroupLayout gl_gradientPanel_1_1 = new GroupLayout(gradientPanel_1_1);
		gl_gradientPanel_1_1.setHorizontalGroup(
			gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(text_pass, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_1_1.setVerticalGroup(
			gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(text_pass, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_1_1.setLayout(gl_gradientPanel_1_1);
		
		text_email = new JTextField();
		text_email.setBorder(null);
		text_email.setColumns(10);
		GroupLayout gl_gradientPanel_1 = new GroupLayout(gradientPanel_1);
		gl_gradientPanel_1.setHorizontalGroup(
			gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(text_email, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_1.setVerticalGroup(
			gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(text_email, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_1.setLayout(gl_gradientPanel_1);
		gradientPanel.setLayout(gl_gradientPanel);
		panel.setLayout(gl_panel);
		setResizable(false);
		setVisible(true);
		addWindowListener(new login_register_window_listener());

		btnLogin.addActionListener(new login_controller(this));
		btnRegister.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new register();
				dispose();
			}

		});
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getText_email() {
		return text_email;
	}

	public JPasswordField getText_pass() {
		return text_pass;
	}
}
