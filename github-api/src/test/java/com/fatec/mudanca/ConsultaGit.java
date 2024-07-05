package com.fatec.mudanca;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URISyntaxException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import com.fatec.mudanca.model.CommitDetails;
import com.fatec.mudanca.service.ConsultaAPI;
import com.fatec.mudanca.service.GitHubService;

@SpringBootTest
class ConsultaGit {
	Logger logger = LogManager.getLogger(ConsultaAPI.class);
  	
	@Test
	void ct01_quando_repositorio_valido_retorna_msg_de_commits(){
		GitHubService git = new GitHubService();
		List<CommitDetails> commitsRetornados = git.getCommits("https://github.com/ffvprogweb/dsm-cap05-backend");
		
	//	commitsRetornados.forEach(message -> System.out.println("Data do commit=> " +  message.getDate() 
	//	                                                      + " Msg: " + message.getMessage()
	//	                                                      + " \t Nome: " + message.getName()));
		assertFalse(commitsRetornados.isEmpty());
	}
	@Test
	void ct02_quando_repositorio_in_valido_retorna_vazio(){
		GitHubService git = new GitHubService();
		List<CommitDetails> commitsRetornados = git.getCommits("https://github.com/ffvprogweb/dsm-cap05-backend1");
		assertTrue(commitsRetornados.isEmpty());
	}
}
