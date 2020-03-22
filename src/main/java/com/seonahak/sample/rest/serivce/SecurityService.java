package com.seonahak.sample.rest.serivce;

public interface SecurityService {
	String createToken(String subject, long ttlMillis);

	String getSubject(String token);
}
