package io.github.positionpal.entities;

/**
 * An interface modeling a notification message.
 */
public interface NotificationMessage {

    /**
     * @return the title of the notification.
     */
    String title();

    /**
     * @return the body of the message, i.e. its content.
     */
    String body();

    /**
     * Factory method to create a new instance of NotificationMessage.
     * @param title the title of the notification.
     * @param body the body of the message.
     * @return a new instance of NotificationMessage.
     */
    static NotificationMessage create(final String title, final String body) {
        return new NotificationMessageImpl(title, body);
    }
}
