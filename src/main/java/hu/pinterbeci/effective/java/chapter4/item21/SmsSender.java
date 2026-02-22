package hu.pinterbeci.effective.java.chapter4.item21;

public class SmsSender implements NotificationSender {
    @Override
    public void send(String message, String recipient) {
        if (message.length() > 160) {
            throw new IllegalArgumentException("SMS too long!");
        }
        System.out.println("SMS to " + recipient + ": " + message);
    }
}