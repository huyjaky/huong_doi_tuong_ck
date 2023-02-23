package view.control_panel.view_user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.Daouser;
import modul.user;
import view.view_ver2;

public class view_dangnhap extends JFrame {

	private JPanel contentPane;
	private JTextField text_email;
	private JPasswordField text_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_dangnhap frame = new view_dangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_dangnhap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 400, 451, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_login = new JLabel("LOGIN", JLabel.CENTER);
		label_login.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_login.setBounds(10, 11, 405, 33);
		panel.add(label_login);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 405, 13);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 85, 117, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(10, 139, 117, 27);
		panel.add(lblNewLabel_1_1);
		
		text_email = new JTextField();
		text_email.setBounds(126, 85, 220, 27);
		panel.add(text_email);
		text_email.setColumns(10);
		
		text_pass = new JPasswordField();
		text_pass.setBounds(126, 139, 220, 27);
		panel.add(text_pass);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 190, 405, 13);
		panel.add(separator_1);
		
		JButton login_button = new JButton("Login");
		login_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_button.setBounds(149, 202, 131, 43);
		panel.add(login_button);
		
		JButton register_button = new JButton("Register >");
		register_button.setBounds(302, 11, 102, 27);
		panel.add(register_button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(view_dangnhap.class.getResource("/view/resource/user.png")));
		lblNewLabel.setBounds(369, 79, 46, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(view_dangnhap.class.getResource("/view/resource/lock.png")));
		lblNewLabel_2.setBounds(369, 139, 46, 27);
		panel.add(lblNewLabel_2);

		
		login_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Daouser user = new Daouser();

				Pattern regex_email = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
				Pattern regex_pass = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})");

				String email = text_email.getText();
				String pass = new String(text_pass.getPassword());

				if (regex_email.matcher(email).find() == false || regex_pass.matcher(pass).find() == false) {
					JOptionPane.showConfirmDialog(null, "Nhap sai email hoac mat khau xin moi nhap lai!", "error", JOptionPane.OK_OPTION);
					return;
				} 
				try {
					user nguoidung = user.login(email, pass).get(0);
					if (nguoidung != null && nguoidung.getPassword().equals(pass)) {
						new view_ver2(email);
						dispose();
					} else {
						JOptionPane.showConfirmDialog(null, "Nhap sai email hoac mat khau xin moi nhap lai!", "error", JOptionPane.OK_OPTION);
						return;
					}
				} catch (Exception a) {
					// TODO: handle exception
					JOptionPane.showConfirmDialog(null, "Nhap sai email hoac mat khau xin moi nhap lai!", "error", JOptionPane.OK_OPTION);
					return;
				}

				
			}
		});

		register_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new view_dangky();
				dispose();
			}
		});
		this.setVisible(true);
		this.setResizable(false);
	}
}
