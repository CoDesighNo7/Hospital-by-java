package role.Hospital;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread {
	public static int pa_max=1000;
	public static int pa_no=0;
	public String id;	//�û�id
	public String role; //�û�����
	public static String command="1 001 123456 ���ȷ� 3 10001 ��ð �׼Ӻ�";	//���յ����Կͻ��˵��������ݰ�
	public boolean conn_state;	//״̬
	public ArrayList<String> command_array=new ArrayList<String>();	//ArrayList �����Դ�ŷָ�������
	public String sql_command;	//Ϊ���յ��������sql���
	public ResultSet re;	//ִ��sql����󷵻صĽ����
	public String result;	//���ɷ��ؿͻ��˵����ݰ�
	static Date dt=new Date();	//
	static SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
	public static String date=matter1.format(dt);
	//��������н���
	public void wordscut(){
		int i=0;
		String [] comm=command.split(" ");							//�����յ��������ַ����ָ���뵽comm�ַ���������
		int count_comm=comm.length;
		for(i=0;i<count_comm;i++)
		{
			command_array.add(comm[i]);
		}
		
	}
	//����DBʵ��
	DB user;
	
	public void run(){
		if(this.command!=null)
		{
			this.wordscut();
			user=new DB(command_array.get(1).toString(),command_array.get(2).toString());
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
		role=command_array.get(0).toString();
		id=command_array.get(1).toString();
		conn_state=user.connect();
	}
	
	//������յ����������sql_command
	public void sql_make(){
		wordscut();
		sql_command=command_array.toString();
	}
	
	//�������ݿ���������ɽ����
	public String getresult(String sql){
		re=user.inquire(sql);
		result=re.toString();
		return result;
	}									
	
	
}