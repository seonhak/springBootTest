package com.seonahak.sample.rest.ui;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seonahak.sample.rest.serivce.SecurityService;

@RestController
@RequestMapping("/security")
public class HomeController {
	
	@Autowired
	SecurityService securityService;

	@GetMapping("/generate/token")
	public Map<String, Object> generateToken(@RequestParam String subject){
		String token = securityService.createToken(subject, 1000 * 60 * 60);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", subject);
		map.put("token", token);
		return map;
	}
	
	@GetMapping("/get/subject")
	public String getSubejct(@RequestParam String token) {
		String subject = securityService.getSubject(token);
		return subject;
	}
}
