package role.Hospital;

public class ThreadPatient extends ServerThread {
	String sql_init="SELECT * FROM Patient WHERE Pa.id="+id;//��ѯ���˱�����Ϣ
	public void run(){
		try {
			init_thread();		//��ʼ���߳�
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.start();
		while(conn_state)
		{
			if(this.command!=null)
			{
				wordscut();
				deal();
				getresult(sql_command);
			}
			else if(getresult(sql_init)!=result)	
				;
				/*
				 �˴�Ϊ��result���͵���Ӧ�ͻ���
				 * */
			try {
				this.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	public void deal(){	
	}
}
