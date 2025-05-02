package Parsers;

import Models.Commits.Commit;
import Models.GitMiner.CommitGM;
import Models.Projects.Project;

import java.util.ArrayList;
import java.util.List;

public class CommitParser {

    public static  List<CommitGM> parseCommit(String owner, String repo) {
        List<CommitGM> commitGMS = new ArrayList<>();
        for (Commit commit : Services.CommitService.getAllCommits(owner, repo)) {
            String id = commit.getNodeId();
            //String title = commit.getCommit().
            String message = commit.getCommit().getMessage();
            String authored_name = commit.getCommit().getAuthor().getName();
            String authored_email = commit.getCommit().getAuthor().getEmail();
            String authored_date = commit.getCommit().getAuthor().getDate();
            String web_url = commit.getUrl().toString();
            //Cambiar el titulo de prueba por uno real
            CommitGM commitGM = new CommitGM(id, "Titulo de prueba", message, authored_name, authored_email, authored_date, web_url);
            commitGMS.add(commitGM);
        }
        return commitGMS;

    }
}