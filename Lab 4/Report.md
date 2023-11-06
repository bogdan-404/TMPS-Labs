# Behavioral Design Patterns

## Author: Zlatovcen Bogdan

---

## Objectives:

- Study and understand the Behavioral Design Patterns.

- Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.

- Use 3 behavioral design patterns for object instantiation in a sample project.

## Implementation

### Command Pattern

The `Command` interface declares a method for executing a command.

```java
public interface Command {
    void execute();
}
```

`SendMessageCommand` is a concrete command that implements the `Command` interface. It has the responsibility to send a message within a chat room.

```java
@Override
public void execute() {
    mediator.sendMessage(message, user, room);
}
```

In `User` class, the send method creates a new `SendMessageCommand` and executes it. This encapsulates the action of sending a message as an executable command.

### Mediator Pattern

The Mediator pattern is used to reduce coupling between classes that communicate with each other. Instead of classes communicating directly, and thus having a high degree of coupling, they communicate indirectly through a mediator.

`ChatCoordinator` is the mediator class. It coordinates the communication between different users and chat rooms.

```java
public class ChatCoordinator implements ChatMediator {
    ...
    @Override
    public void sendMessage(String message, User user, ChatRoom room) {
        room.broadcastMessage(user.getName() + ": " + message, user);
    }
    ...
}
```

`ChatRoom` manages the messages within a specific chat context. It uses the mediator to broadcast messages to all users in the room.

```java
public class ChatRoom {
    public void broadcastMessage(String message, User sender) {
        for (User user : members) {
            if (!user.equals(sender)) {
                user.update(message);
            }
        }
    }
    ...
}
```

### Observer Pattern

The Observer pattern is used for creating a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

The `ChatObserver` interface defines the `update` method that gets called when a notification is sent.

```java
public interface ChatObserver {
    void update(String message);
    void notify(String announcement);
}
```

`User` class implements `ChatObserver` and thus must implement the update method. It gets notified when a message is broadcast in a chat room they belong to.

```java
public class User implements ChatObserver {
    ...
    @Override
    public void update(String message) {
        System.out.println(name + ": " + message);
    }
    ...
}
```

The `NotificationCenter` acts as the subject, keeping track of all its observers and notifying them of any announcements.

```java
public class NotificationCenter {
    private List<ChatObserver> observers = new ArrayList<>();

    public void addObserver(ChatObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ChatObserver observer) {
        observers.remove(observer);
    }

    public void makeAnnouncement(String announcement) {
        for (ChatObserver observer : observers) {
            observer.notify(announcement);
        }
    }
}
```

In the `Main` class, users are added as observers to the `NotificationCenter` and receive announcements, showcasing the Observer pattern in action.

## Conclusion

In this lab, we explored behavioral design patterns, including the Mediator, Command, and Observer patterns, each addressing unique software design challenges. The project uses the Command pattern to encapsulate the action of sending messages as a command that can be executed, the Mediator pattern to centralize and manage chat room communication, and the Observer pattern to allow users to subscribe and get notifications about events like receiving messages or announcements. This leads to a well-organized codebase that is easier to maintain and extend.
