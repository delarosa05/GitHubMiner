package aiss.githubminer.Controller;

import aiss.githubminer.Models.GitMiner.CommitGM;
import aiss.githubminer.Models.GitMiner.IssueGM;
import aiss.githubminer.Models.GitMiner.ProjectGM;
import aiss.githubminer.Models.Projects.Project;
import aiss.githubminer.Parsers.CommitParser;
import aiss.githubminer.Parsers.IssueParser;
import aiss.githubminer.Services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/github")
public class ProjectController {


    @GetMapping("/{owner}/{repo}")
    public ProjectGM getProject(@PathVariable String owner,
                                @PathVariable String repo,
                                @RequestParam(defaultValue = "2") int sinceCommits,
                                @RequestParam(defaultValue = "20") int sinceIssues,
                                @RequestParam(defaultValue = "2") int maxPages) {

        System.out.println("Getting project");

        // Validar que el request no sea null
        Project request = ProjectService.getProject(owner, repo);
        System.out.println(request);
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }

        // Asegurarse de que los commits sean obtenidos correctamente
        //--------------- COMMIT SE OBTIENE CORRECTAMENTE ----------------------
        List<CommitGM> commitGMS;
        try {
            commitGMS = CommitParser.parseCommit(owner, repo, sinceCommits);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error parsing commits", e);
        }
        // Asegurarse de que los issues sean obtenidos correctamente
        // Issues, comments e Users se OBTIENEN CORRECTAMENTE
        List<IssueGM> issueGMS;
        try {
            issueGMS = IssueParser.parseIssue(owner, repo, sinceIssues);
            System.out.println("Issues = " + issueGMS);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error parsing issues", e);
        }

        // Crear y devolver el ProjectGM con datos válidos
        ProjectGM res = ProjectGM.of(request.getId(), request.getName(), request.getUrl(), commitGMS, issueGMS);
        System.out.println(res);
        return res;
    }

}
