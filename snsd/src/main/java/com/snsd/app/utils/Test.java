package com.snsd.app.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String authInfo = "YWRtaW46d2VsY29tZQ==";
		// Decode the data back to original string
		byte[] bytes = null;
		try {
			bytes = new BASE64Decoder().decodeBuffer(authInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String decodedAuth = new String(bytes);
		
		System.out.println("decodedAuth:"+decodedAuth);
	}

}
