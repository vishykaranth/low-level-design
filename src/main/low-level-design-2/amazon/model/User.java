package amazon.model;

import lombok.Getter;

import java.util.UUID;

/**
 * 
 * @created 23/04/2021
 */
@Getter
public abstract class User {
    private final String userId;

    public User() {
        this.userId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
