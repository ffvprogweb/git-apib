package com.fatec.mudanca;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fatec.mudanca.service.ConsultaAPI;
@SpringBootTest
class ConsultaGit {
	Logger logger = LogManager.getLogger(ConsultaAPI.class);
   @Autowired
   ConsultaAPI consulta;
	@Test
	void test() throws Exception {
		
		ResponseEntity<String> result = consulta.consulta();
		String repositorios = result.getBody().toString();
		System.out.println(repositorios.toString());
		logger.info(">>>>>>executou teste 1");
		assertFalse(repositorios.isEmpty());
		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertEquals(true, result.getBody().contains("scel"));
	}
	@Test
	void test2() throws Exception {
	
		RestTemplate template = new RestTemplate();
		String url = "https://api.github.com/repos/ffvprogweb/tssscelrestci/stats/commit_activity";
		String result = template.getForObject(url, String.class);
//		logger.info(">>>>>> 3. obtem endereco ==> " + endereco.toString());
//		return endereco.getLogradouro();
	}
}
