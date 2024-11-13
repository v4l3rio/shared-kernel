package io.github.positionpal;

/**
 * Implementation of the GroupDeleted interface.
 * This class represents an event where a group is deleted.
 *
 * @param groupId the ID of the group
 */
public record GroupDeletedImpl(String groupId) implements GroupDeleted { }
