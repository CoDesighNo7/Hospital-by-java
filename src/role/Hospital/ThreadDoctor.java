package role.Hospital;

public class ThreadDoctor extends ServerThread {
	String init_sql="SELECT * FROM Patient WHERE Do.id="+client.get(0).toString();	//��ʼsql������䣬��ѯҽ���������¹ҺŵĲ���
	public void work(){
		while(conn_state)
		{
			re=user.inquire(init_sql);
			result=getresult();
			
		}
	}
	//���������
	public void deal(){
		
	}
}
