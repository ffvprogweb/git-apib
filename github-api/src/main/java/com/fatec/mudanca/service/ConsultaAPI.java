package com.fatec.mudanca.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ConsultaAPI {
	Logger logger = LogManager.getLogger(ConsultaAPI.class);

	public ResponseEntity<String> consulta() {
		logger.info(">>>>>>executou a chamada 1");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result=null;
		//final String baseUrl = "https://api.github.com/users/ffvprogweb/repos";
		final String baseUrl = "https://api.github.com/users/ffvprogweb/repos";
		URI uri=null;
		logger.info(">>>>>>executou a chamada 2");
		try {
			//uri = new URI(baseUrl);
			result = restTemplate.getForEntity(baseUrl, String.class);
			logger.info(">>>>>>executou a chamada 3" + result.getStatusCode().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		
		logger.info(">>>>>>executou a chamada 4" );
		return result;
	}
}
