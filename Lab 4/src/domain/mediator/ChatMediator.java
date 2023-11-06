package domain.mediator;

import domain.observer.User;

public interface ChatMediator {
    void sendMessage(String message, User user, ChatRoom room);
    void addUserToRoom(User user, ChatRoom room);
    void removeUserFromRoom(User user, ChatRoom room);
    void addRoom(ChatRoom room);
}