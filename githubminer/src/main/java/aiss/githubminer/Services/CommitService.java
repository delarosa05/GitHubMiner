package aiss.githubminer.Services;

import aiss.githubminer.Models.Comments.Comment;
import aiss.githubminer.Models.Commits.Commit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CommitService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String  url = "https://api.github.com/repos/";

    public static Commit[] getAllCommits(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(url + owner + "/" + repo + "/commits", HttpMethod.GET, request, Commit[].class);
        System.out.println(response.getBody());
        return response.getBody();
    }


}
