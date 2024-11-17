package io.github.positionpal.commands;

import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

record GroupWisePushNotificationImpl(
    GroupId recipient,
    UserId sender,
    NotificationMessage message
) implements GroupWisePushNotification { }


record CoMembersPushNotificationImpl(
    UserId referenceUser,
    UserId sender,
    NotificationMessage message
) implements CoMembersPushNotification { }
