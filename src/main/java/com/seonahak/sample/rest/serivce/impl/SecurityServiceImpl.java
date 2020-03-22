package com.seonahak.sample.rest.serivce.impl;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.management.RuntimeErrorException;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import com.seonahak.sample.rest.serivce.SecurityService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityServiceImpl implements SecurityService{
	
	private static final String secretKey = "test";
	
	@Override
	public String createToken(String subject, long ttlMillis) {
		if(ttlMillis == 0) {
			throw new RuntimeException("토큰 만료기간이 지났습니다");
		}
		
		// HS256 방식으로 암호화 방식 설정
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key signialKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		JwtBuilder builder = Jwts.builder().setSubject(subject).signWith(signatureAlgorithm, signialKey);
		
		long nowMillis = System.currentTimeMillis();
		builder.setExpiration(new Date(nowMillis + ttlMillis));
		return builder.compact();
	}
 
	@Override
	public String getSubject(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}

}
