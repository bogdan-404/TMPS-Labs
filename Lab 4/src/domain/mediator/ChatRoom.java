package domain.mediator;

import domain.observer.User;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String name;
    private List<User> members = new ArrayList<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void broadcastMessage(String message, User sender) {
        for (User user : members) {
            if (!user.equals(sender)) {
                user.update(message);
            }
        }
    }

    public void addUser(User user) {
        members.add(user);
    }

    public void removeUser(User user) {
        members.remove(user);
    }

    public String getName() {
        return name;
    }
}