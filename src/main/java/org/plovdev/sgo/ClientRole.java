package org.plovdev.sgo;

public enum ClientRole {
    STUDENT(1), PARENT(2), TEACHER(3);

    private final int role;

    ClientRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}