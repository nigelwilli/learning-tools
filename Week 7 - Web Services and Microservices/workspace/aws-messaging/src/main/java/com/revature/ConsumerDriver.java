package com.revature;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.revature.util.SqsUtil;

public class ConsumerDriver {

	public static void main(String[] args) {
	
		SqsUtil sqsUtil = new SqsUtil();
		ReceiveMessageResult messageResult = sqsUtil.poll();
		
		for(Message msg : messageResult.getMessages()) {
			System.out.println(msg + "\n");
		}
		
		sqsUtil.deleteMessage(messageResult.getMessages().get(0).getReceiptHandle());
		
	}
}
