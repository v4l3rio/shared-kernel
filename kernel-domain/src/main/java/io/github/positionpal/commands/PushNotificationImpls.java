package io.github.positionpal.commands;

import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

record GroupWisePushNotificationImpl(
    GroupId recipient,
    UserId sender,
    NotificationMessage message
) implements GroupWisePushNotification {
    @Override
    public CommandType type() {
        return CommandType.GROUP_WISE_NOTIFICATION;
    }
}

record CoMembersPushNotificationImpl(
    UserId referenceUser,
    UserId sender,
    NotificationMessage message
) implements CoMembersPushNotification {
    @Override
    public CommandType type() {
        return CommandType.CO_MEMBERS_NOTIFICATION;
    }
}
