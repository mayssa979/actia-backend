package com.example.air.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    MANAGER_CREATE("manager:create"),
    MANAGER_DELETE("manager:delete"),
    MANAGER_READ("manager:read"),
    MANAGER_UPDATE("manager:update");

    @Getter
    private final String permission;
}
