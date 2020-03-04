package com.revature.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

public class SqsUtil {
	
	private BasicAWSCredentials awsCreds = new BasicAWSCredentials(
													System.getenv("MESSAGING_ACCESS_KEY"), 
													System.getenv("MESSAGING_ACCESS_SECRET_KEY"));
	
	private final String QUEUE_URL = System.getenv("MESSAGING_QUEUE_URL");
	
	private AmazonSQS sqsClient;
	
	{
		sqsClient = AmazonSQSClient.builder()
								   .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
								   .withRegion(System.getenv("MESSAGING_REGION"))
								   .build();
	}
	
	public SqsUtil() {
		System.out.println(System.getenv("MESSAGING_ACCESS_KEY"));
		System.out.println(System.getenv("MESSAGING_ACCESS_SECRET_KEY"));
		System.out.println(System.getenv("MESSAGING_REGION"));
		System.out.println(System.getenv("MESSAGING_TOPIC_ARN"));
		System.out.println(System.getenv("MESSAGING_QUEUE_URL"));
	}
	
	public ReceiveMessageResult poll() {
		ReceiveMessageRequest msgReq = new ReceiveMessageRequest(QUEUE_URL);
		msgReq.setVisibilityTimeout(15);
		ReceiveMessageResult message = sqsClient.receiveMessage(msgReq);
		return message;
	}
	
	public void deleteMessage(String receiptHandle) {
		DeleteMessageRequest delReq = new DeleteMessageRequest(QUEUE_URL, receiptHandle);
		sqsClient.deleteMessage(delReq);
	}

}
