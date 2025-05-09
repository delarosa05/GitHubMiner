package aiss.githubminer.Services;

import aiss.githubminer.Models.Comments.Comment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CommentService {
    public static RestTemplate restTemplate = new RestTemplate();

    public static Comment[] getAllCommentsIssue(String owner, String repo, int issueId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues/" + issueId + "/comments";
        ResponseEntity<Comment[]> response = restTemplate.exchange(url, HttpMethod.GET, request, Comment[].class);
        System.out.println(response.getBody());
        return response.getBody();
    }



}
