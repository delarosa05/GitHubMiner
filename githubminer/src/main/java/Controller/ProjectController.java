package Controller;

import Models.GitMiner.CommitGM;
import Models.GitMiner.IssueGM;
import Models.GitMiner.ProjectGM;
import Models.Projects.Project;
import Parsers.CommitParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    @GetMapping("/{owner}/{repo}")
    public Project getProject(String owner, String repo) { return Services.ProjectService.getProject(owner, repo); }

    @PostMapping("/{owner}/{repo}")
    public ProjectGM postProject(String owner, String repo) {
        Project request = getProject(owner, repo);
        List<CommitGM> commitGMS = CommitParser.parseCommit(owner, repo);
        List<IssueGM> issueGMS = new ArrayList<>();


        ProjectGM projectGM = new ProjectGM(request.getId(), request.getName(), request.getUrl()); //Falta lista de commits y lista de issues
        return projectGM;
    }
}
