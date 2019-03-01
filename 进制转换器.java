
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class 进制转换器 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	
	JRadioButton radioButton,radioButton_1,radioButton_2, radioButton_3;
	JRadioButton radioButton_4,radioButton_5,radioButton_6,radioButton_7 ;
	private JMenuBar menuBar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					进制转换器 frame = new 进制转换器();
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
	public 进制转换器() {
		setTitle("Digital");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u67E5\u770B");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u6807\u51C6\u578B");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_menuItem_actionPerformed(arg0);
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u79D1\u5B66\u578B");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_menuItem_1_actionPerformed(e);
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8FDB\u5236\u8F6C\u6362");
		mnNewMenu.add(menuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5173\u4E8E\u8FDB\u5236\u8F6C\u6362\u5668");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_menuItem_3_actionPerformed(e);
			}
		});
		mnNewMenu_1.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigitalConversion = new JLabel("Digital Conversion");
		lblDigitalConversion.setBounds(97, 28, 212, 15);
		contentPane.add(lblDigitalConversion);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = 0;
				String s = textField.getText();
				if(radioButton.isSelected()) {
					number = Integer.parseInt(s, 2);
				}
				else if(radioButton_1.isSelected()) {
					number = Integer.parseInt(s, 8);
				}
				else if(radioButton_2.isSelected()) {
					number = Integer.parseInt(s);
				}
				else if(radioButton_3 .isSelected()) {
					number = Integer.parseInt(s, 16);
				}
				else {
					
				}
				String s2 = "";
				if(radioButton_4.isSelected()) {
					s2 = Integer.toBinaryString(number);
				}
				else if(radioButton_5.isSelected()) {
					s2 = Integer.toOctalString(number);
				}
				else if(radioButton_6.isSelected()) {
					s2 = Integer.toString(number);
				}
				else if(radioButton_7.isSelected()) {
					s2 = Integer.toHexString(number);
				}
				else {
					
				}
				textField_1.setText(s2);
			}
		});
		textField.setBounds(32, 53, 326, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		  radioButton = new JRadioButton("2");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(radioButton);
		radioButton.setBounds(27, 100, 42, 23);
		contentPane.add(radioButton);
		
        radioButton_1 = new JRadioButton("8");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(82, 100, 42, 23);
		contentPane.add(radioButton_1);
		
		  radioButton_2 = new JRadioButton("10");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(126, 100, 42, 23);
		contentPane.add(radioButton_2);
		
		  radioButton_3 = new JRadioButton("16");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(195, 100, 48, 23);
		contentPane.add(radioButton_3);
		
		JLabel lblDigitalTo = new JLabel("Digital to");
		lblDigitalTo.setBounds(114, 147, 109, 15);
		contentPane.add(lblDigitalTo);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setEnabled(false);
		textField_1.setBounds(32, 170, 326, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		  radioButton_4 = new JRadioButton("2");
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(radioButton_4);
		radioButton_4.setBounds(32, 209, 42, 23);
		contentPane.add(radioButton_4);
		
		  radioButton_5 = new JRadioButton("8");
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(radioButton_5);
		radioButton_5.setBounds(82, 209, 42, 23);
		contentPane.add(radioButton_5);
		
		  radioButton_6 = new JRadioButton("10");
		radioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(radioButton_6);
		radioButton_6.setBounds(126, 209, 42, 23);
		contentPane.add(radioButton_6);
		
		  radioButton_7 = new JRadioButton("16");
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(radioButton_7);
		radioButton_7.setBounds(195, 209, 48, 23);
		contentPane.add(radioButton_7);
	}
	protected void do_menuItem_actionPerformed(ActionEvent arg0) {
		普通计算器 cal = new 普通计算器();
		cal.setVisible(true);
		this.setVisible(false);
	}
	protected void do_menuItem_1_actionPerformed(ActionEvent e) {
		科学型计算器 calp = new 科学型计算器();
		calp.setVisible(true);
		this.setVisible(false);
	}
	protected void do_menuItem_3_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"java学习小组");
	}
}
