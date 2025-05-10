package aiss.githubminer.Services;

import aiss.githubminer.Models.Commits.Commit;
import aiss.githubminer.Models.GitMiner.ProjectGM;
import aiss.githubminer.Models.Projects.Project;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProjectService {

    public static RestTemplate restTemplate = new RestTemplate();
    static String url = "https://api.github.com/repos/";


    public static Project getProject(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        ResponseEntity<Project> response = restTemplate.exchange(url + owner + "/" + repo , HttpMethod.GET, request, Project.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    //incluir funcion post a la API de gitMiner

    public static ProjectGM postProject(ProjectGM project) {
        String gitMinerUrl = "https://localhost:8080/repos/";
        HttpEntity<ProjectGM> request = restTemplate.postForEntity(gitMinerUrl, project, ProjectGM.class);
        return request.getBody();
    }
}
