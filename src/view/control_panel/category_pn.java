package view.control_panel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import DAO.Daodanhmuchi;
import controller.modifier_category.insert;
import controller.modifier_category.remove;
import controller.modifier_category.search;
import modul.danhmucchi;
import view.view_ver2;
import java.awt.GridLayout;

public class category_pn extends KGradientPanel{
    private view_ver2 c;
	private JTable table_1 = new JTable();
	private JTextField textField = new JTextField();
    private String[][] array_category;
    private JTextField name_tag;
	private	JScrollPane scrollPane = new JScrollPane();
    private String[][] temp;
	private	JPanel panel_5 = new JPanel();

    public String [][] array_category () {
        Daodanhmuchi daodanhmuchi = new Daodanhmuchi(this.c);
        ArrayList <danhmucchi> lst_danhmuc = daodanhmuchi.show_value();

        this.array_category = new String[lst_danhmuc.size()][2];

        for (int i = 0; i < lst_danhmuc.size(); i++) {
            array_category[i][0] = lst_danhmuc.get(i).getMadanhmuc();
            array_category[i][1] = lst_danhmuc.get(i).getTendanhmuc();
        }
        return this.array_category;
    }

    public void refresh () {
        panel_5.removeAll();
        panel_5.revalidate();
    }

    public void add_table () {
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table_1.setModel(new DefaultTableModel(
			temp
            ,
			new String[] {
				"madanhmuc", "tendanhmuc"
			}
		));

        panel_5.add(scrollPane);
        table_1.setDefaultEditor(Object.class, null);
        table_1.setAutoCreateRowSorter(true);
		scrollPane.getViewport().setOpaque(false);
		table_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		table_1.setOpaque(false);
		table_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(table_1);
    }

