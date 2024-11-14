package io.github.positionpal.commands;

import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

/**
 * Interface representing a push notification command.
 */
public interface PushNotificationCommand {

    /**
     * @return the {@link GroupId} to which the notification is to be sent.
     */
    GroupId recipient();

    /**
     * @return the {@link UserId} of the sender of the notification.
     */
    UserId sender();

    /**
     * @return the {@link NotificationMessage} to be sent.
     */
    NotificationMessage message();

    /**
     * Factory method to create a new instance of PushNotificationCommand.
     * @param recipient the {@link GroupId} to which the notification is to be sent.
     * @param sender the {@link UserId} of the sender of the notification.
     * @param message the {@link NotificationMessage} to be sent.
     * @return a new instance of PushNotificationCommand.
     */
    static PushNotificationCommand of(final GroupId recipient, final UserId sender, final NotificationMessage message) {
        return new PushNotificationCommandImpl(recipient, sender, message);
    }
}
