/**
 * <p>Copyright (c) 2018 深圳市鹏途交通科技有限公司 </p>
 * <p>				   All right reserved. 		     </p>
 * 
 * <p>项目名称 ： 	深圳市国省检日常化监管系统         </p>
 * <p>创建者   :	hey 
 * 
 * <p>描   述  :   JDBCHelper.java for com.pachong    </p>
 * 
 * <p>最后修改 : $: Feb 28, 2018-3:02:06 PM v 1.0.0	 hey   $ </p>
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
 * 
 * Feb 28, 2018 3:02:06 PM
 * 
 * @version 1.0.0
 * 
 */
public class JDBCHelper {
	private static final String driver = "com.mysql.jdbc.Driver";  
    private static final String DBurl = "jdbc:mysql://192.168.0.121:3306/pachong";  
    private static final String user = "root";  
    private static final String password = "123456";  
    private PreparedStatement pstmt = null;  
    private Connection spiderconn = null;  
  
    public void insertFilePath(String fileName, String filepath, String url) {  
        try {  
            Class.forName(driver);  
            spiderconn = DriverManager.getConnection(DBurl, user, password);  
            String sql = "insert into FilePath (id,filename,filepath,url) values (UUID(),?,?,?)";  
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