    public category_pn (view_ver2 c) {
        this.c = c;
		setkStartColor(new Color(0, 0, 70));
		setkEndColor(new Color(28, 181, 224));
		setBackground(Color.lightGray);
		setkBorderRadius(100);
		
		KGradientPanel gradientPanel_3 = new KGradientPanel();
		gradientPanel_3.setkStartColor(new Color(255, 255, 255));
		gradientPanel_3.setkEndColor(new Color(255, 255, 255));
		gradientPanel_3.setOpaque(false);
		gradientPanel_3.setkBorderRadius(60);
		
		KButton btnInsert = new KButton();
		btnInsert.setBorderPainted(false);
		btnInsert.setkHoverForeGround(Color.WHITE);
		btnInsert.setkHoverStartColor(new Color(15, 32, 39));
		btnInsert.setkHoverEndColor(new Color(44, 83, 100));
		btnInsert.kEndColor = new Color(247, 121, 125);
		btnInsert.setkEndColor(new Color(247, 121, 125));
		btnInsert.kBackGroundColor = new Color(251, 215, 134);
		btnInsert.setkBackGroundColor(new Color(198, 255, 221));
		btnInsert.setFont(new Font("JetBrains Mono", Font.PLAIN, 40));
		btnInsert.setText("Insert");
		btnInsert.setFocusPainted(false);
		btnInsert.setContentAreaFilled(false);
		btnInsert.setkBorderRadius(50);
		
		KButton btnRemove = new KButton();
		btnRemove.setBorderPainted(false);
		btnRemove.setkHoverForeGround(new Color(255, 255, 255));
		btnRemove.setkHoverStartColor(new Color(15, 32, 39));
		btnRemove.setkHoverEndColor(new Color(44, 83, 100));
		btnRemove.setkEndColor(new Color(247, 121, 125));
		btnRemove.setkBackGroundColor(new Color(198, 255, 221));
		btnRemove.setFont(new Font("JetBrains Mono", Font.PLAIN, 40));
		btnRemove.setText("Remove");
		btnRemove.setFocusPainted(false);
		btnRemove.setContentAreaFilled(false);
		btnRemove.setkBorderRadius(50);
		
		KGradientPanel gradientPanel_4 = new KGradientPanel();
		gradientPanel_4.setkStartColor(new Color(187, 55, 125));
		gradientPanel_4.setkEndColor(new Color(251, 211, 233));
		gradientPanel_4.setOpaque(false);
		gradientPanel_4.setkBorderRadius(100);
		
		KGradientPanel gradientPanel_5 = new KGradientPanel();
		gradientPanel_5.setkStartColor(Color.WHITE);
		gradientPanel_5.setkEndColor(new Color(255, 255, 255));
		gradientPanel_5.setOpaque(false);
		gradientPanel_5.setkBorderRadius(100);
		GroupLayout gl_gradientPanel_2 = new GroupLayout(this);
		gl_gradientPanel_2.setHorizontalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(gradientPanel_3, GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradientPanel_4, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(gradientPanel_5, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_gradientPanel_2.setVerticalGroup(
			gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_2.createSequentialGroup()
					.addGap(32)
					.addComponent(gradientPanel_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_gradientPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(gradientPanel_4, 0, 0, Short.MAX_VALUE)
							.addGap(70))
						.addGroup(gl_gradientPanel_2.createSequentialGroup()
							.addComponent(gradientPanel_5, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
							.addGap(39))))
		);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("Name tag");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkStartColor(Color.WHITE);
		gradientPanel.setkEndColor(Color.WHITE);
		gradientPanel.setOpaque(false);
		gradientPanel.setkBorderRadius(50);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(gradientPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(gradientPanel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		
		name_tag = new JTextField();
		name_tag.setBorder(new EmptyBorder(0, 0, 0, 0));
		name_tag.setColumns(10);
		GroupLayout gl_gradientPanel = new GroupLayout(gradientPanel);
		gl_gradientPanel.setHorizontalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(name_tag, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel.setVerticalGroup(
			gl_gradientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_gradientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(name_tag, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		gradientPanel.setLayout(gl_gradientPanel);
		panel_7.setLayout(gl_panel_7);
		GroupLayout gl_gradientPanel_4 = new GroupLayout(gradientPanel_4);
		gl_gradientPanel_4.setHorizontalGroup(
			gl_gradientPanel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradientPanel_4.setVerticalGroup(
			gl_gradientPanel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(27))
		);

        temp = array_category();
        add_table();

		gradientPanel_4.setLayout(gl_gradientPanel_4);
		
		panel_5.setBorder(null);
		panel_5.setOpaque(false);
		panel_5.setBackground(Color.WHITE);
		GroupLayout gl_gradientPanel_5 = new GroupLayout(gradientPanel_5);
		gl_gradientPanel_5.setHorizontalGroup(
			gl_gradientPanel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_gradientPanel_5.createSequentialGroup()
					.addGap(31)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
					.addGap(23))
		);
		gl_gradientPanel_5.setVerticalGroup(
			gl_gradientPanel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		panel_5.add(scrollPane);
		gradientPanel_5.setLayout(gl_gradientPanel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Search:");
		lblNewLabel_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField.setColumns(10);
		
		KButton btnSearch = new KButton();
		btnSearch.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
		btnSearch.setText("Search");
		btnSearch.setkEndColor(new Color(247, 121, 125));
		btnSearch.setkBackGroundColor(new Color(198, 255, 221));
		btnSearch.setkHoverStartColor(new Color(44, 83, 100));
		btnSearch.setkHoverEndColor(new Color(15, 32, 39));
		btnSearch.setkHoverForeGround(Color.WHITE);
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setkBorderRadius(30);
		GroupLayout gl_gradientPanel_3 = new GroupLayout(gradientPanel_3);
		gl_gradientPanel_3.setHorizontalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradientPanel_3.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		gl_gradientPanel_3.setVerticalGroup(
			gl_gradientPanel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_gradientPanel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradientPanel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
						.addComponent(btnSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap())
		);
		gradientPanel_3.setLayout(gl_gradientPanel_3);
		setLayout(gl_gradientPanel_2);

        btnRemove.addActionListener(new remove(this.c, this));
        btnInsert.addActionListener(new insert(this.c, this));
        btnSearch.addActionListener(new search(this.c, this));
    }

    public view_ver2 getC() {
        return c;
    }

    public void setC(view_ver2 c) {
        this.c = c;
    }

    public JTable getTable_1() {
        return table_1;
    }

    public void setTable_1(JTable table_1) {
        this.table_1 = table_1;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public String[][] getArray_category() {
        return array_category;
    }

    public void setArray_category(String[][] array_category) {
        this.array_category = array_category;
    }

    public JTextField getName_tag() {
        return name_tag;
    }

    public void setName_tag(JTextField name_tag) {
        this.name_tag = name_tag;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public String[][] getTemp() {
        return temp;
    }

    public void setTemp(String[][] temp) {
        this.temp = temp;
    }
}
