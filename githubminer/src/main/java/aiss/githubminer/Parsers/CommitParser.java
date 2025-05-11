package aiss.githubminer.Parsers;

import aiss.githubminer.Models.GitMiner.Commit;
import aiss.githubminer.Services.CommitService;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommitParser {

    public static List<Commit> parseCommit(String owner, String repo, int sinceCommits, int maxpages) {
        List<Commit> commitsGM = new ArrayList<>();

        // Calcular la fecha límite restando los días del sinceCommits
        ZonedDateTime limite = ZonedDateTime.now(ZoneOffset.UTC).minusDays(sinceCommits);  // Usamos UTC aquí
        aiss.githubminer.Models.Commits.Commit[] commits = CommitService.getAllCommits(owner, repo, maxpages);
        System.out.println("Number of commits fetched: " + commits.length);

        for (aiss.githubminer.Models.Commits.Commit commit : commits) {

            String authored_date = commit.getCommit().getAuthor() != null ? commit.getCommit().getAuthor().getDate() : "";
            if (authored_date.isEmpty()) {
                continue;  // Si la fecha es nula, saltamos este commit
            }

            ZonedDateTime commitDate = ZonedDateTime.parse(authored_date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            commitDate = commitDate.withZoneSameInstant(ZoneOffset.UTC);  // Convertir commitDate a UTC

            System.out.println("Commit date: " + commitDate + " | Limit date: " + limite);

            // Filtrar commits antiguos
            if (commitDate.isBefore(limite)) {
                continue;  // Si el commit es anterior a la fecha límite, lo ignoramos
            }

            String id = commit.getNodeId();
            String message = commit.getCommit().getMessage();
            String title = message.split("\n")[0];  // Título es la primera línea del mensaje
            String authored_name = commit.getCommit().getAuthor() != null ? commit.getCommit().getAuthor().getName() : "Unknown";
            String authored_email = commit.getCommit().getAuthor() != null ? commit.getCommit().getAuthor().getEmail() : "Unknown";
            String web_url = commit.getUrl().toString();

            Commit commitGM = new Commit(id, title, message, authored_name, authored_email, authored_date, web_url);
            System.out.println("CommitGM created: " + commitGM);  // Verifica si se crea correctamente

            commitsGM.add(commitGM);
        }

        System.out.println("Total CommitGM count: " + commitsGM.size());  // Verifica el tamaño de la lista
        return commitsGM;
    }


}