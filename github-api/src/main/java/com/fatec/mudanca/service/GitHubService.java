package com.fatec.mudanca.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fatec.mudanca.model.Commit;
import com.fatec.mudanca.model.CommitDetails;

@Service
public class GitHubService {

	private final RestTemplate restTemplate;

	private final DateTimeFormatter outputFormatter;

	public GitHubService() {
		this.restTemplate = new RestTemplate();
		// this.inputFormatter = DateTimeFormatter.ISO_INSTANT;
		this.outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	}

	public List<CommitDetails> getCommits(String repoUrl) {
		
	
		try {
			String[] parts = repoUrl.split("/");
			String owner = parts[parts.length - 2];
			String repo = parts[parts.length - 1];
			String apiUrl = String.format("https://api.github.com/repos/%s/%s/commits", owner, repo);
			RestTemplate restTemplate = new RestTemplate();
			//ResponseEntity<Commit[]> commits = restTemplate.getForEntity(apiUrl, Commit[].class); 
			//Commit[] commits = restTemplate.getForObject(apiUrl, Commit[].class);
			ResponseEntity<Commit[]> commits = restTemplate.exchange(apiUrl, HttpMethod.GET,null, Commit[].class); 
			return Arrays.stream(commits.getBody())
					.map(commit -> new CommitDetails(commit.getCommitDetails().getMessage(),
							formatDate(commit.getCommitDetails().getAuthor().getDate()),
							commit.getCommitDetails().getAuthor().getName()

					)).collect(Collectors.toList());

		} catch (Exception e) {
			List<CommitDetails> lista = new ArrayList<>();
			return lista;
		}
	}

	private String formatDate(String date) {
		Instant instant = Instant.parse(date);
		LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		return outputFormatter.format(dateTime);
	}

}
