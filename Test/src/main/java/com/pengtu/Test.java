/**
 * <p>Copyright (c) 2018 深圳市鹏途交通科技有限公司 </p>
 * <p>				   All right reserved. 		     </p>
 * 
 * <p>项目名称 ： 	深圳市国省检日常化监管系统         </p>
 * <p>创建者   :	hey 
 * 
 * <p>描   述  :   Test.java for com.pengtu    </p>
 * 
 * <p>最后修改 : $: Feb 24, 2018-11:23:41 AM v 1.0.0	 hey   $ </p>
 * 
*/

package com.pengtu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * 
 * Test
 * 
 * Feb 24, 2018 11:23:41 AM
 * 
 * @version 1.0.0
 * 
 */
public class Test {
	
	public void add(){
		List<String> list = new ArrayList<String>();
	    list.add("111");
	    list.add("222");
	    
	    for (String str : list){
	        System.out.println(str);
	    }
	}
	
	public void move(){
		/**
		 * <<表示位移运算符
		 * 1 << 4表示十进制的1转换为二进制后，将0000 0001的1向左移动四位 即0001 0000 即为16
		 */
		final int a = 1 << 4;  //16
		final int b = 3 << 4;  //48 (0000 0011 ----》  0011 0000) 将表示11的位左移4位
		System.out.println(a);
		System.out.println(b);
	}
	
	public <K, V> void entry(){
		final Entry<?,?>[] EMPTY_TABLE = {};
		Entry<K,V>[] a = (Entry<K,V>[]) EMPTY_TABLE;
	}
	
	public static void main( String[] args )throws IOException, ClassNotFoundException{
//		Test function = new Test();
//		function.add();
//		function.move();
//        System.out.println( "Hello World!" );
        
        
//        LoggingInfo logInfo = new LoggingInfo();
//        logInfo.setUid("MIKE");
//        logInfo.setPwd("MECHANICS");
//        System.out.println(logInfo.toString());   
//        try{   
//           ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("logInfo.out"));   
//           o.writeObject(logInfo);   
//           o.close();   
//        }catch(Exception e){}   
//        
//        //Read Obj from File
//        File file = new File("logInfo.out");
//        ObjectInputStream in = null;
//        try{   
//           in =new ObjectInputStream( new FileInputStream(file));   
//           LoggingInfo a = (LoggingInfo)in.readObject();   
//           System.out.println(a.toString());   
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } 
        
        
        GuestLoggingInfo gulogInfo = new GuestLoggingInfo();   
        System.out.println(gulogInfo.toString());
        try{   
           ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("logInfo.out"));   
           o.writeObject(gulogInfo);   
           o.close();   
        }catch(Exception e){}   
          
        try{   
           ObjectInputStream in =new ObjectInputStream( new FileInputStream("logInfo.out"));   
           GuestLoggingInfo b = (GuestLoggingInfo)in.readObject();   
           System.out.println(b.toString());   
        } catch(Exception e) {}
        
        //System.exit(0);
	}
//	www.cofcosp.com
//	jinshouliang.com
//	kaq291557
//	044832
}
