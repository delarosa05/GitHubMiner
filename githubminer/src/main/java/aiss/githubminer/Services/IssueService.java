package aiss.githubminer.Services;

import aiss.githubminer.Models.Commits.Commit;
import aiss.githubminer.Models.Issues.Issue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IssueService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String url ="https://api.github.com/repos/";
    public static String token ="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";

    public static Issue[] getIssues(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        ResponseEntity<Issue[]> response = restTemplate.exchange(url + owner + "/" + repo + "/issues", HttpMethod.GET, request, Issue[].class);
        System.out.println(response.getBody());
        return response.getBody();
    }

}
