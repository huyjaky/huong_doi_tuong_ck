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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.k33ptoo.components.KGradientPanel;

import controller.modifier_overview.category;
import controller.modifier_overview.key_listener_filter;
import controller.modifier_overview.request_mn;
import controller.modifier_overview.transaction;
import controller.modifier_overview.transfer;
import view.view_ver2;

public class overview_pn extends JPanel{

	private	JPanel panel_6 = new JPanel();
    private view_ver2 c;
    private JTable table;
    private String [][] temp ;
    private JTextField textField;
    
	public void refresh() {
		panel_6.removeAll();
		panel_6.revalidate();
	}

	// filter 

	public void filter (String query) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
		table.setRowSorter(trs);

		trs.setRowFilter(RowFilter.regexFilter(query));
	}

	// add table
	public void add_table_transfer () {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_6.add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			temp,
			new String[] {
				"nguoinhan", "khoanggui"
			}
		));
		table.setAutoCreateRowSorter(true);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.white);
		table.setEnabled(false);
	}


	public void add_table_giaodich () {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_6.add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			temp,
			new String[] {
				"Date", "Trading code", "Reason", "Spending goals", "Catalog code", "Approx", "Describe", "Method", "Recipient", "Sender"
			}
		));
		table.setAutoCreateRowSorter(true);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.white);
		table.setEnabled(false);
	}

	public void add_table_request_money () {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			temp
			,
			new String[] {
				"Date", "Approx", "Method", "Sender"
			}
		));
		table.setAutoCreateRowSorter(true);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.white);
		table.setEnabled(false);
	}

	public void add_table_danhmucchi () {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			temp
			,
			new String[] {
				"Category code", "Name list"
			}
		));
		table.setAutoCreateRowSorter(true);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.white);
		table.setEnabled(false);
	}

	public void add_table_user () {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			temp
			,
			new String[] {
				"User_name", "Password"
			}
		));
		table.setAutoCreateRowSorter(true);

		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.white);
		table.setEnabled(false);
	}

    public overview_pn (view_ver2 c) {
        this.c = c;
    	setOpaque(false);
		KGradientPanel gradientPanel_2 = new KGradientPanel();
		gradientPanel_2.kStartColor = new Color(255, 107, 107);
		gradientPanel_2.setkStartColor(new Color(255, 107, 107));
		gradientPanel_2.kEndColor = new Color(85, 98, 112);
		gradientPanel_2.setkEndColor(new Color(85, 98, 112));
		gradientPanel_2.kBorderRadius = 100;
		gradientPanel_2.setkBorderRadius(100);
		gradientPanel_2.setBackground(Color.LIGHT_GRAY);
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setkStartColor(new Color(255, 255, 255));
		gradientPanel_3.setkEndColor(new Color(255, 255, 255));
		gradientPanel_3.setBackground(new Color(192, 192, 192));
		gradientPanel_3.setkBorderRadius(100);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setBackground(Color.LIGHT_GRAY);
		gradientPanel.setkStartColor(Color.WHITE);
		gradientPanel.setkEndColor(Color.WHITE);
		gradientPanel.setOpaque(false);
		gradientPanel.setkBorderRadius(60);
		
		GroupLayout gl_overview_panel = new GroupLayout(this);
		gl_overview_panel.setHorizontalGroup(
			gl_overview_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_overview_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_overview_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(gradientPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addComponent(gradientPanel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addComponent(gradientPanel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_overview_panel.setVerticalGroup(
			gl_overview_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_overview_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(gradientPanel_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gradientPanel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_gradientPanel = new GroupLayout(gradientPanel);
		gl_gradientPanel.setHorizontalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
					.addGap(26))
		);
		gl_gradientPanel.setVerticalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap())
		);
		gradientPanel.setLayout(gl_gradientPanel);
		panel_6.setBackground(Color.WHITE);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addGap(32)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
					.addGap(41))
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("No Action");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel);
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		gradientPanel_2.setLayout(new GridLayout(1, 6, 20, 20));
		
		JPanel panel_option1 = new JPanel();
		panel_option1.setBackground(new Color(240, 240, 240));
		panel_option1.setOpaque(false);
		gradientPanel_2.add(panel_option1);
		panel_option1.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton Category_btn = new JButton("");
		Category_btn.setBorderPainted(false);
		Category_btn.setIcon(new ImageIcon(overview_pn.class.getResource("/view/resource/icons8-sorting-50.png")));
		Category_btn.setFocusPainted(false);
		Category_btn.setOpaque(false);
		Category_btn.setContentAreaFilled(false);
		panel_option1.add(Category_btn);
		
		JPanel panel_option2 = new JPanel();
		panel_option2.setOpaque(false);
		gradientPanel_2.add(panel_option2);
		panel_option2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton Transaction_btn = new JButton("");
		Transaction_btn.setBorderPainted(false);
		Transaction_btn.setIcon(new ImageIcon(overview_pn.class.getResource("/view/resource/icons8-payment-history-60.png")));
		Transaction_btn.setFocusPainted(false);
		Transaction_btn.setContentAreaFilled(false);
		panel_option2.add(Transaction_btn);
		
		JPanel panel_option3 = new JPanel();
		panel_option3.setOpaque(false);
		gradientPanel_2.add(panel_option3);
		panel_option3.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton recharge_btn = new JButton("");
		recharge_btn.setBorderPainted(false);
		recharge_btn.setIcon(new ImageIcon(overview_pn.class.getResource("/view/resource/icons8-low-price-60.png")));
		recharge_btn.setFocusPainted(false);
		recharge_btn.setContentAreaFilled(false);
		panel_option3.add(recharge_btn);
		
		JPanel panel_option4 = new JPanel();
		panel_option4.setOpaque(false);
		gradientPanel_2.add(panel_option4);
		panel_option4.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton transfer_btn = new JButton("");
		transfer_btn.setBorderPainted(false);
		transfer_btn.setIcon(new ImageIcon(overview_pn.class.getResource("/view/resource/icons8-low-price-60 - Copy.png")));
		transfer_btn.setFocusPainted(false);
		transfer_btn.setContentAreaFilled(false);
		panel_option4.add(transfer_btn);
		this.setLayout(gl_overview_panel);

		// overview
		Category_btn.addActionListener(new category(this.c, this));
		Transaction_btn.addActionListener(new transaction(this.c, this));
		transfer_btn.addActionListener(new transfer(this.c, this));
		recharge_btn.addActionListener(new request_mn(this.c, this));
		textField.addKeyListener(new key_listener_filter(this));
    }

    public JPanel getPanel_6() {
        return panel_6;
    }

    public void setPanel_6(JPanel panel_6) {
        this.panel_6 = panel_6;
    }

    public view_ver2 getC() {
        return c;
    }

    public void setC(view_ver2 c) {
        this.c = c;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public String[][] getTemp() {
        return temp;
    }

    public void setTemp(String[][] temp) {
        this.temp = temp;
    }

	public JTextField getTextField() {
		return textField;
	}
}
