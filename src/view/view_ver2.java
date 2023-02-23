package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import DAO.Daouser;
import controller.account_controller;
import controller.category_controller;
import controller.chart_controller;
import controller.join_transaction_controller;
import controller.limit_controller;
import controller.overview_controller;
import controller.refresh_btn;
import controller.request_mn_controller;
import controller.transfer_controller;
import controller.window_listener;
import modul.user;
import view.control_panel.account_pn;
import view.control_panel.category_pn;
import view.control_panel.chart_pn;
import view.control_panel.join_transaction;
import view.control_panel.limit_pn;
import view.control_panel.overview_pn;
import view.control_panel.request_money;
import view.control_panel.transfer_pn;
import view.control_panel.welcome_pn;
import view.control_panel.account_pn_modifier.reset_pass;
import view.control_panel.transfer_pn_modifier.card;
import view.control_panel.transfer_pn_modifier.direct;


public class view_ver2 extends JFrame{

	private JFrame frame;
	private JTable table;
	private	JPanel panel_control = new JPanel();
	private String [][] temp ;
	private	JPanel panel_6 = new JPanel();
	private String email;
	private JPanel contentPane;
	private	JLabel wallet_label = new JLabel("0");
	private	JLabel avg_money = new JLabel("0");
	private	JLabel limit_label = new JLabel("0");
	private	JLabel label_welcome = new JLabel();
	private String pass;
	private	JLabel limit_label_1 = new JLabel("0");


	/**
	 * Create the application.
	 */
	public view_ver2(String email) {
		this.email = email;
		initialize();
	}

