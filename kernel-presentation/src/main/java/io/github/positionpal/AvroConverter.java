package io.github.positionpal;

import io.github.positionpal.commands.PushNotificationCommand;
import io.github.positionpal.entities.GroupId;
import io.github.positionpal.entities.NotificationMessage;
import io.github.positionpal.entities.UserId;

/**
 Utility class to convert objects to and from Avro objects.
 */
public final class AvroConverter {

    private AvroConverter() { }

    /**
     * Converts a UserId object to an AvroUserId object.
     * @param userId the UserId object to convert
     * @return the converted AvroUserId object
     */
    public static AvroUserId toAvroUserId(final UserId userId) {
        return AvroUserId.newBuilder().setUsername(userId.username()).build();
    }

    /**
     * Converts an AvroUserId object to a UserId object.
     * @param avroUserId the AvroUserId object to convert
     * @return the converted UserId object
     */
    public static UserId toUserId(final AvroUserId avroUserId) {
        return UserId.create(avroUserId.getUsername());
    }

    /**
     * Converts a User object to an AvroUser object.
     * @param user the User object to convert
     * @return the converted AvroUser object
     */
    public static AvroUser toAvroUser(final User user) {
        return AvroUser.newBuilder()
                .setId(user.id())
                .setName(user.name())
                .setSurname(user.surname())
                .setEmail(user.email())
                .setRole(user.role())
                .build();
    }

    /**
     * Converts an AvroUser object to a User object.
     * @param avroUser the AvroUser object to convert
     * @return the converted User object
     */
    public static User toUser(final AvroUser avroUser) {
        return User.create(
                avroUser.getId(),
                avroUser.getName(),
                avroUser.getSurname(),
                avroUser.getEmail(),
                avroUser.getRole()
        );
    }

    /**
     * Converts a GroupId object to an AvroGroupId object.
     * @param groupId the GroupId object to convert
     * @return the converted AvroGroupId object
     */
    public static AvroGroupId toAvroGroupId(final GroupId groupId) {
        return AvroGroupId.newBuilder().setValue(groupId.value()).build();
    }

    /**
     * Converts an AvroGroupId object to a GroupId object.
     * @param avroGroupId the AvroGroupId object to convert
     * @return the converted GroupId object
     */
    public static GroupId toGroupId(final AvroGroupId avroGroupId) {
        return GroupId.create(avroGroupId.getValue());
    }

    /**
     * Converts a NotificationMessage object to an AvroNotificationMessage object.
     * @param notificationMessage the NotificationMessage object to convert
     * @return the converted AvroNotificationMessage object
     */
    public static AvroNotificationMessage toAvroNotificationMessage(final NotificationMessage notificationMessage) {
        return AvroNotificationMessage.newBuilder()
                .setTitle(notificationMessage.title())
                .setBody(notificationMessage.body())
                .build();
    }

    /**
     * Converts an AvroNotificationMessage object to a NotificationMessage object.
     * @param avroNotificationMessage the AvroNotificationMessage object to convert
     * @return the converted NotificationMessage object
     */
    public static NotificationMessage toNotificationMessage(final AvroNotificationMessage avroNotificationMessage) {
        return NotificationMessage.create(avroNotificationMessage.getTitle(), avroNotificationMessage.getBody());
    }

    /**
     * Converts a PushNotificationCommand object to an AvroPushNotificationCommand object.
     * @param pushNotificationCommand the PushNotificationCommand object to convert
     * @return the converted AvroPushNotificationCommand object
     */
    public static AvroPushNotificationCommand toAvroPushNotificationCommand(
        final PushNotificationCommand pushNotificationCommand
    ) {
        return AvroPushNotificationCommand.newBuilder()
                .setRecipient(toAvroGroupId(pushNotificationCommand.recipient()))
                .setSender(toAvroUserId(pushNotificationCommand.sender()))
                .setMessage(toAvroNotificationMessage(pushNotificationCommand.message()))
                .build();
    }

    /**
     * Converts an AvroPushNotificationCommand object to a PushNotificationCommand object.
     * @param avroPushNotificationCommand the AvroPushNotificationCommand object to convert
     * @return the converted PushNotificationCommand object
     */
    public static PushNotificationCommand toPushNotificationCommand(
        final AvroPushNotificationCommand avroPushNotificationCommand
    ) {
        return PushNotificationCommand.of(
            toGroupId(avroPushNotificationCommand.getRecipient()),
            toUserId(avroPushNotificationCommand.getSender()),
            toNotificationMessage(avroPushNotificationCommand.getMessage())
        );
    }

