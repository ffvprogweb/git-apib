package com.fatec.mudanca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mudanca.model.CommitDetails;
import com.fatec.mudanca.service.GitHubService;
import com.fatec.mudanca.service.RepoRequest;

@RestController
public class GitHubController {

	@Autowired
	private GitHubService gitHubService;

	@GetMapping("/commits")
	public List<CommitDetails> getCommits(@RequestBody RepoRequest repoRequest) {
		String repoUrl = repoRequest.getRepoUrl();
		return gitHubService.getCommits(repoUrl);

	}
}
