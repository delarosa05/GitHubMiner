package Controller;

import Models.GitMiner.CommitGM;
import Models.GitMiner.IssueGM;
import Models.GitMiner.ProjectGM;
import Models.Projects.Project;
import Parsers.CommitParser;
import Parsers.IssueParser;
import org.springframework.web.bind.annotation.*;


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


        Project request = Services.ProjectService.getProject(owner, repo);
        List<CommitGM> commitGMS = CommitParser.parseCommit(owner, repo, sinceCommits);
        List<IssueGM> issueGMS = IssueParser.parseIssue(owner, repo);


        //Falta lista de commits y lista de issues
        return new ProjectGM(request.getId(), request.getName(), request.getUrl(), commitGMS, issueGMS);
    }
}
