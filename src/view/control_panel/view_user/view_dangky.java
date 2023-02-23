package view.control_panel.view_user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.Daouser;
import modul.user;
import view.view_ver2;
import javax.swing.ImageIcon;


public class view_dangky extends JFrame {

	private JPanel contentPane;
	private JTextField tetxt_name;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField text_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_dangky frame = new view_dangky();
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
	public view_dangky() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 300, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_login = new JLabel("REGISTER", SwingConstants.CENTER);
		label_login.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_login.setBounds(10, 11, 405, 33);
		panel.add(label_login);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 55, 405, 13);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 127, 117, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(10, 181, 117, 27);
		panel.add(lblNewLabel_1_1);
		
		tetxt_name = new JTextField();
		tetxt_name.setColumns(10);
		tetxt_name.setBounds(126, 127, 220, 27);
		panel.add(tetxt_name);
		
		password1 = new JPasswordField();
		password1.setBounds(126, 181, 220, 27);
		panel.add(password1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 273, 405, 13);
		panel.add(separator_1);
		
		JButton register_button = new JButton("Register");
		register_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		register_button.setBounds(151, 286, 131, 43);
		panel.add(register_button);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_1_1.setBounds(10, 235, 117, 27);
		panel.add(lblNewLabel_1_1_1);
		
		password2 = new JPasswordField();
		password2.setBounds(126, 235, 220, 27);
		panel.add(password2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1_2.setBounds(10, 79, 117, 27);
		panel.add(lblNewLabel_1_2);
		
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(126, 79, 220, 27);
		panel.add(text_email);

		JButton login_button = new JButton("< Login");
		login_button.setBounds(10, 11, 102, 27);
		panel.add(login_button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(view_dangky.class.getResource("/view/resource/user.png")));
		lblNewLabel.setBounds(368, 79, 46, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(view_dangky.class.getResource("/view/resource/lock.png")));
		lblNewLabel_2.setBounds(369, 181, 46, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(view_dangky.class.getResource("/view/resource/lock.png")));
		lblNewLabel_2_1.setBounds(369, 235, 46, 27);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(view_dangky.class.getResource("/view/resource/address-book.png")));
		lblNewLabel_2_1_1.setBounds(369, 127, 46, 27);
		panel.add(lblNewLabel_2_1_1);

		register_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Daouser user = new Daouser();

				String pass = new String(password1.getPassword());
				Pattern regex_email = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
				Pattern regex_pass = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})");

				String email = text_email.getText();
				if (regex_email.matcher(email).find() == false) {
					JOptionPane.showConfirmDialog(null, "nhap sai dinh dang email!", "error", JOptionPane.OK_OPTION);
					return;
				}

				if (user.check_exist(email).size() != 0) {
					JOptionPane.showConfirmDialog(null, "email da ton tai!", "error", JOptionPane.OK_OPTION);
					return;
				}

				if (regex_pass.matcher(pass).find() == false) {
					JOptionPane.showConfirmDialog(null, "nhap mat khau khong trung khop!", "error", JOptionPane.OK_OPTION);
					return;
				}

				String re_enter_pass = new String(password2.getPassword());
				if (regex_pass.matcher(re_enter_pass).find() == false) {
					JOptionPane.showConfirmDialog(null, "mat khau phai chua it nhat mot chu hoa, 6 chu thuong va mot ky tu dac biet", "error", JOptionPane.OK_OPTION);
					return;
				}

				if (!pass.equals(re_enter_pass)) {
					JOptionPane.showConfirmDialog(null, "nhap mat khau khong trung khop!", "error", JOptionPane.OK_OPTION);
					return;
				}

				try {
					user user_o = new user(email, tetxt_name.getText(), re_enter_pass);
					user.insert(user_o);
				} catch (Exception a) {
					// TODO: handle exception
					a.printStackTrace();
					return;
				}
				new view_ver2(email);
				dispose();
			}
		});

		login_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new view_dangnhap();
				dispose();
			}

		});

		setResizable(false);
		setVisible(true);
	}
}
