package Services;

import Models.Commits.Commit;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class CommitService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String  url = "https://api.github.com/repos/";

    public static Commit[] getAllCommits(String owner, String repo) {
        return restTemplate.exchange(url+owner + "/"+repo, HttpMethod.GET, null, Commit[].class).getBody();
    }


}
