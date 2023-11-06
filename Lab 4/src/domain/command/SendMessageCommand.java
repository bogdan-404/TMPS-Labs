package domain.command;

import domain.mediator.ChatMediator;
import domain.observer.User;
import domain.mediator.ChatRoom;

public class SendMessageCommand implements Command {
    private ChatMediator mediator;
    private User user;
    private String message;
    private ChatRoom room;

    public SendMessageCommand(ChatMediator mediator, User user, String message, ChatRoom room) {
        this.mediator = mediator;
        this.user = user;
        this.message = message;
        this.room = room;
    }

    @Override
    public void execute() {
        mediator.sendMessage(message, user, room);
    }
}