package com.revature.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class SnsUtil {
	
	private BasicAWSCredentials awsCreds = new BasicAWSCredentials(
													System.getenv("MESSAGING_ACCESS_KEY"), 
													System.getenv("MESSAGING_ACCESS_SECRET_KEY"));
	private AmazonSNS snsClient;
	
	{
		snsClient = AmazonSNSClient.builder()
				 .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				 .withRegion(System.getenv("MESSAGING_REGION"))
				 .build();
	}
	
	public SnsUtil() {
		System.out.println(System.getenv("MESSAGING_ACCESS_KEY"));
		System.out.println(System.getenv("MESSAGING_ACCESS_SECRET_KEY"));
		System.out.println(System.getenv("MESSAGING_REGION"));
		System.out.println(System.getenv("MESSAGING_TOPIC_ARN"));
		System.out.println(System.getenv("MESSAGING_QUEUE_URL"));
	}
	
	public void publish(String message) {
		PublishRequest pubReq = new PublishRequest(System.getenv("MESSAGING_TOPIC_ARN"), message);
		PublishResult pubResult = snsClient.publish(pubReq);
		System.out.println("Message ID for published value: " + pubResult.getMessageId());
	}

}
