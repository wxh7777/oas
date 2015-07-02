package com.pfkj.oas.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	public static String generateRadom() {
		return String.valueOf(System.nanoTime());
	}

	public static String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(date);
    }
	public static String dateToString10(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
	public static String dateToString14(Date date){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(date);
    }

	public static String dateToStringMx(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
	
	/**
	 * 取得大写形式的字符串
	 * @return
	 */
	public static String getCnString(String original){
		// 整数部分
		String integerPart = "";
		// 小数部分
		String floatPart = "";
		// 将数字转化为汉字的数组,因为各个实例都要使用所以设为静态
		char[] cnNumbers={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
		// 供分级转化的数组,因为各个实例都要使用所以设为静态
		char[] series={'元','拾','百','仟','万','拾','百','仟','亿'};
		if(original.contains(".")){
			// 如果包含小数点
			int dotIndex=original.indexOf(".");
			integerPart=original.substring(0,dotIndex);
			floatPart=original.substring(dotIndex+1);
		}else{
		    // 不包含小数点
		    integerPart=original;
		}
	    // 因为是累加所以用StringBuffer
	    StringBuffer sb=new StringBuffer();
	    // 整数部分处理
	    for(int i=0;i<integerPart.length();i++){
	      int number=getNumber(integerPart.charAt(i));
	      
	      sb.append(cnNumbers[number]);
	      sb.append(series[integerPart.length()-1-i]);
	    }
	    // 小数部分处理
	    if(floatPart.length()>0){
	    	sb.append("点");
	    	for(int i=0;i<floatPart.length();i++){
	        int number=getNumber(floatPart.charAt(i));
	        sb.append(cnNumbers[number]);
	      }
	    }
	    return sb.toString();
	}

	private static int getNumber(char c){
	    String str=String.valueOf(c);   
	    return Integer.parseInt(str);
	}

	/**
	 * 
	 * 获取固定长度字符串
	 * @param length int
	 * @return String
	 */
	public static String getNanoStrByLength(int length){
		String nanoStr = String.valueOf(System.nanoTime());
		if(length<=nanoStr.length()){
			nanoStr =  nanoStr.substring(0,length);
		}else{
			while(nanoStr.length() < length) {
				nanoStr = "1" + nanoStr; 
			}
		}
		return nanoStr;
	}
	
}