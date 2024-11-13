package io.github.positionpal;
/**
 Utility class to convert objects to and from Avro objects.
 */
public final class AvroConverter {

    private AvroConverter() { }

    /**
     * Converts a User object to an AvroUser object.
     *
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
     *
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
     * Converts an AddedMemberToGroup object to an Avro AddedMemberToGroupEvent object.
     *
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
     *
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
     *
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
     *
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
     *
     * @param avroGroupCreated the Avro GroupCreatedEvent object to convert
     * @return the converted GroupCreated object
     */
    public static GroupCreated toGroupCreated(final GroupCreatedEvent avroGroupCreated) {
        return GroupCreated.create(avroGroupCreated.getGroupId(), toUser(avroGroupCreated.getCreatedBy()));
    }

    /**
     * Converts a GroupDeleted object to an Avro GroupDeletedEvent object.
     *
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
     *
     * @param avroGroupDeleted the Avro GroupDeletedEvent object to convert
     * @return the converted GroupDeleted object
     */
    public static GroupDeleted toGroupDeleted(final GroupDeletedEvent avroGroupDeleted) {
        return GroupDeleted.create(avroGroupDeleted.getGroupId());
    }
}
