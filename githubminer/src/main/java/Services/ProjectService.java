package Services;

import Models.Projects.Project;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ProjectService {

    public static RestTemplate restTemplate = new RestTemplate();
    static String url = "http://api.github.com/repos/";


    public static Project getProject(String owner, String repo) {
        return restTemplate.getForObject(url + owner + "/" + repo, Project.class);
    }

    //incluir funcion post a la API de gitMiner
}
