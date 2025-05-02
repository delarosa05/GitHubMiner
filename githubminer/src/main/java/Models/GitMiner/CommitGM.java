package Models.GitMiner;

public class CommitGM {
    private String id;
    private String title;
    private String message;
    private String author_name;
    private String author_email;
    private String authored_date;
    private String web_url;

    public CommitGM(String id, String title, String message, String author_name, String author_email, String authored_date, String web_url) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author_name = author_name;
        this.author_email = author_email;
        this.authored_date = authored_date;
        this.web_url = web_url;

    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getAuthorName() { return author_name; }
    public String getAuthorEmail() { return author_email; }
    public String getAuthoredDate() { return authored_date; }
    public String getWebUrl() { return web_url; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setMessage(String message) { this.message = message; }
    public void setAuthorName(String author_name) { this.author_name = author_name; }
    public void setAuthorEmail(String author_email) { this.author_email = author_email; }
    public void setAuthoredDate(String authored_date) { this.authored_date = authored_date; }
    public void setWebUrl(String web_url) { this.web_url = web_url; }

}
