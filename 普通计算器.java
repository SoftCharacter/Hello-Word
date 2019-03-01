 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
 
/**
 * ����������
 */
public class ��ͨ������ extends JFrame implements ActionListener {
    /** �������ϵļ�����ʾ���� */
    private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
            "*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
    /** �������ϵĹ��ܼ�����ʾ���� */
    private final String[] COMMAND = { "Backspace", "CE", "C" };
    /** ��������ߵ�M����ʾ���� */
    private final String[] M = { " ", "MC", "MR", "MS", "M+" };
    /** �������ϼ��İ�ť */
    private JButton keys[] = new JButton[KEYS.length];
    /** �������ϵĹ��ܼ��İ�ť */
    private JButton commands[] = new JButton[COMMAND.length];
    /** ��������ߵ�M�İ�ť */
    private JButton m[] = new JButton[M.length];
    /** �������ı��� */
    private JTextField resultText = new JTextField("0");
 
    // ��־�û������Ƿ����������ʽ�ĵ�һ������,�������������ĵ�һ������
    private boolean firstDigit = true;
    // ������м�����
    private double resultNum = 0.0;
    // ��ǰ����������
    private String operator = "=";
    // �����Ƿ�Ϸ�
    private boolean operateValidFlag = true;
 
    /**
     * ���캯��
     */
    public ��ͨ������() {
        super();
        // ��ʼ��������
        init();
        // ���ü������ı�����ɫ
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("������");
        // ����Ļ(500, 300)���괦��ʾ������
        this.setLocation(500, 300);
        // �����޸ļ������Ĵ�С
        this.setResizable(false);
        // ʹ�������и������С����
        this.pack();
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("\u67E5\u770B");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("\u6807\u51C6\u578B");
        menu.add(menuItem);
        
        JMenuItem menuItem_1 = new JMenuItem("\u79D1\u5B66\u578B");
        menuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_menuItem_1_actionPerformed(e);
        	}
        });
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
        	public void actionPerformed(ActionEvent arg0) {
        		do_menuItem_3_actionPerformed(arg0);
        	}
        });
        menu_1.add(menuItem_3);
    }
 
    /**
     * ��ʼ��������
     */
    private void init() {
        // �ı����е����ݲ����Ҷ��뷽ʽ
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        // �������޸Ľ���ı���
        resultText.setEditable(false);
        // �����ı��򱳾���ɫΪ��ɫ
        resultText.setBackground(Color.WHITE);
 
        // ��ʼ���������ϼ��İ�ť����������һ��������
        JPanel calckeysPanel = new JPanel();
        // �����񲼾�����4�У�5�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
        calckeysPanel.setLayout(new GridLayout(4, 5, 3, 3));
        for (int i = 0; i < KEYS.length; i++) {
            keys[i] = new JButton(KEYS[i]);
            calckeysPanel.add(keys[i]);
            keys[i].setForeground(Color.blue);
        }
        // ��������ú�ɫ��ʾ������������ɫ��ʾ
        keys[3].setForeground(Color.red);
        keys[8].setForeground(Color.red);
        keys[13].setForeground(Color.red);
        keys[18].setForeground(Color.red);
        keys[19].setForeground(Color.red);
 
        // ��ʼ�����ܼ������ú�ɫ��ʾ�������ܼ�����һ��������
        JPanel commandsPanel = new JPanel();
        // �����񲼾�����1�У�3�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
        commandsPanel.setLayout(new GridLayout(1, 3, 3, 3));
        for (int i = 0; i < COMMAND.length; i++) {
            commands[i] = new JButton(COMMAND[i]);
            commandsPanel.add(commands[i]);
            commands[i].setForeground(Color.red);
        }
 
        // ��ʼ��M�����ú�ɫ��ʾ����M������һ��������
        JPanel calmsPanel = new JPanel();
        // �����񲼾ֹ�������5�У�1�е���������֮���ˮƽ������Ϊ3�����أ���ֱ������Ϊ3������
        calmsPanel.setLayout(new GridLayout(5, 1, 3, 3));
        for (int i = 0; i < M.length; i++) {
            m[i] = new JButton(M[i]);
            calmsPanel.add(m[i]);
            m[i].setForeground(Color.red);
        }
 
        // ������м����������岼�֣���calckeys��command������ڼ��������в���
        // ���ı�����ڱ�������calms������ڼ�������������
 
        // �½�һ����Ļ��壬�����潨����command��calckeys������ڸû�����
        JPanel panel1 = new JPanel();
        // ������ñ߽粼�ֹ����������������֮���ˮƽ�ʹ�ֱ�����ϼ����Ϊ3����
        panel1.setLayout(new BorderLayout(3, 3));
        panel1.add("North", commandsPanel);
        panel1.add("Center", calckeysPanel);
 
        // ����һ��������ı���
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add("Center", resultText);
 
        // ���岼��
        getContentPane().setLayout(new BorderLayout(3, 5));
        getContentPane().add("North", top);
        getContentPane().add("Center", panel1);
        getContentPane().add("West", calmsPanel);
        // Ϊ����ť����¼�������
        // ��ʹ��ͬһ���¼����������������󡣱������������implements ActionListener
        for (int i = 0; i < KEYS.length; i++) {
            keys[i].addActionListener(this);
        }
        for (int i = 0; i < COMMAND.length; i++) {
            commands[i].addActionListener(this);
        }
        for (int i = 0; i < M.length; i++) {
            m[i].addActionListener(this);
        }
    }
 
    /**
     * �����¼�
     */
    public void actionPerformed(ActionEvent e) {
        // ��ȡ�¼�Դ�ı�ǩ
        String label = e.getActionCommand();
        if (label.equals(COMMAND[0])) {
            // �û�����"Backspace"��
            handleBackspace();
        } else if (label.equals(COMMAND[1])) {
            // �û�����"CE"��
            resultText.setText("0");
        } else if (label.equals(COMMAND[2])) {
            // �û�����"C"��
            handleC();
        } else if ("0123456789.".indexOf(label) >= 0) {
            // �û��������ּ�����С�����
            handleNumber(label);
            // handlezero(zero);
        } else {
            // �û������������
            handleOperator(label);
        }
    }
 
    /**
     * ����Backspace�������µ��¼�
     */
    private void handleBackspace() {
        String text = resultText.getText();
        int i = text.length();
        if (i > 0) {
            // �˸񣬽��ı����һ���ַ�ȥ��
            text = text.substring(0, i - 1);
            if (text.length() == 0) {
                // ����ı�û�������ݣ����ʼ���������ĸ���ֵ
                resultText.setText("0");
                firstDigit = true;
                operator = "=";
            } else {
                // ��ʾ�µ��ı�
                resultText.setText(text);
            }
        }
    }
 
    /**
     * �������ּ������µ��¼�
     *
     * @param key
     */
    private void handleNumber(String key) {
        if (firstDigit) {
            // ����ĵ�һ������
            resultText.setText(key);
        } else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
            // �������С���㣬����֮ǰû��С���㣬��С���㸽�ڽ���ı���ĺ���
            resultText.setText(resultText.getText() + ".");
        } else if (!key.equals(".")) {
            // �������Ĳ���С���㣬�����ָ��ڽ���ı���ĺ���
            resultText.setText(resultText.getText() + key);
        }
        // �Ժ�����Ŀ϶����ǵ�һ��������
        firstDigit = false;
    }
 
    /**
     * ����C�������µ��¼�
     */
    private void handleC() {
        // ��ʼ���������ĸ���ֵ
        resultText.setText("0");
        firstDigit = true;
        operator = "=";
    }
 
    /**
     * ����������������µ��¼�
     *
     * @param key
     */
    private void handleOperator(String key) {
        if (operator.equals("/")) {
            // ��������
            // �����ǰ����ı����е�ֵ����0
            if (getNumberFromText() == 0.0) {
                // �������Ϸ�
                operateValidFlag = false;
                resultText.setText("��������Ϊ��");
            } else {
                resultNum /= getNumberFromText();
            }
        } else if (operator.equals("1/x")) {
            // ��������
            if (resultNum == 0.0) {
                // �������Ϸ�
                operateValidFlag = false;
                resultText.setText("��û�е���");
            } else {
                resultNum = 1 / resultNum;
            }
        } else if (operator.equals("+")) {
            // �ӷ�����
            resultNum += getNumberFromText();
        } else if (operator.equals("-")) {
            // ��������
            resultNum -= getNumberFromText();
        } else if (operator.equals("*")) {
            // �˷�����
            resultNum *= getNumberFromText();
        } else if (operator.equals("sqrt")) {
            // ƽ��������
            resultNum = Math.sqrt(resultNum);
        } else if (operator.equals("%")) {
            // �ٷֺ����㣬����100
            resultNum = resultNum / 100;
        } else if (operator.equals("+/-")) {
            // ������������
            resultNum = resultNum * (-1);
        } else if (operator.equals("=")) {
            // ��ֵ����
            resultNum = getNumberFromText();
        }
        if (operateValidFlag) {
            // ˫���ȸ�����������
            long t1;
            double t2;
            t1 = (long) resultNum;
            t2 = resultNum - t1;
            if (t2 == 0) {
                resultText.setText(String.valueOf(t1));
            } else {
                resultText.setText(String.valueOf(resultNum));
            }
        }
        // ����������û����İ�ť
        operator = key;
        firstDigit = true;
        operateValidFlag = true;
    }
 
    /**
     * �ӽ���ı����л�ȡ����
     *
     * @return
     */
    private double getNumberFromText() {
        double result = 0;
        try {
            result = Double.valueOf(resultText.getText()).doubleValue();
            //System.out.println(result);
        } catch (NumberFormatException e) {
        }
        return result;
    }
 
    public static void main(String args[]) {
        ��ͨ������ calculator1 = new ��ͨ������();
        calculator1.setVisible(true);
        calculator1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//�����ǰ����������ڼ����������Ĵ��ڣ������и���
	protected void do_menuItem_3_actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null,"javaѧϰС��");
	}//����ð�ť�����л�������ת��
	protected void do_menuItem_2_actionPerformed(ActionEvent e) {
		����ת���� digital = new ����ת����();
		digital.setVisible(true);
		//this.setVisible(false);
	}//����ð�ť�����л����߼�������
	protected void do_menuItem_1_actionPerformed(ActionEvent e) {
		��ѧ�ͼ����� calp = new ��ѧ�ͼ�����();
		calp.setVisible(true);
		this.setVisible(false);
	}
}
