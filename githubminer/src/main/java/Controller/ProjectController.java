package Controller;

import Models.GitMiner.CommitGM;
import Models.GitMiner.IssueGM;
import Models.GitMiner.ProjectGM;
import Models.Projects.Project;
import Parsers.CommitParser;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    @GetMapping("/{owner}/{repo}")
    public Project getProject(String owner, String repo) { return Services.ProjectService.getProject(owner, repo); }

    @PostMapping("/{owner}/{repo}")
    public ProjectGM postProject(@PathVariable String owner,
                                 @PathVariable String repo,
                                 @RequestParam(defaultValue = "2") int sinceCommits,
                                 @RequestParam(defaultValue = "20") int sinceIssues,
                                 @RequestParam(defaultValue = "2") int maxPages) {

        Project request = getProject(owner, repo);
        List<CommitGM> commitGMS = CommitParser.parseCommit(owner, repo, sinceCommits);
        List<IssueGM> issueGMS = new ArrayList<>();


        ProjectGM projectGM = new ProjectGM(request.getId(), request.getName(), request.getUrl()); //Falta lista de commits y lista de issues
        return projectGM;
    }
}
