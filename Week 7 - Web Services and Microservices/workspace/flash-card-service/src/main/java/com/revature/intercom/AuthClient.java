package com.revature.intercom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
	name="auth-service"
)
@RequestMapping("/test")
public interface AuthClient {

	@GetMapping(produces = "text/plain")
	public String test();
	
	@GetMapping(value="/orangeHex", produces = "text/plain")
	public String orange();

}
