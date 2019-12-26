package org.com.common.dbutils;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
	 
	/**
	 * @Author: LiGe
	 * @Date: 2018/10/21 11:50
	 * @description: Oracle连接工具类
	 */
	public class OracleDBUtil {
	    //数据库连接地址
	    private static String url="jdbc:oracle:thin:@10.10.0.117:1521:orcl";
	    //用户名
	    private static String username= "jats201";
	    //密码
	    private static String password ="test1";
	    //驱动名称
	    private static String jdbcName = "oracle.jdbc.OracleDriver";
	 
	    /*获取数据库连接 */
	    public static Connection getCon(String env){
	        try {
	            Class.forName(jdbcName);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        Connection con = null;
	        try {
	            con = DriverManager.getConnection(url,username,password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
	 

		public static Connection createConn(String env,String url,String username,String password)
	    {    
	        Connection conn=null;
	        try {
	            //Class.forName("com.mysql.jdbc.Driver");        	            
	            Class.forName("oracle.jdbc.OracleDriver").newInstance();
	            Properties props = new Properties();
	            props.setProperty("user", username);
	            props.setProperty("password", password);
	            conn=DriverManager.getConnection(url,props);
	            System.out.println("数据库连接成功");
	        }catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("数据库连接异常！！！");
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
	    
	    
	    
	    /*关闭数据库连接*/
	        public static void closeCon(Connection con) throws SQLException {
	            if (con != null)
	                con.close();
	        }
	 
	        

		    public static PreparedStatement prepare(Connection conn,String sql)
		    {
		        PreparedStatement stat=null;
		        try {
		            stat=conn.prepareStatement(sql);
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return stat;
		    }
		    
		    public static void close(Connection conn)
		    {
		        if(conn==null) return;
		        
		        try {
		            conn.close();
		            conn=null;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    public static void close(Statement stat)
		    {
		        if(stat==null) return;
		        
		        try {
		            stat.close();
		            stat=null;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    public static void close(ResultSet rs)
		    {
		        if(rs==null) return;
		        try {
		            rs.close();
		            rs=null;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    
		    public  static String excuteQuery(String env,String table,String condition,String conditionValue,String column) {
		           Connection conn = OracleDBUtil.createConn(env,url,username,password);
//		           String sql="select * from "+Database+"."+table +" where "+condition+"='"+conditionValue+"'";
		           String sql="select * from "+table +" where "+condition+"='"+conditionValue+"'";
		           System.out.println(sql);
			        String value = null;
			        PreparedStatement ps;
			        try {
			            ps = conn.prepareStatement(sql);
		            try {
		                ResultSet rs=ps.executeQuery();
		                
		                while(rs.next())
		                {    
		                	value=rs.getString(column);
		    //            	System.out.println(num+","+rs.getString("APPL_CDE")+","+rs.getString("APPL_SEQ"));
		    //              System.out.println(num+","+rs.getString("APPL_CDE")+","+rs.getString("APPL_SEQ"));
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		            conn.close();
		            ps.close();
		        } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		        return value;
		    }
			
		    public  static String excuteQuery(String env,String sql,String column) {
		           Connection conn = OracleDBUtil.createConn(env,url,username,password);
//		           String sql="select * from "+Database+"."+table +" where "+condition+"='"+conditionValue+"'";
//		           System.out.println(sql);
			        String value = null;
			        PreparedStatement ps;
			        try {
			            ps = conn.prepareStatement(sql);
		            try {
		                ResultSet rs=ps.executeQuery();
		                
		                while(rs.next())
		                {    
		                	value=rs.getString(column);
		    //            	System.out.println(num+","+rs.getString("APPL_CDE")+","+rs.getString("APPL_SEQ"));
		    //              System.out.println(num+","+rs.getString("APPL_CDE")+","+rs.getString("APPL_SEQ"));
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		            conn.close();
		            ps.close();
		        } catch (SQLException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		        return value;
		    }
			
		    
		    /*查询*/
		    public static void select(String env,String sql) throws SQLException{
		    	int i=0;
		    	Connection connection = OracleDBUtil.getCon(env);
//		        String sql = "select id,name,gender from student";
		        try {
		        	PreparedStatement   ps = connection.prepareStatement(sql);
		        	ResultSet  rs = ps.executeQuery();
		            while (rs.next()){
		                String Str = rs.getString(1);
		                i++;
		                System.out.println("查询结果Str:"+Str+" 结果条数 i="+i);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
		        	OracleDBUtil.closeCon(connection);
		        }
		    }
		    
		    
		    
		    public  static void update(String env,String sql) {
		           Connection conn = OracleDBUtil.createConn(env,url,username,password);
			        PreparedStatement ps = null;
			            try {
							ps = conn.prepareStatement(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                try {
							int rs=ps.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}     
		            try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
		    
		   
	        
	        
	        public static void main(String[] args) throws SQLException{
	            try {
	            	Connection Con	=OracleDBUtil.getCon("env");
	                System.out.println("数据库连接成功");
	            } catch (Exception e) {
	                e.printStackTrace();
	                System.out.println("数据库连接失败");
	            }
	            
	           String sql="select paystate from t_se_payments";
//	           OracleDBUtil.select("", sql);
	           OracleDBUtil.createConn("", url, username, password);
	           
	            
	        }
	 
	}

