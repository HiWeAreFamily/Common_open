package utils;

import java.io.UnsupportedEncodingException;

public class Utf_8 {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String a = "\u5229\u7528log4j\u4E3A\u8F93\u51FA\u4ECB\u8D28";
		System.out.println(new String(a.getBytes(), "utf-8"));
	}

}
