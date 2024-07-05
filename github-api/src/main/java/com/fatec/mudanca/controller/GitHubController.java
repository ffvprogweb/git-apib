package com.fatec.mudanca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mudanca.model.CommitDetails;
import com.fatec.mudanca.service.GitHubService;
import com.fatec.mudanca.service.RepoRequest;
@CrossOrigin
@RestController
public class GitHubController {

	@Autowired
	private GitHubService gitHubService;
	@CrossOrigin("*")
	@PostMapping("/commits")
	public List<CommitDetails> getCommits(@RequestBody RepoRequest repoRequest) {
		String repoUrl = repoRequest.getRepoUrl();
		return gitHubService.getCommits(repoUrl);

	}
}
