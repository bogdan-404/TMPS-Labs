package domain.observer;

public interface ChatObserver {
    void update(String message);

    void notify(String announcement);
}