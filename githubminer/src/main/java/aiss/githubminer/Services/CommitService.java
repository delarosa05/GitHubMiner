package aiss.githubminer.Services;

import aiss.githubminer.Models.Comments.Comment;
import aiss.githubminer.Models.Commits.Commit;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommitService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String  url = "https://api.github.com/repos/";

    public static Commit[] getAllCommits(String owner, String repo, int maxPages) {
        HttpHeaders headers = new HttpHeaders();
        List<Commit> commits = new ArrayList<>();
        headers.set("Authorization", "Bearer " + "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");
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        for(int i =1; i<maxPages; i++) {
            ResponseEntity<Commit[]> response = restTemplate.exchange(url + owner + "/" + repo + "/commits", HttpMethod.GET, request, Commit[].class);
            Commit[] paginaActual = response.getBody();
            if (paginaActual == null || paginaActual.length==0) { break;}
            commits.addAll(Arrays.stream(paginaActual).toList());
        }

        return commits.toArray(new Commit[commits.size()]);
    }


}
