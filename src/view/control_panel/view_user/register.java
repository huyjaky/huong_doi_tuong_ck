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

import controller.register_controller;
import controller.login_register_listener.login_register_window_listener;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;


	/**
	 * Create the frame.
	 */
	public register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(register.class.getResource("/view/resource/Untitled_design-removebg-preview.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setOpaque(false);
		gradientPanel.kBorderRadius = 100;
		gradientPanel.setkBorderRadius(100);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setOpaque(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		
		KButton btnRegister = new KButton();
		btnRegister.setText("Register");
		btnRegister.setOpaque(false);
		btnRegister.kBorderRadius = 40;
		btnRegister.setkBorderRadius(40);
		btnRegister.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		KGradientPanel gradientPanel_1 = new KGradientPanel();
		gradientPanel_1.setOpaque(false);
		gradientPanel_1.kStartColor = Color.WHITE;
		gradientPanel_1.setkStartColor(Color.WHITE);
		gradientPanel_1.kEndColor = Color.WHITE;
		gradientPanel_1.setkEndColor(Color.WHITE);
		gradientPanel_1.kBorderRadius = 40;
		gradientPanel_1.setkBorderRadius(40);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(null);
		GroupLayout gl_gradientPanel_1 = new GroupLayout(gradientPanel_1);
		gl_gradientPanel_1.setHorizontalGroup(
			gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 222, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_1.setVerticalGroup(
			gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_1.setLayout(gl_gradientPanel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		KGradientPanel gradientPanel_1_1 = new KGradientPanel();
		gradientPanel_1_1.setOpaque(false);
		gradientPanel_1_1.kStartColor = Color.WHITE;
		gradientPanel_1_1.setkStartColor(Color.WHITE);
		gradientPanel_1_1.kEndColor = Color.WHITE;
		gradientPanel_1_1.setkEndColor(Color.WHITE);
		gradientPanel_1_1.kBorderRadius = 40;
		gradientPanel_1_1.setkBorderRadius(40);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		GroupLayout gl_gradientPanel_1_1 = new GroupLayout(gradientPanel_1_1);
		gl_gradientPanel_1_1.setHorizontalGroup(
			gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 222, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_1_1.setVerticalGroup(
			gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_1_1.setLayout(gl_gradientPanel_1_1);
		
		KGradientPanel gradientPanel_1_2 = new KGradientPanel();
		gradientPanel_1_2.setOpaque(false);
		gradientPanel_1_2.kStartColor = Color.WHITE;
		gradientPanel_1_2.setkStartColor(Color.WHITE);
		gradientPanel_1_2.kEndColor = Color.WHITE;
		gradientPanel_1_2.setkEndColor(Color.WHITE);
		gradientPanel_1_2.kBorderRadius = 40;
		gradientPanel_1_2.setkBorderRadius(40);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		GroupLayout gl_gradientPanel_1_2 = new GroupLayout(gradientPanel_1_2);
		gl_gradientPanel_1_2.setHorizontalGroup(
			gl_gradientPanel_1_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 222, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_1_2.setVerticalGroup(
			gl_gradientPanel_1_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_1_2.setLayout(gl_gradientPanel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("User Name");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		KGradientPanel gradientPanel_1_1_1 = new KGradientPanel();
		gradientPanel_1_1_1.setOpaque(false);
		gradientPanel_1_1_1.kStartColor = Color.WHITE;
		gradientPanel_1_1_1.setkStartColor(Color.WHITE);
		gradientPanel_1_1_1.kEndColor = Color.WHITE;
		gradientPanel_1_1_1.setkEndColor(Color.WHITE);
		gradientPanel_1_1_1.kBorderRadius = 40;
		gradientPanel_1_1_1.setkBorderRadius(40);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		GroupLayout gl_gradientPanel_1_1_1 = new GroupLayout(gradientPanel_1_1_1);
		gl_gradientPanel_1_1_1.setHorizontalGroup(
			gl_gradientPanel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 222, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_1_1_1.setVerticalGroup(
			gl_gradientPanel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_1_1_1.setLayout(gl_gradientPanel_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_gradientPanel = new GroupLayout(gradientPanel);
		gl_gradientPanel.setHorizontalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_gradientPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gradientPanel_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_gradientPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradientPanel_1_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_gradientPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(gradientPanel_1_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_gradientPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(gradientPanel_1_1_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addGap(102)
					.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(95))
				.addGroup(Alignment.LEADING, gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel.setVerticalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(gradientPanel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(gradientPanel_1_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(gradientPanel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(gradientPanel_1_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gradientPanel.setLayout(gl_gradientPanel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(86)
							.addComponent(gradientPanel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(gradientPanel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setResizable(false);
		setVisible(true);

		addWindowListener(new login_register_window_listener());
		btnRegister.addActionListener(new register_controller(this));
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new login();
				dispose();
			}

		});
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}
}
