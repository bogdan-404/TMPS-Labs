package domain.observer;

import java.util.ArrayList;
import java.util.List;

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