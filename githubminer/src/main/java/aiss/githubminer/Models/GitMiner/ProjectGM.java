package aiss.githubminer.Models.GitMiner;


import java.util.List;

public class ProjectGM {

    private int id;
    private String name;
    private String web_url;
    private List<CommitGM> commits;
    private List<IssueGM> issues;

    public ProjectGM(int id, String name, String web_url, List<CommitGM> commits, List<IssueGM> issues)  {
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commits = commits;
        this.issues = issues;
    }

    public static ProjectGM of(int id, String name, String web_url, List<CommitGM> commits, List<IssueGM> issues) {
        return new ProjectGM(id, name, web_url, commits, issues);
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getWeb_url() { return web_url; }
    public List<CommitGM> getCommits() { return commits; }
    public List<IssueGM> getIssues() { return issues; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setWeb_url(String web_url) { this.web_url = web_url; }

}
