/**
 * <p>Copyright (c) 2018 深圳市鹏途交通科技有限公司 </p>
 * <p>				   All right reserved. 		     </p>
 * 
 * <p>项目名称 ： 	深圳市国省检日常化监管系统         </p>
 * <p>创建者   :	hey 
 * 
 * <p>描   述  :   GuestLoggingInfo.java for com.pengtu    </p>
 * 
 * <p>最后修改 : $: Feb 25, 2018-2:47:07 PM v 1.0.0	 hey   $ </p>
 * 
*/

package com.pengtu;

import java.util.Date;

/**
 * 
 * GuestLoggingInfo
 * 
 * Feb 25, 2018 2:47:07 PM
 * 
 * @version 1.0.0
 * 
 */
public class GuestLoggingInfo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Date loggingDate = new Date();   
	private String uid; 
	
	/**
	 * transient 关键字，表示对象pwd没有被序列化，也就是说
	 */
	private transient String pwd;   
	
	GuestLoggingInfo(){   
        uid = "MAIK";   
        pwd = "MECHANICS";   
    }   
	
	public String toString(){   
		String password=null;   
		if(pwd == null){   
			password = "NOT SET";   
		}else{   
			password = pwd;   
		}   
		return "logon info: \n   " + "user: " + uid +   
				"\n   logging date : " + loggingDate.toString() +   
				"\n   password: " + password;   
	}   
	
}
