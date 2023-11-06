import domain.mediator.ChatCoordinator;
import domain.mediator.ChatMediator;
import domain.mediator.ChatRoom;
import domain.observer.NotificationCenter;
import domain.observer.User;

public class Main {
    public static void main(String[] args) {
        ChatMediator coordinator = new ChatCoordinator();
        NotificationCenter notificationCenter = new NotificationCenter();

        ChatRoom generalRoom = new ChatRoom("General");
        coordinator.addRoom(generalRoom);

        User alice = new User("Alice", coordinator);
        User bob = new User("Bob", coordinator);

        coordinator.addUserToRoom(alice, generalRoom);
        coordinator.addUserToRoom(bob, generalRoom);

        alice.send("Hello Bob!", generalRoom);
        bob.send("Hello Alice!", generalRoom);

        alice.update("This is a direct update to Alice!");

        notificationCenter.addObserver(alice);
        notificationCenter.addObserver(bob);
        notificationCenter.makeAnnouncement("Maintenance will take place at midnight.");

        notificationCenter.removeObserver(alice);
        notificationCenter.makeAnnouncement("Maintenance completed. Thank you for your patience.");
    }
}