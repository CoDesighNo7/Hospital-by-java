package role.Hospital;

import java.util.Hashtable;

public class ThreadDoctor extends ServerThread {
	String sql_init="SELECT * FROM Patient WHERE Do.id="+id;	//��ʼsql������䣬��ѯҽ���������¹ҺŵĲ���
	public void run(){
		try {
			init_thread();		//��ʼ���߳�
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!conn_state)
		{
			result="�û�id���������";
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
	
	//���������
	public void deal(){
		String patientid=client.get(4).toString();
		String prescription=client.get(5).toString();
		String illness=client.get(6).toString();
		sql_command="UPDATE Patient SET Pa_illness='"+illness+"',Pa_prescription='"+prescription
				+"',Pa_state=2,"	+" WHERE Pa_id='"+patientid+"'";
	}
	public static void main(String[] args) {
		ThreadDoctor doctor=new ThreadDoctor();
		doctor.command="001 123456 ���ȷ� 1 1 10001 ��ð �׼Ӻ�";
		System.out.println(doctor.command);
		doctor.wordscut();
		System.out.println(doctor.client);
	}
}
