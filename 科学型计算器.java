import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.math.*;
import java.util.ArrayList;
import java.awt.Font;
public class 科学型计算器 extends JFrame implements ActionListener{
  //注册主要界面部件  
	private JPanel contentPane;
	private JTextField textField;
	JButton button;
	JButton btnx;
	JButton button_1;
	JButton btnNewButton;
	JButton button_2;
	JButton button_3;
	JButton button_4;
	JButton button_5;
	JButton btnNewButton_1;
	JButton button_6;
	JButton button_7;
	JButton button_8;
	JButton button_9;
	JButton button_10;
	JButton button_11;
	JButton button_12;
	JButton button_13;
	JButton button_14;
	JButton button_15;
	JButton button_16;
	JButton btnC;
	JButton btnCe;
	JButton btnNewButton_2;
	JButton btnCos;
	JButton btnTan;
	JButton btnN;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_7;
	JButton btnNewButton_8;
	JButton btnNewButton_9;
	private JTextField textField_1;
	// 标志用户按的是否是整个表达式的第一个数字,或者是运算符后的第一个数字
	private boolean firstDigit = true;
	//标志用户是否按下运算符
	private boolean  lastOperator = true; 
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					科学型计算器 frame = new 科学型计算器();
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
	public 科学型计算器() {
		setTitle("\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 300);
	//设计菜单栏	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u67E5\u770B");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6807\u51C6\u578B");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_menuItem_actionPerformed(e);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u79D1\u5B66\u578B");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8FDB\u5236\u8F6C\u6362");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_menuItem_2_actionPerformed(e);
			}
		});
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5173\u4E8E\u8BA1\u7B97\u5668");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_menuItem_3_actionPerformed(e);
			}
		});
		menu_1.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	//初始化显示窗口	
		textField = new JTextField("0");
		textField.setEditable(false);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("SimSun", Font.BOLD, 13));
		textField.setToolTipText("");
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 10, 396, 40);
		contentPane.add(textField);
		textField.setColumns(10);
    //初始化按钮	 
		 button = new JButton("=");
		button.setBounds(356, 177, 54, 54);
		contentPane.add(button);
		
		 btnx = new JButton("1/x");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnx_actionPerformed(e);
			}
		});
		btnx.setBounds(356, 144, 54, 29);
		contentPane.add(btnx);
		
		 button_1 = new JButton("%");
		button_1.setBounds(356, 110, 54, 29);
		contentPane.add(button_1);
		
		  btnNewButton = new JButton("\u221A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(356, 78, 54, 29);
		contentPane.add(btnNewButton);
		
		  button_2 = new JButton("+");
		button_2.setBounds(296, 208, 50, 23);
		contentPane.add(button_2);
		
		 button_3 = new JButton("-");
		button_3.setBounds(296, 175, 50, 23);
		contentPane.add(button_3);
		
		 button_4 = new JButton("*");
		button_4.setBounds(296, 147, 50, 23);
		contentPane.add(button_4);
		
		 button_5 = new JButton("/");
		button_5.setBounds(296, 113, 50, 23);
		contentPane.add(button_5);
		
		 btnNewButton_1 = new JButton("\u00B1");
		btnNewButton_1.setBounds(296, 81, 50, 23);
		contentPane.add(btnNewButton_1);
		
		 button_6 = new JButton(".");
		button_6.setBounds(241, 208, 39, 23);
		contentPane.add(button_6);
		
		 button_7 = new JButton("0");
		button_7.setBounds(154, 208, 77, 23);
		contentPane.add(button_7);
		
		 button_8 = new JButton("3");
		button_8.setBounds(252, 177, 42, 23);
		contentPane.add(button_8);
		
		  button_9 = new JButton("2");
		button_9.setBounds(203, 177, 42, 23);
		contentPane.add(button_9);
		
	 button_10 = new JButton("1");
		button_10.setBounds(154, 177, 42, 23);
		contentPane.add(button_10);
		
		 button_11 = new JButton("6");
		button_11.setBounds(252, 147, 42, 23);
		contentPane.add(button_11);
		
		  button_12 = new JButton("5");
		button_12.setBounds(203, 147, 42, 23);
		contentPane.add(button_12);
		
		 button_13 = new JButton("4");
		button_13.setBounds(154, 147, 42, 23);
		contentPane.add(button_13);
		
		 button_14 = new JButton("9");
		button_14.setBounds(252, 113, 42, 23);
		contentPane.add(button_14);
		
		 button_15 = new JButton("8");
		button_15.setBounds(203, 113, 42, 23);
		contentPane.add(button_15);
		
		 button_16 = new JButton("7");
		button_16.setBounds(154, 113, 42, 23);
		contentPane.add(button_16);
		
		  btnC = new JButton("C");
		btnC.setBounds(229, 81, 57, 23);
		contentPane.add(btnC);
		
		  btnCe = new JButton("CE");
		btnCe.setBounds(154, 81, 65, 23);
		contentPane.add(btnCe);
		
	 btnNewButton_2 = new JButton("sin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(77, 208, 57, 23);
		contentPane.add(btnNewButton_2);
		
		 btnCos = new JButton("cos");
		btnCos.setBounds(77, 177, 57, 23);
		contentPane.add(btnCos);
		
		  btnTan = new JButton("tan");
		btnTan.setBounds(77, 147, 57, 23);
		contentPane.add(btnTan);
		
		  btnN = new JButton("n!");
		btnN.setBounds(77, 113, 57, 23);
		contentPane.add(btnN);
		
		  btnNewButton_3 = new JButton("\u03C0");
		btnNewButton_3.setBounds(77, 81, 57, 23);
		contentPane.add(btnNewButton_3);
		
		  btnNewButton_4 = new JButton("\u00B2");
		btnNewButton_4.setBounds(10, 208, 57, 23);
		contentPane.add(btnNewButton_4);
		
		  btnNewButton_5 = new JButton("\u00B3");
		btnNewButton_5.setBounds(10, 177, 57, 23);
		contentPane.add(btnNewButton_5);
		
		  btnNewButton_6 = new JButton("\u33D1");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_6_actionPerformed(e);
			}
		});
		btnNewButton_6.setBounds(10, 147, 57, 23);
		contentPane.add(btnNewButton_6);
		
	 btnNewButton_7 = new JButton("10x");
		btnNewButton_7.setBounds(10, 113, 57, 23);
		contentPane.add(btnNewButton_7);
		
		  btnNewButton_8 = new JButton("\u2190");
		btnNewButton_8.setBounds(77, 55, 57, 23);
		contentPane.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("\u2153");
		btnNewButton_9.setForeground(Color.BLACK);
		btnNewButton_9.setBounds(10, 81, 57, 23);
		contentPane.add(btnNewButton_9);
		//为按钮注册监听
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setBounds(10, 56, 57, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		 button.addActionListener(this);
		 btnx.addActionListener(this);
		 button_1.addActionListener(this);
		 btnNewButton.addActionListener(this);
		 button_2.addActionListener(this);
		 button_3.addActionListener(this);
		 button_4.addActionListener(this);
		 button_5.addActionListener(this);
		 btnNewButton_1.addActionListener(this);
		 button_6.addActionListener(this);
		 button_7.addActionListener(this);
		 button_8.addActionListener(this);
		 button_9.addActionListener(this);
		 button_10.addActionListener(this);
		 button_11.addActionListener(this);
		 button_12.addActionListener(this);
		 button_13.addActionListener(this);
		 button_14.addActionListener(this);
		 button_15.addActionListener(this);
		 button_16.addActionListener(this);
		 btnC.addActionListener(this);
		 btnCe.addActionListener(this);
		 btnNewButton_2.addActionListener(this);
		 btnCos.addActionListener(this);
		 btnTan.addActionListener(this);
		 btnN.addActionListener(this);
		 btnNewButton_3.addActionListener(this);
		 btnNewButton_4.addActionListener(this);
		 btnNewButton_5.addActionListener(this);
		 btnNewButton_6.addActionListener(this);
		 btnNewButton_7.addActionListener(this);
		 btnNewButton_8.addActionListener(this);
		 btnNewButton_9.addActionListener(this);
		 textField.addActionListener(this);
	}//这里是帮助里点击关于计算器弹出的窗口，可自行更改
	protected void do_menuItem_3_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"java学习小组");
	}//点击该按钮界面切换到普通计算器
	protected void do_menuItem_actionPerformed(ActionEvent e) {
		普通计算器 cal = new 普通计算器();
		cal.setVisible(true);
		this.setVisible(false);
	}//点击该按钮界面切换到进制转换
	protected void do_menuItem_2_actionPerformed(ActionEvent e) {
		进制转换器 digital = new 进制转换器();
		digital.setVisible(true);
		//this.setVisible(false);
	}
	protected void do_btnx_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNewButton_6_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		// 用户按了数字键 运算符或者小数点键
		if(arg0.getSource()==button_7||arg0.getSource()==button_8||arg0.getSource()==button_9||arg0.getSource()==button_10||
				arg0.getSource()==button_11||arg0.getSource()==button_12||arg0.getSource()==button_13||
				arg0.getSource()==button_14||arg0.getSource()==button_15||arg0.getSource()==button_16||
				arg0.getSource()==button_6||arg0.getSource()==button_2||arg0.getSource()==button_3||
				arg0.getSource()==button_4||arg0.getSource()==button_5||arg0.getSource()==btnNewButton_3) {
			if (firstDigit) {
				if(arg0.getSource()==button_2||arg0.getSource()==button_3||
						arg0.getSource()==button_4||arg0.getSource()==button_5) {					 
						textField .setText(textField.getText() + arg0.getActionCommand());
						lastOperator = false;
					}else if(arg0.getSource()==button_6) {
						textField .setText(textField.getText() +".");
					}else {
						if(arg0.getSource()==btnNewButton_3) {
							textField .setText("3.1415926");
						}else {
							textField .setText(arg0.getActionCommand());
						}					
					}
				}				
			else if(arg0.getSource()==button_6&&(textField.getText().indexOf(".") < 0)){
				textField .setText(textField.getText() +".");
			}else if(arg0.getSource()!=button_6&&arg0.getSource()!=button_2&&arg0.getSource()!=button_3&&
					arg0.getSource()!=button_4&&arg0.getSource()!=button_5&&arg0.getSource()!=btnNewButton_3) {
				textField .setText(textField.getText() + arg0.getActionCommand());
				lastOperator = true;
			} else if(arg0.getSource()==button_2||arg0.getSource()==button_3||
						arg0.getSource()==button_4||arg0.getSource()==button_5) {
				if(lastOperator) {
					textField .setText(textField.getText() + arg0.getActionCommand());
					lastOperator = false;
				}
			}else if(arg0.getSource()==btnNewButton_3) {
				textField .setText(textField.getText() + "3.1415926");
				lastOperator = true;
			}
			firstDigit = false;		
			
		}		 
		// 用户按了"C"键
		else if(arg0.getSource()==btnC) {
			textField .setText("0");
			firstDigit = true;	
		}
		// 用户按了后退键
		else if(arg0.getSource()==btnNewButton_8) {
			String text = textField.getText();
			 int i = text.length();
			 if(i>0) {
				 text = text.substring(0, i - 1);
				 if(i==0) {
					 textField .setText("0");						  
				 }
				 else {
					 textField.setText(text);
				 }
			 }
		}
		// 正数负数运算
		else if(arg0.getSource()==btnNewButton_1) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number = number*(-1);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//根号运算
		else if(arg0.getSource()==btnNewButton) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				if(number>=0) {
				number =  Math.sqrt(number);
				textField.setText(String.valueOf(number));
				}else {
					JOptionPane.showMessageDialog(null,"负数没有平方根");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//百分号运算
		else if(arg0.getSource()==button_1) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  number/100;
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//倒数运算
		else if(arg0.getSource()==btnx) {			 
				double number=0.0;			 
				try {					
					number = Double.valueOf(textField.getText()).doubleValue();					
					  if(number!=0) {
					number = 1/number;
					textField.setText(String.valueOf(number));
				}else{
					JOptionPane.showMessageDialog(null,"0没有倒数");
				}				 
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//sin值运算
		else if(arg0.getSource()==btnNewButton_2) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.sin(number);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//cos值运算
		else if(arg0.getSource()==btnCos) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.cos(number);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//tan值运算
		else if(arg0.getSource()==btnTan) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.tan(number);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//计算阶乘
		else if(arg0.getSource()==btnN) {
			double number=0.0;
			double result = 1;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				if(number==0) {
					textField.setText("1");
				}else if(number>0){
				for(int i=1;i<=number;i++) {
					result *=i;
				 }
				textField.setText(String.valueOf(result));
			}else if(number<0) {
				JOptionPane.showMessageDialog(null,"负数没有阶乘！");
			}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//平方运算
		else if(arg0.getSource()==btnNewButton_4) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.pow(number,2);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//三次方运算
		else if(arg0.getSource()==btnNewButton_5) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.pow(number,3);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//对数运算
		else if(arg0.getSource()==btnNewButton_6) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.log(number);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//10的N次方运算
		else if(arg0.getSource()==btnNewButton_7) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.pow(10,number);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//开立方运算
		else if(arg0.getSource()==btnNewButton_9) {
			double number=0.0;
			try {
				number = Double.valueOf(textField.getText()).doubleValue();
				number =  Math.cbrt(number);
				textField.setText(String.valueOf(number));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//按下CE键
		else if(arg0.getSource()==btnCe){
			 textField.setText("0");
			 firstDigit = true;
			 lastOperator = true; 
		}
		//显示算法运算结果
		else {			
			textField.setText(returnNum());
			 
		}
	}
	//向算法写入显示窗口里的字符串
	 public String returnNum() {
		    String result = textField.getText();
		     new 逆波兰算法(result);
		    double number = 逆波兰算法.returnNum();
		     String str =String.valueOf(number);
		    return str; 
	 }
}
