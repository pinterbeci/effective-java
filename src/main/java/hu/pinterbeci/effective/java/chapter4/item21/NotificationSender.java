package hu.pinterbeci.effective.java.chapter4.item21;

import java.util.List;

public interface NotificationSender {
    void send(String message, String recipient);

    //subsequently added default method
    default void sendToAll(String message, List<String> recipients) {
        for (String recipient : recipients) {
            send(message, recipient);
        }
    }
}