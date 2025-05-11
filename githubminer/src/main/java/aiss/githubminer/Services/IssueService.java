package aiss.githubminer.Services;

import aiss.githubminer.Models.Reactions.Comment;
import aiss.githubminer.Models.Commits.Commit;
import aiss.githubminer.Models.Issues.Issue;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IssueService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String url ="https://api.github.com/repos/";
    public static String token ="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";

    public static Issue[] getIssues(String owner, String repo, Integer maxPages) {
        HttpHeaders headers = new HttpHeaders();
        List<Issue> issues = new ArrayList<Issue>();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        for(int i = 1; i<= maxPages; i++) {
            ResponseEntity<Issue[]> response = restTemplate.exchange(url + owner + "/" + repo + "/issues?page="+i, HttpMethod.GET, request, Issue[].class);
            Issue[] paginaActual = response.getBody();
            if (paginaActual == null || paginaActual.length==0) { break;}
            issues.addAll(Arrays.stream(paginaActual).toList());
        }
        return issues.toArray(new Issue[0]); //Aunque ponga 0 se crea del tamaño adecuado internamente
    }

    public static Comment[] getIssueReactions(String owner, String repo, Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        ResponseEntity<Comment[]> response = restTemplate.exchange(url + owner + "/" + repo + "/issues/" + id + "/reactions", HttpMethod.GET, request, Comment[].class);
        return response.getBody();
    }

}