	public void add_row_table (Object[][] array_row) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.addRow(array_row);
	}

	public void remove_row_table () {
        DefaultTableModel dtm = (DefaultTableModel)  table.getModel();
		dtm.removeRow(table.getRowCount() - 1);
	}


	// add pn
	public void add_pn_category () {
		category_pn category_pn = new category_pn(this);
		panel_control.add(category_pn, "category");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "category");
		panel_control.validate();
	}

	public void add_pn_reset_pass () {
		reset_pass reset_pass = new reset_pass(this, this.pass);
		panel_control.add(reset_pass, "reset");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "reset");
		panel_control.validate();
	}

	public void add_pn_join_transaction () {
		join_transaction join_transaction = new join_transaction(this);
		panel_control.add(join_transaction, "join");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "join");
		panel_control.validate();
	}

	public void add_pn_request_mn () {
		request_money request_money = new request_money(this);
		panel_control.add(request_money, "request");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "request");
		panel_control.validate();
	}

	public void add_pn_limit () {
		limit_pn limit_pn = new limit_pn(this);
		panel_control.add(limit_pn, "limit");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "limit");
		panel_control.validate();
	}

	public void add_pn_modifier_direct () {
		direct direct = new direct(this);
		panel_control.add(direct, "direct");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "direct");
		panel_control.validate();
	}

	public void add_pn_modifier_card () {
		card card = new card(this);
		panel_control.add(card, "card");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "card");
		panel_control.validate();
	}

	public void add_pn_transfer () {
		transfer_pn transfer_pn = new transfer_pn(this);
		panel_control.add(transfer_pn, "transfer");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "transfer");
		panel_control.validate();
	}

	public void add_pn_welcome () {
		System.out.println(getEmail());
		welcome_pn welcome_pn = new welcome_pn(this);
		panel_control.add(welcome_pn, "welcome");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "welcome");
		panel_control.validate();
	}

	public void add_pn_accout () {
		Daouser user = new Daouser();
		ArrayList<user> lst_user = user.account(this.getEmail());
		user user_ = lst_user.get(0);
		account_pn account = new account_pn(this);

		account.getLblNewLabel_6().setText("User Name: " + user_.getUser_name());
		account.getLblNewLabel_6_1().setText("Email: " + user_.getEmail());
		account.getLblNewLabel_6_2().setText("Password: " + user_.getPassword());
		this.pass = user_.getPassword();

		panel_control.add(account, "account");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "account");
		panel_control.validate();
	}

	public void add_pn_chart () {
		chart_pn chart_pn = new chart_pn(this);
		panel_control.add(chart_pn, "chart");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "chart");
		panel_control.validate();
	}

	public void add_pn_overview () {
		overview_pn overview_pn = new overview_pn(this);
		panel_control.add(overview_pn, "overview");
		CardLayout c = (CardLayout) panel_control.getLayout();
		c.show(panel_control, "overview");
		panel_control.validate();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 828);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkBorderRadius(70);
		gradientPanel.setkStartColor(new Color(0, 198, 255));
		gradientPanel.setkEndColor(new Color(238, 156, 167));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(gradientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(gradientPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 768, Short.MAX_VALUE))
					.addGap(0))
		);
		
		JButton overview_btn = new JButton("Overview");
		overview_btn.setFocusPainted(false);
		overview_btn.setSelected(true);
		overview_btn.setBorderPainted(false);
		overview_btn.setContentAreaFilled(false);
		overview_btn.setOpaque(false);

		overview_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-financial-growth-analysis-40.png")));
		overview_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		
		JButton account_btn = new JButton("My account");
		account_btn.setFocusPainted(false);
		account_btn.setBorderPainted(false);
		account_btn.setOpaque(false);
		account_btn.setContentAreaFilled(false);
		account_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-user-settings-50.png")));
		account_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		
		JButton chart_btn = new JButton("Chart");
		chart_btn.setBorderPainted(false);
		chart_btn.setContentAreaFilled(false);
		chart_btn.setOpaque(false);
		chart_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-edit-pie-chart-report-50.png")));
		chart_btn.setFocusPainted(false);
		chart_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		
		JButton limit_btn = new JButton("Spending limit");
		limit_btn.setBorderPainted(false);
		limit_btn.setOpaque(false);
		limit_btn.setContentAreaFilled(false);
		limit_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-withdrawal-limit-50.png")));
		limit_btn.setFocusPainted(false);
		limit_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		
		JButton request_btn = new JButton("Request money");

		request_btn.setOpaque(false);
		request_btn.setContentAreaFilled(false);
		request_btn.setBorderPainted(false);
		request_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-request-money-50.png")));
		request_btn.setFocusPainted(false);
		request_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		
		JButton transfer_btn = new JButton("Money transfer");
		transfer_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-money-transfer-50.png")));
		transfer_btn.setContentAreaFilled(false);
		transfer_btn.setBorderPainted(false);
		transfer_btn.setOpaque(false);
		transfer_btn.setFocusPainted(false);
		transfer_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		
		JButton join_transaction_btn = new JButton("Join transaction");
		join_transaction_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-query-inner-join-right-50.png")));
		join_transaction_btn.setOpaque(false);
		join_transaction_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		join_transaction_btn.setFocusPainted(false);
		join_transaction_btn.setContentAreaFilled(false);
		join_transaction_btn.setBorderPainted(false);
		
		JButton category_btn = new JButton("Category");
		category_btn.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/icons8-repository-50.png")));
		category_btn.setOpaque(false);
		category_btn.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 17));
		category_btn.setFocusPainted(false);
		category_btn.setContentAreaFilled(false);
		category_btn.setBorderPainted(false);
		GroupLayout gl_gradientPanel = new GroupLayout(gradientPanel);
		gl_gradientPanel.setHorizontalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(join_transaction_btn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(account_btn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(overview_btn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(request_btn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(transfer_btn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(limit_btn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(chart_btn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(category_btn, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_gradientPanel.setVerticalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addGap(13)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(overview_btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(account_btn, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(chart_btn, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(limit_btn, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(request_btn, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(transfer_btn, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(join_transaction_btn, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(category_btn, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
					.addGap(62))
		);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(view_ver2.class.getResource("/view/resource/Untitled_design-removebg-preview.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 95, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		gradientPanel.setLayout(gl_gradientPanel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setOpaque(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel_control.setBackground(new Color(192, 192, 192));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_control, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_control, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
		);
		// -----------------------------------------------------
		panel_control.setLayout(new CardLayout(0, 0));
		
		
		
		add_pn_welcome();
		
		

		panel_4.setLayout(gl_panel_4);
		// -----------------------------------------------------
		
		KGradientPanel gradientPanel_1 = new KGradientPanel();
		gradientPanel_1.setkGradientFocus(100);
		gradientPanel_1.setkStartColor(new Color(17, 255, 189));
		gradientPanel_1.setkEndColor(new Color(170, 255, 169));
		gradientPanel_1.setBackground(Color.LIGHT_GRAY);
		gradientPanel_1.setForeground(Color.WHITE);
		gradientPanel_1.kBorderRadius = 24;
		gradientPanel_1.setkBorderRadius(35);
		
		KGradientPanel gradientPanel_1_1 = new KGradientPanel();
		gradientPanel_1_1.setkGradientFocus(300);
		gradientPanel_1_1.setkStartColor(new Color(187, 55, 125));
		gradientPanel_1_1.setkEndColor(new Color(251, 211, 233));
		gradientPanel_1_1.setBackground(Color.LIGHT_GRAY);
		gradientPanel_1_1.kBorderRadius = 24;
		gradientPanel_1_1.setkBorderRadius(24);
		
		KGradientPanel gradientPanel_1_2 = new KGradientPanel();
		gradientPanel_1_2.setkGradientFocus(400);
		gradientPanel_1_2.setkStartColor(new Color(255, 175, 189));
		gradientPanel_1_2.setkEndColor(new Color(201, 255, 191));
		gradientPanel_1_2.setBackground(Color.LIGHT_GRAY);
		gradientPanel_1_2.kBorderRadius = 24;
		gradientPanel_1_2.setkBorderRadius(24);
		
		KButton refresh_btn = new KButton();
		refresh_btn.setkForeGround(new Color(255, 255, 255));
		refresh_btn.setkHoverForeGround(new Color(255, 255, 255));
		refresh_btn.setkHoverStartColor(new Color(254, 214, 227));
		refresh_btn.setkHoverEndColor(new Color(168, 237, 234));
		refresh_btn.setkEndColor(new Color(94, 231, 223));
		refresh_btn.setkBackGroundColor(new Color(180, 144, 202));
		refresh_btn.setFont(new Font("JetBrains Mono", Font.PLAIN, 31));
		refresh_btn.setText("Refresh");
		refresh_btn.setVerticalAlignment(SwingConstants.BOTTOM);
		refresh_btn.setFocusPainted(false);
		refresh_btn.setBorderPainted(false);
		refresh_btn.setBackground(Color.LIGHT_GRAY);
		refresh_btn.setkBorderRadius(40);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(refresh_btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(gradientPanel_1, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(gradientPanel_1_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(gradientPanel_1_2, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
					.addGap(23))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(gradientPanel_1_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(gradientPanel_1_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(gradientPanel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh_btn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		limit_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		limit_label.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		limit_label.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4_2 = new JLabel("Limit");
		lblNewLabel_4_2.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 17));
		
		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("JetBrains Mono", Font.PLAIN, 44));
		limit_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		limit_label_1.setForeground(Color.WHITE);
		limit_label_1.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		GroupLayout gl_gradientPanel_1_2 = new GroupLayout(gradientPanel_1_2);
		gl_gradientPanel_1_2.setHorizontalGroup(
			gl_gradientPanel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_1_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_1_2.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(limit_label_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(limit_label, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
						.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_gradientPanel_1_2.setVerticalGroup(
			gl_gradientPanel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_1_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_1_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(limit_label_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addComponent(limit_label, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4_2)
					.addGap(13))
		);
		gradientPanel_1_2.setLayout(gl_gradientPanel_1_2);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		
		wallet_label.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		wallet_label.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Wallet");
		lblNewLabel_4.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 17));
		GroupLayout gl_gradientPanel_1 = new GroupLayout(gradientPanel_1);
		gl_gradientPanel_1.setHorizontalGroup(
			gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_1.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wallet_label, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
						.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_gradientPanel_1.setVerticalGroup(
			gl_gradientPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_gradientPanel_1.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(38))
						.addGroup(gl_gradientPanel_1.createSequentialGroup()
							.addComponent(wallet_label, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addGap(6)))
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(29))
		);
		gradientPanel_1.setLayout(gl_gradientPanel_1);
		
		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		
		avg_money.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 44));
		avg_money.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4_1 = new JLabel("AVG Money/Day");
		lblNewLabel_4_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 17));
		GroupLayout gl_gradientPanel_1_1 = new GroupLayout(gradientPanel_1_1);
		gl_gradientPanel_1_1.setHorizontalGroup(
			gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(avg_money, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_gradientPanel_1_1.setVerticalGroup(
			gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(avg_money, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4_1)
					.addContainerGap(13, Short.MAX_VALUE))
		);

		addWindowListener(new window_listener(this));
		gradientPanel_1_1.setLayout(gl_gradientPanel_1_1);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);



		// actionlistener
		overview_btn.addActionListener(new overview_controller(this));
		chart_btn.addActionListener(new chart_controller(this));
		account_btn.addActionListener(new account_controller(this));
		transfer_btn.addActionListener(new transfer_controller(this));
		limit_btn.addActionListener(new limit_controller(this));
		request_btn.addActionListener(new request_mn_controller(this));
		join_transaction_btn.addActionListener(new join_transaction_controller(this));
		category_btn.addActionListener(new category_controller(this));
		refresh_btn.addActionListener(new refresh_btn(this));

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JPanel getPanel_6() {
		return panel_6;
	}

	public String[][] getTemp() {
		return temp;
	}

	public JPanel getPanel_control() {
		return panel_control;
	}

    public JLabel getLimit_label() {
        return limit_label;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JLabel getLblNewLabel_3() {
        return wallet_label;
    }


	public JLabel getLabel_welcome() {
		return label_welcome;
	}

	public String getEmail() {
		return email;
	}

    public JLabel getWallet_label() {
        return wallet_label;
    }

    public JLabel getAvg_money() {
        return avg_money;
    }

    public String getPass() {
        return pass;
    }

    public JLabel getLimit_label_1() {
        return limit_label_1;
    }
	
}
