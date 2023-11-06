package domain.observer;

import domain.mediator.ChatMediator;
import domain.mediator.ChatRoom;
import domain.command.Command;
import domain.command.SendMessageCommand;

public class User implements ChatObserver {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message, ChatRoom room) {
        Command command = new SendMessageCommand(mediator, this, message, room);
        command.execute();
    }

    @Override
    public void update(String message) {
        System.out.println(name + ": " + message);
    }

    @Override
    public void notify(String announcement) {
        System.out.println(name + " received announcement: " + announcement);
    }

    public String getName() {
        return name;
    }
}