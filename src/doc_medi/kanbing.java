package doc_medi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import patient.Connect;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kanbing extends JFrame {
    static int i=0;
    static String choose;
    static Object[] yao;
    String result2=null;// �������ߵ��ַ��� 
    String a;
    String result3="5";//�Ŷ�����
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kanbing frame = new kanbing();
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
	public kanbing() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String b="2 "+docter.zhanghao+" "+docter.mima+" 1";
		String result=Connect.connect(b);
		//String result = "w-h-b-x-s";   // �õ�������Ϣ���������˺ţ��������Ա����䣬֢״    ps:����ֱ�Ӵ��͸�ץҩ���շ�
	    //String result1=Connect.connect("2-");
		String result1="a-b-c-d-e-f-g";   //�õ�ҩƷ��Ϣ
		
		yao=result1.split("-"); //��ҩ����Ϣ�ֺ�
		JLabel lblNewLabel = new JLabel(result);               //�˴���abc�滻Ϊ������Ϣ
		lblNewLabel.setBounds(10, 10, 245, 46);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("�Ŷ�����Ϊ�� "+result3);
		label.setBounds(280, 10, 144, 31);
		contentPane.add(label);
		

		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=textField.getText();
				result2= choose+"-"+a;   // ��ѡ���ҩ������ƴ����һ��
		System.out.println(result2);
			}
		});
		button.setBounds(162, 228, 93, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 400, 46);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("\u9009\u836F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 choose = (String) JOptionPane.showInputDialog(null,"��ѡ����Ҫ��ҩ:\n", "ҩ", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), yao, "");  
			}
		});
		
		panel.add(btnNewButton);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		
	}
	
}
