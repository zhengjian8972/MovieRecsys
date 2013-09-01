package com.cmri.bcpdm.recsys.util;

import java.security.MessageDigest;

public class MD5Tool {
	
	public final static String mainMD5(String s)
	{ 
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try { 
			byte[] strTemp = s.getBytes(); 
			//使用MD5创建MessageDigest对象 
			MessageDigest mdTemp = MessageDigest.getInstance("MD5"); 
			mdTemp.update(strTemp); 
			//获得密文
			byte[] md = mdTemp.digest(); 
			int j = md.length; 
			char str[] = new char[j * 2]; 
			int k = 0; 
			// 把密文转换成十六进制的字符串形式
			for (int i = 0; i < j; i++) { 
				byte b = md[i]; 	 
				str[k++] = hexDigits[b >> 4 & 0xf]; 
				str[k++] = hexDigits[b & 0xf]; 
			} 
			return new String(str); 
		} catch (Exception e){
			return null;
		} 
		  
	}

	
	public static void main(String [] agrs){
		System.out.println(MD5Tool.mainMD5("123"));
	}
}
