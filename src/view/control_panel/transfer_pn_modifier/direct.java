package view.control_panel.transfer_pn_modifier;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import DAO.Daodanhmuchi;
import controller.transfer_controller;
import controller.modifier_transfer_card_directly.insert_transaction_directly;
import modul.danhmucchi;
import view.view_ver2;

public class direct extends KGradientPanel{
    private JTextField spending_goals = new JTextField();
    private JTextField spending_range = new JTextField();
	private JTextField	money_receiver = new JTextField();
	private	JEditorPane reason = new JEditorPane();
	private	JEditorPane describe = new JEditorPane();
	private view_ver2 c;
	private	JComboBox<String> comboBox = new JComboBox<>();
	private final JButton btnNewButton = new JButton("");

    public String[] array_madanhmuc () {
        Daodanhmuchi daodanhmuchi = new Daodanhmuchi(this.c);
        ArrayList <danhmucchi> lst_madanhmuc = daodanhmuchi.show_value();
        String [] array_madanhmuc = new String[lst_madanhmuc.size()];

        for (int i = 0; i < lst_madanhmuc.size(); i++) {
            array_madanhmuc[i] = lst_madanhmuc.get(i).getMadanhmuc() + ": " + lst_madanhmuc.get(i).getTendanhmuc();
        }
        return array_madanhmuc;
    }
    
