package hu.pinterbeci.effective.java.chapter4.item21;

import java.util.regex.Pattern;

public class EmailSender implements NotificationSender {
    private static final Pattern PATTERN = Pattern.compile("^(.+)@(\\S+)$");

    @Override
    public void send(String message, String recipient) {
        validate(recipient);
        System.out.println("EMAIL to " + recipient + ": " + message);
    }

    private static void validate(String emailAddress) {
        if (!(PATTERN.matcher(emailAddress).matches())) throw new AssertionError();
    }
}