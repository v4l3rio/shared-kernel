package io.github.positionpal.commands;

import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

/**
 * Interface representing a push notification command.
 */
public interface PushNotificationCommand extends Command {

    /**
     * @return the {@link UserId} sending the notification.
     */
    UserId sender();

    /**
     * @return the {@link NotificationMessage} to be sent.
     */
    NotificationMessage message();
}
