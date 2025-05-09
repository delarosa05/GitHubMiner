package aiss.githubminer.Parsers;

import aiss.githubminer.Models.GitMiner.UserGM;
import aiss.githubminer.Models.Issues.Assignee;
import aiss.githubminer.Models.Users.User;

public class UserParser {

    public static UserGM parseUser(User user) {
        String id = user.getId().toString();
        String username = user.getLogin();
        String name = user.getLogin();
        String avatar_url = user.getAvatarUrl();
        String web_url = user.getUrl();
        return new UserGM(id, username, name, avatar_url, web_url);

    }

    public static UserGM parseAsignee(Assignee user) {
        String id = user.getId().toString();
        String username = user.getLogin();
        String name = user.getLogin();
        String avatar_url = user.getAvatarUrl();
        String web_url = user.getUrl();
        return new UserGM(id, username, name, avatar_url, web_url);

    }
}
