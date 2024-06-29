package com.fatec.mudanca;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URISyntaxException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fatec.mudanca.model.CommitDetails;
import com.fatec.mudanca.service.ConsultaAPI;
import com.fatec.mudanca.service.GitHubService;
//https://docs.github.com/en/rest/reference/repos#statuses
@SpringBootTest
class ConsultaGit {
	Logger logger = LogManager.getLogger(ConsultaAPI.class);
  	
	@Test
	void consultaCommits(){
		GitHubService git = new GitHubService();
		List<CommitDetails> commitsRetornados = git.getCommits("https://github.com/ffvprogweb/ads2-cap07-sigvs");
		logger.info(">>>>>> 4. obtem a mensagem ==> " + commitsRetornados.get(0).toString());
		commitsRetornados.forEach(message -> System.out.println("Data do commit=> " +  message.getDate() + " Msg: " + message.getMessage()));
	}
}
