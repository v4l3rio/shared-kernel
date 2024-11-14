package io.github.positionpal.entities;

/**
 * A value object representing a user identifier.
 */
public interface UserId {

    /**
     * @return the username of the user.
     */
    String username();

    /**
     * Factory method to create an instance of UserId.
     * @param username the username of the user
     * @return a new instance of UserId
     */
    static UserId create(final String username) {
        return new UserIdImpl(username);
    }
}
