package org.com.common.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

	public class DB2Tool {
		
		public static Connection createConn(String env)
	    {    
			String url=null;
	        Connection conn=null;
	        try {
	            //Class.forName("com.mysql.jdbc.Driver");        	            
	            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
	            Properties props = new Properties();
	            props.setProperty("user", "db2inst1");
//	            props.setProperty("password", "50%JV@L");	
	            props.setProperty("password", "db2inst1");
	            if(env.equals("uat1")||env.equals("UAT1")) {
		               url="jdbc:db2://10.10.0.180:50001/hbcfc:currentSchema=CMISUAT1;";
		            }else if(env.equals("uat2")||env.equals("UAT2")){
		               url="jdbc:db2://10.10.0.180:50001/hbcfc:currentSchema=CMISUAT2;";
		            }else if(env.equals("cmissit1")||env.equals("CMISSIT1")) {
		               url="jdbc:db2://10.10.0.38:50001/hbcfc:currentSchema=CMISSIT1;";
		               props.setProperty("password", "db2inst1");
		            }else if(env.equals("cmissit2")||env.equals("CMISSIT2")) {
		            	url="jdbc:db2://10.10.0.38:50001/hbcfc:currentSchema=CMISSIT2;";
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("gllosit1")||env.equals("GLLOSIT1")) {
		            	url="jdbc:db2://10.10.0.38:50001/hbcfc:currentSchema=GLLOSIT1;";
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("wfwuat")||env.equals("WFWUAT")){
		            	//url="jdbc:db2://10.10.0.106:50000/hbcfc:currentSchema=MSALMTUT;";
		            	url="jdbc:db2://10.200.10.72:50000/hbcfc:currentSchema=MSALMUT1;";
		            	props.setProperty("user", "db2inst1");
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("wfw")||env.equals("WFW")){
		            	url="jdbc:db2://10.10.0.38:50001/hbcfc:currentSchema=CMISMSA;";
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("yxuat")||env.equals("YXUAT")){
		            	url="jdbc:db2://10.200.10.4:50000/hbcfc:currentSchema=YXUAT;";
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("yxsit")||env.equals("YXSIT")){
		            	url="jdbc:db2://10.200.10.4:50000/hbcfc:currentSchema=YXSIT;";
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("yxcfc")||env.equals("YXCFC")){		            	
		            	url="jdbc:db2://10.200.9.15:50000/hbcfc:currentSchema=YXCFC;";
		            	props.setProperty("user", "yxcfc");
		            	props.setProperty("password", "yxcfc");
		            }else if(env.equals("gllouat1")||env.equals("GLLOUAT1")){
		            	url="jdbc:db2://10.10.0.180:50001/hbcfc:currentSchema=GLLOUAT1;";
		            }else if(env.equals("glloans")||env.equals("GLLOANS")){
		            	url="jdbc:db2://10.10.0.180:50001/hbcfc:currentSchema=GLLOANS;";
		            }else if(env.equals("CMIS")||env.equals("cmis")){
		            	url="jdbc:db2://10.10.0.180:50001/hbcfc:currentSchema=CMIS;";
		            }else if(env.equals("press")||env.equals("PRESS")){
		            	url="jdbc:db2://10.200.9.9:50001/hbcfc:currentSchema=CMIS;";
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("pressyxcfc")||env.equals("PRESSYXCFC")){
		            	url="jdbc:db2://10.200.9.43:50000/hbcfc:currentSchema=YXCFC;";
		            	props.setProperty("user", "db2inst1");
		            	props.setProperty("password", "db2inst1");
		            }else if(env.equals("pressglloans")||env.equals("PRESSGLLOANS")){
		            	url="jdbc:db2://10.200.9.9:50001/hbcfc:currentSchema=GLLOANS;";
		            	props.setProperty("user", "db2inst1");
		            	props.setProperty("password", "db2inst1");
		            }
	                 
	             conn=DriverManager.getConnection(url,props);           	            
	        }catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
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
	    
	    public  static String excuteQuery(String table,String condition,String conditionValue,String column) {
	           Connection conn = createConn("uat1");
//	           String sql="select * from "+Database+"."+table +" where "+condition+"='"+conditionValue+"'";
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
	           Connection conn = createConn(env);
		        String value = null;
		        PreparedStatement ps;
		        try {
		            ps = conn.prepareStatement(sql);
	            try {
	                ResultSet rs=ps.executeQuery();
	                
	                while(rs.next())
	                {    
	                	value=rs.getString(column);
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
		
	    public  static void update(String sql) {
	           Connection conn = createConn("uat1");
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
	    
	    
	    public  static void update(String env,String sql) {
	           Connection conn = createConn(env);
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
		

	 public static void main(String[] args) {
		 
		String value= DB2Tool.excuteQuery("lc_appl", "APPL_CDE", "100000202711170387864", "APPL_SEQ");
		System.out.println("=========================="+value+"===============================");
		/* 
	  try {
	   Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
//	   String url = "jdbc:db2://10.10.0.30:50001/HBCFC";
	   String url="jdbc:db2://10.10.0.30:50001/hbcfc:currentSchema=YXUAT;";
	   String user = "db2inst1";
	   String password = "db2inst130";
	   System.out.println("try");
	   Connection conn = DriverManager.getConnection(url, user, password);
	   System.out.print("Done!OK!!! ");
	   
	   Statement stmt = conn.createStatement();
	   ResultSet rs = stmt.executeQuery("select * from CF_APPL");
	   while (rs.next()) {
	    String id = rs.getString("APPL_CDE");
	    String APPLCDE = rs.getString("APPLCDE");
	    System.out.println(id + " , " + APPLCDE);
	   }
	   stmt.close();
	   conn.close();
	  } catch (Exception e1) {
	   e1.printStackTrace();
	  }  
	  */
	 }
	}
