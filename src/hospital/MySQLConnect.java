package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Liu Yummy
 * 
 *  ����һ�������������ݿ���࣬***���еĴ���***������Ҫ�޸ġ�
 *  ���Բο�hospital�е��������е��ã�
 *	�����ʹ�ù����У����κ����⣬������޷����������Ҫ�����֪���޸ģ����޸�ʱ��Ӹ���ע�ͣ�
 *	
 */

public class MySQLConnect {

	public static final String url = "jdbc:mysql://114.215.112.200/hospital";	// ���ݿ��ַ
	public static final String name = "com.mysql.jdbc.Driver";						// ������
	public static final String user = "tempuserfordage";									// ���ݿ��û���
	public static final String password = "123456";									// �û�����
	
	public Connection conn = null;				// ����һ���յ�Connection����
	public PreparedStatement pst = null;		// ����һ���յ�PreparedStatement����

	public MySQLConnect(String sql) {
		try {
			Class.forName(name);										// ָ����������
			conn = DriverManager.getConnection(url, user, password);	// ��ȡ���ݿ�����
			pst = conn.prepareStatement(sql);							// ׼��ִ�����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void close() {  
            try {
				this.conn.close();		// �ر����ݿ�����
				this.pst.close();		// ����ִ�����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    }  
}