    public direct (view_ver2 c) {
		this.c = c;
		setkGradientFocus(700);
		setkStartColor(new Color(115, 200, 169));
		setkEndColor(new Color(55, 59, 68));
		setBackground(Color.LIGHT_GRAY);
		setkBorderRadius(100);
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setkStartColor(new Color(255, 255, 255));
		gradientPanel_3.setkEndColor(new Color(255, 255, 255));
		gradientPanel_3.setOpaque(false);
		gradientPanel_3.setkBorderRadius(50);
		
		JLabel lblNewLabel_5 = new JLabel("Name receiver");
		lblNewLabel_5.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 19));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		KGradientPanel gradientPanel_3_1 = new KGradientPanel();
		gradientPanel_3_1.setOpaque(false);
		gradientPanel_3_1.kStartColor = Color.WHITE;
		gradientPanel_3_1.setkStartColor(Color.WHITE);
		gradientPanel_3_1.kEndColor = Color.WHITE;
		gradientPanel_3_1.setkEndColor(Color.WHITE);
		gradientPanel_3_1.kBorderRadius = 50;
		gradientPanel_3_1.setkBorderRadius(50);
		
		spending_goals.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 16));
		spending_goals.setColumns(10);
		spending_goals.setBorder(new EmptyBorder(0, 0, 0, 0));
		GroupLayout gl_gradientPanel_3_1 = new GroupLayout(gradientPanel_3_1);
		gl_gradientPanel_3_1.setHorizontalGroup(
			gl_gradientPanel_3_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 446, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(spending_goals, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3_1.setVerticalGroup(
			gl_gradientPanel_3_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 54, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(spending_goals, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3_1.setLayout(gl_gradientPanel_3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Spending goals");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 19));
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Spending range");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 19));
		
		KGradientPanel gradientPanel_3_1_1 = new KGradientPanel();
		gradientPanel_3_1_1.setOpaque(false);
		gradientPanel_3_1_1.kStartColor = Color.WHITE;
		gradientPanel_3_1_1.setkStartColor(Color.WHITE);
		gradientPanel_3_1_1.kEndColor = Color.WHITE;
		gradientPanel_3_1_1.setkEndColor(Color.WHITE);
		gradientPanel_3_1_1.kBorderRadius = 50;
		gradientPanel_3_1_1.setkBorderRadius(50);
		
		spending_range.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 16));
		spending_range.setColumns(10);
		spending_range.setBorder(new EmptyBorder(0, 0, 0, 0));
		GroupLayout gl_gradientPanel_3_1_1 = new GroupLayout(gradientPanel_3_1_1);
		gl_gradientPanel_3_1_1.setHorizontalGroup(
			gl_gradientPanel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 446, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_3_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(spending_range, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3_1_1.setVerticalGroup(
			gl_gradientPanel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 54, Short.MAX_VALUE)
				.addGroup(gl_gradientPanel_3_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(spending_range, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3_1_1.setLayout(gl_gradientPanel_3_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Category");
		lblNewLabel_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 19));
		
		KGradientPanel gradientPanel_3_1_1_1 = new KGradientPanel();
		gradientPanel_3_1_1_1.setOpaque(false);
		gradientPanel_3_1_1_1.kStartColor = Color.WHITE;
		gradientPanel_3_1_1_1.setkStartColor(Color.WHITE);
		gradientPanel_3_1_1_1.kEndColor = Color.WHITE;
		gradientPanel_3_1_1_1.setkEndColor(Color.WHITE);
		gradientPanel_3_1_1_1.kBorderRadius = 50;
		gradientPanel_3_1_1_1.setkBorderRadius(50);
		
		comboBox.setLightWeightPopupEnabled(false);
		comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		comboBox.setOpaque(false);
		comboBox.setMaximumRowCount(100);
		GroupLayout gl_gradientPanel_3_1_1_1 = new GroupLayout(gradientPanel_3_1_1_1);
		gl_gradientPanel_3_1_1_1.setHorizontalGroup(
			gl_gradientPanel_3_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, 0, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3_1_1_1.setVerticalGroup(
			gl_gradientPanel_3_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3_1_1_1.setLayout(gl_gradientPanel_3_1_1_1);
		
		KGradientPanel gradientPanel_3_1_1_1_1 = new KGradientPanel();
		gradientPanel_3_1_1_1_1.setOpaque(false);
		gradientPanel_3_1_1_1_1.kStartColor = Color.WHITE;
		gradientPanel_3_1_1_1_1.setkStartColor(Color.WHITE);
		gradientPanel_3_1_1_1_1.kEndColor = Color.WHITE;
		gradientPanel_3_1_1_1_1.setkEndColor(Color.WHITE);
		gradientPanel_3_1_1_1_1.kBorderRadius = 50;
		gradientPanel_3_1_1_1_1.setkBorderRadius(50);
		
		reason.setFont(new Font("Monospaced", Font.PLAIN, 20));
		GroupLayout gl_gradientPanel_3_1_1_1_1 = new GroupLayout(gradientPanel_3_1_1_1_1);
		gl_gradientPanel_3_1_1_1_1.setHorizontalGroup(
			gl_gradientPanel_3_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(reason, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3_1_1_1_1.setVerticalGroup(
			gl_gradientPanel_3_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(reason, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3_1_1_1_1.setLayout(gl_gradientPanel_3_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Reason");
		lblNewLabel_5_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 19));
		
		KGradientPanel gradientPanel_3_1_1_1_1_1 = new KGradientPanel();
		gradientPanel_3_1_1_1_1_1.setOpaque(false);
		gradientPanel_3_1_1_1_1_1.kStartColor = Color.WHITE;
		gradientPanel_3_1_1_1_1_1.setkStartColor(Color.WHITE);
		gradientPanel_3_1_1_1_1_1.kEndColor = Color.WHITE;
		gradientPanel_3_1_1_1_1_1.setkEndColor(Color.WHITE);
		gradientPanel_3_1_1_1_1_1.kBorderRadius = 50;
		gradientPanel_3_1_1_1_1_1.setkBorderRadius(50);
		
		describe.setFont(new Font("Monospaced", Font.PLAIN, 20));
		GroupLayout gl_gradientPanel_3_1_1_1_1_1 = new GroupLayout(gradientPanel_3_1_1_1_1_1);
		gl_gradientPanel_3_1_1_1_1_1.setHorizontalGroup(
			gl_gradientPanel_3_1_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1_1_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(describe, GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3_1_1_1_1_1.setVerticalGroup(
			gl_gradientPanel_3_1_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3_1_1_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(describe, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel_3_1_1_1_1_1.setLayout(gl_gradientPanel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1_1 = new JLabel("Describe");
		lblNewLabel_5_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1_1_1.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 19));
		
		KButton btnAccept = new KButton();
		btnAccept.setkHoverStartColor(new Color(254, 214, 227));
		btnAccept.setBorderPainted(false);
		btnAccept.setkEndColor(new Color(55, 59, 68));
		btnAccept.setkHoverEndColor(new Color(168, 237, 234));
		btnAccept.setFont(new Font("JetBrains Mono", Font.PLAIN, 40));
		btnAccept.setText("Accept");
		btnAccept.setOpaque(false);
		btnAccept.setFocusPainted(false);
		btnAccept.setContentAreaFilled(false);
		btnAccept.setkBorderRadius(60);
		btnNewButton.setOpaque(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(direct.class.getResource("/view/resource/left.png")));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(gradientPanel_3_1, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5_1_1_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(gradientPanel_3_1_1_1, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5_1_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(gradientPanel_3_1_1, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5_1_1_1_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradientPanel_3_1_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradientPanel_3_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addComponent(btnAccept, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
					.addGap(31))
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(798, Short.MAX_VALUE))
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_gradientPanel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(gradientPanel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
							.addGap(26)
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradientPanel_3_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradientPanel_3_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5_1_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradientPanel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(gradientPanel_3_1_1_1_1, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5_1_1_1_1, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
							.addGap(28)
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradientPanel_3_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAccept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		money_receiver.setFont(new Font("JetBrains Mono NL", Font.PLAIN, 16));
		money_receiver.setBorder(new EmptyBorder(0, 0, 0, 0));
		money_receiver.setColumns(10);
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(money_receiver, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(money_receiver, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);

		comboBox.setModel(new DefaultComboBoxModel<String>(array_madanhmuc()));
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		setLayout(gl_gradientPanel_2);

		btnAccept.addActionListener(new insert_transaction_directly(this, this.c));	
		btnNewButton_1.addActionListener(new transfer_controller(this.c));
    }

	public view_ver2 getC() {
		return c;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JTextField getSpending_goals() {
		return spending_goals;
	}

	public JTextField getSpending_range() {
		return spending_range;
	}

	public JTextField getMoney_receiver() {
		return money_receiver;
	}

	public JEditorPane getReason() {
		return reason;
	}

	public JEditorPane getDescribe() {
		return describe;
	}
}
