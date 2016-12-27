package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mySQL.MySQLConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CostLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static String id;		//�û������ID
	private static String pwd;		//�û����������
	private String pwd_sql=null;	//�����ݿ��ȡ����������
	private String role=null;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostLogin frame = new CostLogin();
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
	public CostLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�û�����");
		label.setBounds(80, 95, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("���룺");
		label_1.setBounds(80, 138, 72, 18);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(166, 92, 127, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 135, 127, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
				
			}
		});
		btnNewButton.setBounds(80, 191, 113, 27);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(326, 95, 72, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(326, 138, 72, 18);
		contentPane.add(lblNewLabel_1);
	}
	
	public void login(){
		id=textField.getText();	//��ȡid
		pwd=textField_1.getText();	//��ȡ����
		String sql="SELECT Ac_pwd,Ac_role FROM Account WHERE Ac_id='"+id+"' AND Ac_role='3';";
		MySQLConnect conn=new MySQLConnect(sql);
		try {
			ResultSet re=conn.pst.executeQuery();
			if(re.next())
			{
				pwd_sql=re.getString(1);
				role=re.getString(2);
			}
				   
			       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(role.equals('2'))
			lblNewLabel.setText("��ݲ���ȷ,��¼ʧ��");
		else if(pwd.equals(pwd_sql))
		{
			lblNewLabel_1.setText("��¼�ɹ�");
			cost_1 cost=new cost_1();
			cost.main(null);
			dispose();
		}
		else 
			lblNewLabel_1.setText("���벻��ȷ");
		//System.out.println(sql);
		//System.out.println(role);
		//System.out.println(pwd_sql);
		conn.close();
	}
}

