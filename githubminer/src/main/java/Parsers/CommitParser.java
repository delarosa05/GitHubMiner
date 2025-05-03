package Parsers;

import Models.Commits.Commit;
import Models.GitMiner.CommitGM;
import Models.Projects.Project;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommitParser {

    public static List<CommitGM> parseCommit(String owner, String repo, int sinceCommits) {
        List<CommitGM> commitGMS = new ArrayList<>();

        // Calcular la fecha límite restando los días del sinceCommits
        ZonedDateTime limite = ZonedDateTime.now().minusDays(sinceCommits);

        for (Commit commit : Services.CommitService.getAllCommits(owner, repo)) {
            String authored_date = commit.getCommit().getAuthor().getDate();
            ZonedDateTime commitDate = ZonedDateTime.parse(authored_date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            // Filtrar commits antiguos
            if (commitDate.isBefore(limite)) {
                continue;
            }
            String id = commit.getNodeId();
            String message = commit.getCommit().getMessage();
            String title = message.split("\n")[0];  // Título es la primera línea del mensaje
            String authored_name = commit.getCommit().getAuthor().getName();
            String authored_email = commit.getCommit().getAuthor().getEmail();
            String web_url = commit.getUrl().toString();

            CommitGM commitGM = new CommitGM(id, title, message, authored_name, authored_email, authored_date, web_url);
            commitGMS.add(commitGM);
        }

        return commitGMS;
    }
}