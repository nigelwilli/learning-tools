package com.revature;

import com.revature.util.SnsUtil;

public class ProducerDriver {
	
	public static void main(String[] args) {
		
		SnsUtil snsUtil = new SnsUtil();
		snsUtil.publish("another test message from Java application!");
		
	}

}
