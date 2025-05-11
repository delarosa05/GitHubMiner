package aiss.githubminer.Parsers;

import aiss.githubminer.Models.GitMiner.User;
import aiss.githubminer.Models.Issues.Assignee;

public class UserParser {

    public static User parseUser(aiss.githubminer.Models.Users.User user) {
        String id = user.getId().toString();
        String username = user.getLogin();
        String name = user.getLogin();
        String avatar_url = user.getAvatarUrl();
        String web_url = user.getUrl();
        return new User(id, username, name, avatar_url, web_url);

    }

    public static User parseAsignee(Assignee user) {
        String id = user.getId().toString();
        String username = user.getLogin();
        String name = user.getLogin();
        String avatar_url = user.getAvatarUrl();
        String web_url = user.getUrl();
        return new User(id, username, name, avatar_url, web_url);

    }
}
