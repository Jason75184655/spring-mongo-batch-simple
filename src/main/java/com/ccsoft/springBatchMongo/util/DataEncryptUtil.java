package com.ccsoft.springBatchMongo.util;

import java.security.MessageDigest;


/**
  * TODO MD5加密工具
  * @date 2015年11月13日
  * @author huangyongchao
 */
public class DataEncryptUtil {

	/**
	 * 将字符串转换成MD5算法加密
	 * @param inputStr
	 * @return
	 */
	public static synchronized String encryptMd5(String inputStr) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(inputStr.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(Integer.toHexString((int) (b & 0xff)));
			}

			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args){
	        System.out.println(DataEncryptUtil.encryptMd5("111111"));
	}
}
