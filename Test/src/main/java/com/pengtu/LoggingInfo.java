/**
 * <p>Copyright (c) 2018 深圳市鹏途交通科技有限公司 </p>
 * <p>				   All right reserved. 		     </p>
 * 
 * <p>项目名称 ： 	深圳市国省检日常化监管系统         </p>
 * <p>创建者   :	hey 
 * 
 * <p>描   述  :   LoginInfo.java for com.pengtu    </p>
 * 
 * <p>最后修改 : $: Feb 25, 2018-2:17:35 PM v 1.0.0	 hey   $ </p>
 * 
*/

package com.pengtu;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * 
 * LoginInfo
 * 
 * Feb 25, 2018 2:17:35 PM
 * 
 * @version 1.0.0
 * 
 */
public class LoggingInfo implements java.io.Externalizable{
	private Date loggingDate = new Date();   
	private String uid;   
	private String pwd;   
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(uid);
		out.writeObject(pwd);
		
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
		uid = (String) in.readObject();
		pwd = (String) in.readObject();
		
	}   
	
}   