    /**
     * Converts an AddedMemberToGroup object to an Avro AddedMemberToGroupEvent object.
     * @param addedMemberToGroup the AddedMemberToGroup object to convert
     * @return the converted Avro AddedMemberToGroupEvent object
     */
    public static AddedMemberToGroupEvent toAvroAddedMemberToGroup(
            final AddedMemberToGroup addedMemberToGroup) {
        return AddedMemberToGroupEvent.newBuilder()
                .setGroupId(addedMemberToGroup.groupId())
                .setAddedMember(toAvroUser(addedMemberToGroup.addedMember()))
                .build();
    }

    /**
     * Converts an Avro AddedMemberToGroupEvent object to an AddedMemberToGroup object.
     * @param avroAddedMemberToGroup the Avro AddedMemberToGroupEvent object to convert
     * @return the converted AddedMemberToGroup object
     */
    public static AddedMemberToGroup toAddedMemberToGroup(
            final AddedMemberToGroupEvent avroAddedMemberToGroup) {
        return AddedMemberToGroup.create(
                avroAddedMemberToGroup.getGroupId(),
                toUser(avroAddedMemberToGroup.getAddedMember())
        );
    }

    /**
     * Converts a RemovedMemberToGroup object to an Avro RemovedMemberToGroupEvent object.
     * @param removedMemberToGroup the RemovedMemberToGroup object to convert
     * @return the converted Avro RemovedMemberToGroupEvent object
     */
    public static RemovedMemberToGroupEvent toAvroRemovedMemberToGroup(
            final RemovedMemberToGroup removedMemberToGroup) {
        return RemovedMemberToGroupEvent.newBuilder()
                .setGroupId(removedMemberToGroup.groupId())
                .setRemovedMember(toAvroUser(removedMemberToGroup.removedMember()))
                .build();
    }

    /**
     * Converts an Avro RemovedMemberToGroupEvent object to a RemovedMemberToGroup object.
     *
     * @param avroRemovedMemberToGroup the Avro RemovedMemberToGroupEvent object to convert
     * @return the converted RemovedMemberToGroup object
     */
    public static RemovedMemberToGroup toRemovedMemberToGroup(
            final RemovedMemberToGroupEvent avroRemovedMemberToGroup) {
        return RemovedMemberToGroup.create(
                avroRemovedMemberToGroup.getGroupId(),
                toUser(avroRemovedMemberToGroup.getRemovedMember())
        );
    }

    /**
     * Converts a GroupCreated object to an Avro GroupCreatedEvent object.
     * @param groupCreated the GroupCreated object to convert
     * @return the converted Avro GroupCreatedEvent object
     */
    public static GroupCreatedEvent toAvroGroupCreated(final GroupCreated groupCreated) {
        return GroupCreatedEvent.newBuilder()
                .setGroupId(groupCreated.groupId())
                .setCreatedBy(toAvroUser(groupCreated.createdBy()))
                .build();
    }

    /**
     * Converts an Avro GroupCreatedEvent object to a GroupCreated object.
     * @param avroGroupCreated the Avro GroupCreatedEvent object to convert
     * @return the converted GroupCreated object
     */
    public static GroupCreated toGroupCreated(final GroupCreatedEvent avroGroupCreated) {
        return GroupCreated.create(avroGroupCreated.getGroupId(), toUser(avroGroupCreated.getCreatedBy()));
    }

    /**
     * Converts a GroupDeleted object to an Avro GroupDeletedEvent object.
     * @param groupDeleted the GroupDeleted object to convert
     * @return the converted Avro GroupDeletedEvent object
     */
    public static GroupDeletedEvent toAvroGroupDeleted(final GroupDeleted groupDeleted) {
        return GroupDeletedEvent.newBuilder()
                .setGroupId(groupDeleted.groupId())
                .build();
    }

    /**
     * Converts an Avro GroupDeletedEvent object to a GroupDeleted object.
     * @param avroGroupDeleted the Avro GroupDeletedEvent object to convert
     * @return the converted GroupDeleted object
     */
    public static GroupDeleted toGroupDeleted(final GroupDeletedEvent avroGroupDeleted) {
        return GroupDeleted.create(avroGroupDeleted.getGroupId());
    }
}
