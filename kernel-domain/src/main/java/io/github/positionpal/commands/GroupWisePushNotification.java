package io.github.positionpal.commands;

import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

/**
 * Interface representing a push notification command to be sent to all members of a group.
 */
public interface GroupWisePushNotification extends PushNotificationCommand {

    /**
     * @return the {@link GroupId} to which the notification is to be sent.
     */
    GroupId recipient();

    /**
     * Factory method to create a new instance of PushNotificationCommand.
     * @param recipient the {@link GroupId} to which the notification is to be sent.
     * @param sender the {@link UserId} of the sender of the notification.
     * @param message the {@link NotificationMessage} to be sent.
     * @return a new instance of PushNotificationCommand.
     */
    static GroupWisePushNotification of(
        final GroupId recipient,
        final UserId sender,
        final NotificationMessage message
    ) {
        return new GroupWisePushNotificationImpl(recipient, sender, message);
    }
}
