package hos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class zhuayao2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	 static String choose;
	    static Object[] yao;
	    String result2=null;// �������ߵ��ַ��� 
	    String a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhuayao2 frame = new zhuayao2();
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
	public zhuayao2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String result="a-4";//result���ܴ�ҽ������õ�ҩ��
		String result1="a-b-c-d-e-f-g";//"result1Ϊ���ܵ���ҩ����Ϣ"
		String result3="w-h-b-x-s";   //result3Ϊ���ܵ��Ĳ�����Ϣ �Ϳ�����resultһ�� ����ֱ�Ӵ���
		yao=result1.split("-"); //��ҩ����Ϣ�ֺ�
		JLabel lblNewLabel = new JLabel(result);   //����Ҫ����result
		lblNewLabel.setBounds(246, 21, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(236, 74, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=textField.getText();
				result2= choose+"-"+a;   // ��ѡ���ҩ������ƴ����һ��
		System.out.println(result2);
			}
		});
		btnNewButton.setBounds(155, 176, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9009\u836F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = (String) JOptionPane.showInputDialog(null,"��ѡ����Ҫ��ҩ:\n", "ҩ", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), yao, ""); 
			}
		});
		btnNewButton_1.setBounds(89, 73, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel(result3);
		lblNewLabel_1.setBounds(28, 21, 154, 15);
		contentPane.add(lblNewLabel_1);
		
	}
}
