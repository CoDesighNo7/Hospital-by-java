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
		String patientid=command_array.get(4).toString();	//��ȡ����id
		String prescription=command_array.get(6).toString();//��ȡ��ҩ��
		String illness=command_array.get(5).toString();		//��ȡ�����Ϣ��ʲô����
		sql_command="UPDATE Patient SET Pa_illness='"+illness+"',Pa_prescription='"+prescription
				+"',Pa_state=4,"+" WHERE Pa_id='"+patientid+"'";		//ҽ�������ҩ�������޸Ĳ�����Ϣ��sql���������״̬�޸�Ϊ4��ȡҩ
	}
	public static void main(String[] args) {
		ThreadDoctor doctor=new ThreadDoctor();
		doctor.command="2 610001 123456 3 001 ��ð �׼Ӻ�";
		System.out.println(doctor.command);
		doctor.wordscut();
		doctor.deal();
		for(int i=0;i<doctor.command_array.size();i++)
		System.out.println(doctor.command_array.get(i));
		System.out.println(doctor.sql_command);
		
	}
}
