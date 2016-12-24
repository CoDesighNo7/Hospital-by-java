package role.Hospital;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread {
	public static int pa_max=1000;
	public String id;	//�û�id
	public String role; //�û�����
	public static String command=null;	//���յ����Կͻ��˵��������ݰ�
	public boolean conn_state;	//״̬
	public ArrayList<String> client=new ArrayList<String>();	//ArrayList �����Դ�ŷָ�������
	public String sql_command;	//Ϊ���յ��������sql���
	public ResultSet re;	//ִ��sql����󷵻صĽ����
	public String result;	//���ɷ��ؿͻ��˵����ݰ�
	static Date dt=new Date();	//
	static SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
	public static String date=matter1.format(dt);
	//��������н���
	public void wordscut(){
		String [] comm=command.split(" ");							//�����յ��������ַ����ָ���뵽comm�ַ���������
		int count_comm=comm.length;
		while(count_comm!=0)										//��comm�е��ַ�������ArrayList����
		{
			int i=0;
			client.add(comm[i++]);
			count_comm--;
		}
	}
	//����DBʵ��
	DB user=new DB(client.get(1).toString(),client.get(2).toString());
	
	public void run(){
		if(this.command!=null)
		{
			this.wordscut();
			try {
				init_thread();
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	//��ʼ���߳�
	public void init_thread() throws ClassNotFoundException{
		role=client.get(0).toString();
		id=client.get(1).toString();
		conn_state=user.connect();
	}
	
	//������յ����������sql_command
	public void sql_make(){
		wordscut();
		sql_command=client.toString();
	}
	
	//�������ݿ���������ɽ����
	public String getresult(String sql){
		re=user.inquire(sql);
		result=re.toString();
		return result;
	}									
	
	
}