/**
 * <p>Copyright (c) 2018 深圳市鹏途交通科技有限公司 </p>
 * <p>				   All right reserved. 		     </p>
 * 
 * <p>项目名称 ： 	深圳市国省检日常化监管系统         </p>
 * <p>创建者   :	hey 
 * 
 * <p>描   述  :   GetPicture.java for com.pachong    </p>
 * 
 * <p>最后修改 : $: Feb 28, 2018-3:24:32 PM v 1.0.0	 hey   $ </p>
 * 
*/

package com.pachong;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * GetPicture
 * 
 * Feb 28, 2018 3:24:32 PM
 * 
 * @version 1.0.0
 * 
 */
public class GetPicture {
	
	public void getHtmlPicture(String httpUrl, String filePath) {  
        URL url;  
        BufferedInputStream in;  
        FileOutputStream file;  
  
        try {  
            System.out.println("爬取网络图片");  
            // 获取图片名  
            String fileName = httpUrl.substring(httpUrl.lastIndexOf("/")).replace("/", "");  
            // 初始化url对象  
            url = new URL(httpUrl);  
            // 初始化in对象，也就是获得url字节流  
            in = new BufferedInputStream(url.openStream());  
            file = new FileOutputStream(new File(filePath + "\\" + fileName));  
            int t;  
            while ((t = in.read()) != -1) {  
                file.write(t);  
            }  
            file.close();  
            in.close();  
            System.out.println("图片爬取成功");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public String getHtmlCode(String httpUrl) throws IOException {  
        String content = "";  
        URL url = new URL(httpUrl);  
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));  
        String input;  
        // 如果有数据  
        while ((input = reader.readLine()) != null) {  
            // 将读取数据赋给content  
            content += input;  
        }  
        // 关闭缓冲区  
        reader.close();  
        // 返回content  
        return content;  
    }  
  
    /** 
     * 图片爬取方法 
     *  
     * @param url 
     * @throws IOException 
     */  
    public void get(String url, String filePath) throws IOException {  
  
        // 定义两个获取网页图片的正则表达式  
        String searchImgReg = "(?x)(src|SRC|background|BACKGROUND)=('|\")/?(([\\w-]+/)*([\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";  
        String searchImgReg2 = "(?x)(src|SRC|background|BACKGROUND)=('|\")(http://([\\w-]+\\.)+[\\w-]+(:[0-9]+)*(/[\\w-]+)*(/[\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";  
  
        String content = this.getHtmlCode(url);  
        Pattern pattern = Pattern.compile(searchImgReg);  
        Matcher matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            System.out.println(matcher.group(3));  
            this.getHtmlPicture(url + "/" + matcher.group(3), filePath);  
        }  
        pattern = Pattern.compile(searchImgReg2);  
        matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            System.out.println(matcher.group(3));  
            this.getHtmlPicture(matcher.group(3), filePath);  
  
        }  
  
    }
	
}
