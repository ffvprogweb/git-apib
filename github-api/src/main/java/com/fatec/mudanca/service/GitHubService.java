package com.fatec.mudanca.service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fatec.mudanca.model.Commit;
import com.fatec.mudanca.model.CommitDetails;

@Service
public class GitHubService {

    private final RestTemplate restTemplate;
    private final DateTimeFormatter inputFormatter;
    private final DateTimeFormatter outputFormatter;

    public GitHubService() {
        this.restTemplate = new RestTemplate();
        this.inputFormatter = DateTimeFormatter.ISO_INSTANT;
        this.outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }

    public List<CommitDetails> getCommits(String repoUrl) {
        String[] parts = repoUrl.split("/");
        String owner = parts[parts.length - 2];
        String repo = parts[parts.length - 1];
        String apiUrl = String.format("https://api.github.com/repos/%s/%s/commits", owner, repo);
        
        Commit[] commits = restTemplate.getForObject(apiUrl, Commit[].class);

        return Arrays.stream(commits)
                .map(commit -> new CommitDetails(
                        commit.getCommitDetails().getMessage(),
                        formatDate(commit.getCommitDetails().getAuthor().getDate()),
                        commit.getCommitDetails().getAuthor().getName()
                        
                ))
                .collect(Collectors.toList());
    }

    private String formatDate(String date) {
        Instant instant = Instant.parse(date);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return outputFormatter.format(dateTime);
    }

    
}
