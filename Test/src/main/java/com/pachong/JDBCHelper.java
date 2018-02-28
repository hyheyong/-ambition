/**
 * <p>Copyright (c) 2018 娣卞湷甯傞箯閫斾氦閫氱鎶�湁闄愬叕鍙�</p>
 * <p>				   All right reserved. 		     </p>
 * 
 * <p>椤圭洰鍚嶇О 锛�	娣卞湷甯傚浗鐪佹鏃ュ父鍖栫洃绠＄郴缁�        </p>
 * <p>鍒涘缓鑰�  :	hey 
 * 
 * <p>鎻�  杩� :   JDBCHelper.java for com.pachong    </p>
 * 
 * <p>鏈�悗淇敼 : $: Feb 28, 2018-3:02:06 PM v 1.0.0	 hey   $ </p>
 * 
*/

package com.pachong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * 
 * JDBCHelper
 *  修改备注
 * Feb 28, 2018 3:02:06 PM
 * 
 * @version 1.0.0
 * 
 */
public class JDBCHelper {
	private static final String driver = "com.mysql.jdbc.Driver";  //数据库驱动
    private static final String DBurl = "jdbc:mysql://192.168.0.121:3306/pachong";  	//数据库地址
    private static final String user = "root";  
    private static final String password = "123456";  
    private PreparedStatement pstmt = null;  
    private Connection spiderconn = null;  
  
    public void insertFilePath(String fileName, String filepath, String url) {  
        try {  
            Class.forName(driver);  
            spiderconn = DriverManager.getConnection(DBurl, user, password);  
            String sql = "insert into FilePath (id,filename,filepath,url) values (UUID(),?,?,?)";  //向FilePath表插入数据
            pstmt = spiderconn.prepareStatement(sql);
            pstmt.setString(1, fileName);  
            pstmt.setString(2, filepath);  
            pstmt.setString(3, url);  
            pstmt.executeUpdate();  
  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                pstmt.close();  
                spiderconn.close();  
            } catch (Exception e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}
