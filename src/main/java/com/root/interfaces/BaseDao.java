package com.root.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
 
public class BaseDao {
 
    private static String DRIVDR;
    private static String URL;
    private static String USER;
    private static String PWD;
    private static Connection connection;
    private static Properties properties = new Properties();
    private static Logger logger = Logger.getLogger(BaseDao.class);
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static final String CLASS_NOT_EXCEPTION = "驱动加载失败";
 
    static {
        try {
            properties.load(BaseDao.class.getResourceAsStream("/config/config.properties"));
            DRIVDR = properties.getProperty("jdbc.driver");
            URL = properties.getProperty("jdbc.url");
            USER = properties.getProperty("jdbc.user");
            PWD = properties.getProperty("jdbc.password");
            Class.forName(DRIVDR);
        } catch (Exception e) {
            logger.debug(CLASS_NOT_EXCEPTION + e.getMessage());
        }
 
    }
 
    /**
     * 通用的增删改
     * 
     * @param sql
     * @param args
     * @return
     */
    public static int executeCommand(String sql, Object... args) {
        int m = 0;
        try {
             initPreparedStatement(sql, args);
            m = pst.executeUpdate();
        } catch (Exception e) {
            logger.debug("执行增、删、该。错误。。请检查preparedStatement参数。。。"+e.getMessage());
        } finally {
            closeAll(null, pst, connection);
        }
        return m;
    }
 
     private static PreparedStatement initPreparedStatement(String sql,Object...args){
         try {
                pst=getConnection().prepareStatement(sql);
                if(args!=null){
                    for(int i=0;i<args.length;i++){
                         pst.setObject(i+1, args[i]);
                    }
                }
                 
            } catch (Exception e) {
                 logger.debug("为pst对象赋值错误。。请检查preparedStatement参数。。。"+e.getMessage());
            }
         return pst;
     }
    /**
     * 通用的执行聚合函数
     * @param sql
     * @param args
     * @return
     */
    public static int executeScalare(String sql,Object...args){
            int count=0;
            initPreparedStatement(sql, args);
            try {
                rs=pst.executeQuery();
                if(rs.next()){
                    count=rs.getInt(1);
                }
            } catch (SQLException e) {
                logger.debug("执行聚合函数出错。。。请检查preparedStatement参数。。。"+e.getMessage());
            }finally{
                closeAll(rs, pst, connection);
            }
           return count;
         
    }
     
     
     /**
      * 根据id查询单个对象
      * @param sql
      * @param clazz
      * @param args
      * @return
      */
     public static <T> T findById(String sql,Class<T> clazz,Object...args){
         T t = null;
            try {
                initPreparedStatement(sql, args);
                rs = pst.executeQuery();
 
                ResultSetMetaData metaData = rs.getMetaData();
                // 以上的代码：获取元数据（各个字段的数据类型）
                int count = metaData.getColumnCount();
                // 获取字段的数量
 
                if(rs.next()) {
                    try {
                        t = clazz.newInstance();// 利用反射自动创建对象的类型的对象 User.class User
                                                // u=new User();
                        for (int i = 1; i <= count; i++) {
                            BeanUtils.copyProperty(t, metaData.getColumnName(i), rs.getObject(i));
                            // 自动获取各个字段的名称并获取该字段的值
                        }
                    } catch (Exception e) {
                        logger.debug("查询单个对象，错误。。请检查preparedStatement参数。。。。"+e.getMessage());
                    }
 
                     
                }
 
            } catch (SQLException e) {
                logger.debug("查询失败。。。。。" + e.getMessage());
            }
         return t;
     }
     
    /**
     * 通用的查询
     * 
     * @param sql
     * @param clazz
     * @param args
     * @return
     */
    public static <T> List<T> findAll(String sql, Class<T> clazz, Object... args) {
        List<T> list = new ArrayList<T>(100);
        T t = null;
        try {
            initPreparedStatement(sql, args);
            rs = pst.executeQuery();
 
            ResultSetMetaData metaData = rs.getMetaData();
            // 以上的代码：获取元数据（各个字段的数据类型）
            int count = metaData.getColumnCount();
            // 获取字段的数量
 
            while (rs.next()) {
                try {
                    t = clazz.newInstance();// 利用反射自动创建对象的类型的对象 User.class User
                                            // u=new User();
                    for (int i = 1; i <= count; i++) {
                        BeanUtils.copyProperty(t, metaData.getColumnName(i), rs.getObject(i));
                        // 自动获取各个字段的名称并获取该字段的值
                    }
                } catch (Exception e) {
                    logger.debug("查询集合，错误。。。。。"+e.getMessage());
                }
 
                list.add(t);// 将对象添加到集合中
            }
 
        } catch (SQLException e) {
            logger.debug("查询失败。。。。。" + e.getMessage());
        }
 
        return list;
    }
 
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PWD);
            }
        } catch (SQLException e) {
            logger.debug("获取connection失败，请检查配置文件！" + e.getMessage());
        }
        return connection;
    }
 
    public static void closeAll(ResultSet rs, PreparedStatement pst, Connection conn) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                logger.debug("关闭ResultSet错误。。。。。" + e.getMessage());
            }
        if (pst != null)
            try {
                pst.close();
            } catch (SQLException e) {
                logger.debug("关闭PreparedStatement错误。。。。。" + e.getMessage());
            }
        if (conn != null)
            closeConnection(conn);
    }
 
    private static void closeConnection(Connection conn) {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.debug("关闭Connection错误。。。。。" + e.getMessage());
        } finally {
            conn = null;
        }
 
    }
 
    public static void main(String[] args) {
        System.out.println(BaseDao.getConnection());
    }
}
