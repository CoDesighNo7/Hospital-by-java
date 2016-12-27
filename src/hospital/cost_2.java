package hospital;


import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.*;

import hospital.MySQLConnect;

public class cost_2 extends AbstractTableModel {
	
	
		

	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
 
    //通过传递的sql语句来获得数据模型
    public cost_2(String sql)
    {
    	//建立表头  
    	ColumnNames= new Vector();
    	ColumnNames.add("病人id");
		ColumnNames.add("药品名");
		ColumnNames.add("数量");
		ColumnNames.add("价格");
		RowData=new Vector(); 						// 此处填写要执行的语句
	    db = new MySQLConnect(sql);							// 新建一个数据库连接
	    try {
			ret = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getInt(3));
	        	hang.add(ret.getDouble(4));
	        	RowData.add(hang);
	        }
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //建立构造函数初始化数据模型
    public cost_2()
    {
		ColumnNames= new Vector();
		ColumnNames.add("病人id");
		ColumnNames.add("药品名");
		ColumnNames.add("数量");
		ColumnNames.add("价格");
		//建立表头
		
		
		
		RowData=new Vector(); 
		sql = "SELECT Pa_id,Me_id,Me_count,price FROM Me_List";						// 此处填写要执行的语句
	    db = new MySQLConnect(sql);							// 新建一个数据库连接
	    try {
			ret = db.pst.executeQuery();// 执行sql语句，得到结果集
			
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getInt(3));
	        	hang.add(ret.getDouble(4));
	        	RowData.add(hang);
	        }
	        ret.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	//得到共有多少列
	public int getColumnCount() {
		
		// TODO 自动生成的方法存根
		return this.ColumnNames.size();
	}

	//得到共有多少行
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.RowData.size();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO 自动生成的方法存根
		return (String)this.ColumnNames.get(arg0);
	}


	//得到某行某列的数据
	public Object getValueAt(int row, int column) {
		// TODO 自动生成的方法存根
		return ((Vector)this.RowData.get(row)).get(column);
	}

}
