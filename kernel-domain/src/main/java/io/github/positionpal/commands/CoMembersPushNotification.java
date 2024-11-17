package io.github.positionpal.commands;

import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

/**
 * Interface representing a push notification command to be sent to all users who share
 * at least one group with a specific reference user.
 */
public interface CoMembersPushNotification extends PushNotificationCommand {

    /**
     * @return the {@link UserId} whose co-members will receive the notification.
     */
    UserId referenceUser();

    /**
     * Factory method to create a new instance of {@link CoMembersPushNotification}.
     * @param referenceUser the {@link UserId} whose co-members will receive the notification.
     * @param sender the {@link UserId} of the notification sender.
     * @param message the {@link NotificationMessage} to be sent.
     * @return a new instance of CoMembersPushNotification.
     */
    static CoMembersPushNotification of(
        final UserId referenceUser,
        final UserId sender,
        final NotificationMessage message
    ) {
        return new CoMembersPushNotificationImpl(referenceUser, sender, message);
    }
}
