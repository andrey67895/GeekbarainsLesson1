package InternetChat.Client.gui.api;

@FunctionalInterface
public interface Receiver {
    void receive(String data);
}
