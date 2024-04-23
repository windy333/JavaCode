package utils;

import java.sql.*;



public class DBUtil {
	Connection conn=null;
	Statement stat=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public Connection getConn(){
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosc", "root", "123456");
	    } catch (ClassNotFoundException e){
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}

	

	public void release() {
		
    		try {
    			if(rs!=null) rs.close();
    			if(stat!=null) stat.close();
    			if(conn!=null)  conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	public ResultSet getResult(String sql,String[] args) {
	rs=null;
	if(conn==null)
	conn=this. getConn();
	try{
		ps=conn. prepareStatement(sql);
		for (int i=0;i<args.length;i++){
			ps. setString(i+1,args[i]);
		}
		rs=ps. executeQuery();
		}catch (SQLException e){
			e. printStackTrace();}
		return rs;
	}
	
	
	public ResultSet getResult(String sql) {
	rs=null;
	if(conn==null)
	conn=this. getConn();
	try{
		stat=conn. createStatement();
		rs=stat. executeQuery(sql);
	}catch (SQLException e) {
		e. printStackTrace();}
	return rs;
	}
	
	
	public int executeSql(String sql) {
		return 0;
	}
	
	public static void main(String[] args){
	DBUtil db=new DBUtil();
	ResultSet rs=db. getResult("select * from user;");
	//ResultSet rs=db. getResult("selcect * from T_userInfo where userName=? and userPwd=?;",new String[]{"006","66"});
	
	try {
		while(rs. next()){
			System. out. println(rs. getString("Host"));
			System. out. println(rs. getString("User"));
			}
		}catch (SQLException e){
				e. printStackTrace();
			}finally{
				if(db!=null)
					db. release();
			}
		}

		
}
