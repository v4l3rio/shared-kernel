package io.github.positionpal;

/**
 * Implementation of the GroupCreated interface.
 * This class represents an event where a group is created.
 *
 * @param groupId the ID of the group
 * @param createdBy the user who created the group
 */
public record GroupCreatedImpl(String groupId, User createdBy) implements GroupCreated { }
