package aiss.githubminer.Services;

import aiss.githubminer.Models.GitMiner.Project;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProjectService {

    public static RestTemplate restTemplate = new RestTemplate();
    static String url = "https://api.github.com/repos/";


    public static aiss.githubminer.Models.Projects.Project getProject(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        ResponseEntity<aiss.githubminer.Models.Projects.Project> response = restTemplate.exchange(url + owner + "/" + repo , HttpMethod.GET, request, aiss.githubminer.Models.Projects.Project.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    //incluir funcion post a la API de gitMiner

    public static Project postProject(Project project) {
        String gitMinerUrl = "http://localhost:8080/gitminer/projects";
        HttpEntity<Project> request = restTemplate.postForEntity(gitMinerUrl, project, Project.class);
        return request.getBody();
    }
}
