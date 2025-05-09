package Services;

import Models.Issues.Issue;
import org.springframework.web.client.RestTemplate;

public class IssueService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String url ="http://api.github.com/";

    public static Issue[] getIssues(String owner, String repo) {
        return restTemplate.getForObject(url + owner + "/" + repo + "/issues", Issue[].class);
    }

}
