package role.Hospital;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ServerThread extends Thread {
	public String name;	//�߳���
	public String command=null;	//���յ����Կͻ��˵��������ݰ�
	public boolean conn_state;	//״̬
	public ArrayList<String> client=new ArrayList<String>();	//ArrayList �����Դ�ŷָ�������
	public String sql_command;	//Ϊ���յ��������sql���
	public ResultSet re;	//ִ��sql����󷵻صĽ����
	public String result;	//���ɷ��ؿͻ��˵����ݰ�
	//��������н���
	public void wordscut(){
		String [] comm=command.split(" ");							//�����յ��������ַ����ָ���뵽comm�ַ���������
		int count_comm=comm.length;
		while(count_comm!=0)										//��comm�е��ַ�������ArrayList����
		{
			int i=0;
			this.client.add(comm[i++]);
			count_comm--;
		}
	}
	//����DBʵ��
	DB user=new DB(client.get(0).toString(),client.get(1).toString());
	//��ʼ���߳�
	public void init_this() throws ClassNotFoundException{
		name=client.get(2).toString();
		conn_state=user.connect();
		
	}
	
	//����sql���
	//public void sql_make() {	}					
	//�������ݿ���������ɽ����
	public String getresult(){
		if(!conn_state)
			{
				result="��������ʧ�ܣ������û����������Ƿ���ȷ";
				return result;
			}
		re=user.inquire(sql_command);
		result=re.toString();
		return result;
	}									
	
	
}