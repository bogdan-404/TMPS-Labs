package domain.mediator;

import domain.observer.User;

import java.util.ArrayList;
import java.util.List;

public class ChatCoordinator implements ChatMediator {
    private List<ChatRoom> rooms = new ArrayList<>();

    @Override
    public void addRoom(ChatRoom room) {
        rooms.add(room);
    }

    @Override
    public void sendMessage(String message, User user, ChatRoom room) {
        room.broadcastMessage(user.getName() + ": " + message, user);
    }

    @Override
    public void addUserToRoom(User user, ChatRoom room) {
        room.addUser(user);
    }

    @Override
    public void removeUserFromRoom(User user, ChatRoom room) {
        room.removeUser(user);
    }
}