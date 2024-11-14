package io.github.positionpal.commands;

import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

record PushNotificationCommandImpl(
    GroupId recipient,
    UserId sender,
    NotificationMessage message
) implements PushNotificationCommand { }
