package org.plovdev.sgo.security;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import org.plovdev.sgo.utils.EnvReader;

public record AuthKeys(String username, String password) {
    @Contract("_, _ -> new")
    public static @NonNull AuthKeys load(String usernameKey, String passwordKey) {
        return new AuthKeys(EnvReader.getEnv(usernameKey), EnvReader.getEnv(passwordKey));
    }

    @Override
    public @NonNull String toString() {
        return String.format("AuthKeys: [username: %s, password: %s]", username, "*".repeat(password.length()));
    }
}